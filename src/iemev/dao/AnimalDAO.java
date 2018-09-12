package iemev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import iemev.models.Animal;
import iemev.utils.bd.ConnectionFactory;

public class AnimalDAO extends CommonsDAO {

	@Override
	public void inserir(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean apagar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void atualizar(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<?> selecionarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object selecionarPorID(int identificado) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean inserir( Animal animal ) {
		Connection con = ConnectionFactory.getConnection();
		ResultSet rs = null;
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sqlAnimal = "INSERT INTO T_ANIMAL ( nomeAnimal, sexo, dataDeNascimentoAnimal, especie, porte, raca, pelagem, temperamento, cpfCliente, idAtendenteDeCadastramento) values (?,?,?,?,?,?,?,?,?,?)"; 
				//"values(   "+animal.getIdAtendimentoDeCadastramento()+" );";
		try {
			
			
			PreparedStatement stm = con.prepareStatement(sqlAnimal);
			stm.setString(1, animal.getNomeAnimal());
			stm.setString(2, String.valueOf(animal.getSexo()));
			stm.setString(3, formater.format(animal.getDataDeNascimentoAnimal()));
			stm.setString(4, animal.getEspecie());
			stm.setString(5, animal.getPorte());
			stm.setString(6, animal.getRaca());
			stm.setString(7, animal.getPelagem());
			stm.setString(8, animal.getTemperamento());
			stm.setLong(9, animal.getCpfCliente());
			stm.setLong(10, animal.getIdAtendimentoDeCadastramento());
			stm.executeUpdate();
			stm.close();
			con.close();
		} catch (Exception e ) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public JsonObject buscarAnimalId(int id ) {
		Connection con = ConnectionFactory.getConnection();
		JsonObject animal = new JsonObject();
		try {
			String sqlAnimal = "SELECT * FROM T_ANIMAL WHERE idAnimal ="+id+";";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sqlAnimal);
			try {
				animal.addProperty("id", rs.getString("idAnimal"));
				animal.addProperty("nome", rs.getString("nomeAnimal"));
				animal.addProperty("sexo", rs.getString("sexo"));
				animal.addProperty("data", rs.getString("dataDeNascimentoAnimal"));
				animal.addProperty("especie", rs.getString("especie"));
				animal.addProperty("porte", rs.getString("porte"));
				animal.addProperty("raca", rs.getString("raca"));
				animal.addProperty("pelagem", rs.getString("pelagem"));
				animal.addProperty("temperamento", rs.getString("temperamento"));
				animal.addProperty("cpf", rs.getString("cpfCliente"));
				animal.addProperty("idAtendente", rs.getString("idAtendenteDeCadastramento"));
			} catch (JsonIOException je) {
				je.printStackTrace();
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return animal;
	}
	
	public JsonObject buscarPorDono( int id ) {
		Connection con = ConnectionFactory.getConnection();
		JsonObject dono = new JsonObject();
		try {
			String sqlDono = "SELECT * FROM ((T_PESSOA P INNER JOIN T_CLIENTE C ON P.cpf = c.cpfUsuario) INNER JOIN T_ANIMAL A ON P.cpf = A.cpfCliente) WHERE A.idAnimal = "+id+";";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sqlDono);
			try {
				dono.addProperty("nome", rs.getString("nome"));
				dono.addProperty("cpf", rs.getString("cpf"));
				dono.addProperty("cpf", rs.getString("cpf"));
				dono.addProperty("telefone", rs.getString("telefoneResidencial"));
				dono.addProperty("celular", rs.getString("celular"));
				dono.addProperty("email", rs.getString("emailCliente"));
			} catch (JsonIOException je) {
				je.printStackTrace();
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dono;
	}
	public List<Animal> buscarAnimaisDono(long cpf){
		System.out.println(cpf);
		System.out.println("ANIMAL DAO");
		Connection con = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM T_ANIMAL WHERE cpfCliente = ?;";
		List<Animal> retorno = new ArrayList<Animal>();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setLong(1, cpf);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				Animal animal = new Animal();
				animal.setIdAnimal(rs.getInt("idAnimal"));
				animal.setNomeAnimal(rs.getString("nomeAnimal"));
				animal.setSexo(rs.getString("sexo").charAt(0));
				SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date data = new Date();
				try {
					String dataString = dataFormat.format( rs.getDate("dataDeNascimentoAnimal"));
					System.out.println(dataString);
					data = dataFormat.parse(dataString);
				} catch(ParseException pe) {
					pe.printStackTrace();
				}
				System.out.println(rs.getDate("dataDeNascimentoAnimal"));
				
				System.out.println(data);
				animal.setDataDeNascimentoAnimal(rs.getDate("dataDeNascimentoAnimal"));
				animal.setEspecie(rs.getString("especie"));
				animal.setPorte(rs.getString("porte"));
				animal.setRaca(rs.getString("raca"));
				animal.setPelagem(rs.getString("pelagem"));
				animal.setTemperamento(rs.getString("temperamento"));
				animal.setCpfCliente(rs.getLong("cpfCliente"));
				animal.setIdAtendimentoDeCadastramento(rs.getInt("idAtendenteDeCadastramento"));				
				retorno.add(animal);
			}
			System.out.println(retorno);
			stm.close();
			con.close();
			return retorno;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

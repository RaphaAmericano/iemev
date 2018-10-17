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
import iemev.utils.DataUtils;
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
	
	public int editar( Animal animal ) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "UPDATE T_ANIMAL SET nomeAnimal = ?, sexo = ?, dataDeNascimentoAnimal = ?, especie = ?, porte = ?, raca = ?, pelagem = ?, temperamento = ? WHERE idAnimal = ?";
		int retorno = 0;
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, animal.getNomeAnimal());
			stm.setString(2, animal.getSexo().toString());
			stm.setString(3, DataUtils.formatarData(animal.getDataDeNascimentoAnimal()));
			stm.setString(4, animal.getEspecie());
			stm.setString(5, animal.getPorte());
			stm.setString(6, animal.getRaca());
			stm.setString(7, animal.getPelagem());
			stm.setString(8, animal.getTemperamento());
			retorno = stm.executeUpdate();
			System.out.println(retorno);
			stm.close();
			con.close();
			return retorno;
		} catch (Exception e ) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	public int deletar(int id ) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "DELETE FROM T_ANIMAL WHERE idAnimal = ?";
		ResultSet rs = null;
		int retorno = 0; 
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setLong(1, id);
			retorno = stm.executeUpdate();
			rs.close();
			stm.close();
			con.close();
			return retorno;
		} catch( SQLException se ) {
			se.printStackTrace();
		}
		return retorno;
	}
	
	public List<Animal> buscarNome( String nome ) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM T_ANIMAL WHERE nomeAnimal LIKE ?";
		ResultSet rs = null;
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, "%"+nome+"%");
			rs = stm.executeQuery();
			List<Animal> retorno = new ArrayList<Animal>();
			while(rs.next()) {
				Date data = new Date();
				data = DataUtils.parseData(rs.getString("dataDeNascimentoAnimal"));
				Animal animal = new Animal(
						rs.getInt("idAnimal"),
						rs.getString("nomeAnimal"),
						rs.getString("Sexo").charAt(0),
						data,
						rs.getString("especie"),
						rs.getString("porte"),
						rs.getString("raca"),
						rs.getString("pelagem"),
						rs.getString("temperamento"),
						rs.getLong("cpfCliente"),
						rs.getInt("idAtendenteDeCadastramento")
						);
				retorno.add(animal);
			}
			rs.close();
			stm.close();
			con.close();
			return retorno;
		} catch (SQLException se ) {
			se.printStackTrace();
		}
		return null;
	}
	
	public Animal buscar(int id) {
		Connection con = ConnectionFactory.getConnection();
		Animal animal = new Animal();
		try {
			String sqlAnimal = "SELECT * FROM T_ANIMAL WHERE idAnimal ="+id+";";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sqlAnimal);
			SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				animal.setIdAnimal(rs.getInt("idAnimal"));
				animal.setNomeAnimal(rs.getString("nomeAnimal"));
				Date data = new Date();
				try {
					data = dataFormat.parse(rs.getString("dataDeNascimentoAnimal"));
				} catch(ParseException pe) {
					pe.printStackTrace();
				}
				animal.setSexo(rs.getString("sexo").charAt(0));
				animal.setDataDeNascimentoAnimal(data);
				animal.setEspecie(rs.getString("especie"));
				animal.setPorte(rs.getString("porte"));
				animal.setRaca(rs.getString("raca"));
				animal.setPelagem(rs.getString("pelagem"));
				animal.setTemperamento(rs.getString("temperamento"));
				animal.setCpfCliente(rs.getLong("cpfCliente"));
				animal.setIdAtendimentoDeCadastramento(rs.getInt("idAtendenteDeCadastramento"));
			} catch (JsonIOException je) {
				je.printStackTrace();
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return animal;
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
		Connection con = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM T_ANIMAL WHERE cpfCliente = ?;";
		List<Animal> retorno = new ArrayList<Animal>();
		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setLong(1, cpf);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				Animal animal = new Animal();
				animal.setIdAnimal(rs.getInt("idAnimal"));
				animal.setNomeAnimal(rs.getString("nomeAnimal"));
				animal.setSexo(rs.getString("sexo").charAt(0));		
				Date data = new Date();
				try {
					data = dataFormat.parse(rs.getString("dataDeNascimentoAnimal"));
				} catch(ParseException pe) {
					pe.printStackTrace();
				}
				animal.setDataDeNascimentoAnimal(data);
				animal.setEspecie(rs.getString("especie"));
				animal.setPorte(rs.getString("porte"));
				animal.setRaca(rs.getString("raca"));
				animal.setPelagem(rs.getString("pelagem"));
				animal.setTemperamento(rs.getString("temperamento"));
				animal.setCpfCliente(rs.getLong("cpfCliente"));
				animal.setIdAtendimentoDeCadastramento(rs.getInt("idAtendenteDeCadastramento"));				
				retorno.add(animal);
			}
			stm.close();
			con.close();
			return retorno;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

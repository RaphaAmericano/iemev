package iemev.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		try {
			String sqlAnimal = "INSERT INTO T_ANIMAL ( nomeAnimal, sexo, dataDeNascimentoAnimal, especie, porte, raca, pelagem, temperamento, cpfCliente, idAtendenteDeCadastramento	)" + 
					"values('"+animal.getNomeAnimal()+"', '"+animal.getSexo()+"', '"+animal.getDataDeNascimentoAnimal()+"', '"+animal.getEspecie()+"', '"+animal.getPorte()+"', '"+animal.getRaca()+"', '"+animal.getPelagem()+"', '"+animal.getTemperamento()+"', "+animal.getCpfCliente()+", "+animal.getIdAtendimentoDeCadastramento()+" );";
			
			Statement stm = con.createStatement();
			stm.executeUpdate(sqlAnimal);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dono;
	}
}

package iemev.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import iemev.utils.bd.ConnectionFactory;

public class FichaAtendimentoDAO {
	
	public ArrayList<JsonObject> buscar(String palavra) {
		Connection con = ConnectionFactory.getConnection();
		//Criar uma maneira de retornar um json com {nome: , cpf: }
		try { 
			String sqlSelect = "SELECT NOME, CPF FROM T_PESSOA WHERE NOME LIKE '%"+palavra+"%';";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sqlSelect);
			ArrayList<JsonObject> retorno = new ArrayList<JsonObject>(); 
			while(rs.next()) {
				JsonObject usuario = new JsonObject();
				try {
					usuario.addProperty("nome", rs.getString("NOME"));
					usuario.addProperty("cpf", rs.getString("CPF")); 
					retorno.add(usuario);
				} catch (JsonIOException je) {
					je.printStackTrace();
				}
			}
			
			con.close();
			return retorno;
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return null;
	}
	public ArrayList<JsonObject> buscarAnimal(long id){
		Connection con = ConnectionFactory.getConnection();
		try {
			String slqAnimalId = "SELECT * FROM T_ANIMAL A INNER JOIN T_PESSOA P ON A.cpfCliente = P.cpf WHERE P.CPF = "+id+";";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(slqAnimalId);
			ArrayList<JsonObject> retorno = new ArrayList<JsonObject>();
			while(rs.next()) {
				JsonObject animal = new JsonObject();
				try {
					animal.addProperty("id", rs.getString("idAnimal"));
					animal.addProperty("nome", rs.getString("nomeAnimal"));
//					animal.addProperty("sexo", rs.getString("sexo"));
//					animal.addProperty("data", rs.getString("dataDeNascimentoAnimal"));
//					animal.addProperty("especie", rs.getString("especie"));
//					animal.addProperty("porte", rs.getString("porte"));
//					animal.addProperty("raca", rs.getString("raca"));
//					animal.addProperty("pelagem", rs.getString("pelagem"));
//					animal.addProperty("temperamento", rs.getString("temperamento"));
//					animal.addProperty("cpf", rs.getString("cpfCliente"));
//					animal.addProperty("idAtendente", rs.getString("idAtendenteDeCadastramento"));
					retorno.add(animal);
				} catch(JsonIOException je ) {
					je.printStackTrace();
				}
			}
			con.close();
			return retorno;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

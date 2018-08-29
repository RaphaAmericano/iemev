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
	
}

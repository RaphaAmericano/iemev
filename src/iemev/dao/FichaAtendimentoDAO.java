package iemev.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import iemev.utils.bd.ConnectionFactory;

public class FichaAtendimentoDAO {
	
	public String buscar(String palavra) {
		Connection con = ConnectionFactory.getConnection();
		//Criar uma maneira de retornar um json com {nome: , cpf: }
		try { 
			String sqlSelect = "SELECT NOME, CPF FROM T_PESSOA WHERE NOME LIKE '"+palavra+"';";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sqlSelect);
			String retorno = "";
			while(rs.next()) {
				retorno += rs.getString("NOME");
			}
			con.close();
			return retorno;
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return null;
	}
	
}

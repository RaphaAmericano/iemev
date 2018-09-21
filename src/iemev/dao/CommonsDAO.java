package iemev.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import iemev.utils.bd.ConnectionFactory;

public abstract class CommonsDAO implements GenericDAO{
	
	public boolean apagar (String tabela, String coluna, int id) {
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement stm = con.createStatement();
			String slqDelete = "DELETE FROM "+ tabela +"WHERE "+coluna+" ="+id;
			stm.executeUpdate(slqDelete);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	};
}

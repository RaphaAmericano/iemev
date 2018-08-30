package iemev.utils.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	public static Connection getConnection() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			String db = "C:/Users/Raphael/eclipse-workspace/iemev/iemev.db";
			Connection con = DriverManager.getConnection("jdbc:sqlite:"+ db );
			return con;		
		}
		catch(Exception e ) {
			e.printStackTrace();			
		}
		return null;
	}
}

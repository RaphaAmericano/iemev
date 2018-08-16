package dao;

import java.sql.*;
import model.Pessoa;

public class PessoaDAO {
	public Pessoa daoUsuarioGetUsuario(int cpf, String password) {
		Pessoa u = new Pessoa();
		u.setCpf(cpf);
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Raphael\\eclipse-workspace\\Iemev\\iemev.db");
			Statement stm = con.createStatement();
			ResultSet resultado = stm.executeQuery("SELECT * FROM T_PESSOA");
			System.out.println(resultado);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return u;
	}
}

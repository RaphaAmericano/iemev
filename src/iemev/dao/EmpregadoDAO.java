package iemev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import iemev.models.Empregado;
import iemev.utils.bd.ConnectionFactory;

public class EmpregadoDAO {
	public static Empregado buscar(long cpf ) {
		Connection con = ConnectionFactory.getConnection();
		Empregado empregado = new Empregado();
		try {
			String sql = "SELECT * FROM T_EMPREGADO WHERE cpfCliente WHERE cpfEmpregado = ? ;";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setLong(1, cpf);
			ResultSet rs = stm.executeQuery();
			empregado.setCpf(rs.getLong("cpfEmpregado"));
			empregado.setIdEmpregado(rs.getInt("idEmpregado"));
			empregado.setIdEmpregado(rs.getInt("idEmpregado"));
			
			stm.close();
		} catch(SQLException se) {
			se.printStackTrace();
		}
		finally {
			con.close();
			return empregado;
		}
	}
}

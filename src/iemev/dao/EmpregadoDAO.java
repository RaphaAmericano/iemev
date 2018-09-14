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
		String sql = "SELECT * FROM T_EMPREGADO WHERE cpfEmpregado = ? ;";
		try {
			
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setLong(1, cpf);
			ResultSet rs = stm.executeQuery();
			empregado.setCpf(rs.getLong("cpfEmpregado"));
			empregado.setIdEmpregado(rs.getInt("idEmpregado"));
			empregado.setSenha(rs.getString("senha"));
			stm.close();
			con.close();
		} catch(SQLException se) {
			se.printStackTrace();
			return null;
		}
		return empregado;
	}
}

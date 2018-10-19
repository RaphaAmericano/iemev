package iemev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import iemev.models.Empregado;
import iemev.utils.DataUtils;
import iemev.utils.bd.ConnectionFactory;

public class EmpregadoDAO {
	public static Empregado buscar(long cpf ) {
		Connection con = ConnectionFactory.getConnection();
		Empregado empregado = new Empregado();
		String sql = "SELECT * FROM T_EMPREGADO WHERE cpfEmpregado = ?";
		try {
			
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setLong(1, cpf);
			ResultSet rs = stm.executeQuery();
			empregado.setCpf(rs.getLong("cpfEmpregado"));
			empregado.setIdEmpregado(rs.getInt("idEmpregado"));
			empregado.setSenha(rs.getString("senha"));
			empregado.setTipoEmpregado(rs.getString("tipoEmpregado"));
			rs.close();
			stm.close();
			con.close();
			return empregado;
		} catch(SQLException se) {
			se.printStackTrace();
			return null;
		}
	}
	public static Empregado buscarId(int id ) {
		Connection con = ConnectionFactory.getConnection();
		Empregado empregado = new Empregado();
		String sql = "SELECT * FROM T_EMPREGADO WHERE idEmpregado = ?";
		try {
			
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			empregado.setCpf(rs.getLong("cpfEmpregado"));
			empregado.setIdEmpregado(rs.getInt("idEmpregado"));
			empregado.setDataDeAdmissaoEmpregado(DataUtils.parseData(rs.getString("dataDeAdmissaoEmpregado")));
			empregado.setRamal(rs.getInt("ramal"));
			empregado.setEmailEmpregado(rs.getString("emailEmpregado"));
			empregado.setSenha(rs.getString("senha"));
			empregado.setIndicadorNovaSenha(rs.getBoolean("indicadorNovaSenha"));
			empregado.setTipoEmpregado(rs.getString("tipoEmpregado"));
			empregado.setIdAdministradoDeCadastramento(rs.getInt("idAdministradorDeCadastramento"));
			
			rs.close();
			stm.close();
			con.close();
			return empregado;
		} catch(SQLException se) {
			se.printStackTrace();
			return null;
		}
	}
}

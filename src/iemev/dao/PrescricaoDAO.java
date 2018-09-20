package iemev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import iemev.models.Prescricao;
import iemev.models.Servico;
import iemev.utils.bd.ConnectionFactory;

public class PrescricaoDAO {
	public int inserir(int ficha, int servico) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "INSERT INTO T_PRESCRICAO( cpfVeterinario, idServico, idEmpregadoDeOrdenacao) VALUES(?, ?, ?, ?) WHERE numeroFicha = ?";
		ResultSet rs = null;
		try {
			Prescricao prescricao = new Prescricao();
			PreparedStatement stm = con.prepareStatement(sql);
//			stm.setInt(1, servico.get);
//			stm.setLong(2, servico);
			
			
			stm.executeUpdate();
			stm.close();
			con.close();
			if(rs.next()) {
				return 1;
			} else {
				return 0;
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}
		return 0;
	}
}
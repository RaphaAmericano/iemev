package iemev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import iemev.models.Prescricao;
import iemev.models.Servico;
import iemev.utils.bd.ConnectionFactory;

public class PrescricaoDAO {
	public int inserir(long cpf, int servico, int idempregado, int ficha) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "INSERT INTO T_PRESCRICAO( cpfVeterinario, idServico, idEmpregadoDeOrdenacao, numeroFicha) VALUES(?, ?, ?, ?)";
		ResultSet rs = null;
		int retorno = 0;
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setLong(1, cpf);
			stm.setInt(2, servico);
			stm.setInt(3, idempregado);
			stm.setInt(4, ficha);
			stm.executeUpdate();
			rs = stm.getGeneratedKeys();
			retorno = rs.getInt(1);
			rs.close();
			stm.close();
			con.close();
			return retorno;
		}catch(SQLException se) {
			se.printStackTrace();
		}
		return retorno;
	}
	public Prescricao buscar(int id) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM T_PRESCRICAO WHERE idPrescricao = ?";
		ResultSet rs = null;
		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, id);
			rs = stm.executeQuery();
			Date data = new Date();
			try {
				data = dataFormat.parse(rs.getString("dataPrescricaoServico"));
			}catch(Exception e ) {
				e.printStackTrace();
			}
			Prescricao prescricao = new Prescricao(rs.getInt("idPrescricao"), rs.getInt("numeroFicha"), rs.getLong("cpfVeterinario"), rs.getInt("idServico"), data, rs.getInt("idEmpregadoDeOrdenacao"));
			rs.close();
			stm.close();
			con.close();
			return prescricao;
		} catch( SQLException se) {
			se.printStackTrace();
		}
		return null;
	}
}
package iemev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import iemev.models.Servico;
import iemev.utils.bd.ConnectionFactory;

public class ServicoDAO {
	public static List<Servico> buscarTodosServicos(){
		Connection con = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM T_SERVICO";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			List<Servico> retorno = new ArrayList<Servico>();
			while(rs.next()) {
				Servico servico = new Servico(rs.getInt("idServico"), rs.getString("categoria"), rs.getString("nomeServico"), rs.getDouble("preco"), rs.getInt("idAdministradorDeCadastramento"));
				retorno.add(servico);
			}
			stm.close();
			con.close();
			return retorno;	
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return null;
	}
	public static String novoServico() {
		String sql = "insert into t_servico ( categoria, nomeServico, preco, idAdministradorDeCadastramento) values (?, ?, ?, ?);";
		//....
		return sql;
	}
}

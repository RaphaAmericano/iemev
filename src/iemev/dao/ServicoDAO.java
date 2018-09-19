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
	public static List<String> buscarTodasCategorias(){
		Connection con = ConnectionFactory.getConnection();
		String sql = "SELECT DISTINCT categoria FROM T_SERVICO";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			List<String> retorno = new ArrayList<String>();
			while(rs.next()) {
				retorno.add(rs.getString("categoria"));
			}
			stm.close();
			con.close();
			return retorno;	
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return null;
	}
	public List<Servico> buscarPorCategoria(String categoria){
		Connection con = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM T_SERVICO WHERE categoria = ?";
		List<Servico> retorno = new ArrayList<Servico>();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, categoria);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Servico servico = new Servico(rs.getInt("idServico"), rs.getString("categoria"), rs.getString("nomeServico"), rs.getDouble("preco"), rs.getInt("idAdministradorDeCadastramento"));
				retorno.add(servico);
			}
			stm.close();
			con.close();
			return retorno;
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return null;
	}
	
	public static String novoServico() {
		String sql = "insert into t_servico ( categoria, nomeServico, preco, idAdministradorDeCadastramento) values (?, ?, ?, ?);";
		//....
		return sql;
	}
}

package iemev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import iemev.models.Agendamento;
import iemev.utils.bd.ConnectionFactory;

public class ConsultaDAO {
	public ArrayList<JsonObject> buscarPorData(String data){
		Connection con = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM (((T_AGENDAMENTO A INNER JOIN T_ANIMAL AN ON A.idAnimal = AN.idAnimal) INNER JOIN T_CLIENTE C ON C.cpfUsuario = AN.cpfCliente) INNER JOIN T_PESSOA P ON C.cpfUsuario = P.cpf ) WHERE dataAgendamento LIKE ?;";
		//String sql = "SELECT * FROM T_AGENDAMENTO WHERE dataAgendamento = ?;";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, "%"+data+"%");
			ResultSet rs = stm.executeQuery();
			ArrayList<JsonObject> retorno = new ArrayList<JsonObject>();
			
			while(rs.next()) {
				JsonObject agendamento = new JsonObject();
				try {
					agendamento.addProperty("nome_animal", rs.getString("nomeAnimal"));
					agendamento.addProperty("nome_cliente", rs.getString("nome"));
					agendamento.addProperty("id", rs.getInt("idAgendamento"));
					agendamento.addProperty("data", rs.getString("dataAgendamento"));
					agendamento.addProperty("id_servico", rs.getInt("idServicoAgendado"));
					agendamento.addProperty("id_animal", rs.getInt("idAnimal"));
					agendamento.addProperty("id_atendente", rs.getInt("idAtendenteDeAgendamento"));
					retorno.add(agendamento);
				} catch (JsonIOException e) {
					e.printStackTrace();
				}
			}
			
			stm.close();
			con.close();
			return retorno;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}
	public ArrayList<JsonObject> buscarPorNome(String nome){
		Connection con = ConnectionFactory.getConnection();
		
		String sql = "SELECT * FROM (((T_AGENDAMENTO A INNER JOIN T_ANIMAL AN ON A.idAnimal = AN.idAnimal) INNER JOIN T_CLIENTE C ON C.cpfUsuario = AN.cpfCliente) INNER JOIN T_PESSOA P ON C.cpfUsuario = P.cpf ) WHERE P.nome LIKE ? ;";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, "%"+nome+"%");
			ResultSet rs = stm.executeQuery();
			ArrayList<JsonObject> retorno = new ArrayList<JsonObject>();
			
			while(rs.next()) {
				JsonObject agendamento = new JsonObject();
				try {
					agendamento.addProperty("nome_animal", rs.getString("nomeAnimal"));
					agendamento.addProperty("nome_cliente", rs.getString("nome"));
					agendamento.addProperty("id", rs.getInt("idAgendamento"));
					agendamento.addProperty("data", rs.getString("dataAgendamento"));
					agendamento.addProperty("id_servico", rs.getInt("idServicoAgendado"));
					agendamento.addProperty("id_animal", rs.getInt("idAnimal"));
					agendamento.addProperty("id_atendente", rs.getInt("idAtendenteDeAgendamento"));
					retorno.add(agendamento);
				} catch (JsonIOException e) {
					e.printStackTrace();
				}
			}
			
			stm.close();
			con.close();
			return retorno;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	public JsonObject buscarPorId(int id){
		Connection con = ConnectionFactory.getConnection();
		
		String sql = "SELECT * FROM (((T_AGENDAMENTO A INNER JOIN T_ANIMAL AN ON A.idAnimal = AN.idAnimal) INNER JOIN T_CLIENTE C ON C.cpfUsuario = AN.cpfCliente) INNER JOIN T_PESSOA P ON C.cpfUsuario = P.cpf ) WHERE A.idAgendamento =  ?;";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			JsonObject agendamento = new JsonObject();
			while(rs.next()) {
				try {
					agendamento.addProperty("nome_animal", rs.getString("nomeAnimal"));
					agendamento.addProperty("nome_cliente", rs.getString("nome"));
					agendamento.addProperty("cpf_cliente", rs.getString("cpfCliente"));
					agendamento.addProperty("id", rs.getInt("idAgendamento"));
					agendamento.addProperty("data", rs.getString("dataAgendamento"));
					agendamento.addProperty("id_servico", rs.getInt("idServicoAgendado"));
					agendamento.addProperty("id_animal", rs.getInt("idAnimal"));
					agendamento.addProperty("id_atendente", rs.getInt("idAtendenteDeAgendamento"));
				} catch (JsonIOException e) {
					e.printStackTrace();
				}
			}
			
			stm.close();
			con.close();
			return agendamento;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	public static boolean inserir(Agendamento agendamento ) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "INSERT INTO T_AGENDAMENTO( dataAgendamento, idServicoAgendado, idAnimal, idAtendenteDeAgendamento) VALUES(?,?,?,?);";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			SimpleDateFormat dataformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			stm.setString(1, dataformat.format(agendamento.getDataAgendamento()));
			stm.setInt(2, agendamento.getIdServicoAgendado());
			stm.setInt(3, agendamento.getIdAnimal());
			stm.setInt(4, agendamento.getIdAtendenteDeAgendamento());
			stm.executeUpdate();
			stm.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean atualizar(Agendamento agendamento) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "UPDATE T_AGENDAMENTO SET dataAgendamento = ?, idServicoAgendado = ?, idAnimal = ?, idAtendenteDeAgendamento = ? WHERE idAgendamento = ?";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			SimpleDateFormat dataformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			stm.setString(1, dataformat.format(agendamento.getDataAgendamento()));
			stm.setInt(2, agendamento.getIdServicoAgendado());
			stm.setInt(3, agendamento.getIdAnimal());
			stm.setInt(4, agendamento.getIdAtendenteDeAgendamento());
			stm.setInt(5, agendamento.getIdAgendamento());
			stm.executeUpdate();
			stm.close();
			con.close();
		} catch(SQLException e ) {
			e.printStackTrace();
			return false;
		}
		return true;
	} 
	public boolean deletar(int idAgendamento) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "DELETE FROM T_AGENDAMENTO WHERE idAgendamento = ?";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, idAgendamento);
			stm.executeUpdate();
			stm.close();
			con.close();
		}catch(SQLException se) {
			se.printStackTrace();
			return false;
		}
		return true;
	}
	
}

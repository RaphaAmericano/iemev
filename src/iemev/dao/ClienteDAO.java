package iemev.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import iemev.models.Cliente;
import iemev.utils.bd.ConnectionFactory;

public class ClienteDAO extends CommonsDAO{
	
	@Override
	public void inserir(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object selecionarPorID(int identificado) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean inserir(Cliente cliente) {
		Connection con = ConnectionFactory.getConnection();
		try {
			String sqlPessoa = "INSERT INTO T_PESSOA (cpf, rg, nome, endereco, telefoneResidencial, celular, dataDeNascimento) VALUES ("
					+ cliente.getCpf()+","
					+ cliente.getRg()+",'"
					+ cliente.getNome()+"','"
					+ cliente.getEndereco()+"','"
					+ cliente.getTelefoneResidencial()+"','"
					+ cliente.getCelular()+"','"
					+ cliente.getDataDeNascimento()+"')";
			
			String sqlCliente = "INSERT INTO T_CLIENTE (cpfUsuario,emailCliente, idAtendenteDeCadastramento) VALUES ("
					+ cliente.getCpf()+",'"
					+ cliente.getEmailCliente()+"',"
					+ cliente.getIdAtendentDeCadastramento()+")";
			Statement stm = con.createStatement();
			stm.executeUpdate(sqlPessoa);
			stm.executeUpdate(sqlCliente);
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean apagar(int id) {
		Connection con = ConnectionFactory.getConnection();
		try {
			String slqDelete = "DELETE FROM T_CLIENTE WHERE cpfUsuario = "+ id;
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(slqDelete);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public List<Cliente> selecionarTodos() {
		Connection con = ConnectionFactory.getConnection();
		List clientes = new ArrayList<Cliente>();
		try {
			String slqSelect = "SELECT * FROM T_CLIENTE";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(slqSelect);
			while(rs.next()) {
				clientes.add(rs);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return clientes;
	}
//	public Cliente selecionarPodID(int id) {
//		Connection con = ConnectionFactory.getConnection();
//		try {
//			String slqSelect = "SELECT * FROM T_CLIENTE WHERE cpfCliente="+id;
//			Statement stm = con.createStatement();
//			ResultSet rs = stm.executeQuery(slqSelect);
//			con.close();
//		} 
//		catch(SQLException se) {
//			se.printStackTrace();
//		}
		//return rs;
//	}
}

package iemev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			String sqlPessoa = "INSERT INTO T_PESSOA (cpf, rg, nome, endereco, telefoneResidencial, celular, dataDeNascimento) VALUES ("
					+ cliente.getCpf()+","
					+ cliente.getRg()+",'"
					+ cliente.getNome()+"','"
					+ cliente.getEndereco()+"','"
					+ cliente.getTelefoneResidencial()+"','"
					+ cliente.getCelular()+"','"
					+ formater.format(cliente.getDataDeNascimento())+"')";
			
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
	public Cliente buscarId(long id) {
		Connection con = ConnectionFactory.getConnection();
		String slqSelect = "SELECT * FROM T_CLIENTE C INNER JOIN T_PESSOA P ON C.cpfUsuario = P.cpf WHERE cpfUsuario = ? ;";
		try {
			
			PreparedStatement stm = con.prepareStatement(slqSelect);
			stm.setLong(1, id);
			ResultSet rs = stm.executeQuery();
			SimpleDateFormat dataformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date data = new Date();
			try {
				data = dataformat.parse(rs.getString("dataDeNascimento"));
			} catch(Exception e) {
				e.printStackTrace();
			}
			Cliente cliente = new Cliente(
					rs.getLong("cpfUsuario"),
					rs.getLong("rg"),
					rs.getString("nome"),
					rs.getString("endereco"),
					rs.getString("telefoneResidencial"),
					rs.getString("celular"),
					data,
					rs.getString("emailCliente"),
					rs.getInt("idAtendenteDeCadastramento")
					);
			stm.close();
			con.close();
			return cliente;
		} 
		catch(SQLException se) {
			se.printStackTrace();
		}
		return null;
	}
}

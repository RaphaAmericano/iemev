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
import iemev.utils.DataUtils;
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

	public int deletar(long cpf ) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "DELETE FROM T_CLIENTE WHERE cpfCliente = ?";
		ResultSet rs = null;
		int retorno = 0;
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setLong(1, cpf);
			retorno = stm.executeUpdate();
			rs.close();
			stm.close();
			con.close();
		} catch (SQLException se ) {
			se.printStackTrace();
		}
		return retorno;
	}
	
	public int inserir(Cliente cliente) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "INSERT INTO T_CLIENTE (cpfCliente, emailCliente, idAtendenteDeCadastramento) VALUES (?, ?, ? )";
		ResultSet rs = null;
		int retorno = 0;
		try {
			PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stm.setLong(1, cliente.getCpf());
			stm.setString(2, cliente.getEmailCliente());
			stm.setInt(3, cliente.getIdAtendentDeCadastramento());
			retorno = stm.executeUpdate();
			rs.close();
			stm.close();
			con.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
			return retorno;
		}
		return retorno;
	}
	
	public boolean apagar(int id) {
		Connection con = ConnectionFactory.getConnection();
		try {
			String slqDelete = "DELETE FROM T_CLIENTE WHERE cpfCliente = "+ id;
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
		String slqSelect = "SELECT * FROM T_CLIENTE C INNER JOIN T_PESSOA P ON C.cpfCliente = P.cpf WHERE cpfCliente = ? ;";
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
					rs.getLong("cpfCliente"),
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
	public List<Cliente> buscarCpf(long cpf){
		Connection con = ConnectionFactory.getConnection();
		//mudar para cpf na tabela cliente
		String sql = "SELECT * FROM T_CLIENTE WHERE cpfCliente = ?";
		ResultSet rs = null;
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setLong(1, cpf);
			rs = stm.executeQuery();
			List<Cliente> retorno = new ArrayList<Cliente>();
			while(rs.next()) {
				Cliente cliente = new Cliente();
				retorno.add(cliente);
			}
			rs.close();
			stm.close();
			con.close();
			return retorno;
		}catch( SQLException se) {
			se.printStackTrace();
		}
		return null;
	}
}

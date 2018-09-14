package iemev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import iemev.models.Pessoa;
import iemev.utils.bd.ConnectionFactory;
import oracle.jrockit.jfr.parser.ParseException;

public class PessoaDAO extends CommonsDAO{

	@Override
	public void inserir(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean apagar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void atualizar(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<?> selecionarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object selecionarPorID(int identificado) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Pessoa buscarId(long id) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM T_PESSOA WHERE cpf = ?";
		Pessoa pessoa = null;
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setLong(1, id);
			ResultSet rs = stm.executeQuery();
			Date data = new Date();
			try {
				data = dateformat.parse(rs.getString("dataDeNascimento"));
			} catch(Exception pa ) {
				pa.printStackTrace();
			}
			pessoa = new Pessoa(
					rs.getLong("cpf"),
					rs.getInt("rg"),
					rs.getString("nome"),
					rs.getString("endereco"),
					rs.getString("telefoneResidencial"),
					rs.getString("celular"),
					data
					);
			stm.close();
			con.close();
		}
		catch(SQLException sq) {
			sq.printStackTrace();
			return null;
		}
		return pessoa; 
	}
}

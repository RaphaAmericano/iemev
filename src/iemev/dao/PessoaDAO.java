package iemev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import iemev.models.Cliente;
import iemev.models.Pessoa;
import iemev.utils.DataUtils;
import iemev.utils.bd.ConnectionFactory;
import oracle.jrockit.jfr.parser.ParseException;

public class PessoaDAO extends CommonsDAO{

	@Override
	public void inserir(Object o) {
		
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
	
	public int inserirPessoa( Pessoa pessoa ) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "INSERT INTO T_PESSOA (cpf, rg, nome, endereco, telefoneResidencial, celular, dataDeNascimento) values (?, ?, ?, ?, ?, ?, ?)";
		ResultSet rs = null;
		int retorno = 0;
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setLong(1, pessoa.getCpf());
			stm.setLong(2, pessoa.getRg());
			stm.setString(3, pessoa.getNome());
			stm.setString(4, pessoa.getEndereco());
			stm.setString(5, pessoa.getTelefoneResidencial());
			stm.setString(6, pessoa.getCelular());
			stm.setString(7, DataUtils.formatarData(pessoa.getDataDeNascimento()));
			retorno = stm.executeUpdate();
			rs.close();
			stm.close();
			con.close();
		} catch( SQLException se ) {
			se.printStackTrace();
		}
		return retorno;
	}
	
	public int deletar( long cpf ) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "DELETE FROM T_PESSOA WHERE cpf = ?";
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
	
	public List<Pessoa> buscarNome( String nome ) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM T_PESSOA WHERE nome LIKE ?";
		ResultSet rs = null;
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, "%"+nome+"%");
			rs = stm.executeQuery();
			List<Pessoa> retorno = new ArrayList<Pessoa>();
			while(rs.next()) {
				Date data = new Date();
				data = DataUtils.parseData(rs.getString("dataDeNascimento"));
				Pessoa pessoa = new Pessoa(
						rs.getLong("cpf"),
						rs.getLong("rg"),
						rs.getString("nome"),
						rs.getString("endereco"),
						rs.getString("telefoneResidencial"),
						rs.getString("celular"),
						data
						);
				retorno.add(pessoa);
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

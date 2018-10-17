package iemev.manager;

import java.text.SimpleDateFormat;
import java.util.List;

import com.google.gson.JsonObject;

import iemev.dao.PessoaDAO;
import iemev.models.Pessoa;

public class PessoaManager {
	
	public static int inserir(Pessoa pessoa ) {
		PessoaDAO dao = new PessoaDAO();
		try {
			int inserir = dao.inserirPessoa(pessoa);
			return inserir;
		} catch (Exception e ) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static int deletar(long cpf) {
		PessoaDAO dao = new PessoaDAO();
		try {
			int deletar = dao.deletar(cpf);
			return deletar;
		} catch (Exception e ) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static Pessoa buscarId(long id ) {
		PessoaDAO dao = new PessoaDAO();
		try {
			Pessoa pessoa = dao.buscarId(id);
			return pessoa;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<Pessoa> buscarNome( String nome ) {
		PessoaDAO dao = new PessoaDAO();
		try {
			List<Pessoa> pessoa = dao.buscarNome(nome);
			return pessoa;
		} catch( Exception e ) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static JsonObject pessoaJson(Pessoa pessoa ) {
		JsonObject retorno = new JsonObject();
		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		retorno.addProperty("cpf", pessoa.getCpf());
		retorno.addProperty("rg", pessoa.getRg());
		retorno.addProperty("nome", pessoa.getNome());
		retorno.addProperty("endereco", pessoa.getEndereco());
		retorno.addProperty("telefoneResidencial", pessoa.getTelefoneResidencial());
		retorno.addProperty("celular", pessoa.getCelular());
		retorno.addProperty("dataDeNascimento", dataFormat.format(pessoa.getDataDeNascimento()));
		return retorno;
	}
}

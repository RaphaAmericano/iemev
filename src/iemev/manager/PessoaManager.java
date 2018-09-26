package iemev.manager;

import java.text.SimpleDateFormat;

import com.google.gson.JsonObject;

import iemev.dao.PessoaDAO;
import iemev.models.Pessoa;

public class PessoaManager {
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

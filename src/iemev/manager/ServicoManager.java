package iemev.manager;

import java.text.SimpleDateFormat;
import java.util.List;

import com.google.gson.JsonObject;

import iemev.dao.ServicoDAO;
import iemev.models.Servico;

public class ServicoManager {
	public static Servico buscar(int id) {
		ServicoDAO dao = new ServicoDAO();
		Servico retorno = dao.buscarPorId(id);
		return retorno;
	}
	
	public static List<Servico> buscarTodosServicos(){
		ServicoDAO dao = new ServicoDAO();
		List<Servico> retorno = dao.buscarTodosServicos();
		return retorno;
	}
	public static List<String> buscarTodasCategorias(){
		ServicoDAO dao = new ServicoDAO();
		List<String> retorno = dao.buscarTodasCategorias();
		return retorno;
	}
	public static List<Servico> buscarPorCategoria(String categoria){
		ServicoDAO dao = new ServicoDAO();
		List<Servico> retorno = dao.buscarPorCategoria(categoria);
		return retorno;
	}
	public static JsonObject servicoJson(Servico servico) {
		JsonObject retorno = new JsonObject();
		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		retorno.addProperty("id_servico", servico.getIdServico());
		retorno.addProperty("categoria", servico.getCategoria());
		retorno.addProperty("nome_servico", servico.getNomeServico());
		retorno.addProperty("preco", servico.getPreco());
		retorno.addProperty("id_administrador", servico.getIdAdministradorDeCadastramento());
		return retorno;
	}
}



package iemev.manager;

import java.util.List;

import iemev.dao.ServicoDAO;
import iemev.models.Servico;

public class ServicoManager {
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
}



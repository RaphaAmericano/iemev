package iemev.manager;

import java.util.List;

import com.google.gson.JsonObject;

import iemev.dao.ConsultaDAO;

public class ConsultaManager {
	public static List<JsonObject> buscarData(String data) {
		ConsultaDAO dao = new ConsultaDAO();
		List<JsonObject> retorno = dao.buscarPorData(data);
		return retorno;
	}
	public static List<JsonObject> buscarNome(String nome) {
		ConsultaDAO dao = new ConsultaDAO();
		List<JsonObject> retorno = dao.buscarPorNome(nome);
		return retorno;
	}
	
	public static JsonObject buscarId(int id ) {
		ConsultaDAO dao = new ConsultaDAO();
		JsonObject retorno = dao.buscarPorId(id);
		return retorno;
	}
	
}

package iemev.manager;

import java.util.List;

import com.google.gson.JsonObject;

import iemev.dao.ConsultaDAO;
import iemev.models.Agendamento;

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
	
	public static String incluirConsulta(Agendamento agendamento) {
		ConsultaDAO dao = new ConsultaDAO();
		boolean inserir =  dao.inserir(agendamento);
		String retorno = "Não foi possivel agendar nova consulta";
		if(inserir = true) {
			retorno = "Nova consulta inserida com sucesso";
		}
		return retorno;
	}
	
}

package iemev.manager;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.google.gson.JsonObject;

import iemev.dao.PrescricaoDAO;
import iemev.models.Prescricao;

public class PrescricaoManager {
	public static int inserir(long cpf, int ficha, int servico, int idempregado) {
		PrescricaoDAO dao = new PrescricaoDAO();
		try {
			int prescricao = dao.inserir(cpf, servico, idempregado, ficha);
			return prescricao;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static int deletar(int id_prescricao) {
		PrescricaoDAO dao = new PrescricaoDAO();
		try {
			int deletar = dao.deletar(id_prescricao);
			return deletar;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static Prescricao buscar(int id) {
		PrescricaoDAO dao = new PrescricaoDAO();
		try {
			Prescricao prescricao = dao.buscar(id);
			return prescricao;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static JsonObject prescricaoJson(Prescricao prescricao) {
		JsonObject retorno = new JsonObject();
		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		retorno.addProperty("id_prescricao", prescricao.getIdPrescricao());
		retorno.addProperty("numero_ficha", prescricao.getNumeroFicha());
		retorno.addProperty("cpf_veterinario", prescricao.getCpfVeterinario());
		retorno.addProperty("id_servico", prescricao.getIdServico());
		retorno.addProperty("data_prescricao_servico", dataFormat.format(prescricao.getDataPrescricaoServico()));
		retorno.addProperty("id_empregado_ordenacao", prescricao.getIdEmpregadoDeOrdenacao());
		if(prescricao.getDataFila() != null ) {
			retorno.addProperty("data_fila", dataFormat.format(prescricao.getDataFila()));
		}
		return retorno;
	}
	public static List<Prescricao> buscarTodasPrescricoes(int ficha){
		PrescricaoDAO dao = new PrescricaoDAO();
		try {
			List<Prescricao> retorno = dao.buscarTodasPrescricoes(ficha);
			return retorno;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

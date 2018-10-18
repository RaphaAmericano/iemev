package iemev.manager;

import com.google.gson.JsonObject;

import iemev.dao.EmpregadoDAO;
import iemev.models.Empregado;
import iemev.utils.DataUtils;

public class EmpregadoManager {
	public static Empregado buscar(long cpf ) {
		EmpregadoDAO dao = new EmpregadoDAO();
		try {
			Empregado retorno = dao.buscar(cpf);
			return retorno;	
		} catch( Exception e ) {
			e.printStackTrace();
		}
		return null;
	}
	public static Empregado buscarId(int id ) {
		EmpregadoDAO dao = new EmpregadoDAO();
		try {
			Empregado retorno = dao.buscarId(id);
			return retorno;	
		} catch( Exception e ) {
			e.printStackTrace();
		}
		return null;
	}
	public static JsonObject empregadoJson(Empregado empregado ) {
		JsonObject retorno = new JsonObject();
		retorno.addProperty("cpfEmpregado", empregado.getCpf());
		retorno.addProperty("idEmpregado", empregado.getIdEmpregado());
		retorno.addProperty("dataDeAdmissaoEmpregado", DataUtils.formatarData(empregado.getDataDeAdmissaoEmpregado()));
		retorno.addProperty("ramal", empregado.getRamal());
		retorno.addProperty("emailEmpregado", empregado.getEmailEmpregado());
		retorno.addProperty("tipoEmpregado", empregado.getTipoEmpregado());
		retorno.addProperty("idAdministradorDeCadastramento", empregado.getIdAdministradoDeCadastramento());
		return retorno;
	}
}

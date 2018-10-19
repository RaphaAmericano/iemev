package iemev.manager;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

import iemev.dao.FichaAtendimentoDAO;
import iemev.models.FichaDeAtendimento;
import iemev.utils.DataUtils;

public class FichaAtendimentoManager {
	public static ArrayList buscarString(String palavra) {
		FichaAtendimentoDAO dao = new FichaAtendimentoDAO();
		ArrayList retorno = new ArrayList<>();
		try {
			retorno = dao.buscar(palavra);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	public static ArrayList buscarAnimais(long idcliente) {
		
		FichaAtendimentoDAO dao = new FichaAtendimentoDAO();
		ArrayList retorno = new ArrayList<>();
		try {
			retorno = dao.buscarAnimal(idcliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	public static int novaFicha(FichaDeAtendimento ficha ) {
		FichaAtendimentoDAO dao = new FichaAtendimentoDAO();
		int fichaId = 0;
		try {
			//retorno o id da ultima ficha gerada pelo banco
			fichaId = dao.inserir(ficha);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fichaId;
	}
	
	public static int deletar(int id_ficha) {
		FichaAtendimentoDAO dao = new FichaAtendimentoDAO();
		try {
			int deletar = dao.deletarFicha(id_ficha);
			return deletar;
		} catch( Exception e ) {
			e.printStackTrace();
		}
		return 0;
	}
	public static FichaDeAtendimento buscarPorId(int id ) {
		FichaAtendimentoDAO dao = new FichaAtendimentoDAO();
		try {
			FichaDeAtendimento ficha = dao.selecionarPorId(id);
			return ficha;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<FichaDeAtendimento> fichasUsuario(long id){
		FichaAtendimentoDAO dao = new FichaAtendimentoDAO();
		try {
			ArrayList<FichaDeAtendimento> fichas = dao.fichasUsuario(id);
			return fichas;
		} catch(Exception e ) {
			e.printStackTrace();
		}
		return null;
	}
	public static List<FichaDeAtendimento> todasFichas(){
		FichaAtendimentoDAO dao = new FichaAtendimentoDAO();
		try {
			List<FichaDeAtendimento> fichas = dao.todasFichas();
			return fichas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<FichaDeAtendimento> fichasAbertasAnimal(int id_animal){
		FichaAtendimentoDAO dao = new FichaAtendimentoDAO();
		try {
			List<FichaDeAtendimento> fichas = dao.fichasAnimal(id_animal, false);
			return fichas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static int fecharFicha(int id_ficha) {
		FichaAtendimentoDAO dao = new FichaAtendimentoDAO();
		try {
			int retorno = dao.fecharFicha(id_ficha);
			return retorno;
		} catch (Exception e ) {
			e.printStackTrace();
		}
		return 0;
	}
	public static int abrirFicha(int id_ficha) {
		FichaAtendimentoDAO dao = new FichaAtendimentoDAO();
		try {
			int retorno = dao.abrirFicha(id_ficha);
			return retorno;
		} catch (Exception e ) {
			e.printStackTrace();
		}
		return 0;
	}
	public static JsonObject fichaJson(FichaDeAtendimento ficha ) {
		JsonObject retorno = new JsonObject();
		retorno.addProperty("numeroFicha", ficha.getNumeroFicha());
		retorno.addProperty("dataAbertura", DataUtils.formatarData(ficha.getDataAbertura()));
		retorno.addProperty("dataFechamento", DataUtils.formatarData(ficha.getDataAbertura()));
		retorno.addProperty("idAnimal", ficha.getIdAnimal());
		retorno.addProperty("idAtendenteAbriuFicha", ficha.getIdAtendenteAbriuFicha());
		retorno.addProperty("idAtendenteFechouFicha", ficha.getIdAtendenteFechouFicha());
		return retorno;
	}
}

package iemev.manager;

import java.util.List;

import com.google.gson.JsonObject;

import iemev.dao.ClienteDAO;
import iemev.models.Cliente;


public class ClienteManager {
	
	public static int deletar(long cpf) {
		ClienteDAO dao = new ClienteDAO();
		try {
			int deletar = dao.deletar(cpf);
			return deletar;
		} catch(Exception e ) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static int cadastrarCliente( Cliente cliente ) {
		ClienteDAO dao = new ClienteDAO();
		try {
			int cadastrar = dao.inserir(cliente);
			return cadastrar;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static Cliente buscarId(long id) {
		ClienteDAO dao = new ClienteDAO();
		try {
			Cliente cliente = dao.buscarId(id);
			return cliente;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<Cliente> buscarCpf(long cpf ){
		ClienteDAO dao = new ClienteDAO();
		try {
			List<Cliente> retorno = dao.buscarCpf(cpf);
			return retorno;
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static JsonObject clienteJson(Cliente cliente ) {
		JsonObject retorno  = new JsonObject();
		retorno.addProperty("emailCliente", cliente.getEmailCliente());
		retorno.addProperty("idAtendenteDeCadastramento", cliente.getIdAtendentDeCadastramento());
		return retorno;
	}
	
}

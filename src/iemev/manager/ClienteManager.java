package iemev.manager;

import iemev.dao.ClienteDAO;
import iemev.models.Cliente;


public class ClienteManager {
	public static String cadastrarCliente( Cliente cliente ) {
		ClienteDAO dao = new ClienteDAO();
		try {
			dao.inserir(cliente);	
		} catch(Exception e) {
			e.printStackTrace();
			return "Erro";
		}
		return "Sucesso";
	}
	public static Cliente buscarId(long id) {
		ClienteDAO dao = new ClienteDAO();
		try {
			Cliente cliente = dao.buscarId(id);
			System.out.println(cliente);
			return cliente;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

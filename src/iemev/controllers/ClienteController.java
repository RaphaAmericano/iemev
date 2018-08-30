package iemev.controllers;

import iemev.dao.ClienteDAO;
import iemev.models.Cliente;


public class ClienteController {
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
}

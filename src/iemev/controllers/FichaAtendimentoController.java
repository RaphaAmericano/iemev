package iemev.controllers;

import iemev.dao.FichaAtendimentoDAO;

public class FichaAtendimentoController {
	public static String buscarString(String palavra) {
		FichaAtendimentoDAO dao = new FichaAtendimentoDAO();
		String retorno = "";
		try {
			retorno = dao.buscar(palavra);	
		} catch (Exception e) {
			retorno = "Não há usuários com esse nome";
			e.printStackTrace();
		}
		return retorno;
	}
}

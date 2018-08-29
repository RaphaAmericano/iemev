package iemev.controllers;

import java.util.ArrayList;

import iemev.dao.FichaAtendimentoDAO;

public class FichaAtendimentoController {
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
}

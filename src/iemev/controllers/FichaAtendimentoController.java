package iemev.controllers;

import java.util.ArrayList;

import iemev.dao.FichaAtendimentoDAO;
import iemev.models.FichaDeAtendimento;

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
	
	public static String novaFicha(FichaDeAtendimento ficha ) {
		FichaAtendimentoDAO dao = new FichaAtendimentoDAO();
		boolean status = false;
		System.out.println("Ficha");
		try {
			status = dao.inserir(ficha);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String retorno = "Não foi possível cadastrar nova ficha";
		if(status == true) {
			retorno = "Ficha cadastrada com sucesso";
		}
		return retorno;
	}
}

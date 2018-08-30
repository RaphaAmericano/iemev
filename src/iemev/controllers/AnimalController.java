package iemev.controllers;

import com.google.gson.JsonObject;

import iemev.dao.AnimalDAO;
import iemev.models.Animal;

public class AnimalController {
	public static String cadastrarAnimal( Animal animal ) {
		AnimalDAO dao = new AnimalDAO();
		try {
			dao.inserir(animal);
		}  catch (Exception e ) {
			e.printStackTrace();
			return "Erro";
		}
		return "Sucesso";
	}
	public static JsonObject buscarAnimalId(int idanimal) {
		AnimalDAO dao = new AnimalDAO();
		JsonObject retorno = new JsonObject();
		try {
			retorno = dao.buscarAnimalId(idanimal);
		} catch (Exception e) {
				e.printStackTrace();
		}
		return retorno;
	}
}

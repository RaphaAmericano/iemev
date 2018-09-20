package iemev.manager;

import java.util.List;

import com.google.gson.JsonObject;

import iemev.dao.AnimalDAO;
import iemev.models.Animal;

public class AnimalManager {
	public static Animal buscar(int id) {
		AnimalDAO dao = new AnimalDAO();
		try {
			Animal retorno = dao.buscar(id);
			return retorno;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
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
	public static JsonObject buscarDonoId(int idanimal) {
		AnimalDAO dao = new AnimalDAO();
		JsonObject retorno = new JsonObject();
		try {
			retorno = dao.buscarPorDono(idanimal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	public static List<Animal> buscarAnimaisCliente(long cpf ){
		AnimalDAO dao = new AnimalDAO();
		try {
			List<Animal> retorno = dao.buscarAnimaisDono(cpf);
			return retorno;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

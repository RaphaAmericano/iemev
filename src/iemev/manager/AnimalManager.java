package iemev.manager;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import iemev.dao.AnimalDAO;
import iemev.models.Animal;
import iemev.utils.DataUtils;

public class AnimalManager {
	
	public static int deletar( int id ) {
		AnimalDAO dao = new AnimalDAO();
		int retorno = 0;
		try {
			retorno = dao.deletar(id);
			return retorno;
		} catch (Exception e ) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	public static int editar( Animal animal ) {
		AnimalDAO dao = new AnimalDAO();
		int retorno = 0;
		try {
			retorno = dao.editar(animal);
			return retorno;
		} catch (Exception e ) {
			e.printStackTrace();
		}
		return retorno;
	}
	
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
	
	public static List<Animal> buscarNome(String nome ){
		AnimalDAO dao = new AnimalDAO();
		try {
			List<Animal> retorno = dao.buscarNome(nome);
			return retorno;
		} catch (Exception e ) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static int cadastrarAnimal( Animal animal ) {
		AnimalDAO dao = new AnimalDAO();
		int retorno = 0;
		try {
			retorno = dao.inserir(animal);
			return retorno;
		}  catch (Exception e ) {
			e.printStackTrace();
		}
		return retorno;
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
	
	public static JsonObject animalJson(Animal animal ) {
		JsonObject retorno = new JsonObject();
		retorno.addProperty("idAnimal", animal.getIdAnimal());
		retorno.addProperty("nomeAnimal", animal.getNomeAnimal());
		retorno.addProperty("sexo", animal.getSexo());
		if(animal.getDataDeNascimentoAnimal() != null ) {
			retorno.addProperty("dataDeNascimentoAnimal", DataUtils.formatarData(animal.getDataDeNascimentoAnimal()));
		} else {
			retorno.addProperty("dataDeNascimentoAnimal", "");
		}
		
		retorno.addProperty("especie", animal.getEspecie());
		retorno.addProperty("porte", animal.getPorte());
		retorno.addProperty("raca", animal.getRaca());
		retorno.addProperty("pelagem", animal.getPelagem());
		retorno.addProperty("temperamento", animal.getTemperamento());
		retorno.addProperty("cpfCliente", animal.getCpfCliente());
		retorno.addProperty("idAtendimentoDeCadastramento", animal.getIdAtendimentoDeCadastramento());
		return retorno;
	}
}

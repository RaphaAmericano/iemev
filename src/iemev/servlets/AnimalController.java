package iemev.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import iemev.manager.AnimalManager;
import iemev.manager.ClienteManager;
import iemev.models.Animal;
import iemev.models.Cliente;
import iemev.utils.DataUtils;

/**
 * Servlet implementation class AnimalServlet
 */
@WebServlet("/animalServlet.do")
public class AnimalController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AnimalController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int opcao = Integer.parseInt(request.getParameter("opcao"));
		RequestDispatcher view = request.getRequestDispatcher("animal.jsp");
		Animal animal;
		int idAnimal;
		String mensagem;
		String retorno;
		
		String nome;
		Character sexo;
		Date data;
		String especie;
		String raca;
		String porte;
		String pelagem;
		String temperamento;
		long cpf;
		int idatendente;
		
		switch (opcao) {
		case 0:
			String valor = request.getParameter("busca");
			List<Animal> animais = AnimalManager.buscarNome(valor);
			List<JsonObject> lista = new ArrayList<JsonObject>();
			for(int i = 0; i < animais.size(); i++ ) {
				JsonObject animal_j = AnimalManager.animalJson(animais.get(i));
				lista.add(animal_j);
			}
			retorno = new Gson().toJson(lista);
			response.setContentType("text/plain");
			response.getWriter().write(retorno);
			break;
		case 1:
			idAnimal = Integer.parseInt(request.getParameter("idAnimal"));
			animal = AnimalManager.buscar(idAnimal);
			JsonObject animal_j = AnimalManager.animalJson(animal);
			retorno = new Gson().toJson(animal_j);
			response.setContentType("text/plain");
			response.getWriter().write(retorno);
			break;
		case 2:
			//case incluir
			nome = request.getParameter("nome");
			sexo = request.getParameter("sexo").toUpperCase().charAt(0);
			data = DataUtils.parseData(request.getParameter("dataNascimento") + DataUtils.horaAtual());
			especie = request.getParameter("especie");
			porte = request.getParameter("porte");
			raca = request.getParameter("raca");
			pelagem = request.getParameter("pelagem");
			temperamento = request.getParameter("temperamento");
			cpf = Long.parseLong(request.getParameter("cpf").replace(".","").replace("-", ""));
			Cliente cliente = ClienteManager.buscarId(cpf);
			if(cliente == null ) {
				mensagem = "Cliente inexistente";
				System.out.println(mensagem);
				request.setAttribute("mensagem_crud", mensagem);
				view.forward(request, response);
				break;
			}
			idatendente = Integer.parseInt(request.getParameter("idatendente"));
			animal = new Animal(nome, sexo, data, especie, porte, raca, pelagem, temperamento, cpf, idatendente);
			int incluir = AnimalManager.cadastrarAnimal(animal);
			
			if( incluir == 1 ) {
				mensagem = "Animal incluído com sucesso";	
			} else {
				mensagem = "Não foi possível incluir o animal";
			}
			request.setAttribute("mensagem_crud", mensagem);
			view.forward(request, response);
			break;
		case 3:
			//Case editar
			idAnimal = Integer.parseInt(request.getParameter("idanimal"));
			nome = request.getParameter("nome");
			sexo = request.getParameter("sexo").toUpperCase().charAt(0);
			data = DataUtils.parseData(request.getParameter("dataNascimento"));
			especie = request.getParameter("especie");
			porte = request.getParameter("porte");
			raca = request.getParameter("raca");
			pelagem = request.getParameter("pelagem");
			temperamento = request.getParameter("temperamento");
			animal = new Animal(idAnimal, nome, sexo, data, especie, porte, raca, pelagem, temperamento );
			int editar = AnimalManager.editar(animal);
			if( editar == 1 ) {
				mensagem = "Animal editado com sucesso";	
			} else {
				mensagem = "Não foi possível editar o animal";
			}
			request.setAttribute("mensagem_crud", mensagem);
			view.forward(request, response);
			break;
		case 4:
			//case excluir
			idAnimal = Integer.parseInt(request.getParameter("idanimal"));
			int deletar = AnimalManager.deletar(idAnimal);
			System.out.println(deletar);
			if(deletar == 0 ) {
				mensagem = "Animal apagado com sucesso";
			} else {
				mensagem = "Não foi possível apagar o animal";
			}
			request.setAttribute("mensagem_crud", mensagem);
			view.forward(request, response);
			break;
		default:
			break;
		}
		
	}

}

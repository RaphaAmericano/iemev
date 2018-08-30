package iemev.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import iemev.controllers.AnimalController;
import iemev.controllers.FichaAtendimentoController;

/**
 * Servlet implementation class FichaAtendimentoServlet
 */
@WebServlet("/FichaAtendimentoServlet.do")
public class FichaAtendimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FichaAtendimentoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int opcao = Integer.parseInt(request.getParameter("opcao"));
		
		switch (opcao) {
		case 0:
			String palavra = request.getParameter("busca");
			ArrayList<String> resultArray = FichaAtendimentoController.buscarString(palavra);
			String result = new Gson().toJson(resultArray);
			response.setContentType("text/plain");
			response.getWriter().write(result);	
			break;
		case 1:
			long idusuario = Long.parseLong(request.getParameter("idcliente"));
			
			ArrayList<String> animais = FichaAtendimentoController.buscarAnimais(idusuario);
//			if(animais.size() == 0 ) { }
			String resultAnimal = new Gson().toJson(animais);
			response.setContentType("text/plain");
			response.getWriter().write(resultAnimal);	
			break;
		case 2:
			int idanimal = Integer.parseInt(request.getParameter("idAnimal"));
			JsonObject animal = AnimalController.buscarAnimalId(idanimal);
			JsonObject dono = AnimalController.buscarDonoId(idanimal);
			List<JsonObject> animalDono = new ArrayList<JsonObject>();
			animalDono.add(animal);
			animalDono.add(dono);
			String retorno = new Gson().toJson(animalDono);
			System.out.println(retorno);
			response.setContentType("text/plain");
			response.getWriter().write(retorno);	
			break;
		default:
			break;
		}
//		RequestDispatcher view = request.getRequestDispatcher("ficha_atendimento.jsp");
//		view.forward(request, response);
	}

}

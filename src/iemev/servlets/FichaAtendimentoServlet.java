package iemev.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import iemev.controllers.AnimalController;
import iemev.controllers.FichaAtendimentoController;
import iemev.models.FichaDeAtendimento;

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
			System.out.println(opcao);
			int idanimal = Integer.parseInt(request.getParameter("idAnimal"));
			JsonObject animal = AnimalController.buscarAnimalId(idanimal);
			JsonObject dono = AnimalController.buscarDonoId(idanimal);
			List<JsonObject> animalDono = new ArrayList<JsonObject>();
			animalDono.add(animal);
			animalDono.add(dono);
			String retorno = new Gson().toJson(animalDono);
			response.setContentType("text/plain");
			response.getWriter().write(retorno);	
			break;
		case 3:
			System.out.println(opcao);
			Date data = new Date();
			int idAtendAbri = Integer.parseInt(request.getParameter("idatendente"));
			int idAnimal = Integer.parseInt(request.getParameter("select_nome_animal"));
			String status = "Aberta";
			
			FichaDeAtendimento ficha = new FichaDeAtendimento(data, idAnimal, idAtendAbri, status);
			String mensagem = FichaAtendimentoController.novaFicha(ficha);
			request.setAttribute("status_insert", mensagem);
			RequestDispatcher view = request.getRequestDispatcher("ficha_atendimento.jsp");
			view.forward(request, response);
			break;
		default:
			break;
		}
//		RequestDispatcher view = request.getRequestDispatcher("ficha_atendimento.jsp");
//		view.forward(request, response);
	}

}

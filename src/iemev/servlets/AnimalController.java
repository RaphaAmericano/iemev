package iemev.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iemev.manager.AnimalManager;
import iemev.models.Animal;

/**
 * Servlet implementation class AnimalServlet
 */
@WebServlet("/animalServlet.do")
public class AnimalController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AnimalController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome").trim();
		String sexoString = request.getParameter("sexo").toUpperCase();
		Character sexo = sexoString.charAt(0);
		SimpleDateFormat dataformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dataString = request.getParameter("dataNascimento") + " 00:00:00";
		Date data = new Date();
		try {
			data = dataformat.parse(dataString); 					
		} 
		catch (Exception e) {	
			e.printStackTrace();
		}
		String especie = request.getParameter("especie").trim();
		String raca = request.getParameter("raca").trim();
		String porte = request.getParameter("porte").trim();
		String pelagem = request.getParameter("pelagem").trim();
		String temperamento = request.getParameter("temperamento").trim();
		long cpf = Long.parseLong(request.getParameter("cpfcliente").trim());
		int idatendente = Integer.parseInt(request.getParameter("idatendente").trim());
		Animal animal = new Animal(nome, sexo, data, especie, raca, porte, pelagem, temperamento, cpf, idatendente );
		String result = AnimalManager.cadastrarAnimal(animal);
		
		RequestDispatcher view = request.getRequestDispatcher("animal.jsp");
		view.forward(request, response);
	}

}

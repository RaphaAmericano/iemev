package iemev.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import iemev.manager.ConsultaManager;

/**
 * Servlet implementation class Consulta
 */
@WebServlet("/consultaServlet.do")
public class ConsultaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConsultaController() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int opcao = Integer.parseInt(request.getParameter("opcao"));
		String dados = request.getParameter("dados");
		List<JsonObject> consultas = new ArrayList<JsonObject>();
		String retorno = "";
		switch (opcao) {
		case 0:
			consultas = ConsultaManager.buscarData(dados);
			retorno = new Gson().toJson(consultas);
			response.setContentType("text/plain");
			response.getWriter().write(retorno);	
			break;
		case 1:
			consultas = ConsultaManager.buscarNome(dados);
			retorno = new Gson().toJson(consultas);
			response.setContentType("text/plain");
			response.getWriter().write(retorno);
			break;
		case 2:
			JsonObject consulta = ConsultaManager.buscarId(Integer.parseInt(dados));
			retorno = new Gson().toJson(consulta);
			response.setContentType("text/plain");
			response.getWriter().write(retorno);
			break;
		default:
			
			break;
		}
		 
	}

}

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
import iemev.manager.ConsultaManager;
import iemev.models.Agendamento;
import iemev.models.Animal;
import iemev.models.Cliente;

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
		case 3:
			long cpf = Long.parseLong(dados);
			Cliente cliente = ClienteManager.buscarId(cpf);
			List<Animal> animais = AnimalManager.buscarAnimaisCliente(cliente.getCpf());
			
			break;
		case 4:
			int idanimal = Integer.parseInt( request.getParameter("nome_animal"));
			String dia = request.getParameter("data");
			String horario = request.getParameter("horario");
			int idatendente = Integer.parseInt(request.getParameter("atendente"));
			int idser = Integer.parseInt(request.getParameter("consulta"));
			SimpleDateFormat dataformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date data = new Date();
			try {
				data = dataformat.parse(dia+ " "+horario );
			} catch (Exception e ) {
				e.printStackTrace();
			}
			Agendamento agendamento = new Agendamento(data, idser, idanimal, idatendente );
			String result = ConsultaManager.incluirConsulta(agendamento);
			
			RequestDispatcher view = request.getRequestDispatcher("consulta.jsp");
			view.forward(request, response);
			
			break;
		default:
			break;
		}
		 
	}

}

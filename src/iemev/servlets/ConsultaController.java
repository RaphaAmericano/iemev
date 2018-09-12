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
		RequestDispatcher view = null;
		String dados = request.getParameter("dados");
		//
		String result = null;
		Agendamento agendamento = null;
		int idAgendamento;
		int idanimal;
		String dia = null;
		String horario = null;
		int idatendente;
		int idser;
		SimpleDateFormat dataformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date data = new Date();
		//
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
			//busca cliente para nova consulta
		case 3:
			long cpf = Long.parseLong(dados);
			Cliente cliente = ClienteManager.buscarId(cpf);
			System.out.println(cliente);
			List<Animal> animais = AnimalManager.buscarAnimaisCliente(cliente.getCpf());
			System.out.println(animais);
			break;
		case 4:
			System.out.println("Case4");
			idanimal = Integer.parseInt( request.getParameter("nome_animal"));
			dia = request.getParameter("data");
			horario = request.getParameter("horario");
			idatendente = Integer.parseInt(request.getParameter("atendente"));
			idser = Integer.parseInt(request.getParameter("consulta"));
			try {
				data = dataformat.parse(dia+ " "+horario );
			} catch (Exception e ) {
				e.printStackTrace();
			}
			agendamento = new Agendamento(data, idser, idanimal, idatendente );
			result = ConsultaManager.incluirConsulta(agendamento);
			
			view = request.getRequestDispatcher("consulta.jsp");
			view.forward(request, response);
			
			break;
			//update
		case 5:
			System.out.println("Case5");
			idAgendamento = Integer.parseInt(request.getParameter("agendamento"));
			idanimal = Integer.parseInt( request.getParameter("nome_animal"));
			dia = request.getParameter("data");
			horario = request.getParameter("horario");
			idatendente = Integer.parseInt(request.getParameter("atendente"));
			idser = Integer.parseInt(request.getParameter("consulta"));
			
			System.out.println(request.getParameter("agendamento"));
			System.out.println(request.getParameter("nome_animal"));
			System.out.println(request.getParameter("data"));
			System.out.println(request.getParameter("horario")+ ":00");
			System.out.println(request.getParameter("atendente"));
			System.out.println(request.getParameter("consulta"));
			try {
				data = dataformat.parse(dia+ " "+horario+":00" );
			} catch (Exception e ) {
				e.printStackTrace();
			}
			agendamento = new Agendamento(idAgendamento, data, idser, idanimal, idatendente );
			System.out.println(agendamento);
			result = ConsultaManager.atualizarConsulta(agendamento);
			request.setAttribute("resposta_update", result);
			view = request.getRequestDispatcher("consulta.jsp");
			view.forward(request, response);
			break;
		default:
			break;
		}
		
	}

}

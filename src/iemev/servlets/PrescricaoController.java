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

import iemev.manager.PrescricaoManager;
import iemev.manager.ServicoManager;
import iemev.models.Prescricao;
import iemev.models.Servico;

/**
 * Servlet implementation class PrescricaoController
 */
@WebServlet("/prescricaoServlet.do")
public class PrescricaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrescricaoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int opcao = Integer.parseInt(request.getParameter("opcao"));
	
	switch(opcao) {
		case 0:
			
			int  numeroficha = Integer.parseInt(request.getParameter("ficha")); 
			int numeroservico = Integer.parseInt(request.getParameter("servico"));
			int idatendente = Integer.parseInt(request.getParameter("atendente"));
			long cpfveterinario = Long.parseLong(request.getParameter("veterinario"));
			int novo_prescricao = PrescricaoManager.inserir(cpfveterinario, numeroficha, numeroservico, idatendente);
			Prescricao prescricao = PrescricaoManager.buscar(novo_prescricao);
			Servico servico = ServicoManager.buscar(prescricao.getIdServico());
			JsonObject json_prescricao = PrescricaoManager.prescricaoJson(prescricao);
			JsonObject json_servico = ServicoManager.servicoJson(servico);
			System.out.println(prescricao);
			System.out.println(servico);
			System.out.println(json_prescricao);
			System.out.println(json_servico);
			//nome veterinario
			List<JsonObject> objeto = new ArrayList<JsonObject>();
			objeto.add(json_prescricao);
			objeto.add(json_servico);
			String retorno = new Gson().toJson(objeto);  
			
			response.setContentType("text/plain");
			response.getWriter().write("OK");
			break;
		default:
			break;
		}
	}
	

}

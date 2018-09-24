package iemev.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
	int numeroficha;
	String retorno;
	Servico servico = null;
	switch(opcao) {
		case 0:
			
			numeroficha = Integer.parseInt(request.getParameter("ficha")); 
			int numeroservico = Integer.parseInt(request.getParameter("servico"));
			int idatendente = Integer.parseInt(request.getParameter("atendente"));
			long cpfveterinario = Long.parseLong(request.getParameter("veterinario"));
			int novo_prescricao = PrescricaoManager.inserir(cpfveterinario, numeroficha, numeroservico, idatendente);
			Prescricao prescricao = PrescricaoManager.buscar(novo_prescricao);
			servico = ServicoManager.buscar(prescricao.getIdServico());
			JsonObject json_prescricao = PrescricaoManager.prescricaoJson(prescricao);
			JsonObject json_servico = ServicoManager.servicoJson(servico);
			
			//nome veterinario
			List<JsonObject> objeto = new ArrayList<JsonObject>();
			objeto.add(json_prescricao);
			objeto.add(json_servico);
			retorno = new Gson().toJson(objeto);  
			response.setContentType("text/plain");
			response.getWriter().write(retorno);
			break;
		case 1:
			numeroficha = Integer.parseInt(request.getParameter("valor")); 
			List<Prescricao> listaprescricoes = PrescricaoManager.buscarTodasPrescricoes(numeroficha);
			List<List> retorno_json = new ArrayList<List>();
			
			for (int i = 0; i < listaprescricoes.size(); i++) {
				servico = ServicoManager.buscar(listaprescricoes.get(i).getIdServico());
				JsonObject prescricao_json = PrescricaoManager.prescricaoJson(listaprescricoes.get(i));
				JsonObject servico_json = ServicoManager.servicoJson(servico);
				List<JsonObject> lista_json = new ArrayList<JsonObject>();
				lista_json.add(prescricao_json);
				lista_json.add(servico_json);
				retorno_json.add(lista_json);
			}
			retorno = new Gson().toJson(retorno_json);
			
			response.setContentType("text/plain");
			response.getWriter().write(retorno);
			break;
		case 2:
			int id_prescricao = Integer.parseInt(request.getParameter("id"));
			
			int deletar = PrescricaoManager.deletar(id_prescricao);
			retorno = new Gson().toJson(deletar);
			
			response.setContentType("text/plain");
			response.getWriter().write(retorno);
			break;
		default:
			break;
		}
	}
	

}

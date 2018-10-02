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

import iemev.manager.FichaAtendimentoManager;
import iemev.manager.PrescricaoManager;
import iemev.manager.ServicoManager;
import iemev.models.FichaDeAtendimento;
import iemev.models.Prescricao;
import iemev.models.Servico;

/**
 * Servlet implementation class RelatorioController
 */
@WebServlet("/relatorioController.do")
public class RelatorioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RelatorioController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double total = 0;
		double retorno = 0;
		List<Prescricao> prescricoes = PrescricaoManager.buscarLista();
		List<FichaDeAtendimento> fichas = FichaAtendimentoManager.todasFichas();
		for(int i = 0; i < prescricoes.size(); i++) {
			Servico servico = ServicoManager.buscar(prescricoes.get(i).getIdServico());
			total += servico.getPreco();
		}
		
		retorno = total / fichas.size();
		request.setAttribute("relatorio", retorno);
		RequestDispatcher view = request.getRequestDispatcher("relatorios.jsp");
		view.forward(request, response);
	}

}

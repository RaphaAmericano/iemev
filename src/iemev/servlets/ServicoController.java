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

import iemev.manager.ServicoManager;
import iemev.models.Servico;

/**
 * Servlet implementation class ServicoController
 */
@WebServlet("/servicoServlet.do")
public class ServicoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ServicoController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int opcao = Integer.parseInt(request.getParameter("opcao"));
		String categoria = request.getParameter("data");
		String result;
		List<Servico> arrayServico = null;
		switch(opcao) {
			case 0:
				arrayServico = ServicoManager.buscarPorCategoria(categoria);
				result = new Gson().toJson(arrayServico);
				response.setContentType("text/plain");
				response.getWriter().write(result);
			break;
			default:
			break;
		}
	}

}

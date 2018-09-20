package iemev.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iemev.manager.PrescricaoManager;

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
	int idservico = Integer.parseInt(request.getParameter("data"));
	
	switch(opcao) {
		case 0:
			int numeroficha = Integer.parseInt(request.getParameter("ficha")); 
			int numeroServico = Integer.parseInt(request.getParameter("servico"));
			int idveterinario = Integer.parseInt(request.getParameter("veterinario"));
			System.out.println(idveterinario);
			//String prescricao = PrescricaoManager.inserir(numeroficha, numeroServico)
			response.setContentType("text/plain");
			response.getWriter().write(idveterinario);
			break;
		}
	}
	

}

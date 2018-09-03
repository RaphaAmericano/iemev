package iemev.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import iemev.controllers.EmpregadoController;
import iemev.controllers.LoginController;
import iemev.models.Empregado;

@WebServlet("/loginServlet.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		
		response.setContentType("text/html");
		
//		int acao = Integer.parseInt(request.getParameter("login"));
		
//		switch (acao) {
//		case 0:
//			Empregado usuario = EmpregadoController.buscar(Long.parseLong(cpf));
			
			
			
//			if(cpf.equals("222")) {
				HttpSession session = request.getSession(true);
				session.setAttribute("cpf", cpf );
				session.setAttribute("senha", senha );
				
				session.setMaxInactiveInterval(30);
				response.sendRedirect("main.jsp");
				
//			}else {
				RequestDispatcher view = request.getRequestDispatcher("index.jsp");
				view.include(request, response);
//			}
			
//			break;
//		case 1: 
//			
//			break;
//		default:
//			break;
//		}
//		
		
		
		
//		request.setAttribute("cpf", cpf );
//		request.setAttribute("senha", senha );
		//RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		//view.forward(request, response);
	}

}

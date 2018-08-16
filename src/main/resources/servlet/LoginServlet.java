package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PessoaDAO;
import model.Pessoa;

@WebServlet("/loginServlet.do")
public class LoginServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cpfUsuario = Integer.parseInt(request.getParameter("cpf"));
		String senhaUsuario = request.getParameter("senha");
		
		PessoaDAO dao = new PessoaDAO();
		Pessoa usr = dao.daoUsuarioGetUsuario(cpfUsuario, senhaUsuario);
		
		//request.setAttribute("cpf", usr);
		
		HttpSession session = request.getSession();
		session.setAttribute("cpf", usr);
		//RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		//rd.forward(request, response);
		response.sendRedirect("index.jsp");
	}

}

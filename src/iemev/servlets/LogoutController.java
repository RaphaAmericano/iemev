package iemev.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/logoutController.do")
public class LogoutController extends HttpServlet {

    public LogoutController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("empregado");
		session.removeAttribute("pessoa");
		session.getMaxInactiveInterval();
		session.invalidate();	
		response.sendRedirect("index.jsp");
	}

}

package iemev.servlets.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;

import iemev.utils.bd.ConnectionFactory;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet.do")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cpf = request.getParameter("cpf");
		//String senha = request.getParameter("senha");
		
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement stm = con.createStatement();
			System.out.print(stm);
			System.out.print("Stament");
			ResultSet rs = stm.executeQuery("SELECT * FROM T_PESSOA");
			con.close();
		}
		catch (SQLException se){
			System.out.println(se);
			se.printStackTrace();
		}
		
		request.setAttribute("cpfUsuario", cpf);
		RequestDispatcher view = request.getRequestDispatcher("main.jsp");
		view.forward(request, response);
	}

}

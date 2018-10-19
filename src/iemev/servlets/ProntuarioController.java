package iemev.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProntuarioController
 */
@WebServlet("/ProntuarioController")
public class ProntuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProntuarioController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Buscar o usuario
		 * listar os animais do usuario
		 * selecionar as fichas do animal com status de FECHADA
		 * listar as prescricoes das fichas a partir do numero da ficha
		 * 
		 * 
		 * */
	}

}

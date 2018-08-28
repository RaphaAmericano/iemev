package iemev.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import iemev.controllers.ClienteController;
import iemev.models.Cliente;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/clienteServlet.do")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tipoFormulario = Integer.parseInt(request.getParameter("tipoFormulario"));
		String formulario = "";
		
		
		
		switch(tipoFormulario) {
			//Busca por data
			case 0: {

				formulario = "busca";
				break;
			}
			//Busca por nome
			case 1: {

				formulario = "detalhar";
				break;
			}
			//CRUD usuario
			case 2: {
				String nome = request.getParameter("nome").trim();
				long cpf = Long.parseLong(request.getParameter("cpf").trim());
				long rg = Long.parseLong(request.getParameter("rg").trim());
				
				
				SimpleDateFormat dataformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dataString = request.getParameter("data") + " 00:00:00";
				Date data = new Date();
				try {
					data = dataformat.parse(dataString); 					
				} 
				catch (Exception e) {	
					e.printStackTrace();
				}
				System.out.println(data);
				String endereco = request.getParameter("endereco").trim();
				String telefone = request.getParameter("telefone").trim();
				String celular = request.getParameter("celular").trim();
				String email = request.getParameter("email").trim();
				int idAtend = Integer.parseInt(request.getParameter("idatendente"));
				System.out.println(cpf+ " "+rg+" "+nome+" "+endereco+" "+telefone+" "+celular+" "+email+" "+idAtend);
				Cliente cliente = new Cliente(cpf, rg, nome, endereco, telefone, celular, data, email, idAtend);
				String result = ClienteController.cadastrarCliente(cliente);
				System.out.println(result);
				break;
			}
			
		}
		
		request.setAttribute("tipo", formulario);
		RequestDispatcher view = request.getRequestDispatcher("cliente.jsp");
		view.forward(request, response);
		
	}

}

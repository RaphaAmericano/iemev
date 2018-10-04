package iemev.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import iemev.manager.EmpregadoManager;
import iemev.manager.LoginManager;
import iemev.manager.PessoaManager;
import iemev.models.Empregado;
import iemev.models.Pessoa;

@WebServlet("/loginServlet.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LoginController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpf = request.getParameter("cpf").replace(".", "").replaceAll("-", "");		
		String senha = request.getParameter("senha");
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		int acao = Integer.parseInt(request.getParameter("login"));
		Empregado empregado = EmpregadoManager.buscar(Long.parseLong(cpf));
		String mensagem_erro;
		long cpfLong = Long.parseLong(cpf);
		if(empregado == null ) {
			mensagem_erro = "Usuário inexistente";
			request.setAttribute("mensagem_erro", mensagem_erro);
			rd.forward(request, response);
		}
		
		if(cpfLong != empregado.getCpf() ) {
			mensagem_erro = "CPF inválido";
			request.setAttribute("mensagem_erro", mensagem_erro);
			rd.forward(request, response);
		}
		if(!senha.equals(empregado.getSenha())) {
			mensagem_erro = "Senha inválida";
			request.setAttribute("mensagem_erro", mensagem_erro);
			rd.forward(request, response);
		}	
		
		Pessoa pessoa = PessoaManager.buscarId(empregado.getCpf());
		HttpSession session = request.getSession(true);
		session.setAttribute("cpf", cpf );
		session.setAttribute("senha", senha );
		session.setAttribute("pessoa", pessoa);
		session.setAttribute("empregado", empregado);
		session.setMaxInactiveInterval(30);
		response.sendRedirect("main.jsp");		
	}

}

package iemev.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import iemev.manager.ClienteManager;
import iemev.manager.PessoaManager;
import iemev.models.Cliente;
import iemev.models.Pessoa;
import iemev.utils.DataUtils;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/clienteServlet.do")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ClienteController() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tipoFormulario = Integer.parseInt(request.getParameter("opcao"));
		
		switch(tipoFormulario) {
			case 0: {
				String nome = request.getParameter("busca");
				List<Pessoa> pessoas = PessoaManager.buscarNome(nome);
				List<List<JsonObject>> lista_par = new ArrayList<List<JsonObject>>();
				for(int i = 0; i < pessoas.size(); i++) {
					Cliente cliente = ClienteManager.buscarId(pessoas.get(i).getCpf());
					if(cliente != null ) {
						JsonObject pessoa_j = PessoaManager.pessoaJson(pessoas.get(i));
						JsonObject cliente_j = ClienteManager.clienteJson(cliente);
						List<JsonObject> par = new ArrayList<JsonObject>();
						par.add(pessoa_j);
						par.add(cliente_j);
						lista_par.add(par);
					}
				}	
				String retorno = new Gson().toJson(lista_par);
				response.setContentType("text/plain");
				response.getWriter().write(retorno);
				break;
			}
			//Busca por nome
			case 1: {
				long cpf = Long.parseLong(request.getParameter("cpf"));
				Pessoa pessoa = PessoaManager.buscarId(cpf);
				Cliente cliente = ClienteManager.buscarId(pessoa.getCpf());
				JsonObject pessoa_j = PessoaManager.pessoaJson(pessoa);
				JsonObject cliente_j = ClienteManager.clienteJson(cliente);
				
				List<JsonObject> lista = new ArrayList<JsonObject>();
				lista.add(pessoa_j);
				lista.add(cliente_j);
				String retorno = new Gson().toJson(lista);
				response.setContentType("text/plain");
				response.getWriter().write(retorno);
				break;
			}
			//CRUD usuario
			case 2: {
				String nome = request.getParameter("nome").trim();
				long cpf = Long.parseLong(request.getParameter("cpf").trim());
				long rg = Long.parseLong(request.getParameter("rg").trim());	
				Date data = DataUtils.parseData(request.getParameter("data") + " 00:00:00");
				String endereco = request.getParameter("endereco").trim();
				String telefone = request.getParameter("telefone").trim();
				String celular = request.getParameter("celular").trim();
				String email = request.getParameter("email").trim();
				int idAtend = Integer.parseInt(request.getParameter("idatendente"));
				String mensagem = "Cliente cadastrado com sucesso";
				
				Cliente cliente = new Cliente(cpf, rg, nome, endereco, telefone, celular, data, email, idAtend);
				int result_pessoa = PessoaManager.inserir(cliente);
				if( result_pessoa == 0 ) {
					int result_cliente = ClienteManager.cadastrarCliente(cliente);	
					request.setAttribute("cliente", cliente);
				} else {
					mensagem = "Erro ao cadastrar o cliente";
				}
				request.setAttribute("mensagem_crud", mensagem);
				request.setAttribute("cpf_cliente", Long.toString(cliente.getCpf()));
				RequestDispatcher view = request.getRequestDispatcher("animal.jsp");
				view.forward(request, response);
				break;
			}
			
			case 3: {
				
				break;
			}
			
			case 4: {
				long cpf = Long.parseLong(request.getParameter("cpf"));
				int deletarCliente = ClienteManager.deletar(cpf);
				String mensagem = "Cliente excluído com sucesso";
				if(deletarCliente == 1 ) {
					PessoaManager.deletar(cpf);	
				} else {
					mensagem = "Não foi possível excluir o cliente";
				}
				request.setAttribute("mensagem_crud", mensagem);
				RequestDispatcher view = request.getRequestDispatcher("cliente.jsp");
				view.forward(request, response);
			}
		}
		
//		RequestDispatcher view = request.getRequestDispatcher("cliente.jsp");
//		view.forward(request, response);
		
	}

}

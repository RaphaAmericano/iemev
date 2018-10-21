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
import com.google.gson.JsonObject;

import iemev.manager.AnimalManager;
import iemev.manager.ClienteManager;
import iemev.manager.FichaAtendimentoManager;
import iemev.manager.PessoaManager;
import iemev.manager.PrescricaoManager;
import iemev.manager.ServicoManager;
import iemev.models.Animal;
import iemev.models.Cliente;
import iemev.models.FichaDeAtendimento;
import iemev.models.Pessoa;
import iemev.models.Prescricao;
import iemev.models.Servico;

/**
 * Servlet implementation class ProntuarioController
 */
@WebServlet("/ProntuarioServlet.do")
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
		int opcao = Integer.parseInt(request.getParameter("opcao"));
		long cpf;
		List conjunto;
		String retorno;
		switch (opcao) {
		case 0:
			cpf = Long.parseLong(request.getParameter("cpf").replace(".", "").replace("-", ""));
			Cliente cliente = ClienteManager.buscarId(cpf);
			if(cliente == null ) {
				response.setContentType("text/plain");
				response.getWriter().write("Usuário não foi encontrado");
				break;
			}
			Pessoa pessoa = PessoaManager.buscarId(cpf);
			JsonObject pessoa_j = PessoaManager.pessoaJson(pessoa);
			List<Animal> lista = AnimalManager.buscarAnimaisCliente(cpf);
			List<JsonObject> lista_j = new ArrayList<JsonObject>();
			conjunto = new ArrayList();
			for(int i = 0; i < lista.size(); i++ ) {
				JsonObject animal_j = AnimalManager.animalJson(lista.get(i));
				lista_j.add(animal_j);
			}
			conjunto.add(pessoa_j);
			conjunto.add(lista_j);
			retorno = new Gson().toJson(conjunto);
			response.setContentType("text/plain");
			response.getWriter().write(retorno);
			break;
		case 1:
			int id_animal = Integer.parseInt(request.getParameter("idanimal"));
			Animal animal = AnimalManager.buscar(id_animal);
			List<FichaDeAtendimento> fichas = FichaAtendimentoManager.fichasAbertasAnimal(id_animal);
			List<JsonObject> fichas_j = new ArrayList<JsonObject>();
			List<JsonObject> lista_prescricoes = new ArrayList<JsonObject>();
			
			
			for(int i = 0; i < fichas.size(); i++ ) {
				List<Prescricao> prescricoes = PrescricaoManager.buscarTodasPrescricoes(fichas.get(i).getNumeroFicha());
				
				for( int k = 0; k < prescricoes.size(); k++ ) {
					JsonObject prescricao_j = PrescricaoManager.prescricaoJson(prescricoes.get(k));
					Servico servico = ServicoManager.buscar(prescricoes.get(k).getIdServico());
					Pessoa veterinario = PessoaManager.buscarId(prescricoes.get(k).getCpfVeterinario());
					prescricao_j.addProperty("servico", servico.getNomeServico());
					prescricao_j.addProperty("categoria", servico.getCategoria());
					prescricao_j.addProperty("veterinario", veterinario.getNome());
					//Buscar o veterinaro e add property
					//Buscar a categoria do servioco
					lista_prescricoes.add(prescricao_j);
				}
			}
			conjunto = new ArrayList();
			conjunto.add(animal);
			conjunto.add(lista_prescricoes);
			retorno = new Gson().toJson(conjunto);
			response.setContentType("text/plain");
			response.getWriter().write(retorno);
			break;
		default:
			break;
		}
		
		
	}

}

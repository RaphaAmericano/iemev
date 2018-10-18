package iemev.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import iemev.manager.AnimalManager;
import iemev.manager.ClienteManager;
import iemev.manager.EmpregadoManager;
import iemev.manager.FichaAtendimentoManager;
import iemev.manager.PrescricaoManager;
import iemev.models.Animal;
import iemev.models.Cliente;
import iemev.models.Empregado;
import iemev.models.FichaDeAtendimento;

/**
 * Servlet implementation class FichaAtendimentoServlet
 */
@WebServlet("/FichaAtendimentoServlet.do")
public class FichaAtendimentoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FichaAtendimentoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int opcao = Integer.parseInt(request.getParameter("opcao"));
		RequestDispatcher view = request.getRequestDispatcher("ficha_atendimento.jsp");
		int id_ficha;
		int alterar;
		String mensagem;
		switch (opcao) {
		case 0:
			String palavra = request.getParameter("busca").trim();
			ArrayList<String> resultArray = FichaAtendimentoManager.buscarString(palavra);
			String result = new Gson().toJson(resultArray);
			response.setContentType("text/plain");
			response.getWriter().write(result);	
			break;
		case 1:
			long idusuario = Long.parseLong(request.getParameter("idcliente"));
			ArrayList<String> animais = FichaAtendimentoManager.buscarAnimais(idusuario);
			String resultAnimal;
			if(animais == null ) {
				resultAnimal = "Errou ao buscar no banco";
			} 
			else if(animais.size() == 0) {
				resultAnimal = "Nenhum animal encontrado";
			} else {
				resultAnimal = new Gson().toJson(animais);	
			}
			response.setContentType("text/plain");
			response.getWriter().write(resultAnimal);	
			break;
		case 2:
			int idanimal = Integer.parseInt(request.getParameter("idAnimal"));
			JsonObject animal = AnimalManager.buscarAnimalId(idanimal);
			JsonObject dono = AnimalManager.buscarDonoId(idanimal);
			List<JsonObject> animalDono = new ArrayList<JsonObject>();
			animalDono.add(animal);
			animalDono.add(dono);
			String retorno = new Gson().toJson(animalDono);
			response.setContentType("text/plain");
			response.getWriter().write(retorno);	
			break;
		case 3:
			Date data = new Date();
			int idAtendAbri = Integer.parseInt(request.getParameter("idatendente"));
			int idAnimal = Integer.parseInt(request.getParameter("select_nome_animal"));
			mensagem = "Não foi possível cadastrar nova ficha";
			System.out.println(idAnimal);
			FichaDeAtendimento ficha = new FichaDeAtendimento(data, idAnimal, idAtendAbri);
			
			int idNovaFicha = FichaAtendimentoManager.novaFicha(ficha);
			if(idNovaFicha > 0 ) {
				mensagem = "Ficha cadastrada com sucesso";
			}
			FichaDeAtendimento fichaRequest = FichaAtendimentoManager.buscarPorId(idNovaFicha);
			request.setAttribute("numero_ficha", fichaRequest.getNumeroFicha());
			request.setAttribute("data_abertura", fichaRequest.getDataAbertura());
			request.setAttribute("data_fechamento", fichaRequest.getDataFechamento());
			request.setAttribute("id_animal", fichaRequest.getIdAnimal());
			request.setAttribute("id_atendente_abriu", fichaRequest.getIdAtendenteAbriuFicha());
			request.setAttribute("id_atendente_fechou", fichaRequest.getIdAtendenteFechouFicha());
			//request.setAttribute("status", fichaRequest.getStatusFicha());
			request.setAttribute("status", fichaRequest.getStatusAtual().stateString());
//			.....completar os setAttributes como os acima			
			request.setAttribute("status_insert", mensagem);
			view.forward(request, response);
			break;
		case 4:
			long idcliente = Long.parseLong(request.getParameter("idcliente"));	
			ArrayList<FichaDeAtendimento> fichas = FichaAtendimentoManager.fichasUsuario(idcliente);
			ArrayList<ArrayList> fichas_ = new ArrayList<ArrayList>();		
			for (int i = 0; i < fichas.size(); i++) {
				Animal animal_obj = AnimalManager.buscar(fichas.get(i).getIdAnimal());
				JsonObject ficha_ = FichaAtendimentoManager.fichaJson(fichas.get(i));
				JsonObject animal_ = AnimalManager.animalJson(animal_obj);
				ArrayList<JsonObject> conjunto_ = new ArrayList<JsonObject>();
				
				conjunto_.add(animal_);
				conjunto_.add(ficha_);
				fichas_.add(conjunto_);
			}

			String retornojson = new Gson().toJson(fichas_);
			response.setContentType("text/plain");
			response.getWriter().write(retornojson);
			break;
		case 5:
			id_ficha = Integer.parseInt(request.getParameter("data"));
			FichaDeAtendimento ficha_detalhe = FichaAtendimentoManager.buscarPorId(id_ficha);
			Animal ficha_animal = AnimalManager.buscar(ficha_detalhe.getIdAnimal());
			Cliente ficha_cliente = ClienteManager.buscarId(ficha_animal.getCpfCliente());
			//Empregado atendente = EmpregadoManager.buscarId(ficha_detalhe.getIdAtendenteAbriuFicha());
			//
			SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//JsonObject json_atendente = EmpregadoManager.empregadoJson(atendente);
			JsonObject animalJson = new JsonObject();
			try {
				animalJson.addProperty("id", ficha_animal.getIdAnimal());
				animalJson.addProperty("nome", ficha_animal.getNomeAnimal());
				animalJson.addProperty("sexo", ficha_animal.getSexo());
				animalJson.addProperty("data", dataFormat.format(ficha_animal.getDataDeNascimentoAnimal()));
				animalJson.addProperty("especie", ficha_animal.getEspecie());
				animalJson.addProperty("porte", ficha_animal.getPorte());
				animalJson.addProperty("raca", ficha_animal.getRaca());
				animalJson.addProperty("pelagem", ficha_animal.getPelagem());
				animalJson.addProperty("temperamento", ficha_animal.getTemperamento());
				animalJson.addProperty("cpf", ficha_animal.getCpfCliente());
				animalJson.addProperty("idAtendente", ficha_animal.getIdAtendimentoDeCadastramento());	
			} catch(JsonIOException je) {
				je.printStackTrace();
			}
			JsonObject donoJson = new JsonObject();
			try {
				donoJson.addProperty("nome", ficha_cliente.getNome());
				donoJson.addProperty("cpf", ficha_cliente.getCpf());
				donoJson.addProperty("telefone", ficha_cliente.getTelefoneResidencial());
				donoJson.addProperty("celular", ficha_cliente.getCelular());
				donoJson.addProperty("email", ficha_cliente.getEmailCliente());
			}catch(JsonIOException je) {
				je.printStackTrace();
			}
			JsonObject fichaJson = new JsonObject();
			try {
				fichaJson.addProperty("status", ficha_detalhe.getStatusAtual().stateString());
				fichaJson.addProperty("numero_sequencial", ficha_detalhe.getNumeroFicha());
				fichaJson.addProperty("data_abertura", dataFormat.format(ficha_detalhe.getDataAbertura()));
			} catch(JsonIOException je) {
				je.printStackTrace();
			}
			
			//Fazer um decorator para retornar o valar da soma dos precos
			
			List<JsonObject> retornoLista = new ArrayList<JsonObject>();
			retornoLista.add(animalJson);
			retornoLista.add(donoJson);
			retornoLista.add(fichaJson);
			//retornoLista.add(json_atendente);
			String retornoJson = new Gson().toJson(retornoLista);
			//
			response.setContentType("text/plain");
			response.getWriter().write(retornoJson);
			break;
		case 6:
			id_ficha = Integer.parseInt(request.getParameter("id_ficha"));
			int deletar = FichaAtendimentoManager.deletar(id_ficha);
			mensagem = "Não foi possível excluir a ficha";
			if( deletar > 0 ) {
				mensagem = "Ficha excluída com sucesso";
				PrescricaoManager.deletarTodas(id_ficha);
			}
			request.setAttribute("status_delete", mensagem);
			view.forward(request, response);
			break;
		case 7:
			id_ficha = Integer.parseInt(request.getParameter("id_ficha"));
			alterar = FichaAtendimentoManager.abrirFicha(id_ficha);
			mensagem = "Não foi possível abrir a ficha";
			if(alterar > 0 ) {
				mensagem = "Ficha número "+request.getParameter("id_ficha")+" aberta com sucesso";
			}
			request.setAttribute("status_ficha", mensagem);
			view = request.getRequestDispatcher("finalizar_atendimento.jsp");;
			view.forward(request, response);
			break;
		case 8:
			id_ficha = Integer.parseInt(request.getParameter("id_ficha"));
			alterar = FichaAtendimentoManager.fecharFicha(id_ficha);
			mensagem = "Não foi possível fechar a ficha";
			if(alterar > 0 ) {
				mensagem = "Ficha número "+request.getParameter("id_ficha")+" fechada com sucesso";
			}
			request.setAttribute("status_ficha", mensagem);
			view = request.getRequestDispatcher("finalizar_atendimento.jsp");;
			view.forward(request, response);
			break;
		default:
			break;
		}
		
	}

}

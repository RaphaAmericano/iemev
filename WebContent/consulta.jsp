<%@page import="iemev.models.Servico"%>
<%@page import="iemev.manager.ServicoManager"%>
<%@page import="java.util.List"%>
<%@include file="_header.jsp" %>
<%
Empregado empregado = (Empregado) session.getAttribute("empregado");
if(empregado != null ){
	if(empregado.getTipoEmpregado().equals("veterinario")){
		response.sendRedirect("main.jsp");
	}	
}
%>
<%
List<Servico> servicos = ServicoManager.buscarTodosServicos();
String resposta_update = (String)request.getAttribute("resposta_update");
String resposta_delete = (String)request.getAttribute("resposta_delete");
String resposta_insert = (String)request.getAttribute("resposta_insert");
%>

<!-- Por data -->
    <div class="container">
        <div class="row justify-content-md center">
            <div class="col col-xs col-md-auto col-md-12 mt-2" id="buscaData">
                <h2 class="font-weight-bold">Consultar agendamento por data</h2>
                <div class="form-group col-2 p-0">
                    <label for="">Buscar por data</label>
                    <input class="form-control" name="data" type="date">
                </div>
                <button class="btn btn-primary" >Localizar por data</button>
            </div>
        </div>
    </div>
    <!-- /por data -->
    <div class="container">
        <div class="row justify-content-md center">
            <div class="col col-xs col-md-auto col-md-12 mt-2" id="buscaNome">
                <h2 class="font-weight-bold">Consultar agendamento por nome do cliente</h2>
                <div>
                    <div class="form-group col-6 p-0">
                        <label for="">Buscar por nome</label>
                        <input class="form-control" type="search">
                    </div>
                    <button class="btn btn-primary" type="submit">Localizar por nome</button>
                </div>
            </div>
        </div>
    </div>
<!-- Lista de Clientes - exibir apenas em caso da tela ser acessada pela funcionalidade de busca pelo nome do cliente -->
    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col col-xs col-md-auto col-md-12 mt-2">
                <div class="form-group" id="selectAgendamento">
                	<label for="animal">Agendamentos</label>
                    <select name="animal" class="form-control" multiple="multiple">
                    </select>
                    <button class="btn btn-success mt-2" value="selecionar" name="agendamento" type="submit">Detalhar agendamento</button>
                </div>
            </div>
        </div>
    </div>
    <!--  -->
    <div class="container">
        <div class="row">
            <div class="col col-xs">
                <form action="consultaServlet.do" method="POST" id="formularioConsulta">
                    <div class="form-row">
                        <div class="col-8 col-xs-12 mt-2">
                            <button type="button" class="btn btn-success" id="incluirAge">Incluir novo agendamento</button>
                            <button type="button" class="btn btn-warning" id="alterarAge" disabled>Alterar agendamento</button>
                            <button type="button" class="btn btn-danger" id="excluirAge" disabled data-toggle="modal" data-target="#modalConfirmacao">Excluir agendamento</button>
                        </div>
                    </div>
                    <% if(resposta_insert != null ) {  %>
                    <div class="alert alert-success mt-2" role="alert">
					<%=resposta_insert %>
					</div>
					<% }%>
                    <% if(resposta_update != null ) {  %>
                    <div class="alert alert-warning mt-2" role="alert">
					<%=resposta_update %>
					</div>
					<% }%>
					 <% if(resposta_delete != null ) {  %>
                    <div class="alert alert-danger mt-2" role="alert">
					<%=resposta_delete %>
					</div>
					<% }%>
                    <div class="form-row mt-2">
                        <div class="col-md-6 mb-3">
                            <label for="cpfcliente">CPF do Cliente *</label>
                            <input class="form-control" type="number" name="cpfcliente" maxlength="99999999999" readonly>
                            <div class="mt-2">
                                <button type="button" class="btn btn-success" disabled>OK</button>
                                <a href="cliente.jsp" class="btn btn-primary">Adicionar Cliente</a>
                            </div>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="nome_animal">Nome do Animal *</label>
                            <select name="nome_animal" class="form-control" readonly="readonly">
                            </select>
                            <div class="valid-feedback"></div>
                            <div class="mt-2">
                                <a href="animal.jsp" class="btn btn-primary">Adicionar Animal</a>
                            </div>
                        </div>
                    </div>
                    <div class="form-row mt-2">
                        <div class="col-md-6 mb-3">
                            <label for="nome_cliente">Nome do Cliente *</label>
                            <input type="text" name="nome_cliente" class="form-control" readonly>
                            <div class="valid-feedback">Inválido</div>
                        </div>
                        <div class="col-md-2 mb-3">
                            <label for="data">Data da consulta *</label>
                            <!-- Exemplo: -->
                            <input type="date" name="data" value="" class="form-control" readonly>
                            <div class="valid-feedback">Inválido</div>
                        </div>
                        <div class="col-md-2 mb-3">
                            <label for="horario">Horário *</label>
                            <!-- Exemplo: -->
                            <input type="time" name="horario" value="" class="form-control" readonly>
                            <!-- formato entrada 18:30 -->
                            <div class="valid-feedback">Inválido</div>
                        </div>
                        <div class="col-md-2 md-3">
                            <label for="consulta">Tipo de Consulta *</label>
                            <select class="form-control" name="consulta" readonly="readonly">
                           	<% if( servicos != null || servicos.isEmpty() ){
                           		for( Servico servico : servicos) { %>
                           		<option value="<%= servico.getIdServico() %>"><%=servico.getCategoria()+" "+servico.getNomeServico()%></option>	
                           		<% }
                           		
                           	} %>
                           	</select>
                        </div>
                    </div>
                    <!-- Em seguida, os campos são os especiais de cada tipo de usuario do sistema -->
                    <div class="form-row mt-2">
                        <div class="col-md-12 mx-auto">
                        <!-- Adicionar por jsp para o usuario da sessao no valor od atendente -->
	                        <input type="hidden" name="atendente" value="0">
                        	<input type="hidden" name="opcao" value="3">
                        	
                           <input type="submit" value="Agendar" class="btn btn-primary" disabled>
                           <input type="hidden" name="agendamento" value="0">
                        </div>
                    </div>
                    <!-- Modal de confirmação -->
                    <div class="modal fade" id="modalConfirmacao" tabindex="-1" role="dialog" aria-labelledby="modalConfirmacaoLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
	                        <div class="modal-content">
	                            <div class="modal-header">
	                            <h5 class="modal-title" id="modalConfirmacaoLabel">Confirme a Exclusão do Agendamento</h5>
	                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                                <span aria-hidden="true">&times;</span>
	                            </button>
	                            </div>
	                            <div class="modal-body">
	                            Deseja excluir o atendimento
	                            </div>
	                            <div class="modal-footer">
	                            <input type="submit" class="btn btn-danger" value="Sim">
	                            <button type="button" class="btn btn-success">Não</button>
	                            </div>
	                        </div>
                        </div>
                    </div>
                    <!-- /Modal de confirmação -->
                </form>
            </div>
        </div>
    </div>
<%@include file="_footer.jsp" %>
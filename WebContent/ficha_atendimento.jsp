<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="iemev.models.Servico"%>
<%@page import="iemev.manager.ServicoManager"%>
<%@include file="_header.jsp" %>
<%
List<Servico> servicos = ServicoManager.buscarTodosServicos();
List<String> categorias = ServicoManager.buscarTodasCategorias();
Empregado empregado = (Empregado) session.getAttribute("empregado");
String mensagem = null;

%>


    <!-- Consulta -->
    <div class="container">
        <div class="row justify-content-md center">
            <div class="col col-xs col-md-auto col-md-12">
                <h1 class="font-weight-bold">Consultar Ficha</h1>
                <form action="FichaAtendimentoServlet.do" id="formBuscarUsuarios">
                    <div class="form-group">
                        <label for="">Buscar Cliente</label>
                        <input class="form-control" type="search" placeholder="Nome do Cliente">                        
                    </div>
                    <button class="btn btn-primary" type="submit" disabled>Localizar</button>
                </form>
            </div>
        </div>
    </div>

<!-- Lista de animais - exibir apenas em caso da tela ser acessada pela funcionalidade de busca -->
    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col col-xs col-md-auto col-md-12 mt-2">
                <form action="ficha_atendimento.html" id="cliente_ficha">
                    <div class="form-group">
                        <label for="animal">Clientes</label>
                        <select name="cliente" class="form-control" multiple="multiple">
                            
                        </select>
                        <button class="btn btn-success mt-2" value="selecionar" name="cliente" type="submit">OK</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
<!-- /Lista -->
    <!-- Lista de Fichas -->

    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col col-xs col-md-auto col-md-12">
                <form action="FichaAtendimentoServlet.do" id="tabela_prescricoes">
                <table class="table table-hover">
                    <thead>
                        <tr>
                        <th scope="col">Número da Ficha</th>
                        <th scope="col">Data de Abertura</th>
                        <th scope="col">Nome do Animal</th>
                        <th scope="col">Opções</th>
                        </tr>
                    </thead>
                    <tbody id="tabelaFichas">
                    </tbody>
                </table>
                </form>
            </div>
        </div>
    </div>
    <!-- /Lista de Fichas -->
    <div class="container">
        <div class="row">
            <div class="col col-xs mt-4">
                <h1>Ficha de Atendimento</h1>
                <form action="FichaAtendimentoServlet.do" method="POST" id="ficha_atendimento">
                    
                	<div class="form-row mt-2">
                        <div class="col-md-6 mb-3">
                            <label for="select_nome_animal">Nome do Animal</label>
                            <select name="select_nome_animal" class="form-control" disabled>
                            </select>
                            <div class="valid-feedback">Inválido</div>
                        </div>
                        
                    </div>
                    <div class="form-row mt-2">
                        <div class="col-3 col-xs-12 col-md-auto">
                            <input type="submit" class="btn btn-success" value="Abrir Ficha" disabled>
                            <button type="button" class="btn btn-warning" disabled>Alterar Ficha</button>
                            <button type="button" class="btn btn-danger" disabled data-toggle="modal" data-target="#modalExcluir">Excluir Ficha</button>
                            <input type="hidden" name="opcao" value="3">
                        </div>
                    </div>
                    <div class="form-row mt-2">
                        <div class="col-md-4 md-3">
                            <label for="">Status</label>
                            <input class="form-control" name="status" type="text" readonly>
                        </div>
                        <div class="col-md-4 md-3">
                            <label for="">Número Sequecial</label>
                            <input class="form-control" name="id_ficha" type="number" readonly>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="data">Data de Abertura</label>
                            <input type="date" name="data_abertura" class="form-control" readonly>
                            <div class="valid-feedback">Inválido</div>
                        </div>
                    </div>
                    <div class="form-row mt-2">
                        
                        <div class="col-md-3 mb-3">
                            <label for="data">Data de Nascimento</label>
                            <input type="date" name="data" class="form-control" readonly>
                            <div class="valid-feedback">Inválido</div>
                        </div>
                      

                        <div class="col-md-3">
                            <label for="especie">Espécie</label>
                            <input class="form-control" type="text" name="especie" readonly>
                        </div>
                        <div class="col-md-3">
                            <label for="raca">Raça</label>
                            <input class="form-control" type="text" name="raca" readonly>
                        </div>

                        <div class="col-md-3 mb-3">
                            <label for="sexo">Sexo</label>
                            <div class="form-check">
                                <input type="radio" class="form-check-imput" name="sexo" value="0" readonly>
                                <label for="sexo" class="form-check-label">Masculino</label>
                            </div>
                            <div class="form-check">
                                <input type="radio" class="form-check-imput" name="sexo" value="1" readonly>
                                <label for="sexo" class="form-check-label">Feminino</label>
                            </div>
                            
                            <div class="valid-feedback"></div>
                        </div>
                    </div>
                    
                    <div class="form-row mt-2">
                        
                        <div class="col-md-4">
                            <label for="porte">Porte</label>
                            <input class="form-control" type="text" name="porte" readonly>
                        </div>
                        <div class="col-md-4">
                            <label for="pelagem">Pelagem</label>
                            <input class="form-control" type="text" name="pelagem" readonly>
                        </div>
                        <div class="col-md-4">
                            <label for="temperamento">Temperamento</label>
                            <input class="form-control" type="text" name="temperamento" readonly>
                        </div>
                    </div>
                    <!-- Em seguida, os campos são os especiais de cada tipo de usuario do sistema -->      

                    <div class="form-row mt-2">
                        <div class="col-md-6">
                            <label for="cpfcliente">Nome do Cliente</label>
                            <input class="form-control" type="text" name="nomecliente" readonly>
                        </div>
                        <div class="col-md-6">
                            <label for="cpfcliente">CPF do Cliente</label>
                            <input class="form-control" type="number" name="cpfcliente" placeholder="000.000.000-00" readonly>
                        </div>
                    </div>
                    
                    <div class="form-row mt-2">
                        <div class="col-md-4">
                            <label for="telefone">Telefone Residencial</label>
                            <input class="form-control" type="number" name="telefone" placeholder="(00) 0000-0000" readonly>
                        </div>
                        <div class="col-md-4">
                            <label for="celular">Telefone Celular</label>
                            <input class="form-control" type="number" name="celular" placeholder="(00) 0-0000-0000" readonly>
                        </div>
                        <div class="col-md-4">
                            <label for="email">Email</label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">@</span>
                                </div>
                                <input class="form-control" type="email" name="email" readonly>
                            </div>
                        </div>
                    </div>
                    <div class="form-row mt-2">
                        <div class="col-md-2">
                            <label for="idatendente">Nome do Atendente</label>
                            <input class="form-control" type="text" name="nome_atendente" placeholder="" value="" readonly>
                            <input class="form-control" type="hidden" name="idatendente" value="" readonly>
                            <input type="hidden" name="cpf_veterinario" value="<%=empregado.getCpf() %>">
                            <input class="form-control" type="hidden" name="id_atendente_ativo" value="<%=empregado.getIdEmpregado() %>" readonly>
                        </div>
                    </div>
                    
                    <% if(request.getAttribute("status_insert") != null ){ %>
                    <div class="form-row mt-2">
                        <div class="col-12">
                        	<% if(request.getAttribute("status_insert") == "Ficha cadastrada com sucesso" ){ %>
                        	<div class="alert alert-success" role="alert">
							  <%=request.getAttribute("status_insert") %>
							</div> 
							<% } else {  %>
	                       <div class="alert alert-danger" role="alert">
							  <%=request.getAttribute("status_insert") %>
							</div>
						 	 <% } %>
                    	</div>
                    </div>
                    <% } %>
                    
                    <!--  -->
                    <% if(request.getAttribute("status_delete") != null ){ %>
                    <div class="form-row mt-2">
                        <div class="col-12">
                        	<% if(request.getAttribute("status_delete") == "Ficha excluída com sucesso" ){ %>
                        	<div class="alert alert-success" role="alert">
							  <%=request.getAttribute("status_delete") %>
							</div> 
							<% } else {  %>
	                       <div class="alert alert-danger" role="alert">
							  <%=request.getAttribute("status_delete") %>
							</div>
						 	 <% } %>
                    	</div>
                    </div>
                    <% } %>
                    <!--  -->
                    <div class="form-row mt-4">
                        <div class="col-md-12">
                            <h2>Serviços</h2>
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                    <th scope="col">Item #</th>
                                    <th scope="col">Categoria</th>
                                    <th scope="col">Serviço</th>
                                    <th scope="col">Nome do Veterinário</th>
                                    <th scope="col">Data da Prescrição</th>
                                    <th scope="col">Preço</th>
                                    <th scope="col">Excluir</th>
                                    </tr>
                                </thead>
                                <tbody id="tabelaServicos">
                                    <tr>
                                   	<th scope="row">Incluir</th>
                                      <td>
                                          <select name="categoria" id="" class="form-control" disabled>
                                             <%for(int i = 0; i < categorias.size(); i++){ 
                                             %>
											<option value="<%=categorias.get(i) %>"><%=categorias.get(i)%></option>
										<%  }%>
                                          </select> 
                                      </td>
                                      <td>
                                          <select name="servico" id="" class="form-control" disabled>
                                              
                                          </select> 
                                      </td>
                                      <td colspan="2"></td>
                                      <td></td>
                                      <td>
                                          <button type="button" class="btn btn-success" disabled="disabled">Incluir</button>
                                      </td>
                               	 	</tr>
                                </tbody>
                                </table>
                        </div>
                    </div>
                    <!-- Modal de confirmação -->
                    <div class="modal fade" id="modalExcluir" tabindex="-1" role="dialog" aria-labelledby="modalConfirmacaoLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
	                        <div class="modal-content">
	                            <div class="modal-header">
	                            <h5 class="modal-title" id="modalConfirmacaoLabel">Confirme a Exclusão da Ficha de Atendimento</h5>
	                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                                <span aria-hidden="true">&times;</span>
	                            </button>
	                            </div>
	                            <div class="modal-body">
	                            Deseja excluir o atendimento
	                            </div>
	                            <div class="modal-footer">
	                            <input type="submit" class="btn btn-danger" value="Sim">
	                            <button type="button" class="btn btn-success" data-dismiss="modal" aria-label="Close">Não</button>
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
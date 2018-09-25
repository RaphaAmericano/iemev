<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="iemev.models.Servico"%>
<%@page import="iemev.manager.ServicoManager"%>
<%@include file="_header.jsp" %>
<%
List<Servico> servicos = ServicoManager.buscarTodosServicos();
List<String> categorias = ServicoManager.buscarTodasCategorias();
%>


    <!-- Consulta -->
    <div class="container">
        <div class="row justify-content-md center">
            <div class="col col-xs col-md-auto col-md-12">
                <h1>Consultar Ficha</h1>
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
                <form action="ficha_atendimento.html" id="tabela_prescricoes">
                <table class="table table-hover">
                    <thead>
                        <tr>
                        <th scope="col">N�mero da Ficha</th>
                        <th scope="col">Data de Abertura</th>
                        <th scope="col">Nome do Animal</th>
                        <th scope="col">Op��es</th>
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
                            <div class="valid-feedback">Inv�lido</div>
                        </div>
                        
                    </div>
                    <div class="form-row mt-2">
                        <div class="col-3 col-xs-12 col-md-auto">
                            <input type="submit" class="btn btn-success" value="Abrir Ficha" disabled>
                            <button type="button" class="btn btn-warning" disabled>Alterar Ficha</button>
                            <button type="button" class="btn btn-danger" disabled>Excluir Ficha</button>
                            <input type="hidden" name="opcao" value="3">
                        </div>
                    </div>
                    <div class="form-row mt-2">
                        <div class="col-md-4 md-3">
                            <label for="">Status</label>
                            <input class="form-control" name="status" type="text" readonly>
                        </div>
                        <div class="col-md-4 md-3">
                            <label for="">N�mero Sequecial</label>
                            <input class="form-control" name="id_ficha" type="number" readonly>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="data">Data de Abertura</label>
                            <input type="date" name="data_abertura" class="form-control" readonly>
                            <div class="valid-feedback">Inv�lido</div>
                        </div>
                    </div>
                    <div class="form-row mt-2">
                        
                        <div class="col-md-3 mb-3">
                            <label for="data">Data de Nascimento</label>
                            <input type="date" name="data" class="form-control" readonly>
                            <div class="valid-feedback">Inv�lido</div>
                        </div>
                      

                        <div class="col-md-3">
                            <label for="especie">Esp�cie</label>
                            <input class="form-control" type="text" name="especie" readonly>
                        </div>
                        <div class="col-md-3">
                            <label for="raca">Ra�a</label>
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
                    <!-- Em seguida, os campos s�o os especiais de cada tipo de usuario do sistema -->      

                    <div class="form-row mt-2">
                        <div class="col-md-6">
                            <label for="cpfcliente">Nome do Cliente</label>
                            <input class="form-control" type="text" name="nomecliente" readonly>
                        </div>
                        <div class="col-md-6">
                            <label for="cpfcliente">CPF do Cliente</label>
                            <input class="form-control" type="number" name="cpfcliente" readonly>
                        </div>
                    </div>
                    
                    <div class="form-row mt-2">
                        <div class="col-md-4">
                            <label for="telefone">Telefone Residencial</label>
                            <input class="form-control" type="number" name="telefone" readonly>
                        </div>
                        <div class="col-md-4">
                            <label for="celular">Telefone Celular</label>
                            <input class="form-control" type="number" name="celular" readonly>
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
                            <input class="form-control" type="text" name="idatendente" placeholder="Lineu Silva" value="1" readonly>
                            <input type="hidden" name="cpf_veterinario" value="55555555555">
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
                    
                    <div class="form-row mt-4">
                        <div class="col-md-12">
                            <h2>Servi�os</h2>
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                    <th scope="col">Item #</th>
                                    <th scope="col">Categoria</th>
                                    <th scope="col">Servi�o</th>
                                    <th scope="col">Nome do Veterin�rio</th>
                                    <th scope="col">Data da Prescri��o</th>
                                    <th scope="col">Pre�o</th>
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
                </form>
            </div>
        </div>
    </div>
<%@include file="_footer.jsp" %>
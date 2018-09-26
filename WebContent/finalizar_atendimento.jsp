<%@page import="iemev.models.Cliente"%>
<%@page import="iemev.manager.ClienteManager"%>
<%@page import="iemev.models.Animal"%>
<%@page import="iemev.manager.AnimalManager"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="iemev.models.FichaDeAtendimento"%>
<%@page import="java.util.List"%>
<%@page import="iemev.manager.FichaAtendimentoManager"%>
<%@include file="_header.jsp" %>
<%
List<FichaDeAtendimento> atendimentos = FichaAtendimentoManager.todasFichas();
SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
%>

<!-- Consulta -->
    <div class="container">
        <div class="row justify-content-md center">
            <div class="col col-xs col-md-auto col-md-12 mt-2">
                <h1>Finalização de Atendimento</h1>
                <form action="" class="form-inline">
                    <button class="btn btn-primary btn-lg" type="submit">Fechar Atendimento</button>
                    <button class="btn btn-warning btn-lg" type="submit">Reabrir Ficha</button>
                </form>
            </div>
        </div>
    </div>


    <!-- Lista de Fichas -->

    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col col-xs col-md-auto col-md-12 mt-4">
                <form action="FichaAtendimentoServlet.do">
                <table class="table table-hover">
                    <thead>
                        <tr>
                        <th scope="col">Número da Ficha</th>
                        <th scope="col">Nome do Cliente</th>
                        <th scope="col">Data de Abertura</th>
                        <th scope="col">Nome do Animal</th>
                        <th scope="col">Selecionar</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%if(!atendimentos.isEmpty()){ 
                    	for(int i = 0; i < atendimentos.size(); i++ ){
                    		Animal animal = AnimalManager.buscar(atendimentos.get(i).getIdAnimal());
                    		Cliente cliente = ClienteManager.buscarId(animal.getCpfCliente());
                    %>
                        <tr>
                            <th scope="row"><%=i+1 %></th>
                            <td><%=cliente.getNome() %></td>
                            <td><time datetime="2016-07-31"><%=dateformat.format(atendimentos.get(i).getDataAbertura()) %></time></td>
                            <td><%=animal.getNomeAnimal() %></td>
                            <td>
                            	<input type="hidden" value="<%=atendimentos.get(i).getNumeroFicha() %>" name="id_ficha">
                                <button type="button" class="btn btn-info" name="detalhar">Selecionar</button>
                            </td>
                        </tr>
                    <% }
                    } %>
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
                <form action="FichaAtendimentoServlet.do" id="ficha_atendimento">
                    <div class="form-row mt-2">
                        <div class="col-md-3 md-3">
                            <label for="">Status</label>
                            <input class="form-control" name="status" type="text" readonly>
                        </div>
                        <div class="col-md-3 md-3">
                            <label for="">Número Sequecial</label>
                            <input class="form-control" name="id_ficha" type="number" readonly>
                        </div>
                        <div class="col-md-3 mb-3">
                            <label for="data">Data de Abertura</label>
                            <input type="date" name="data_abertura" class="form-control" readonly>
                            <div class="valid-feedback">Inválido</div>
                        </div>
                        <div class="col-md-3">
                            <label for="idatendente">Nome do Atendente</label>
                            <input class="form-control" type="text" name="nome_atendente" placeholder="Lineu Silva" readonly>
                        </div>
                    </div>

                    <div class="form-row mt-2">
                        <div class="col-md-6 mb-3">
                            <label for="cpfcliente">Nome do Cliente</label>
                            <input class="form-control" type="text" name="nomecliente" readonly>
                            <div class="valid-feedback">Inválido</div>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="nome">Nome do Animal</label>
                            <input type="text" name="name" class="form-control" readonly>
                            <div class="valid-feedback">Inválido</div>
                        </div>
                    </div>
                    
                    <!-- Em seguida, os campos são os especiais de cada tipo de usuario do sistema -->      

                    <div class="form-row mt-2">     
                        <div class="col-md-6">
                            <label for="cpfcliente">CPF do Cliente</label>
                            <input class="form-control" type="number" name="cpfcliente" readonly>
                        </div>
                        <div class="col-md-6">
                            <label for="pagamento">Forma de Pagamento</label>
                            
                            <div class="form-check">
                                <input type="radio" class="form-check-imput" name="pagamento" value="0">
                                <label for="pagamento" class="form-check-label">Dinheiro</label>
                            </div>
                            <div class="form-check">
                                <input type="radio" class="form-check-imput" name="pagamento" value="1">
                                <label for="pagamento" class="form-check-label">Cheque</label>
                            </div>
                            <div class="form-check">
                                <input type="radio" class="form-check-imput" name="pagamento" value="1">
                                <label for="pagamento" class="form-check-label">Cartão</label>
                            </div>
                        </div>
                    </div>

                    <div class="form-row mt-2">
                        <div class="col-md-12">
                            <h2>Serviços</h2>
                            <table class="table table-hover" id="tabela_servicos">
                                <thead>
                                    <tr>
                                    <th scope="col">Item #</th>
                                    <th scope="col">Categoria</th>
                                    <th scope="col">Serviço</th>
                                    <th scope="col">Nome do Veterinário</th>
                                    <th scope="col">Data da Prescrição</th>
                                    <th scope="col">Preço</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                    <th scope="row">1</th>
                                    <td>Vacina</td>
                                    <td>Ubirajara Castro</td>
                                    <td><time>20/02/2018</time></td>
                                    <td>R$450,00</td>
                                    </tr>
                                    <tr>
                                    <th scope="row">2</th>
                                    <td>Anestesia</td>
                                    <td>Vandecir Gomes</td>
                                    <td><time>10/02/2018</time></td>
                                    <td>R$150,00</td>
                                    </tr>
                                    <tr>
                                    <th scope="row">3</th>
                                    <td>Operação</td>
                                    <td>Maria Eduarda Coutinho</td>
                                    <td><time>04/04/2018</time></td>
                                    <td>R$300,00</td>
                                    </tr>
                                    <tr>
                                        <th scope="row" colspan="5">Total</th>
                                        <td></td>
                                    </tr>
                                </tbody>
                                </table>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-3 col-xs-12 col-md-auto">
                            <button class="btn btn-success">Reabrir Ficha</button>
                            <button class="btn btn-danger">Fechar Ficha de Atendimento</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
<%@include file="_footer.jsp" %>
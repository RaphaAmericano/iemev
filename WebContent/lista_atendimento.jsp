<%@page import="iemev.models.Animal"%>
<%@page import="iemev.manager.AnimalManager"%>
<%@page import="iemev.models.FichaDeAtendimento"%>
<%@page import="java.util.List"%>
<%@page import="iemev.manager.FichaAtendimentoManager"%>
<%@include file="_header.jsp" %>
<%
List<FichaDeAtendimento> fichas = FichaAtendimentoManager.todasFichas();
%>

<!-- /Navbar Fixa -->
    <div class="container">
        <div class="row justify-content-md center">
            <div class="col col-xs col-md-auto col-md-12 mt-2">
            <button class="btn btn-primary">Fila de Consulta</button>
            <button class="btn btn-primary">Fila de Exame</button>
            </div>
        </div>
    </div>
<!-- Lista de animais - exibir apenas em caso da tela ser acessada pela funcionalidade de busca -->
    <div class="container">
        <div class="row justify-content-md-center mt-2">
            <div class="col col-xs col-md-auto col-md-5">
                <form action="ficha_atendimento.jsp">
                    <label for="animal">Fila de Consulta</label>
                    <div class="form-row">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                <th scope="col">Número da Ficha</th>
                                <th scope="col">Nome do Cliente</th>
                                <th scope="col">Nome do Animal</th>
                                <th scope="col">Serviço</th>
                                <th scope="col">Horário de Atendimento</th>
                                </tr>
                            </thead>
                            <tbody>
                                <!-- <tr>
                                    <th scope="row">1</th>
                                    <td>Jorge Matos</td>
                                    <td>Otto</td>
                                    <td>Internação</td>
                                    <td>
                                        <input type="time" class="form-control" value="18:00" readonly>
                                    </td>
                                </tr> -->
                            </tbody>
                        </table>
                    </div>
                    <div class="form-row">
                        <div class="col-3 col-xs-12 col-md-4">
                            <button class="btn btn-warning">Alterar Posição da Ficha na Fila</button>
                            <button class="btn btn-danger mt-2">Excluir Ficha da Fila</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col col-xs col-md-auto col-md-5 ml-auto">
                <form action="ficha_atendimento.html">
                    <div class="form-group">
                        <label for="animal">Fichas de Atendimento( Cliente | Animal | Serviço )</label>
                        <select name="cliente[id]" id="" class="form-control" multiple="multiple">
                            <%for(int i = 0; i < fichas.size(); i++ ){ 
                            	Animal animal = AnimalManager.buscar(fichas.get(i).getIdAnimal());
                            	Pessoa dono = AnimalManager.buscarDono(animal.getIdAnimal());
                            %>
                            	<option value="<%=fichas.get(i).getNumeroFicha() %>"><%=dono.getNome() %> | <%=animal.getNomeAnimal() %> | Internação</option>	
                            <% } %>
                        </select>
                        
                    </div>
                    <div class="form-inline mt-2">
                        <button class="btn btn-success" value="selecionar" name="cliente[acao]" type="submit">Incluir Ficha</button>
                        <label for="horario" class="my-1 mr-2 ml-2">Horário do Atendimento</label>
                        <select class="custom-select" name="horario">
                            <option value="0">18:30</option>
                            <option value="1">18:45</option>
                            <option value="2">19:00</option>
                            <option value="3">19:15</option>
                        </select>
                    </div>
                    
                </form>
            </div>
        </div>
    </div>
<!-- /Lista -->
<%@include file="_footer.jsp" %>
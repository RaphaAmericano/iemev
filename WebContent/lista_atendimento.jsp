<%@include file="_header.jsp" %>
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
                <form action="ficha_atendimento.html">
                    <label for="animal">Fila de Consulta</label>
                    <div class="form-row">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                <th scope="col">N�mero da Ficha</th>
                                <th scope="col">Nome do Cliente</th>
                                <th scope="col">Nome do Animal</th>
                                <th scope="col">Servi�o</th>
                                <th scope="col">Hor�rio de Atendimento</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row">1</th>
                                    <td>Jorge Matos</td>
                                    <td>Otto</td>
                                    <td>Interna��o</td>
                                    <td>
                                        <input type="time" class="form-control" value="18:00" readonly>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">2</th>
                                    <td>Luiz Gomes</td>
                                    <td>Thornton</td>
                                    <td>Consulta</td>
                                    <td>
                                        <input type="time" class="form-control" value="18:15" readonly>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">3</th>
                                    <td>Ubirajara Tavares</td>
                                    <td>the Bird</td>
                                    <td>Interna��o</td>
                                    <td>
                                        <input type="time" class="form-control" value="18:30" readonly>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="form-row">
                        <div class="col-3 col-xs-12 col-md-4">
                            <button class="btn btn-warning">Alterar Posi��o da Ficha na Fila</button>
                            <button class="btn btn-danger mt-2">Excluir Ficha da Fila</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col col-xs col-md-auto col-md-5 ml-auto">
                <form action="ficha_atendimento.html">
                    <div class="form-group">
                        <label for="animal">Fichas de Atendimento( Cliente | Animal | Servi�o )</label>
                        <select name="cliente[id]" id="" class="form-control" multiple="multiple">
                            <option value="0">Jorge Matos | Tobby | Interna��o</option>
                            <option value="1">Jorge Silva | Rufus | Consulta</option>
                            <option value="2">Jorge Loureiro | Thor | Consulta</option>
                            <option value="3">Jorge Mascarenhas | Judith | Consulta</option>
                            <option value="3">Jorge Mascarenhas | Janj�o | Interna��o</option>
                        </select>
                        
                    </div>
                    <div class="form-inline mt-2">
                        <button class="btn btn-success" value="selecionar" name="cliente[acao]" type="submit">Incluir Ficha</button>
                        <label for="horario" class="my-1 mr-2 ml-2">Hor�rio do Atendimento</label>
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
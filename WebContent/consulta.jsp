<%@include file="_header.jsp" %>
<!-- Por data -->
    <div class="container">
        <div class="row justify-content-md center">
            <div class="col col-xs col-md-auto col-md-12 mt-2" id="buscaData">
                <h1>Consultar agendamento por data</h1>
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
                <h1>Consultar agendamento por nome do cliente</h1>
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
                            <button type="button" class="btn btn-success">Incluir novo agendamento</button>
                            <button type="button" class="btn btn-warning" disabled>Alterar agendamento</button>
                            <button type="button" class="btn btn-danger" disabled>Excluir agendamento</button>
                        </div>
                    </div>
                    <div class="form-row mt-2">
                        <div class="col-md-6 mb-3">
                            <label for="cpfcliente">CPF do Cliente</label>
                            <input class="form-control" type="number" name="cpfcliente" readonly>
                            <div class="mt-2">
                                <button type="button" class="btn btn-success">OK</button>
                                <a href="cliente.jsp" class="btn btn-primary">Adicionar Cliente</a>
                            </div>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="nome_animal">Nome do Animal</label>
                            <select type="text" name="nome_animal" class="form-control" readonly>
                              <!--  <option value="0">Bill</option>
                                <option value="1">Bob</option>
                                <option value="2">Bart</option> -->
                            </select>
                            <div class="valid-feedback"></div>
                            <div class="mt-2">
                                <a href="animal.jsp" class="btn btn-primary">Adicionar Animal</a>
                            </div>
                        </div>
                    </div>
                    <div class="form-row mt-2">
                        <div class="col-md-6 mb-3">
                            <label for="nome_cliente">Nome do Cliente</label>
                            <input type="text" name="nome_cliente" class="form-control" readonly>
                            <div class="valid-feedback">Inválido</div>
                        </div>
                        <div class="col-md-2 mb-3">
                            <label for="data">Data da consulta</label>
                            <!-- Exemplo: -->
                            <input type="date" name="data" value="" class="form-control" readonly>
                            <div class="valid-feedback">Inválido</div>
                        </div>
                        <div class="col-md-2 mb-3">
                            <label for="horario">Horário</label>
                            <!-- Exemplo: -->
                            <input type="time" name="horario" value="" class="form-control" readonly>
                            <!-- formato entrada 18:30 -->
                            <div class="valid-feedback">Inválido</div>
                        </div>
                        <div class="col-md-2 md-3">
                            <label for="consulta">Tipo de Consulta</label>
                            <select class="form-control" name="consulta" readonly>
                            <!--      <option>Geriatria</option>
                                <option>Pre Natal</option> -->
                            </select>
                        </div>
                    </div>
                    <!-- Em seguida, os campos são os especiais de cada tipo de usuario do sistema -->
                    <div class="form-row mt-2">
                        <div class="col-md-12 mx-auto">
                        	<input type="hidden">
                           <input type="submit" value="Agendar" class="btn btn-primary" disabled >
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
<%@include file="_footer.jsp" %>
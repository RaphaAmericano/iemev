<%@include file="_header.jsp" %>
<!-- Por data -->
    <div class="container">
        <div class="row justify-content-md center">
            <div class="col col-xs col-md-auto col-md-12 mt-2">
                <h1>Consultar exame por data</h1>
                <form action="">
                    <div class="form-group col-2 p-0">
                            <label for="">Buscar</label>
                        <input class="form-control" name="data" type="date">
                    </div>
                    <button class="btn btn-primary" type="submit">Localizar</button>
                </form>
            </div>
        </div>
    </div>
    <!-- /por data -->
    <div class="container">
        <div class="row justify-content-md center">
            <div class="col col-xs col-md-auto col-md-12 mt-2">
                <h1>Consultar exame por nome do cliente</h1>
                <form action="" >
                    <div class="form-group col-6 p-0">
                        <label for="">Buscar</label>
                        <input class="form-control" type="search">
                    </div>
                    <button class="btn btn-primary" type="submit">Localizar</button>
                    <a href="cliente.html" class="btn btn-success">Adicionar Cliente</a>
                    <a href="animal.html" class="btn btn-success">Adicionar Animal</a>
                </form>
            </div>
        </div>
    </div>
<!-- Lista de Clientes - exibir apenas em caso da tela ser acessada pela funcionalidade de busca pelo nome do cliente -->
    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col col-xs col-md-auto col-md-12 mt-2">
                <form action="animal.html">
                    <div class="form-group"><label for="animal">Exames</label>
                        <select name="animal[id]" class="form-control" multiple="multiple">
                            <option value="0">18:00 - Jorge Luiz - Rex</option>
                            <option value="1">18:15 - Humberto Jorge Silva - Tobby</option>
                            <option value="2">18:30 - Maria da Conceição - Billy</option>
                            <option value="3">18:45 - Maria Bonita Araújo - Judith</option>
                        </select>
                        <button class="btn btn-success mt-2" value="selecionar" name="agendamento" type="submit">Detalhar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!--  -->
    <div class="container">
        <div class="row">
            <div class="col col-xs">
                <form action="">
                    <div class="form-row mt-2">
                        <div class="col-3 col-xs-12">
                            <button class="btn btn-success">Incluir</button>
                            <button class="btn btn-warning">Alterar</button>
                            <button class="btn btn-danger">Excluir</button>
                        </div>
                        <div class="col-3 col-xs-12">
                            <label for="pedido">Pedido de Exame Assinado</label>
                            <div class="custom-control custom-radio">
                                <input type="radio" id="pedidoUm" name="pedido" class="custom-control-input">
                                <label class="custom-control-label" for="pedidoUm">Sim</label>
                            </div>
                            <div class="custom-control custom-radio">
                                <input type="radio" id="pedidoDois" name="pedido" class="custom-control-input">
                                <label class="custom-control-label" for="pedidoDois">Não</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-row mt-4">
                        <div class="col-md-6 mb-3">
                            <label for="cpfcliente">CPF do Cliente</label>
                            <input class="form-control" type="number" name="cpfcliente">
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="nome_animal">Nome do Animal</label>
                            <select type="text" name="nome_animal" class="form-control">
                                <option value="0">Bill</option>
                                <option value="1">Bob</option>
                                <option value="2">Bart</option>
                            </select>
                            <div class="valid-feedback"></div>
                        </div>
                    </div>
                    <div class="form-row mt-2">
                        <div class="col-md-6 mb-3">
                            <label for="nome_cliente">Nome do Cliente</label>
                            <input type="text" name="nome_cliente" class="form-control" readonly>
                            <div class="valid-feedback">Inválido</div>
                        </div>
                        <div class="col-md-2 mb-3">
                            <label for="data">Data do Exame</label>
                            <!-- Exemplo: -->
                            <input type="date" name="data" value="2018-08-25" class="form-control" readonly>
                            <div class="valid-feedback">Inválido</div>
                        </div>
                        <div class="col-md-2 mb-3">
                                <label for="horario">Horário do Exame</label>
                                <!-- Exemplo: -->
                                <input type="time" name="horario" value="18:30" class="form-control" readonly>
                                <div class="valid-feedback">Inválido</div>
                            </div>
                        <div class="col-md-2 md-3">
                            <label for="exame">Tipo do Exame</label>
                            <select class="form-control" name="exame">
                                <option>Sangue</option>
                                <option>Urina</option>
                                <option>Fezes</option>
                            </select>
                        </div>
                    </div>
                    <!-- Em seguida, os campos são os especiais de cada tipo de usuario do sistema -->      
                    <div class="form-row mt-2">
                            <div class="col-md-12 mx-auto">
                                <input type="submit" value="Agendar" class="btn btn-primary" readonly>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
<%@include file="_footer.jsp" %>
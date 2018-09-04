<%@include file="_header.jsp" %>
<!-- Consulta -->
    <div class="container">
        <div class="row justify-content-md center">
            <div class="col col-xs col-md-auto col-md-12 mt-2">
                <h1>Finaliza��o de Atendimento</h1>
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
                <form action="ficha_atendimento.html">
                <table class="table table-hover">
                    <thead>
                        <tr>
                        <th scope="col">N�mero da Ficha</th>
                        <th scope="col">Nome do Cliente</th>
                        <th scope="col">Data de Abertura</th>
                        <th scope="col">Nome do Animal</th>
                        <th scope="col">Selecionar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Ubirantam M�rcio Pacheco</td>
                            <td><time datetime="2016-07-31">2016-07-31</time></td>
                            <td>Otto</td>
                            <td>
                                <button class="btn btn-info" name="detalhar[0]">Selecionar</button>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>Luiz Vasco Pe�anha</td>
                            <td><time datetime="2016-07-31">2016-07-31</time></td>
                            <td>Thornton</td>
                            <td>
                                <button class="btn btn-info" name="detalhar[0]">Selecionar</button>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>Jorge Carlos Almeida</td>
                            <td><time datetime="2016-07-31">2016-07-31</time></td>
                            <td>the Bird</td>
                            <td>
                                <button class="btn btn-info" name="detalhar[0]">Selecionar</button>
                            </td>
                        </tr>
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
                <form action="">
                    <div class="form-row mt-2">
                        <div class="col-md-3 md-3">
                            <label for="">Status</label>
                            <input class="form-control" name="status" type="text">
                        </div>
                        <div class="col-md-3 md-3">
                            <label for="">N�mero Sequecial</label>
                            <input class="form-control" name="id_ficha" type="number" readonly>
                        </div>
                        <div class="col-md-3 mb-3">
                            <label for="data">Data de Abertura</label>
                            <input type="date" name="data_abertura" class="form-control">
                            <div class="valid-feedback">Inv�lido</div>
                        </div>
                        <div class="col-md-3">
                            <label for="idatendente">Nome do Atendente</label>
                            <input class="form-control" type="text" name="nome_atendente" placeholder="Lineu Silva" readonly>
                        </div>
                    </div>

                    <div class="form-row mt-2">
                        <div class="col-md-6 mb-3">
                            <label for="cpfcliente">Nome do Cliente</label>
                            <input class="form-control is-invalid" type="text" name="nomecliente">
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="nome">Nome do Animal</label>
                            <input type="text" name="name" class="form-control">
                            <div class="valid-feedback">Inv�lido</div>
                        </div>
                    </div>
                    
                    <!-- Em seguida, os campos s�o os especiais de cada tipo de usuario do sistema -->      

                    <div class="form-row mt-2">     
                        <div class="col-md-6">
                            <label for="cpfcliente">CPF do Cliente</label>
                            <input class="form-control is-invalid" type="number" name="cpfcliente">
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
                                    <label for="pagamento" class="form-check-label">Cart�o</label>
                                </div>
                        </div>
                    </div>

                    <div class="form-row mt-2">
                        <div class="col-md-12">
                            <h2>Servi�os</h2>
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                    <th scope="col">Item #</th>
                                    <th scope="col">Servi�o</th>
                                    <th scope="col">Nome do Veterin�rio</th>
                                    <th scope="col">Data da Prescri��o</th>
                                    <th scope="col">Pre�o</th>
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
                                    <td>Opera��o</td>
                                    <td>Maria Eduarda Coutinho</td>
                                    <td><time>04/04/2018</time></td>
                                    <td>R$300,00</td>
                                    </tr>
                                    <tr>
                                        <th scope="row" colspan="4">Total</th>
                                        <td>R$900,00</td>
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
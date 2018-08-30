<%@include file="_header.jsp" %>
    <!-- Consulta -->
    <div class="container">
        <div class="row justify-content-md center">
            <div class="col col-xs col-md-auto col-md-12">
                <h1>Consultar Ficha</h1>
                <form action="FichaAtendimentoServlet.do" id="formBuscarUsuarios">
                    <div class="form-group">
                        <label for="">Buscar</label>
                        <input class="form-control" type="search" placeholder="Nome do Cliente">
                    </div>
                    <button class="btn btn-primary" type="submit">Localizar</button>
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
                        <select name="cliente[id]" class="form-control" multiple="multiple">
                            <!-- <option value="0">Jorge Matos</option> -->
                        </select>
                        <button class="btn btn-success mt-2" value="selecionar" name="cliente[acao]" type="submit">OK</button>
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
                <form action="ficha_atendimento.html">
                <table class="table table-hover">
                    <thead>
                        <tr>
                        <th scope="col">Número da Ficha</th>
                        <th scope="col">Data de Abertura</th>
                        <th scope="col">Nome do Animal</th>
                        <th scope="col">Opções</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td><time datetime="2016-07-31">2016-07-31</time></td>
                            <td>Otto</td>
                            <td>
                                <button class="btn btn-info" name="detalhar[0]">Detalhar Ficha</button>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td><time datetime="2016-07-31">2016-07-31</time></td>
                            <td>Thornton</td>
                            <td>
                                <button class="btn btn-info" name="detalhar[0]">Detalhar Ficha</button>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td><time datetime="2016-07-31">2016-07-31</time></td>
                            <td>the Bird</td>
                            <td>
                                <button class="btn btn-info" name="detalhar[0]">Detalhar Ficha</button>
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
                <form action="" method="POST" id="ficha_atendimento">
                    
                <div class="form-row mt-2">
                        <div class="col-md-6 mb-3">
                            <label for="nome">Nome do Animal</label>
                            <select name="select_nome" class="form-control">
                            </select>
                            <div class="valid-feedback">Inválido</div>
                        </div>
                        
                    </div>

                    <div class="form-row mt-2">
                        <div class="col-3 col-xs-12 col-md-auto">
                            <button class="btn btn-success">Abrir Ficha</button>
                            <button class="btn btn-warning" disabled>Alterar Ficha</button>
                            <button class="btn btn-danger" disabled>Excluir Ficha</button>
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
                            <input class="form-control" type="text" name="nome_atendente" placeholder="Lineu Silva" readonly>
                        </div>
                    </div>
					<div class="form-row mt-2">
                        <div class="col-12">
                            <!-- <input type="submit" class="btn btn-primary" data-toggle="modal" value="ok" data-target="#modalConfirmacao"> -->
                            <input type="submit" class="btn btn-primary" value="ok">
                            <input type="hidden" name="tipo_submit" value="0">
                        </div>
                    </div>
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
                                <tbody>
                                    <tr>
                                    <th scope="row">1</th>
                                    <td>Vacina</td>
                                    <td>Raiva</td>
                                    <td>Ubirajara Castro</td>
                                    <td><time>20/02/2018</time></td>
                                    <td>R$100,00</td>
                                    <td><button class="btn btn-danger" readonly>Excluir</button></td>
                                    </tr>
                                    <tr>
                                    <th scope="row">2</th>
                                    <td>Anestesia</td>
                                    <td>Local</td>
                                    <td>Vandecir Gomes</td>
                                    <td><time>10/02/2018</time></td>
                                    <td>R$200,00</td>
                                    <td><button class="btn btn-danger" readonly>Excluir</button></td>
                                    </tr>
                                    <tr>
                                    <th scope="row">3</th>
                                    <td>Operação</td>
                                    <td>Próstata</td>
                                    <td>Maria Eduarda Coutinho</td>
                                    <td><time>04/04/2018</time></td>
                                    <td>R$500,00</td>
                                    <td><button class="btn btn-danger" readonly>Excluir</button></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Incluir</th>
                                        <td>
                                            <select name="categoria" id="" class="form-control" readonly>
                                                <option value="0">Vacina</option>
                                                <option value="1">Anestesia</option>
                                                <option value="2">Apuncultura</option>
                                            </select> 
                                        </td>
                                        <td>
                                            <select name="servico" id="" class="form-control" readonly>
                                                <option value="0">Antirrábica</option>
                                                <option value="1">Gripe</option>
                                                <option value="2">Hepatite</option>
                                            </select> 
                                        </td>
                                        <td colspan="3"></td>
                                        <td>
                                            <button class="btn btn-success" readonly>Incluir</button>
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
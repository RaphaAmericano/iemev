<%@include file="_header.jsp" %>
<!-- Busca -->
    <div class="container">
        <div class="row justify-content-md center">
            <div class="col col-xs col-md-auto col-md-12 mt-2">
                <h1 class="font-weight-bold">Consultar Cliente</h1>
                <form action="clienteServlet.do" method="POST">
                	<input type="hidden" name="tipoFormulario" value="0">
                    <div class="form-group">
                        <label for="" class="col-md-2 col-form-label">Buscar</label>
                        <input class="form-control" type="search">
                    </div>
                    <button class="btn btn-primary" type="submit">Localizar</button>
                </form>
            </div>
        </div>
    </div>
<!-- /Busca -->
<!-- Select Resultados -->
    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col col-xs col-md-auto col-md-12 mt-4">
                <form action="clienteServlet.do" method="POST">
                	<input type="hidden" name="tipoFormulario" value="1">
                    <div class="form-group"><label for="animal">Clientes</label>
                        <select name="animal[id]" id="" class="form-control" multiple="multiple">
                            <option value="0">Jorge Silva</option>
                            <option value="1">Jorge Guimarães</option>
                            <option value="2">Jorge Montenegro</option>
                            <option value="3">Jorge Campos</option>
                        </select>
                        <button class="btn btn-success mt-2" value="selecionar" name="animal[acao]" type="submit">Detalhar Cliente</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
<!-- /Select Resultados -->
    <div class="container">
        <div class="row">
            <div class="col col-xs mt-4">
                <h1 class="font-weight-bold">Incluir Cliente</h1>
                <form action="clienteServlet.do" method="POST">
                	<input type="hidden" name="tipoFormulario" value="2">
                    <div class="form-row mt-2">
                        <div class="col-3 col-xs-12">
                            <button class="btn btn-success">Incluir</button>
                            <button class="btn btn-warning">Editar</button>
                            <button class="btn btn-danger">Excluir</button>
                        </div>
                    </div>
                    <div class="form-row mt-2">
                        <div class="col-md-12 mt-2">
                            <label for="nome">Nome</label>
                            <input type="text" name="nome" class="form-control">
                            <div class="valid-feedback">Inválido</div>
                        </div>
                    </div>
                    <div class="form-row mt-2">
                        <div class="col-md-4 mb-3">
                            <label for="cpf">CPF</label>
                            <input type="number" name="cpf" class="form-control">
                            <div class="valid-feedback">Inválido</div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="rg">RG</label>
                            <input type="number" name="rg" class="form-control">
                            <div class="valid-feedback"></div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="data">Data de Nascimento</label>
                            <input type="date" name="data" class="form-control">
                            <div class="valid-feedback">Inválido</div>
                        </div>
                    </div>
                    <div class="form-row mt-2">
                        <div class="col-md-12">
                            <label for="endereco">Endereço</label>
                            <input type="text" class="form-control" name="endereco">
                            <div class="valid-feedback">Inválido</div>
                        </div>
                    </div>
                    <div class="form-row mt-2">
                        <div class="col-md-6">
                            <label for="telefone">Telefone Residencial</label>
                            <input class="form-control" type="number" name="telefone">
                        </div>
                        <div class="col-md-6">
                            <label for="celular">Telefone Celular</label>
                            <input class="form-control" type="number" name="celular">
                        </div>
                    </div>
                    <!-- Em seguida, os campos são os especiais de cada tipo de usuario do sistema -->
                    <div class="form-row mt-2">
                        <div class="col-md-6">
                            <label for="email">Email</label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">@</span>
                                </div>
                                <input class="form-control" type="email" name="email">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <label for="idatendente">ID do Atendente</label>
                            <input class="form-control" type="number" name="idatendente" value="1" readonly>
                        </div>
                    </div>
                    <div class="form-row mt-2">
                        <div class="col-12">
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalConfirmacao">OK</button>
                        </div>
                    </div>

                    <!-- Modal de confirmação -->
                    <div class="modal fade" id="modalConfirmacao" tabindex="-1" role="dialog" aria-labelledby="modalConfirmacaoLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                            <h5 class="modal-title" id="modalConfirmacaoLabel">Confirme a Exclusão do Usuário</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            </div>
                            <div class="modal-body">
                            Fulano de tal
                            </div>
                            <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Sim</button>
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
<%@include file="_header.jsp" %>
<!-- Select Resultados -->
    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col col-xs col-md-auto col-md-12 mt-4">
                <form action="servico.html">
                    <div class="form-group"><label for="servico">Serviços</label>
                        <select name="servico[id]" id="" class="form-control" multiple="multiple">
                            <option value="0">Exame de Fezes</option>
                            <option value="1">Anestesia Geral</option>
                            <option value="2">Anestesia Local</option>
                            <option value="3">Exame de Urina</option>
                        </select>
                        <button class="btn btn-success mt-2" value="selecionar" name="servico[acao]" type="submit">Detalhar Serviço</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
<!-- /Select Resultados -->
    <div class="container">
        <div class="row">
            <div class="col col-xs mt-4">
                <h1>Incluir Serviço</h1>
                <form action="">
                    <div class="form-row mt-2">
                        <div class="col-12 col-xs-12">
                            <button class="btn btn-success">Incluir serviço</button>
                            <button class="btn btn-warning" disabled>Editar serviço</button>
                            <button class="btn btn-danger" disabled>Excluir serviço</button>
                        </div>
                    </div>
                    <div class="form-row mt-2">
                        <div class="col-md-4 mb-3">
                            <label for="cpf">Categoria do Serviço</label>
                            <input type="number" name="cpf" class="form-control">
                            <div class="valid-feedback">Inválido</div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="nome">Nome do Serviço</label>
                            <input type="text" name="name" class="form-control">
                            <div class="valid-feedback">Inválido</div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="preco">Preço</label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">R$</span>
                                </div>
                                <input class="form-control" type="number" min="0" step="0.01" name="preco">
                            </div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <input type="submit" class="btn btn-primary" value="OK" disabled>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
<%@include file="_footer.jsp" %>
<%@include file="_header.jsp" %>
<%
Empregado empregado = (Empregado) session.getAttribute("empregado");
if(empregado != null ){
	if(!empregado.getTipoEmpregado().equals("administrador")){
		response.sendRedirect("main.jsp");
	}	
}
%>
<!-- Busca -->
<div class="container" id="containerBusca">
    <div class="row justify-content-md center">
        <div class="col col-xs col-md-auto col-md-12 mt-2">
            <h1 class="font-weight-bold">Consultar Servi�o</h1>
            <form action="">
                <div class="form-group">
                    <label for="" class="col-md-6 col-form-label">Buscar categoria de servi�o</label>
                    <input class="form-control" type="search">
                </div>
                <button class="btn btn-primary" type="submit">Localizar servi�o</button>
            </form>
        </div>
    </div>
</div>
<!-- /Busca -->

<!-- Select Resultados -->
    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col col-xs col-md-auto col-md-12 mt-4">
                <form action="servico.html">
                    <div class="form-group"><label for="servico">Servi�os</label>
                        <select name="servico[id]" id="" class="form-control" multiple="multiple">
                            <!-- <option value="0">Exame de Fezes</option> -->
                        </select>
                        <button class="btn btn-success mt-2" value="selecionar" name="servico[acao]" type="submit">Detalhar Servi�o</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
<!-- /Select Resultados -->
    <div class="container">
        <div class="row">
            <div class="col col-xs mt-4">
                <h1 class="font-weight-bold">Incluir Servi�o</h1>
                <form action="">
                    <div class="form-row mt-2">
                        <div class="col-12 col-xs-12">
                            <button class="btn btn-success">Incluir servi�o</button>
                            <button class="btn btn-warning" disabled>Editar servi�o</button>
                            <button class="btn btn-danger" disabled>Excluir servi�o</button>
                        </div>
                    </div>
                    <div class="form-row mt-2">
                        <div class="col-md-4 mb-3">
                            <label for="cpf">Categoria do Servi�o *</label>
                            <input type="number" name="cpf" class="form-control">
                            <div class="valid-feedback">Inv�lido</div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="nome">Nome do Servi�o *</label>
                            <input type="text" name="name" class="form-control">
                            <div class="valid-feedback">Inv�lido</div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="preco">Pre�o *</label>
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
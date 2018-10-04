<%@include file="_header.jsp" %>
<% 
double valor_medio = 00.00;
if(request.getAttribute("relatorio") != null){
	valor_medio = (double) request.getAttribute("relatorio");
} 
%>
<div class="container">
    <div class="row justify-content-md center">
        <div class="col col-xs col-md-auto col-md-12">
            <h1 class="font-weight-bold">Relatórios</h1>
        </div>
    </div>
</div>
<!-- Lista de animais - exibir apenas em caso da tela ser acessada pela funcionalidade de busca -->
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col col-xs col-md-auto col-md-12 mt-2">
            <form action="relatorioController.do" method="POST">
                <div class="form-group">    
                    <button class="btn btn-success mt-2" name="valor_medio" type="submit">Gerar Relatório</button>
                </div>
            </form>
        </div>
    </div>
    <div class="row justify-content-md-center">
        <div class="col col-xs col-md-auto col-md-12 mt-2">
            <div class="form-row">
                <div class="col-md-2">
                    <label for="valor_medio">Valor médio por atendimento</label>
                    <div class="input-group">
                        
                        <div class="input-group-prepend">
                            <span class="input-group-text">
                                <i class="fas fa-dollar-sign"></i>
                            </span>
                        </div>
                        <input type="number" class="form-control" min="0" step="0.01" value="<%=valor_medio %>" readonly>
                    </div> 
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="_footer.jsp" %>
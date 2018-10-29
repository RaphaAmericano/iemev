<%@page import="iemev.utils.DataUtils"%>
<%@page import="iemev.models.Cliente"%>
<%@include file="_header.jsp" %>
<% 
Empregado empregado = null;
Cliente cliente = null;
String dataNascimento = null;
if(session != null && session.getAttribute("empregado") != null ){ 
	empregado = (Empregado) session.getAttribute("empregado");
	if(empregado.getTipoEmpregado().equals("veterinario")){
		response.sendRedirect("main.jsp");
	}	
	if(session.getAttribute("cliente") != null ){
		cliente = (Cliente) session.getAttribute("cliente");
		dataNascimento = DataUtils.formatarData(cliente.getDataDeNascimento());
	}
}%> 
<!-- Busca -->
    <div class="container">
        <div class="row justify-content-md center">
            <div class="col col-xs col-md-auto col-md-12 mt-2">
                <h1 class="font-weight-bold">Consultar Cliente</h1>
                <form action="clienteServlet.do" method="POST" id="formularioBusca">
                    <div class="form-group">
                        <label for="" class="col-md-2 col-form-label">Buscar cliente</label>
                        <input class="form-control" type="search">
                    </div>
                    <button class="btn btn-primary" type="submit">Localizar Cliente</button>
                </form>
            </div>
        </div>
    </div>
<!-- /Busca -->
<!-- Select Resultados -->
    <div class="container" style="display: none;" id="containerSelect">
        <div class="row justify-content-md-center">
            <div class="col col-xs col-md-auto col-md-12 mt-4">
                <div>
                    <div class="form-group">
                    	<label for="animal">Clientes</label>
                        <select name="animal" class="form-control" multiple="multiple"></select>
                        <button class="btn btn-success mt-2" type="submit">Detalhar Cliente</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
<!-- /Select Resultados -->
    <div class="container" id="formularioCliente">
        <div class="row">
            <div class="col col-xs mt-4">
                <h1 class="font-weight-bold">Incluir Cliente</h1>
                <form action="clienteServlet.do" method="POST">
                	<input type="hidden" name="" value="">
                    <div class="form-row mt-2">
                        <div class="col-3 col-xs-12">
                            <button class="btn btn-success" disabled>Incluir</button>
                            <button class="btn btn-warning" disabled>Editar</button>
                            <button class="btn btn-danger" data-toggle="modal" data-target="#modalExcluirCliente" disabled>Excluir</button>
                        </div>
                    </div>
                    <div class="form-row mt-2">
                        <div class="col-md-12 mt-2">
                            <label for="nome">Nome *</label>
                            <input type="text" name="nome" class="form-control" value="<%= cliente != null ? cliente.getNome() : ""  %>" required>
                            <div class="valid-feedback">Inválido</div>
                        </div>
                    </div>
                    <div class="form-row mt-2">
                        <div class="col-md-4 mb-3">
                            <label for="cpf">CPF *</label>
                            <input type="text" name="cpf" class="form-control" placeholder="000.000.000-00" value="<%= cliente != null ? cliente.getCpf() : "" %>" required>
                            <div class="valid-feedback">Inválido</div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="rg">RG *</label>
                            <input type="text" name="rg" class="form-control" placeholder="00.000.000-0" value="<%= cliente != null ? cliente.getRg() : "" %>" required>
                            <div class="valid-feedback"></div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="data">Data de Nascimento *</label>
                            <input type="date" name="data" class="form-control" value="<%= cliente != null ? dataNascimento : ""  %>" required>
                            <div class="valid-feedback">Inválido</div>
                        </div>
                    </div>
                    <div class="form-row mt-2">
                        <div class="col-md-12">
                            <label for="endereco">Endereço *</label>
                            <input type="text" class="form-control" name="endereco" value="<%=  cliente != null ? cliente.getEndereco() : "" %>" required>
                            <div class="valid-feedback">Inválido</div>
                        </div>
                    </div>
                    <div class="form-row mt-2">
                        <div class="col-md-6">
                            <label for="telefone">Telefone Residencial *</label>
                            <input class="form-control" type="text" name="telefone" value="<%= cliente != null ? cliente.getTelefoneResidencial() : ""  %>" required>
                        </div>
                        <div class="col-md-6">
                            <label for="celular">Telefone Celular *</label>
                            <input class="form-control" type="text" name="celular" value="<%= cliente != null ? cliente.getCelular() : "" %>" required>
                        </div>
                    </div>
                    <!-- Em seguida, os campos são os especiais de cada tipo de usuario do sistema -->
                    <div class="form-row mt-2">
                        <div class="col-md-6">
                            <label for="email">Email *</label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">@</span>
                                </div>
                                <input class="form-control" type="email" name="email" value="<%= cliente != null ? cliente.getEmailCliente() : "" %>" required>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <label for="idatendente">ID do Atendente</label>
                            <!-- Puxar o numero do atendente logado para preencher o valor -->
                            <input class="form-control" type="number" name="idatendente" value="<%= cliente != null ? cliente.getIdAtendentDeCadastramento() : 1 %>" readonly>
                        </div>
                    </div>
                    <div class="form-row mt-2">
                        <div class="col-12">
                        	<input type="hidden" value="2" name="opcao">
                            <button type="submit" class="btn btn-primary">OK</button>
                        </div>
                    </div>

                    <!-- Modal de confirmação -->
                    <div class="modal fade" id="modalExcluirCliente" tabindex="-1" role="dialog" aria-labelledby="modalConfirmacaoLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                            <h5 class="modal-title" id="modalConfirmacaoLabel">Confirme a Exclusão do Cliente</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            </div>
                            <div class="modal-footer">
                            <button type="submit" class="btn btn-danger">Sim</button>
                            <button type="button" class="btn btn-success" data-dismiss="modal">Não</button>
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
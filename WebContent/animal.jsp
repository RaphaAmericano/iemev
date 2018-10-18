<%@include file="_header.jsp" %>
<%
Empregado empregado = (Empregado) session.getAttribute("empregado");
if(empregado != null ){
	if(empregado.getTipoEmpregado().equals("veterinario")){
		response.sendRedirect("main.jsp");
	}	
}
String mensagem_crud = (String)request.getAttribute("mensagem_crud");
%>
    <!-- Consulta -->
    <div class="container">
        <div class="row justify-content-md center" id="formularioBusca">
            <div class="col col-xs col-md-auto col-md-12 mt-2">
                <h1 class="font-weight-bold">Consultar Animal</h1>
                <form action="animalServlet.do" method="POST">
                    <div class="form-group col-6 p-0">
                        <label for="">Buscar animal</label>
                        <input class="form-control" type="search">
                    </div>
                    <button class="btn btn-primary" type="submit">Localizar Animal</button>
                </form>
            </div>
        </div>
    </div>

<!-- Lista de animais - exibir apenas em caso da tela ser acessada pela funcionalidade de busca -->
    <div class="container" id="selectAnimais" >
        <div class="row justify-content-md-center" >
            <div class="col col-xs col-md-auto col-md-12 mt-2">
                <form action="animalServlet.do" method="POST" style="display:none;">
                    <div class="form-group col-6 p-0">
                        <label for="animal">Animais</label>
                        <select name="animal" class="form-control" multiple="multiple"></select>
                        <button class="btn btn-success mt-2" type="submit" disabled>Detalhar Animal</button>
                    </div>
                </form>
            </div>
            <div class="col-6 col-xs col-md-auto col-md-12 mt-2">
            	<div class="alert alert-danger mt-2" role="alert" style="display:none;">Não foi possivel localizar animal com esse nome</div>
            </div>
        </div>
        
    </div>
<!-- /Lista -->

    <div class="container" id="containerFormulario">
        <div class="row">
            <div class="col col-xs">
                <h1>Incluir Animal</h1>
                <form action="animalServlet.do" method="POST">
                    <div class="form-row mt-2">
                        <div class="col-3 col-xs-12">
                            <button class="btn btn-success">Incluir</button>
                            <button class="btn btn-warning" disabled>Editar</button>
                            <button class="btn btn-danger" data-toggle="modal" data-target="#modalExcluirAnimal" disabled>Excluir</button>
                        </div>
                    </div>
                    
                    <% if(mensagem_crud != null ) {  
                    	if(mensagem_crud.contentEquals("Animal apagado com sucesso") || mensagem_crud.contentEquals("Animal editado com sucesso") || mensagem_crud.contentEquals("Animal incluído com sucesso") ){
                    %>
                    <div class="alert alert-success mt-2" role="alert">
                    <% } else if(mensagem_crud.contentEquals("Não foi possível apagar o animal") || mensagem_crud.contentEquals("Não foi possível editar o animal") || mensagem_crud.contentEquals("Não foi possível incluir o animal") ){  %>
                    <div class="alert alert-danger mt-2" role="alert">
                    <% } %>
					<%=mensagem_crud %>
					</div>
					<% }%>
					
                    <div class="form-row mt-4">
                        <div class="col-md-6 mb-3">
                            <label for="nome">Nome do Animal</label>
                            <input type="text" name="nome" class="form-control" readonly>
                            <div class="valid-feedback">Inválido</div>
                        </div>
                        <div class="col-md-2 mb-3">
                            <label for="sexo">Sexo</label>
                            <div class="form-check">
                                <input type="radio" class="form-check-imput" name="sexo" value="masculino" disabled>
                                <label for="sexo" class="form-check-label">Masculino</label>
                            </div>
                            <div class="form-check">
                                <input type="radio" class="form-check-imput" name="sexo" value="feminino" disabled>
                                <label for="sexo" class="form-check-label">Feminino</label>
                            </div>
                            <div class="valid-feedback"></div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="data">Data de Nascimento</label>
                            <input type="date" name="dataNascimento" class="form-control" readonly>
                            <div class="valid-feedback">Inválido</div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-3">
                            <label for="especie">Especie</label>
                            <input class="form-control" type="text" name="especie" readonly>
                        </div>
                        <div class="col-md-3">
                            <label for="raca">Raça</label>
                            <input class="form-control" type="text" name="raca" readonly>
                        </div>
                        <div class="col-md-2">
                            <label for="porte">Porte</label>
                            <input class="form-control" type="text" name="porte" readonly>
                        </div>
                        <div class="col-md-2">
                            <label for="pelagem">Pelagem</label>
                            <input class="form-control" type="text" name="pelagem" readonly>
                        </div>
                        <div class="col-md-2">
                            <label for="temperamento">Temperamento</label>
                            <input class="form-control" type="text" name="temperamento" readonly>
                        </div>
                    </div>
                    <!-- Em seguida, os campos são os especiais de cada tipo de usuario do sistema -->      

                    <div class="form-row mt-2">
                        <div class="col-md-6">
                            <label for="cpfcliente">CPF do Cliente</label>
                            <input class="form-control" type="text" name="cpf" readonly>
                        </div>
                        <div class="col-md-6">
                            <label for="idatendente">ID do Atendente</label>
                            <input class="form-control" type="number" name="idatendente" value="<%=empregado.getTipoEmpregado().equals("atendente") ? empregado.getIdAdministradoDeCadastramento() : 1 %>" readonly>
                        </div>
                    </div>
                    <div class="form-row mt-2">
                        <div class="col-md-12">
                        	<input type="hidden" name="idanimal" value="">
                        	<input type="hidden" name="opcao" value="2">
                            <input type="submit" value="OK" class="btn btn-primary" disabled>
                        </div>
                    </div>
                    
                    <!-- Modal de confirmação -->
                    <div class="modal fade" id="modalExcluirAnimal" tabindex="-1" role="dialog" aria-labelledby="modalConfirmacaoLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
	                        <div class="modal-content">
	                            <div class="modal-header">
	                            <h5 class="modal-title" id="modalConfirmacaoLabel">Confirme a Exclusão do Animal</h5>
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
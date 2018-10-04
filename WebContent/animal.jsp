<%@include file="_header.jsp" %>
<%
Empregado empregado = (Empregado) session.getAttribute("empregado");
if(empregado != null ){
	if(empregado.getTipoEmpregado().equals("veterinario")){
		response.sendRedirect("main.jsp");
	}	
}
%>
    <!-- Consulta -->
    <div class="container">
        <div class="row justify-content-md center">
            <div class="col col-xs col-md-auto col-md-12 mt-2">
                <h1 class="font-weight-bold">Consultar Animal</h1>
                <form action="">
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
    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col col-xs col-md-auto col-md-12 mt-2">
                <form action="animal.html">
                    <div class="form-group col-6 p-0">
                        <label for="animal">Animais</label>
                        <select name="animal[id]" id="" class="form-control" multiple="multiple">
                            <option value="0">Rex</option>
                            <option value="1">Tobby</option>
                            <option value="2">Billy</option>
                            <option value="3">Judith</option>
                        </select>
                        <button class="btn btn-success mt-2" value="selecionar" name="animal[acao]" type="submit">Detalhar Animal</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
<!-- /Lista -->

    <div class="container">
        <div class="row">
            <div class="col col-xs">
                <h1>Incluir Animal</h1>
                <form action="animalServlet.do" method="POST">
                    <div class="form-row mt-2">
                        <div class="col-3 col-xs-12">
                            <button class="btn btn-success">Incluir</button>
                            <button class="btn btn-warning">Editar</button>
                            <button class="btn btn-danger">Excluir</button>
                        </div>
                    </div>
                    <div class="form-row mt-4">
                        <div class="col-md-6 mb-3">
                            <label for="nome">Nome do Animal</label>
                            <input type="text" name="nome" class="form-control">
                            <div class="valid-feedback">Inválido</div>
                        </div>
                        <div class="col-md-2 mb-3">
                            <label for="sexo">Sexo</label>
                            <div class="form-check">
                                <input type="radio" class="form-check-imput" name="sexo" value="masculino">
                                <label for="sexo" class="form-check-label">Masculino</label>
                            </div>
                            <div class="form-check">
                                <input type="radio" class="form-check-imput" name="sexo" value="feminino">
                                <label for="sexo" class="form-check-label">Feminino</label>
                            </div>
                            <div class="valid-feedback"></div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="data">Data de Nascimento</label>
                            <input type="date" name="dataNascimento" class="form-control">
                            <div class="valid-feedback">Inválido</div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-3">
                            <label for="especie">Especie</label>
                            <input class="form-control" type="text" name="especie">
                        </div>
                        <div class="col-md-3">
                            <label for="raca">Raça</label>
                            <input class="form-control" type="text" name="raca">
                        </div>
                        <div class="col-md-2">
                            <label for="porte">Porte</label>
                            <input class="form-control" type="text" name="porte">
                        </div>
                        <div class="col-md-2">
                            <label for="pelagem">Pelagem</label>
                            <input class="form-control" type="text" name="pelagem">
                        </div>
                        <div class="col-md-2">
                            <label for="temperamento">Temperamento</label>
                            <input class="form-control" type="text" name="temperamento">
                        </div>
                    </div>
                    <!-- Em seguida, os campos são os especiais de cada tipo de usuario do sistema -->      

                    <div class="form-row mt-2">
                        <div class="col-md-6">
                            <label for="cpfcliente">CPF do Cliente</label>
                            <input class="form-control is-invalid" type="number" name="cpfcliente">
                        </div>
                        <div class="col-md-6">
                            <label for="idatendente">ID do Atendente</label>
                            <input class="form-control" type="number" name="idatendente" value="1" readonly>
                        </div>
                    </div>
                    <div class="form-row mt-2">
                        <div class="col-md-12">
                            <input type="submit" value="OK" class="btn btn-primary" readonly>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
<%@include file="_footer.jsp" %>
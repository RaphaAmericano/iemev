<%@include file="_header.jsp" %>
<%
Empregado empregado = (Empregado) session.getAttribute("empregado");
if(empregado != null ){
	if(!empregado.getTipoEmpregado().equals("atendente")){
		response.sendRedirect("main.jsp");
	}	
}
%>
<!-- Busca -->
    <div class="container">
        <div class="row justify-content-md center">
            <div class="col col-xs col-md-auto col-md-12 mt-2">
                <h1 class="font-weight-bold">Consultar Usuário</h1>
                <form action="">
                    <div class="form-group">
                        <label for="">Buscar usuário</label>
                        <input class="form-control" type="search">
                    </div>
                    <button class="btn btn-primary" type="submit">Localizar usuário</button>
                </form>
            </div>
        </div>
    </div>
<!-- /Busca -->

<!-- Select Resultados -->
<div class="container">
        <div class="row justify-content-md-center">
            <div class="col col-xs col-md-auto col-md-12 mt-2">
                <form action="animal.html">
                    <div class="form-group">
                        <label for="animal">Usuários</label>
                        <select name="animal[id]" id="" class="form-control" multiple="multiple">
                            <option value="0">Jorge Silva</option>
                            <option value="1">Jorge Guimarães</option>
                            <option value="2">Jorge Montenegro</option>
                            <option value="3">Jorge Campos</option>
                        </select>
                        <button class="btn btn-success mt-2" value="selecionar" name="animal[acao]" type="submit">Detalhar Usuário</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
<!-- /Select Resultados -->
    <div class="container">
        <div class="row">
            <div class="col col-xs">
                <h1>Incluir Usuário</h1>
                <form action="">
                    <div class="form-row mt-2">
                        <div class="col col-xs-12">
                            <button class="btn btn-success">Incluir usuário</button>
                            <button class="btn btn-warning">Editar usuário</button>
                            <button class="btn btn-danger">Excluir usuário</button>
                        </div>
                    </div>
                    <div class="form-row mt-2">
                        <div class="col-md-12">
                            <label for="nome">Nome</label>
                            <input type="text" name="name" class="form-control">
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
                        <div class="col-md-4">
                            <label for="ramal">Ramal</label>
                            <input class="form-control" type="number" name="ramal" maxlength="4">
                        </div>
                        <div class="col-md-4">
                                <label for="tipo">Perfil</label>
                                <select class="form-control" type="text" name="perfil">
                                    <option value="0">Atendente</option>
                                    <option value="1">Administrador</option>
                                    <option value="2">Veterinário</option>
                                </select>
                            </div>
                        <div class="col-md-4">
                            <label for="dataadminissao">Data de Admissão</label>
                            <input class="form-control" type="number" name="dataadminissao" readonly>
                        </div>
                    </div>

                    <div class="form-row mt-2">
                        <div class="col-md-6">
                            <label for="crmv">CRMV</label>
                            <input class="form-control" type="number" name="crmv">
                        </div>
                        <div class="col-md-6">
                            <label for="especialidade">Especialidade</label>
                            <input class="form-control" type="number" name="especialidade">
                        </div>
                    </div>

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
                            <label for="" type="senha">Senha Inicial</label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-key"></i></span>
                                </div>
                                <input type="senha_inicial" class="form-control">
                            </div>
                        </div>
                    </div>
                    <div class="form-row mt-2">
                        
                        <div class="col-md-6">
                            <label for="idadministrador">ID do Administrador</label>
                            <input class="form-control" type="number" name="idatendente" readonly>
                        </div>
                        <!-- <div class="col-md-6">
                            <label for="idusuario">ID do Usuário</label>
                            <input class="form-control" type="number" name="idusuario" readonly>
                        </div> -->
                    </div>
                    <div class="form-row mt-2">
                            <div class="col-3">
                                <button class="btn btn-primary">OK</button>
                            </div>
                        </div>
                </form>
            </div>
        </div>
    </div>
<%@include file="_footer.jsp" %>
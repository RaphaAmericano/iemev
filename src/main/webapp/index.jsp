<%@include file="_header.jsp" %>
<div class="container">
        <div class="row">
            <div class="col-3 col-xs-12 mx-auto m-5">
                <!-- Modificar para o servlet de acesso -->
                <form action="/loginServlet.do">
                    <div class="form-group">
                        <label for="usuario">CPF do Usuário</label>
                        <div class="input-group-prepend">
                            <span class="input-group-text">
                                <i class="fas fa-user"></i>
                            </span>
                            <input class="form-control" type="text" name="cpf" placeholder="CPF">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="senha">Senha</label>
                        <div class="input-group-prepend">
                            <span class="input-group-text">
                                <i class="fas fa-key"></i>
                            </span>
                            <input class="form-control" type="password" name="senha" placeholder="Senha">
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Entrar</button>
                </form>
            </div>
        </div>
    </div>
<%@include file="_footer.jsp" %>
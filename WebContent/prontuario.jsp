<%@include file="_header.jsp" %>
<%
Empregado empregado = (Empregado) session.getAttribute("empregado");
if(empregado != null ){
	if(!empregado.getTipoEmpregado().equals("veterinario")){
		response.sendRedirect("main.jsp");
	}	
}
%>
<!-- Consulta -->
<div class="container" id="containerBusca">
    <div class="row justify-content-md center">
        <div class="col col-xs col-md-auto col-md-12">
            <h1 class="font-weight-bold">Consultar Prontuário</h1>
            <form action="ProntuarioServlet.do" method="POST">
                <div class="form-group">
                    <label for="">Buscar prontuário</label>
                    <input class="form-control" type="text" placeholder="CPF do Cliente">
                </div>
                <button class="btn btn-primary" type="submit">Localizar cliente</button>
                <div class="alert alert-danger mt-3" role="alert" style="display:none;"></div>
            </form>
        </div>
    </div>
</div>

<div class="container" id="containerAnimais">
    <div class="row justify-content-md-center">
        <div class="col col-xs col-md-auto col-md-12 mt-2">
            <form action="ProntuarioServlet.do">
                <div class="form-group">
                    <label for="animal">Animais do Cliente: <strong></strong></label>
                    <select name="animal" class="form-control" multiple="multiple"></select>
                    <button class="btn btn-success mt-2" value="selecionar" name="animal[acao]" type="submit">Consultar Prontuário</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- /Lista -->
<!-- Lista de Fichas -->
<div class="container" id="containerPrescricoes">
    <div class="row justify-content-md-center">
        <div class="col col-xs col-md-6">
            <table class="table table-hover">
                <thead>
                    <tr>
                    <th scope="col">Data de Prescrição</th>
                    <th>Número da Ficha</th>
                    <th>Categoria</th>
                    <th>Serviço</th>
                    <th>Veterinário</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><time datetime="2016-07-31">2016-07-31</time></td>
                        <td>5</td>
                        <td>Vacinação</td>
                        <td>Raiva</td>
                        <td>João Valadão</td>
                    </tr>
                    <tr>
                        <td><time datetime="2016-07-31">2016-07-31</time></td>
                        <td>2</td>
                        <td>Cirurgia</td>
                        <td>Fratura</td>
                        <td>Antonio Marques</td>
                    </tr>
                    <tr>
                        <td><time datetime="2016-07-31">2016-07-31</time></td>
                        <td>10</td>
                        <td>Internação</td>
                        <td>Diária</td>
                        <td>Ubiratam José Gonçalves</td>
                       
                    </tr>
                </tbody>
            </table>
        </div>

        <div class="col col-xs col-md-6" id="fichaAnimal">
            <fieldset disabled="disabled">
                    <div class="form-row">
                            <div class="col-md-3"><label for="">Nome</label><input type="text" class="form-control" value=""></div>
                            <div class="col-md-3"><label for="">Espécie</label><input type="text" class="form-control" value=""></div>
                            <div class="col-md-2"><label for="">Sexo</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">
                                            <i class="fas fa-transgender"></i>
                                        </span>
                                    </div>
                                    <input type="text" class="form-control" value="">
                                </div>
                            </div>
                            <div class="col-md-4"><label for="">Data de Nascimento</label><input type="date" class="form-control" value=""></div>
                        </div>
                        <div class="form-row">
                            <div class="col-md-3"><label for="">Raça</label><input type="text" class="form-control" value=""></div>
                            <div class="col-md-3"><label for="">Pelagem</label><input type="text" class="form-control" value=""></div>
                            <div class="col-md-3"><label for="">Porte</label><input type="text" class="form-control" value=""></div>
                            <div class="col-md-3"><label for="">Tempramento</label><input type="text" class="form-control" value=""></div>
                        </div>
            </fieldset>
        </div>
    </div>
</div>
<%@include file="_footer.jsp" %>
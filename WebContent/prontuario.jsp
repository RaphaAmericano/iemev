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
<div class="container">
    <div class="row justify-content-md center">
        <div class="col col-xs col-md-auto col-md-12">
            <h1 class="font-weight-bold">Consultar Prontu�rio</h1>
            <form action="">
                <div class="form-group">
                    <label for="">Buscar prontu�rio</label>
                    <input class="form-control" type="number" placeholder="CPF do Cliente">
                </div>
                <button class="btn btn-primary" type="submit">Localizar cliente</button>
            </form>
        </div>
    </div>
</div>

<div class="container">
        <div class="row justify-content-md-center">
            <div class="col col-xs col-md-auto col-md-12 mt-2">
                <form action="ficha_atendimento.html">
                    <div class="form-group">
                        <label for="animal">Animais do Cliente: <strong>Jorge Baltazar</strong></label>
                        <select name="animal[id]" id="" class="form-control" multiple="multiple">
                            <option value="0">Toby</option>
                            <option value="1">Rufus</option>
                            <option value="2">Dolly</option>
                        </select>
                        <button class="btn btn-success mt-2" value="selecionar" name="animal[acao]" type="submit">Consultar Prontu�rio</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
<!-- /Lista -->
    <!-- Lista de Fichas -->

    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col col-xs col-md-6">
                
                <table class="table table-hover">
                    <thead>
                        <tr>
                        <th scope="col">Data de Prescri��o</th>
                        <th>N�mero da Ficha</th>
                        <th>Categoria</th>
                        <th>Servi�o</th>
                        <th>Veterin�rio</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><time datetime="2016-07-31">2016-07-31</time></td>
                            <td>5</td>
                            <td>Vacina��o</td>
                            <td>Raiva</td>
                            <td>Jo�o Valad�o</td>
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
                            <td>Interna��o</td>
                            <td>Di�ria</td>
                            <td>Ubiratam Jos� Gon�alves</td>
                           
                        </tr>
                    </tbody>
                </table>
            </div>

            <div class="col col-xs col-md-6">
                <fieldset disabled="disabled">
                        <div class="form-row">
                                <div class="col-md-3"><label for="">Nome</label><input type="text" class="form-control" value="Toby"></div>
                                <div class="col-md-3"><label for="">Esp�cie</label><input type="text" class="form-control" value="Cachorro"></div>
                                <div class="col-md-2"><label for="">Sexo</label>
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="fas fa-transgender"></i>
                                            </span>
                                        </div>
                                        <input type="text" class="form-control" value="M">
                                    </div>
                                </div>
                                <div class="col-md-4"><label for="">Data de Nascimento</label><input type="date" class="form-control" value="2018-02-23"></div>
                            </div>
                            <div class="form-row">
                                <div class="col-md-3"><label for="">Ra�a</label><input type="text" class="form-control" value="Pastor Alem�o"></div>
                                <div class="col-md-3"><label for="">Pelagem</label><input type="text" class="form-control" value="Alta"></div>
                                <div class="col-md-3"><label for="">Porte</label><input type="text" class="form-control" value="Grande"></div>
                                <div class="col-md-3"><label for="">Tempramento</label><input type="text" class="form-control" value="Manso"></div>
                            </div>
                </fieldset>
                
            </div>
        </div>
    </div>
<%@include file="_footer.jsp" %>
<%@include file="_header.jsp" %>
<%
Empregado empregado = (Empregado) session.getAttribute("empregado");
if(empregado != null ){
	if(!empregado.getTipoEmpregado().equals("veterinario")){
		response.sendRedirect("main.jsp");
	}	
}
%>
<div class="container">
    <div class="row justify-content-md center">
        <div class="col col-xs col-md-auto col-md-12 mt-2">
            <h1 class="font-weight-bold">Boxes</h1>
        </div>
    </div>
</div>

<div class="container">
    <div class="row justify-content-md-center mt-2">
        <div class="col col-xs col-md-auto col-md">
            <form action="boxesController.do">
                
                <div class="form-row">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                            <th scope="col">Número Box</th>
                            <th scope="col">Número da Ficha</th>
                            <th scope="col">Nome do Cliente</th>
                            <th scope="col">Nome do Animal</th>
                            <th scope="col">Data de Internação</th>
                            <th scope="col">Status</th>
                            <th scope="col">Ação</th>
                            <th scope="col">Excluir</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>4</td>
                                <td>Jorge Matos</td>
                                <td>Otto</td>
                                <td><time datetime="2018-07-10">2018-07-10</time></td>
                                <td>Ocupado</td>
                                <td><button class="btn btn-warning">Liberar Box</button></td>
                                <td><button class="btn btn-danger" disabled>Excluir Box</button></td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <th><input type="number" class="form-control"></th>
                                <td>-</td>
                                <td>-</td>
                                <td><time datetime="0000-00-00">0000-00-00</time></td>
                                <td>Vazio</td>
                                <td><button class="btn btn-success">Ocupar Box</button></td>
                                <td><button class="btn btn-danger">Excluir Box</button></td>
                            </tr>
                            <tr>
                                <th scope="row">3</th>
                                <td>8</td>
                                <td>João Penha</td>
                                <td>Peperoni</td>
                                <td><time datetime="2018-07-10">2018-07-10</time></td>
                                <td>Ocupado</td>
                                <td><button class="btn btn-warning">Liberar Box</button></td>
                                <td><button class="btn btn-danger" disabled>Excluir Box</button></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="form-row align-items-center">
                    <div class="col-sm-3 col-md-12 my-1">
                        <h2 class="font-weight-bold">Incluir novo box</h2>
                    </div>
                </div>
                <div class="form-row align-items-center">
                    <div class="col-sm-3 col-md-1 my-1">
                        <label>Nº do novo box</label>
                    </div>
                </div>
                <div class="form-row align-items-center">
                    <div class="col-sm-3 col-md-1 my-1">
                        <input type="number" class="form-control" placeholder="Nº">
                    </div>
                    <div class="col-auto my-1">
                        <button type="submit" class="btn btn-success">OK</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="_footer.jsp" %>
<%@include file="_header.jsp" %>


<div class="container">
    <div class="row justify-content-md-center mt-2">
        <div class="col col-xs col-md-auto col-md">
            <form action="ficha_atendimento.html">
                <label for="boxes">Boxes</label>
                <div class="form-row">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                            <th scope="col">N�mero Box</th>
                            <th scope="col">N�mero da Ficha</th>
                            <th scope="col">Nome do Cliente</th>
                            <th scope="col">Nome do Animal</th>
                            <th scope="col">Data de Interna��o</th>
                            <th scope="col">Status</th>
                            <th scope="col">A��o</th>
                            <th scope="col">Excluir</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <th scope="row">4</th>
                                <td>Jorge Matos</td>
                                <td>Otto</td>
                                <td><time datetime="2018-07-10">2018-07-10</time></td>
                                <td>Ocupado</td>
                                <td><button class="btn btn-warning">Liberar Box</button></td>
                                <td><button class="btn btn-danger" disabled>Excluir Box</button></td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <th scope="row"><input type="number" class="form-control"></th>
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
                                <td>Jo�o Penha</td>
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
                    <div class="col-sm-3 col-md-1 my-1">
                        <label>N� do novo box</label>
                    </div>
                </div>
                <div class="form-row align-items-center">
                    <div class="col-sm-3 col-md-1 my-1">
                        <input type="number" class="form-control" placeholder="N�">
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
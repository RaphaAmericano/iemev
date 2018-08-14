<%@include file="_header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col col-xs mt-5">
            <div class="card-deck">
                    
                    <div class="card">
                        <img class="card-img-top" src="img/cliente_geriatria.jpg" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Cliente</h5>
                            <a href="cliente.jsp"class="btn btn-primary btn-block">Cadastro Cliente</a>
                        </div>
                    </div>
                    <div class="card">
                        <img class="card-img-top" src="img/anestesiologia.jpg" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Animal</h5>
                            <a href="animal.html" class="btn btn-primary btn-block">Cadastro de Animal</a>
                        </div>
                    </div>
                    <div class="card">
                        <img class="card-img-top" src="img/cardiologia_iemev.jpg" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Consulta</h5>
                            <a href="consulta.html" class="btn btn-primary btn-block">Cadastro Consulta</a>
                        </div>
                    </div>
                    <div class="card">
                        <img class="card-img-top" src="img/cliente_geriatria.jpg" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Exame</h5>
                            <a href="exame.html" name="incluir" class="btn btn-primary btn-block">Cadastro de Exames</a>
                        </div>
                    </div>
                </div>
        </div>
    </div>
</div>
<div class="container">
  <div class="row">
      <div class="col col-xs mt-5">
          <div class="card-deck">
              <div class="card">
                  <img class="card-img-top" src="img/veterinaria_iemev.jpg" alt="Card image cap">
                  <div class="card-body">
                      <h5 class="card-title">Ficha de Atendimento</h5>
                      <a href="ficha_atendimento.html" class="btn btn-primary btn-block">Cadastro de Ficha de Atendimento</a>
                  </div>
              </div>
              <div class="card">
                  <img class="card-img-top" src="img/veterinaria_iemev.jpg" alt="Card image cap">
                  <div class="card-body">
                      <h5 class="card-title">Lista de Atendimento</h5>
                      <form action="lista_atendimento.html" class="form-group">
                      <a href="lista_atendimento.html" class="btn btn-primary btn-block">Gerenciar Listas</a>
                  </div>
              </div>
              <div class="card">
                  <img class="card-img-top" src="img/veterinaria_iemev.jpg" alt="Card image cap">
                  <div class="card-body">
                      <h5 class="card-title">Finalizar Atendimento</h5>
                      <a href="finalizar_atendimento.html" class="btn btn-primary btn-block">Finalizar Atendimento</a>
                  </div>
              </div>
          </div>
      </div>
  </div>
</div>
<div class="container">
    <div class="row">
        <div class="col col-xs mt-5">
            <div class="card-deck">
                <div class="card">
                    <img class="card-img-top" src="img/veterinaria_iemev.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Usuário</h5>
                        <a href="usuario.html" name="incluir" class="btn btn-primary btn-block">Incluir Usuário</a>
                    </div>
                </div>
                <div class="card">
                    <img class="card-img-top" src="img/veterinaria_iemev.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Serviços</h5>
                        <a href="servico.html" name="incluir" class="btn btn-primary btn-block">Incluir Usuário</a>
                    </div>
                </div>
                <div class="card">
                    <img class="card-img-top" src="img/veterinaria_iemev.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Relatórios</h5>
                        <a href="relatorios.html" class="btn btn-primary btn-block">Incluir Relatório</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col col-xs mt-5">
            <div class="card-deck">
                <div class="card">
                    <img class="card-img-top" src="img/veterinaria_iemev.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Boxes</h5>
                        <a href="boxes.html" class="btn btn-primary btn-block">Incluir Box</a>
                    </div>
                </div>
                <div class="card">
                    <img class="card-img-top" src="img/veterinaria_iemev.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Prontuários</h5>
                            <a href="prontuario.html" class="btn btn-primary btn-block">Visualizar Prontuários</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="_footer.jsp" %>
<%@include file="_header.jsp" %>
<% String perfil = null;
if(session != null ){ 
	if(session.getAttribute("empregado") != null && session.getAttribute("pessoa") != null ){
		Empregado empregado = (Empregado) session.getAttribute("empregado");
		Pessoa pessoa = (Pessoa) session.getAttribute("pessoa");
		perfil = empregado.getTipoEmpregado();
	}%>
<div class="container">
	<% if(perfil.equals("administrador") || perfil.equals("atendente")){ %>
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
                            <a href="animal.jsp" class="btn btn-primary btn-block">Cadastro de Animal</a>
                        </div>
                    </div>
                    <div class="card">
                        <img class="card-img-top" src="img/cardiologia_iemev.jpg" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Consulta</h5>
                            <a href="consulta.jsp" class="btn btn-primary btn-block">Cadastro Consulta</a>
                        </div>
                    </div>
                    <div class="card">
                        <img class="card-img-top" src="img/cliente_geriatria.jpg" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Exame</h5>
                            <a href="exame.jsp" name="incluir" class="btn btn-primary btn-block">Cadastro de Exames</a>
                        </div>
                    </div>
                </div>
        </div>
    </div>
    <% } %>
</div>

<div class="container">
  <div class="row justify-content-center">
      <div class="<%=perfil.equals("veterinario") ? "col-6" : "col-9"%> col-xs mt-5">
          <div class="card-deck">
       		  
              <div class="card">
                  <img class="card-img-top" src="img/veterinaria_iemev.jpg" alt="Card image cap">
                  <div class="card-body">
                      <h5 class="card-title">Ficha de Atendimento</h5>
                      <a href="ficha_atendimento.jsp" class="btn btn-primary btn-block">Cadastro de Ficha de Atendimento</a>
                  </div>
              </div>
              <div class="card">
                  <img class="card-img-top" src="img/veterinaria_iemev.jpg" alt="Card image cap">
                  <div class="card-body">
                      <h5 class="card-title">Lista de Atendimento</h5>
                      <form action="lista_atendimento.html" class="form-group">
                      <a href="lista_atendimento.jsp" class="btn btn-primary btn-block">Gerenciar Listas</a>
                  </div>
              </div>
              <%if(!perfil.equals("veterinario")){ %>
              <div class="card">
                  <img class="card-img-top" src="img/veterinaria_iemev.jpg" alt="Card image cap">
                  <div class="card-body">
                      <h5 class="card-title">Finalizar Atendimento</h5>
                      <a href="finalizar_atendimento.jsp" class="btn btn-primary btn-block">Finalizar Atendimento</a>
                  </div>
              </div>
              <%} %>
          </div>
      </div>
  </div>
</div>
<%
if( perfil.equals("administrador") ){ %>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-9 col-xs mt-5">
            <div class="card-deck">
                <div class="card">
                    <img class="card-img-top" src="img/veterinaria_iemev.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Usu�rio</h5>
                        <a href="usuario.html" name="incluir" class="btn btn-primary btn-block">Incluir Usu�rio</a>
                    </div>
                </div>
                <div class="card">
                    <img class="card-img-top" src="img/veterinaria_iemev.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Servi�os</h5>
                        <a href="servico.html" name="incluir" class="btn btn-primary btn-block">Incluir Usu�rio</a>
                    </div>
                </div>
                <div class="card">
                    <img class="card-img-top" src="img/veterinaria_iemev.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Relat�rios</h5>
                        <a href="relatorios.jsp" class="btn btn-primary btn-block">Incluir Relat�rio</a>
                    </div>
                </div>
                
            </div>
        </div>
    </div>
</div>
<% } 
if(perfil.equals("veterinario") ){ %>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-6 col-xs mt-5">
            <div class="card-deck">
                <div class="card">
                  <img class="card-img-top" src="img/veterinaria_iemev.jpg" alt="Card image cap">
                  <div class="card-body">
                      <h5 class="card-title">Boxes</h5>
                      <a href="boxes.jsp" class="btn btn-primary btn-block">Incluir Box</a>
                  </div>
             	</div>
                <div class="card">
                    <img class="card-img-top" src="img/veterinaria_iemev.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Prontu�rios</h5>
                            <a href="prontuario.jsp" class="btn btn-primary btn-block">Visualizar Prontu�rios</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <% } %>
</div>

<% }%>
<%@include file="_footer.jsp" %>
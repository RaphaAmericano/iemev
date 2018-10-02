<%@page import="iemev.models.Empregado"%>
<% 
String url =  request.getRequestURI();
String[] parts = url.split("/");
String pagina = parts[2];
Empregado empregado = (Empregado) session.getAttribute("empregado");
String perfil = empregado.getTipoEmpregado();
%>

<nav class="navbar sticky-top navbar-expand-lg">
    <div class="container">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarPrincipal" aria-controls="navbarPrincipal" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarPrincipal">
            <div class="navbar-nav">
            <%if(!perfil.equals("veterinario")){ %>
            <a class="nav-item nav-link <%=pagina.equals("cliente.jsp") ? "active": "" %>" data-toggle="tooltip" data-animation="false" data-placement="bottom" title="Listagem de Clientes" href="cliente.jsp">Cliente</a>
            <a class="nav-item nav-link <%=pagina.equals("animal.jsp") ? "active": "" %>" data-toggle="tooltip" data-animation="false" data-placement="bottom" title="Cadastro para Animais" href="animal.jsp">Animal <span class="sr-only">(current)</a>
            <a class="nav-item nav-link <%=pagina.equals("consulta.jsp") ? "active": "" %>" data-toggle="tooltip" data-animation="false" data-placement="bottom" title="Administração das consultas" href="consulta.jsp">Consulta</a>
            <a class="nav-item nav-link <%=pagina.equals("exame.jsp") ? "active": "" %>" data-toggle="tooltip" data-animation="false" data-placement="bottom" title="Listagem de exames" href="exame.jsp">Exame</a>
            <%} %>
            <a class="nav-item nav-link <%=pagina.equals("ficha_atendimento.jsp") ? "active": "" %>" data-toggle="tooltip" data-animation="false" data-placement="bottom" title="Consulta e cadastro de fichas de atendimento" href="ficha_atendimento.jsp">Ficha de Atendimento</a>
            <a class="nav-item nav-link <%=pagina.equals("lista_atendimento.jsp") ? "active": "" %>" data-toggle="tooltip" data-animation="false" data-placement="bottom" title="Gerenciamento das listas de atendimento" href="lista_atendimento.jsp">Lista de Atendimento</a>
            <%if(!perfil.equals("veterinario")){ %>
            <a class="nav-item nav-link <%=pagina.equals("finalizar_atendimento.jsp") ? "active": "" %>" data-toggle="tooltip" data-animation="false" data-placement="bottom" title="Finalizar os atendimentos" href="finalizar_atendimento.jsp">Finalizar Atendimento</a>
            <%} 
            if(perfil.equals("usuario")){ %>
            <a class="nav-item nav-link <%=pagina.equals("usuario.jsp") ? "active": "" %> <%=perfil.equals("atendente") ? "": "disabled" %>" data-toggle="tooltip" data-animation="false" data-placement="bottom" title="Administração dos usuários do sistema" href="usuario.jsp">Usuário</a>
            <%}
            if(perfil.equals("administrador")){ %>
            <a class="nav-item nav-link <%=pagina.equals("servico.jsp") ? "active": "" %>" data-toggle="tooltip" data-animation="false" data-placement="bottom" title="Gerencie os sistemas" href="servico.jsp">Serviços</a>
            <a class="nav-item nav-link <%=pagina.equals("relatorios.jsp") ? "active": "" %>" data-toggle="tooltip" data-animation="false" data-placement="bottom" title="Emissão dos relatórios" href="relatorios.jsp">Relatórios</a>
            <a class="nav-item nav-link <%=pagina.equals("prontuario.jsp") ? "active": "" %>" data-toggle="tooltip" data-animation="false" data-placement="bottom" title="Administre os prontuários" href="prontuario.jsp">Prontuários</a>
            <% }
            if(perfil.equals("veterinario")){ %>
            <a class="nav-item nav-link <%=pagina.equals("boxes.jsp") ? "active": "" %>" data-toggle="tooltip" data-animation="false" data-placement="bottom" title="Gerencie os boxes" href="boxes.jsp">Boxes</a>
            <%} %>
            </div>
        </div>
    </div>
</nav>
<!-- Vericaçoes de acordo com o perfil de usuario -->
<%@page import="java.util.Enumeration"%>
<%@page import="iemev.models.Empregado"%>
<%@page import="iemev.models.Pessoa"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="main.jsp">
            <img src="img/logo-iemev.png" alt="">
        </a>
       	<% if(session != null ){
       	if(session.getAttribute("empregado") != null && session.getAttribute("pessoa") != null ){
			Empregado empregado = (Empregado) session.getAttribute("empregado");
			Pessoa pessoa = (Pessoa) session.getAttribute("pessoa");
			
		%>
  		<span class="navbar-text">Bem vindo <strong><%=pessoa.getNome() %></strong></span>
        <form action="logoutController.do" class="float-xs-right" method="POST">
	        <button type="submit" class="btn btn-primary">Sair</button>
   		</form>
   			<% } 
       	} else {
       		out.print(session);
  			//response.sendRedirect("index.jsp");
   		}%>
    </div>
</nav>
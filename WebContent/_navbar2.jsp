<nav class="navbar navbar-expand-lg navbar-light">
    <div class="container">
        <a class="navbar-brand" href="main.jsp">
            <img src="img/logo-iemev.png" alt="">
        </a>
       
       <%
       if(session != null ){
    	   if(session.getAttribute("cpf") != null ){ %>
    		   <span class="navbar-text">Bem vindo: <%=session.getAttribute("cpf") %></span>
    		   <form action="" class="float-xs-right" method="POST">   
		            <ul class="navbar-nav mr-auto">
		                <li class="nav-item active">
		                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
		                </li>
		                <li class="nav-item">
		                    <a class="nav-link" href="#">Logout</a>
		                </li>
		                <li class="nav-item">
		                    <a class="nav-link disabled" href="#">Disabled</a>
		                </li>
		            </ul>
		            <input type="hidden" name="login" value="1">
    		   </form>
    		   
    	   <%  } else { 
 
    		response.sendRedirect("index.jsp");
    	   }
       }
       %>
       
        
    </div>
</nav>
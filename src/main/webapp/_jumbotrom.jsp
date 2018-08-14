<!-- Jumbotrom titulo da sessao -->
<% String uri = request.getRequestURI();
	uri = uri.substring(uri.lastIndexOf("/"));
	uri = uri.replace("/", "").replace(".jsp", "");
	String firstLatter = uri.substring(0, 1).toUpperCase(); 
	
%>
<div class="jumbotron jum_cliente">
    <div class="container">
        <h1 class="display-4"><% out.println(uri); %></h1>
    </div>
</div>
<!-- Jumbotrom titulo da sessao -->
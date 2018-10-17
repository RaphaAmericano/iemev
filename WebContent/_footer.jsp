<%@page import="iemev.utils.UrlUtils"%>
<nav class="navbar navbar-dark bg-dark mt-3">
    <footer class="container">
            <span class="navbar-text"><img src="img/logo-iemev-footer.png" alt="">Iemev</span>
            <span class="navbar-text">&copy; <script> var hoje = new Date().getFullYear(); document.write(hoje);</script> Todos os direitos reservados.</span>
            <span class="navbar-text">BBA Soluções</span>
    </footer>
</nav>
<!-- Scripts -->



<script src="node_modules/jquery/dist/jquery.min.js"></script>
<script src="node_modules/jquery-mask-plugin/dist/jquery.mask.min.js"></script>
<script src="node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"></script>

<script src="js/main.js"></script>
<%
if(request != null ){
String url =  request.getRequestURI();
String[] parts = url.split("/");
int partsLength = parts.length; 
String pagina = parts[partsLength - 1];

if( pagina.equals("index.jsp") || partsLength == 2){ %>
<script src="js/index.js"></script>
<% } 
if( pagina.equals("ficha_atendimento.jsp")){ %>
<script src="js/ficha.js"></script>
<% } 
if( pagina.equals("animal.jsp")){ %>
<script src="js/animal.js"></script>
<% }
if( pagina.equals("cliente.jsp")){ %>
<script src="js/cliente.js"></script>
<% } if( pagina.equals("finalizar_atendimento.jsp")){ %>
<script src="js/finalizar.js"></script>
<% } }%>
<!-- Inserir verificacoes para o javascript correspondente a cada pagina -->


<!-- /Scripts -->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="_head.jsp" %>
<title>Iemev</title>
</head>
<body>
<%@include file="_navbar.jsp" %>

<!-- Fazer uma verifica��o para exibir apenas se n�o for tela de login -->
<% if(session != null ){ 
	if(session.getAttribute("empregado") != null ){ %>
<%@include file="_navbar_sticky.jsp" %>
<%	} else {
	
		//response.sendRedirect("index.jsp");
	}
} 
%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.desafiolatam.modelo.Usuario"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido usuario</title>
</head>
<%
	
	HttpSession sesion = request.getSession();
	if(sesion.getAttribute("nombre")==null){
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
%>
<body>
	<h1>Bienvenido usuario : <%= sesion.getAttribute("nombre")%></h1>
	<h2>Correo: <%= sesion.getAttribute("correo")%></h2>
	<h2>Profesion: <%= sesion.getAttribute("profesion")%></h2>
</body>
</html>
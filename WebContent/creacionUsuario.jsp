<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	HttpSession sesion = request.getSession();
	if(sesion.getAttribute("correo")==null){
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
%>
<body>
	<div id="container">
		<!--Barra de navegacion -->
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="creacionUsuario.jsp">CREAR USUARIO</a></li>
				<li class="nav-item"><a class="nav-link" href="listarUsuarios.jsp">LISTAR USUARIO</a></li>
				<li class="nav-item"><a class="nav-link" href="eliminacionUsuario.jsp">ELIMINACION USUARIO</a></li>
				<li class="nav-item"><a class="nav-link" href="modificacionUsuario.jsp">MODIFICACION USUARIO</a></li>
				<li class="nav-item"><a class="nav-link" href="horoscopo.jsp">CONSULTAR ANIMAL ZODIACAL</a></li>
				<li class="nav-item"><a class="nav-link" href="cerrarSesion">CERRAR SESION</a></li>
			</ul>
		</nav>
		
		<div id="contenedor" style="margin: 0 auto; border: 1px solid black; width: 600px; margin-top: 50px;">
		<div id="content" style="margin:5%">
			<form action="creacion" method="post">
				<div class="form-group">
					<label for="usuario">Usuario</label> <input type="text" class="form-control" name="usuario" placeholder="ingrese usuario">
				</div>
				<div class="form-group">
					<label for="fechaNac">Fecha de nacimiento</label> <input type="text" class="form-control" name="fechaNac" placeholder="FORMATO dd/mm/aaaa">
				</div>
				<div class="form-group">
					<label for="correo">correo</label> <input type="email" class="form-control" name="correo" placeholder="ingrese correo">
				</div>
				<div class="form-group">
					<label for="pass">password</label> <input type="text" class="form-control" name="pass" placeholder="ingrese password">
				</div>
				
				<button type="submit" class="btn btn-primary">Agregar</button>
			</form>
		</div>
	</div>
	</div>
</body>
</html>
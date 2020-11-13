<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.desafiolatam.modelo.Usuario"%>
	<%@ page import="java.text.SimpleDateFormat"%>
	<%@ page import="java.util.Date"%>
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
<title>Eliminar Usuario</title>
</head>
<body>
	<%
			HttpSession sesion = request.getSession();
			if(sesion.getAttribute("correo")==null){
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
			Usuario user = new Usuario();
			String fechaNacimiento = "";
			if (request.getAttribute("usuarioAEliminar") != null) {
				user = (Usuario) request.getAttribute("usuarioAEliminar");
				
				String fn = user.getFecha_nacimiento();
				Date fechaNac = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(fn);
				
				fechaNacimiento =(String)new SimpleDateFormat("dd/MM/yyyy").format(fechaNac);
			}
	%>
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

		<div id="contenedor"
			style="margin: 0 auto; border: 1px solid black; width: 600px; margin-top: 50px;">
			<div id="content" style="margin: 5%">

				<div class="card">
					<div class="card-body">
					<h5 class="card-title">Buscar usuario a eliminar</h5>
						<form action="listarDelete" method="post">
							<div class="form-group">
								<label for="nombre">Usuario</label> <input type="text"
									class="form-control" name="nombre"
									placeholder="ingrese nombre">
							</div>
							<button type="submit" class="btn btn-primary">Buscar</button>
						</form>
					</div>
				</div>
				<br>
				
				<% if (request.getAttribute("usuarioAEliminar") != null) { %>
				<div class="card">
					<div class="card-body">
					<h5 class="card-title">Usuario encontrado</h5>
						<form action="deleteUser" method="post">
						
						<input type="hidden" name="id_user" value="<%= user.getId_user() %>">
						
							<div class="form-group">
								<label for="usuario">Usuario</label> <input type="text"
									class="form-control" name="usuario" value="<%=user.getUsuario() %>" disabled>
							</div>
							<div class="form-group">
								<label for="fechaNac">Fecha de nacimiento</label> <input
									type="text" class="form-control" name="fechaNac" value="<%=fechaNacimiento%>" disabled>
							</div>
							<div class="form-group">
								<label for="correo">Correo</label> <input type="email"
									class="form-control" name="correo" value="<%=user.getMail()%>" disabled>
							</div>
							
							<button type="submit" class="btn btn-primary">Eliminar</button>
						</form>
					</div>
				</div>
				
				<% } %>
			</div>
		</div>
	</div>
</body>
</html>
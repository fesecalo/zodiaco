package com.desafiolatam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.desafiolatam.facade.Facade;

@WebServlet("/login")
public class ProcesaLogin extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean usuarioExiste = false;
		Facade facade = new Facade();
		
		String correo = request.getParameter("mail");
		String password = request.getParameter("pass");
		
		
		usuarioExiste= facade.usuarioRegistrado(correo,password);
		request.setAttribute("usuarioExiste", usuarioExiste);
		
		
		if (usuarioExiste) {
			HttpSession sesionUsuario = request.getSession(true);
			sesionUsuario.setAttribute("correo", correo);
			request.setAttribute("correo", correo);
			request.getRequestDispatcher("creacionUsuario.jsp").forward(request, response);
			return;
		}
		else
		{
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Usuario o password incorrecto');");
			out.println("location='login.jsp';");
			out.println("</script>");
		}
	}
}

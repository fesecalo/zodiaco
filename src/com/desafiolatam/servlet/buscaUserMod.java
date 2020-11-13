package com.desafiolatam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.facade.Facade;
import com.desafiolatam.modelo.Usuario;

@WebServlet("/listarMod")
public class buscaUserMod extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
		
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Usuario usuarioMod = new Usuario();
		String nombre = request.getParameter("nombre");
		
		Facade facade = new Facade();
		usuarioMod= facade.buscarUserByName(nombre);
		
		if(usuarioMod!=null)
		{
			request.setAttribute("usuarioAModificar", usuarioMod);
			request.getRequestDispatcher("modificacionUsuario.jsp").forward(request, response);
		}
		else
		{
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Usuario no encontrado');");
			out.println("location='modificacionUsuario.jsp';");
			out.println("</script>");
		}
	}
}

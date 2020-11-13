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

@WebServlet("/listarDelete")
public class buscaUserDel extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
		
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Usuario usuarioDel = new Usuario();
		String nombre = request.getParameter("nombre");
		
		Facade facade = new Facade();
		usuarioDel= facade.buscarUserByName(nombre);
		
		if(usuarioDel!=null)
		{
			request.setAttribute("usuarioAEliminar", usuarioDel);
			request.getRequestDispatcher("eliminacionUsuario.jsp").forward(request, response);
		}
		else
		{
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Usuario no encontrado');");
			out.println("location='eliminacionUsuario.jsp';");
			out.println("</script>");
		}
	}
}

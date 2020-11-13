package com.desafiolatam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.facade.Facade;
import com.desafiolatam.modelo.Usuario;

@WebServlet("/listarUsuarios")
public class listarUsuarios extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
		
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		String nombre = request.getParameter("nombre");
		
		Facade facade = new Facade();
		lista= facade.listarUsuarios(nombre);
		
		if(lista!=null)
		{
			request.setAttribute("listaUsuarios", lista);
			request.getRequestDispatcher("listarUsuarios.jsp").forward(request, response);
		}
		else
		{
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Usuario no encontrado');");
			out.println("location='listarUsuarios.jsp';");
			out.println("</script>");
		}
	}
}

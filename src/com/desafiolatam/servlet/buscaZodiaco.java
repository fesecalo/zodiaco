package com.desafiolatam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.facade.Facade;
import com.desafiolatam.modelo.Usuario;
import com.desafiolatam.modelo.Zodiaco;

@WebServlet("/busquedaZodiaco")
public class buscaZodiaco extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
		
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		try
		{
			Zodiaco signo = new Zodiaco();
			int animal=0;
			int year =Integer.parseInt(request.getParameter("anioNacimiento"));
			
			switch (year % 12) {
		      case 0: animal=9; break;
		      case 1: animal=10; break;
		      case 2: animal=11; break;
		      case 3: animal=12; break;
		      case 4: animal=1; break;
		      case 5: animal=2; break;
		      case 6: animal=3; break;
		      case 7: animal=4; break;
		      case 8: animal=5; break;
		      case 9: animal=6; break;
		      case 10: animal=7; break;
		      case 11: animal=8; break;
		    }
			
			
			Facade facade = new Facade();
			signo= facade.buscaSignoByID(animal);
			
			
			request.setAttribute("zodiaco", signo);
			request.getRequestDispatcher("horoscopo.jsp").forward(request, response);
		}
		catch(Exception e)
		{
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Año incorrecto');");
			out.println("location='horoscopo.jsp';");
			out.println("</script>");
		}

	}
}

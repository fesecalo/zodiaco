package com.desafiolatam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.facade.Facade;

@WebServlet("/updateUser")
public class updateUser extends HttpServlet {

	private static final long serialVersionUID = 1L;
		
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		try {
			
			int id_user =Integer.parseInt(request.getParameter("id_user"));
			String usuario = request.getParameter("usuario");
			
			String fn = request.getParameter("fechaNac");
			Date fechaNac = new SimpleDateFormat("dd/MM/yyyy").parse(fn);
			
			String correo = request.getParameter("correo");
			String pass = request.getParameter("pass");
			
			//http://cs.armstrong.edu/liang/intro10e/html/ChineseZodiac.html
			//para determinar el animal que le corresponde
			
			int animal=0;
			int year =Integer.parseInt(new SimpleDateFormat("yyyy").format(fechaNac));
			
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
			boolean updateUser= facade.updateUser(usuario, fn, correo, pass, animal, id_user);
			
			if(updateUser)
			{
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Usuario modificado con éxito');");
				out.println("location='modificacionUsuario.jsp';");
				out.println("</script>");
			}
			
		} catch (ParseException e) {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('"+e.getMessage()+"');");
			out.println("location='modificacionUsuario.jsp';");
			out.println("</script>");
		}
				
	}
}

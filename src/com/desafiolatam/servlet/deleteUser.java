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

@WebServlet("/deleteUser")
public class deleteUser extends HttpServlet {

	private static final long serialVersionUID = 1L;
		
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			int id_user =Integer.parseInt(request.getParameter("id_user"));
			Facade facade = new Facade();
			boolean deleteUser= facade.deleteUser(id_user);
			
			if(deleteUser)
			{
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Usuario eliminado con éxito');");
				out.println("location='eliminacionUsuario.jsp';");
				out.println("</script>");
			}
			
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('"+e.getMessage()+"');");
			out.println("location='modificacionUsuario.jsp';");
			out.println("</script>");
		}
				
	}
}

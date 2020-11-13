package com.desafiolatam.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.desafiolatam.procesaConexion.AdministradorConexion;

public class AddUserDAO  extends AdministradorConexion{
	
	public AddUserDAO() {
		 Connection conn = generaConexion();
	}
	
	public boolean addUser(String usuario, String fechaNac, String correo, String pass, int animal)
	{
		boolean insertOk = false;
		String sql = "INSERT INTO USUARIOS (ID_USER, FECHA_NACIMIENTO, PASS, MAIL, SIGNO, USUARIO) VALUES (USUARIO_SEC.NEXTVAL, TO_DATE('"+fechaNac+"', 'DD-MM-YYYY'), '"+pass+"', '"+correo+"', "+animal+", '"+usuario+"')";

		try
		{
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				insertOk = true;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return insertOk;
	}

}

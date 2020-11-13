package com.desafiolatam.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.desafiolatam.procesaConexion.AdministradorConexion;

public class UpdateUserDAO  extends AdministradorConexion{
	
	public UpdateUserDAO() {
		 Connection conn = generaConexion();
	}
	
	public boolean updateUser(String usuario, String fechaNac, String correo, String pass, int animal, int id_user)
	{
		boolean updateOK = false;
		String sql = "UPDATE USUARIOS SET USUARIO='"+usuario+"', FECHA_NACIMIENTO=TO_DATE('"+fechaNac+"', 'DD-MM-YYYY'), PASS='"+pass+"', MAIL='"+correo+"', SIGNO="+animal+" WHERE ID_USER = "+id_user;
		try
		{
			pstm = conn.prepareStatement(sql);
			pstm.executeUpdate();
			
			updateOK = true;
			return updateOK;
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return updateOK;
		}
	}

}

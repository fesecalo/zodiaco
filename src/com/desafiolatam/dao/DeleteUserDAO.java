package com.desafiolatam.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.desafiolatam.procesaConexion.AdministradorConexion;

public class DeleteUserDAO  extends AdministradorConexion{
	
	public DeleteUserDAO() {
		 Connection conn = generaConexion();
	}
	
	public boolean deleteUser(int id_user)
	{
		boolean deleteOK = false;
		String sql = "DELETE FROM USUARIOS WHERE ID_USER="+id_user;
		try
		{
			pstm = conn.prepareStatement(sql);
			pstm.executeUpdate();
			
			deleteOK = true;
			return deleteOK;
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return deleteOK;
		}
	}

}

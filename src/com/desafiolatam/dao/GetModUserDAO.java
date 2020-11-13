package com.desafiolatam.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.desafiolatam.modelo.Usuario;
import com.desafiolatam.procesaConexion.AdministradorConexion;

public class GetModUserDAO extends AdministradorConexion{

	public GetModUserDAO() {
		Connection conn = generaConexion();
	}
	
	public Usuario buscarUserByName(String nombre)
	{
		Usuario userMod=null;
		String query ="SELECT * FROM USUARIOS WHERE USUARIO='"+nombre+"'";
		
		try
		{
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				 
				userMod = new Usuario(rs.getInt("ID_USER"), rs.getString("FECHA_NACIMIENTO"),rs.getString("PASS"),rs.getString("MAIL"), null, rs.getString("USUARIO"));
			}
			return userMod;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return userMod;
		}
	
	}

}

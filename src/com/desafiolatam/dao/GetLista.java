package com.desafiolatam.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.desafiolatam.modelo.Usuario;
import com.desafiolatam.procesaConexion.AdministradorConexion;

public class GetLista extends AdministradorConexion{

	public GetLista() {
		Connection conn = generaConexion();
	}
	
	public ArrayList<Usuario> listarUsuarios(String nombre)
	{
		ArrayList<Usuario> lista=new ArrayList<Usuario>();
		String query ="SELECT * FROM USUARIOS WHERE USUARIO LIKE '%"+nombre+"%'";
		
		try
		{
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				lista.add(new Usuario(rs.getInt("ID_USER"), rs.getString("FECHA_NACIMIENTO"),rs.getString("PASS"),rs.getString("MAIL"), null, rs.getString("USUARIO")));
			}
			return lista;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return lista;
		}
	
	}

}

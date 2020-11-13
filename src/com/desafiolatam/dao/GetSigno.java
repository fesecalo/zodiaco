package com.desafiolatam.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.desafiolatam.modelo.Zodiaco;
import com.desafiolatam.procesaConexion.AdministradorConexion;

public class GetSigno extends AdministradorConexion{

	public GetSigno() {
		Connection conn = generaConexion();
	}
	
	public Zodiaco buscaSignoByID(int animal)
	{
		Zodiaco signo=null;
		String query ="SELECT * FROM ZODIACO WHERE ID_ZODIACO='"+animal+"'";
		
		try
		{
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				 
				signo = new Zodiaco(rs.getInt("ID_ZODIACO"), rs.getString("ANIMAL"));
			}
			return signo;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return signo;
		}
	
	}

}

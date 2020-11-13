package com.desafiolatam.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.desafiolatam.procesaConexion.AdministradorConexion;

public class LoginDaoImp  extends AdministradorConexion implements LoginDao{
	
	public LoginDaoImp() {
		 Connection conn = generaConexion();
	}
	
	@Override
	public boolean usuarioRegistrado(String mail, String pass) {

		boolean usuarioExiste = false;
		 String sql = "SELECT * FROM USUARIOS WHERE MAIL = '" +mail + "'" + "AND PASS = '" + pass + "'";
		
		 try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				usuarioExiste = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarioExiste;
	}

}

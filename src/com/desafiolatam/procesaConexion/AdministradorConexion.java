package com.desafiolatam.procesaConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdministradorConexion {
	
	//se hace static para cumplir con el singleton
		protected static Connection conn = null;
		protected PreparedStatement pstm = null;
		protected ResultSet rs = null;
		
		protected Connection generaConexion()
		{
			String usr = "hr";
			String pwd = "system";
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			//singleton
			if(conn==null)
			{
				try
				{
					Class.forName(driver);
					conn = DriverManager.getConnection(url, usr, pwd);
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
				
				return conn;
			}
			else
			{
				return conn;
			}
		}
	 
	
}

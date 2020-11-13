package com.desafiolatam.modelo;

public class Usuario {
	
	private int id_user;
	private String fecha_nacimiento;
	private String pass;
	private String mail;
	private Zodiaco signo;
	private String usuario;
	
	public Usuario() {}
	
	public Usuario(int id_user, String fecha_nacimiento, String pass, String mail, Zodiaco signo, String usuario) {
		this.id_user = id_user;
		this.fecha_nacimiento = fecha_nacimiento;
		this.pass = pass;
		this.mail = mail;
		this.signo = signo;
		this.usuario = usuario;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Zodiaco getSigno() {
		return signo;
	}

	public void setSigno(Zodiaco signo) {
		this.signo = signo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	
}

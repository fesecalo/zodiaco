package com.desafiolatam.facade;

import com.desafiolatam.dao.LoginDaoImp;
import com.desafiolatam.dao.UpdateUserDAO;
import com.desafiolatam.modelo.Usuario;
import com.desafiolatam.modelo.Zodiaco;

import java.util.ArrayList;

import com.desafiolatam.dao.AddUserDAO;
import com.desafiolatam.dao.DeleteUserDAO;
import com.desafiolatam.dao.GetLista;
import com.desafiolatam.dao.GetModUserDAO;
import com.desafiolatam.dao.GetSigno;

public class Facade {
	
	public boolean usuarioRegistrado(String usuario, String pass)
	{
		LoginDaoImp dao = new LoginDaoImp();
		return dao.usuarioRegistrado(usuario, pass);
	}
	
	public boolean addUser(String usuario, String fechaNac, String correo, String pass, int animal)
	{
		AddUserDAO dao = new AddUserDAO();
		return dao.addUser(usuario, fechaNac, correo, pass, animal);
	}
	
	public Usuario buscarUserByName(String nombre)
	{
		GetModUserDAO dao = new GetModUserDAO();
		return dao.buscarUserByName(nombre);
	}
	
	public boolean updateUser(String usuario, String fechaNac, String correo, String pass, int animal, int id_user)
	{
		UpdateUserDAO dao = new UpdateUserDAO();
		return dao.updateUser(usuario, fechaNac, correo, pass, animal, id_user);
	}
	
	public boolean deleteUser(int id_user)
	{
		DeleteUserDAO dao = new DeleteUserDAO();
		return dao.deleteUser(id_user);
	}
	
	public ArrayList<Usuario> listarUsuarios(String nombre)
	{
		GetLista dao = new GetLista();
		return dao.listarUsuarios(nombre);
	}
	
	public Zodiaco buscaSignoByID(int animal)
	{
		GetSigno dao = new GetSigno();
		return dao.buscaSignoByID(animal);
	}
}


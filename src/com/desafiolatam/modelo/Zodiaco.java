package com.desafiolatam.modelo;

public class Zodiaco {
	
	private int id_zodiaco;
	private String animal;
	
	public Zodiaco() {}
	
	public Zodiaco(int id_zodiaco, String animal) {
		super();
		this.id_zodiaco = id_zodiaco;
		this.animal = animal;
	}

	public int getId_zodiaco() {
		return id_zodiaco;
	}

	public void setId_zodiaco(int id_zodiaco) {
		this.id_zodiaco = id_zodiaco;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}
	
	
	
	
}

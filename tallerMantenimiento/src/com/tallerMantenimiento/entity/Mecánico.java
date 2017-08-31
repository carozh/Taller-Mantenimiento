package com.tallerMantenimiento.entity;

public class Mecánico {
	private int códigoMecánico;
	private String nombre;
	private String apellidos;
	private int telfDomicilio;
	private int celular;
	public Mecánico(int códigoMecánico, String nombre, String apellidos, int telfDomicilio, int celular) {
	
		this.códigoMecánico = códigoMecánico;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telfDomicilio = telfDomicilio;
		this.celular = celular;
	}
	
	public Mecánico (int códigoMecánico){
		this.códigoMecánico = códigoMecánico;
	}

	public int getCódigoMecánico() {
		return códigoMecánico;
	}

	public void setCódigoMecánico(int códigoMecánico) {
		this.códigoMecánico = códigoMecánico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getTelfDomicilio() {
		return telfDomicilio;
	}

	public void setTelfDomicilio(int telfDomicilio) {
		this.telfDomicilio = telfDomicilio;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	@Override
	public String toString() {
		return "Mecánico [códigoMecánico=" + códigoMecánico + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", telfDomicilio=" + telfDomicilio + ", celular=" + celular + "]";
	}
	
	
	

}

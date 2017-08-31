package com.tallerMantenimiento.entity;

public class Mec�nico {
	private int c�digoMec�nico;
	private String nombre;
	private String apellidos;
	private int telfDomicilio;
	private int celular;
	public Mec�nico(int c�digoMec�nico, String nombre, String apellidos, int telfDomicilio, int celular) {
	
		this.c�digoMec�nico = c�digoMec�nico;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telfDomicilio = telfDomicilio;
		this.celular = celular;
	}
	
	public Mec�nico (int c�digoMec�nico){
		this.c�digoMec�nico = c�digoMec�nico;
	}

	public int getC�digoMec�nico() {
		return c�digoMec�nico;
	}

	public void setC�digoMec�nico(int c�digoMec�nico) {
		this.c�digoMec�nico = c�digoMec�nico;
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
		return "Mec�nico [c�digoMec�nico=" + c�digoMec�nico + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", telfDomicilio=" + telfDomicilio + ", celular=" + celular + "]";
	}
	
	
	

}

package com.tallerMantenimiento.entity;

public class Cliente {
	private String NIT;
	private String nombre;
	private String apellido;
	private int telfDomicilio;
	private int telfOficina;
	private int m�vil;
	
	public Cliente(String NIT, String nombre, String apellido, int telfDomicilio, int telfOficina, int m�vil){
		this.NIT = NIT;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telfDomicilio = telfDomicilio;
		this.telfOficina = telfOficina;
		this.m�vil = m�vil;
	}
	
	//POR LA CLAVE PRINCIPAL DE LA CLASE
	public Cliente(String NIT){
		this.NIT = NIT;
	}

	public String getNIT() {
		return NIT;
	}

	public void setNIT(String nIT) {
		NIT = nIT;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getTelfDomicilio() {
		return telfDomicilio;
	}

	public void setTelfDomicilio(int telfDomicilio) {
		this.telfDomicilio = telfDomicilio;
	}

	public int getTelfOficina() {
		return telfOficina;
	}

	public void setTelfOficina(int telfOficina) {
		this.telfOficina = telfOficina;
	}

	public int getM�vil() {
		return m�vil;
	}

	public void setM�vil(int m�vil) {
		this.m�vil = m�vil;
	}

	@Override
	public String toString() {
		return "Cliente [NIT=" + NIT + ", nombre=" + nombre + ", apellido=" + apellido + ", telfDomicilio="
				+ telfDomicilio + ", telfOficina=" + telfOficina + ", m�vil=" + m�vil + "]";
	}
	
	
}

package com.tallerMantenimiento.entity;

public class Servicios {
	private int c�digoServicios;
	private String nombre;
	private String descripci�n;
	private int precio;
	private String tipo;
	public Servicios(int c�digoServicios, String nombre, String descripci�n, int precio, String tipo) {
	
		this.c�digoServicios = c�digoServicios;
		this.nombre = nombre;
		this.descripci�n = descripci�n;
		this.precio = precio;
		this.tipo = tipo;
	}
	
	public Servicios(int c�digoServicios){
		this.c�digoServicios = c�digoServicios;
	}

	public int getC�digoServicios() {
		return c�digoServicios;
	}

	public void setC�digoServicios(int c�digoServicios) {
		this.c�digoServicios = c�digoServicios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripci�n() {
		return descripci�n;
	}

	public void setDescripci�n(String descripci�n) {
		this.descripci�n = descripci�n;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Servicios [c�digoServicios=" + c�digoServicios + ", nombre=" + nombre + ", descripci�n=" + descripci�n
				+ ", precio=" + precio + ", tipo=" + tipo + "]";
	}
	
	

}

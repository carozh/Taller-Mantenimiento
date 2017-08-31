package com.tallerMantenimiento.entity;

public class Servicios {
	private int códigoServicios;
	private String nombre;
	private String descripción;
	private int precio;
	private String tipo;
	public Servicios(int códigoServicios, String nombre, String descripción, int precio, String tipo) {
	
		this.códigoServicios = códigoServicios;
		this.nombre = nombre;
		this.descripción = descripción;
		this.precio = precio;
		this.tipo = tipo;
	}
	
	public Servicios(int códigoServicios){
		this.códigoServicios = códigoServicios;
	}

	public int getCódigoServicios() {
		return códigoServicios;
	}

	public void setCódigoServicios(int códigoServicios) {
		this.códigoServicios = códigoServicios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripción() {
		return descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
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
		return "Servicios [códigoServicios=" + códigoServicios + ", nombre=" + nombre + ", descripción=" + descripción
				+ ", precio=" + precio + ", tipo=" + tipo + "]";
	}
	
	

}

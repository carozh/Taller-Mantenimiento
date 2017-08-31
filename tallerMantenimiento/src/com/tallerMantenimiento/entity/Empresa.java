package com.tallerMantenimiento.entity;

public class Empresa {
	private int códigoEmpresa;
	private String nombre;
	private int teléfono;
	private String dirección;
	public Empresa(int códigoEmpresa, String nombre, int teléfono, String dirección) {
		
		this.códigoEmpresa = códigoEmpresa;
		this.nombre = nombre;
		this.teléfono = teléfono;
		this.dirección = dirección;
	}
	
	public Empresa(int códigoEmpresa){
		this.códigoEmpresa = códigoEmpresa;
	}

	public int getCódigoEmpresa() {
		return códigoEmpresa;
	}

	public void setCódigoEmpresa(int códigoEmpresa) {
		this.códigoEmpresa = códigoEmpresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTeléfono() {
		return teléfono;
	}

	public void setTeléfono(int teléfono) {
		this.teléfono = teléfono;
	}

	public String getDirección() {
		return dirección;
	}

	public void setDirección(String dirección) {
		this.dirección = dirección;
	}

	@Override
	public String toString() {
		return "Empresa [códigoEmpresa=" + códigoEmpresa + ", nombre=" + nombre + ", teléfono=" + teléfono
				+ ", dirección=" + dirección + "]";
	}
	
	

}

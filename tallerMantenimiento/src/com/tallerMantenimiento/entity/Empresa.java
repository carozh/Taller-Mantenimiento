package com.tallerMantenimiento.entity;

public class Empresa {
	private int c�digoEmpresa;
	private String nombre;
	private int tel�fono;
	private String direcci�n;
	public Empresa(int c�digoEmpresa, String nombre, int tel�fono, String direcci�n) {
		
		this.c�digoEmpresa = c�digoEmpresa;
		this.nombre = nombre;
		this.tel�fono = tel�fono;
		this.direcci�n = direcci�n;
	}
	
	public Empresa(int c�digoEmpresa){
		this.c�digoEmpresa = c�digoEmpresa;
	}

	public int getC�digoEmpresa() {
		return c�digoEmpresa;
	}

	public void setC�digoEmpresa(int c�digoEmpresa) {
		this.c�digoEmpresa = c�digoEmpresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTel�fono() {
		return tel�fono;
	}

	public void setTel�fono(int tel�fono) {
		this.tel�fono = tel�fono;
	}

	public String getDirecci�n() {
		return direcci�n;
	}

	public void setDirecci�n(String direcci�n) {
		this.direcci�n = direcci�n;
	}

	@Override
	public String toString() {
		return "Empresa [c�digoEmpresa=" + c�digoEmpresa + ", nombre=" + nombre + ", tel�fono=" + tel�fono
				+ ", direcci�n=" + direcci�n + "]";
	}
	
	

}

package com.tallerMantenimiento.entity;

public class Veh�culo {
	private String chasis;
	private String marca;
	private String clase;
	private String tipo;
	private String color;
	private int a�o;
	private String placa;
	private int kilometraje;
	private String NIT;
	
	public Veh�culo(String chasis, String marca, String clase, String tipo, String color, int a�o, String placa,
			int kilometraje, String NIT) {
		
		this.chasis = chasis;
		this.marca = marca;
		this.clase = clase;
		this.tipo = tipo;
		this.color = color;
		this.a�o = a�o;
		this.placa = placa;
		this.kilometraje = kilometraje;
		this.NIT = NIT;
	}
	
	public Veh�culo(String chasis){
		this.chasis = chasis;
	}

	public String getChasis() {
		return chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getA�o() {
		return a�o;
	}

	public void setA�o(int a�o) {
		this.a�o = a�o;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(int kilometraje) {
		this.kilometraje = kilometraje;
	}

	public String getNIT() {
		return NIT;
	}

	public void setNIT(String nIT) {
		NIT = nIT;
	}

	@Override
	public String toString() {
		return "Veh�culo [chasis=" + chasis + ", marca=" + marca + ", clase=" + clase + ", tipo=" + tipo + ", color="
				+ color + ", a�o=" + a�o + ", placa=" + placa + ", kilometraje=" + kilometraje + ", NIT=" + NIT + "]";
	}
	
	
	
	

}

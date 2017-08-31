package com.tallerMantenimiento.entity;

import java.util.Date;

public class Mantenimiento {
	private int c�digoMantenimiento;
	private String chasis;
	private int c�digoMec�nico;
	private Date fecha;
	public Mantenimiento(int c�digoMantenimiento, String chasis, int c�digoMec�nico, Date fecha) {
		
		this.c�digoMantenimiento = c�digoMantenimiento;
		this.chasis = chasis;
		this.c�digoMec�nico = c�digoMec�nico;
		this.fecha = fecha;
	}
	
	public Mantenimiento(int c�digoMantenimiento){
		this.c�digoMantenimiento = c�digoMantenimiento;
	}

	public int getC�digoMantenimiento() {
		return c�digoMantenimiento;
	}

	public void setC�digoMantenimiento(int c�digoMantenimiento) {
		this.c�digoMantenimiento = c�digoMantenimiento;
	}

	public String getChasis() {
		return chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	public int getC�digoMec�nico() {
		return c�digoMec�nico;
	}

	public void setC�digoMec�nico(int c�digoMec�nico) {
		this.c�digoMec�nico = c�digoMec�nico;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Mantenimiento [c�digoMantenimiento=" + c�digoMantenimiento + ", chasis=" + chasis + ", c�digoMec�nico="
				+ c�digoMec�nico + ", fecha=" + fecha + "]";
	}
	
	
	
	
	

}

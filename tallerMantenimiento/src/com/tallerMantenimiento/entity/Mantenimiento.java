package com.tallerMantenimiento.entity;

import java.util.Date;

public class Mantenimiento {
	private int códigoMantenimiento;
	private String chasis;
	private int códigoMecánico;
	private Date fecha;
	public Mantenimiento(int códigoMantenimiento, String chasis, int códigoMecánico, Date fecha) {
		
		this.códigoMantenimiento = códigoMantenimiento;
		this.chasis = chasis;
		this.códigoMecánico = códigoMecánico;
		this.fecha = fecha;
	}
	
	public Mantenimiento(int códigoMantenimiento){
		this.códigoMantenimiento = códigoMantenimiento;
	}

	public int getCódigoMantenimiento() {
		return códigoMantenimiento;
	}

	public void setCódigoMantenimiento(int códigoMantenimiento) {
		this.códigoMantenimiento = códigoMantenimiento;
	}

	public String getChasis() {
		return chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	public int getCódigoMecánico() {
		return códigoMecánico;
	}

	public void setCódigoMecánico(int códigoMecánico) {
		this.códigoMecánico = códigoMecánico;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Mantenimiento [códigoMantenimiento=" + códigoMantenimiento + ", chasis=" + chasis + ", códigoMecánico="
				+ códigoMecánico + ", fecha=" + fecha + "]";
	}
	
	
	
	
	

}

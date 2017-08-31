package com.tallerMantenimiento.entity;

import java.util.Date;

public class DetalleMantenimiento {
	private int códigoDetalleMantenimiento;
	private int códigoServicios;
	private int códigoEmpresa;
	private int códigoMantenimiento;
	private int cantidad;
	private Date fecha;
	
	public DetalleMantenimiento(int códigoDetalleMantenimiento, int códigoServicios, int códigoEmpresa,
			int códigoMantenimiento, int cantidad, Date fecha) {
	
		this.códigoDetalleMantenimiento = códigoDetalleMantenimiento;
		this.códigoServicios = códigoServicios;
		this.códigoEmpresa = códigoEmpresa;
		this.códigoMantenimiento = códigoMantenimiento;
		this.cantidad = cantidad;
		this.fecha = fecha;
	}
	
	public DetalleMantenimiento(int códigoDetalleMantenimiento){
		this.códigoDetalleMantenimiento = códigoDetalleMantenimiento;
	}

	public int getCódigoDetalleMantenimiento() {
		return códigoDetalleMantenimiento;
	}

	public void setCódigoDetalleMantenimiento(int códigoDetalleMantenimiento) {
		this.códigoDetalleMantenimiento = códigoDetalleMantenimiento;
	}

	public int getCódigoServicios() {
		return códigoServicios;
	}

	public void setCódigoServicios(int códigoServicios) {
		this.códigoServicios = códigoServicios;
	}

	public int getCódigoEmpresa() {
		return códigoEmpresa;
	}

	public void setCódigoEmpresa(int códigoEmpresa) {
		this.códigoEmpresa = códigoEmpresa;
	}

	public int getCódigoMantenimiento() {
		return códigoMantenimiento;
	}

	public void setCódigoMantenimiento(int códigoMantenimiento) {
		this.códigoMantenimiento = códigoMantenimiento;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "DetalleMantenimiento [códigoDetalleMantenimiento=" + códigoDetalleMantenimiento + ", códigoServicios="
				+ códigoServicios + ", códigoEmpresa=" + códigoEmpresa + ", códigoMantenimiento=" + códigoMantenimiento
				+ ", cantidad=" + cantidad + ", fecha=" + fecha + "]";
	}
	
	
	
}

package com.tallerMantenimiento.entity;

import java.util.Date;

public class DetalleMantenimiento {
	private int c�digoDetalleMantenimiento;
	private int c�digoServicios;
	private int c�digoEmpresa;
	private int c�digoMantenimiento;
	private int cantidad;
	private Date fecha;
	
	public DetalleMantenimiento(int c�digoDetalleMantenimiento, int c�digoServicios, int c�digoEmpresa,
			int c�digoMantenimiento, int cantidad, Date fecha) {
	
		this.c�digoDetalleMantenimiento = c�digoDetalleMantenimiento;
		this.c�digoServicios = c�digoServicios;
		this.c�digoEmpresa = c�digoEmpresa;
		this.c�digoMantenimiento = c�digoMantenimiento;
		this.cantidad = cantidad;
		this.fecha = fecha;
	}
	
	public DetalleMantenimiento(int c�digoDetalleMantenimiento){
		this.c�digoDetalleMantenimiento = c�digoDetalleMantenimiento;
	}

	public int getC�digoDetalleMantenimiento() {
		return c�digoDetalleMantenimiento;
	}

	public void setC�digoDetalleMantenimiento(int c�digoDetalleMantenimiento) {
		this.c�digoDetalleMantenimiento = c�digoDetalleMantenimiento;
	}

	public int getC�digoServicios() {
		return c�digoServicios;
	}

	public void setC�digoServicios(int c�digoServicios) {
		this.c�digoServicios = c�digoServicios;
	}

	public int getC�digoEmpresa() {
		return c�digoEmpresa;
	}

	public void setC�digoEmpresa(int c�digoEmpresa) {
		this.c�digoEmpresa = c�digoEmpresa;
	}

	public int getC�digoMantenimiento() {
		return c�digoMantenimiento;
	}

	public void setC�digoMantenimiento(int c�digoMantenimiento) {
		this.c�digoMantenimiento = c�digoMantenimiento;
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
		return "DetalleMantenimiento [c�digoDetalleMantenimiento=" + c�digoDetalleMantenimiento + ", c�digoServicios="
				+ c�digoServicios + ", c�digoEmpresa=" + c�digoEmpresa + ", c�digoMantenimiento=" + c�digoMantenimiento
				+ ", cantidad=" + cantidad + ", fecha=" + fecha + "]";
	}
	
	
	
}

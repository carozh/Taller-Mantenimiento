package com.tallerMantenimiento.control;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import com.tallerMantenimiento.entity.DetalleMantenimiento;


public class DetalleMantenimientoCtrl implements Control<DetalleMantenimiento> {
	private Conexion conexion;
	
	public DetalleMantenimientoCtrl(Conexion conexion){
		
		this.conexion = conexion;
	
	}
	
	/******************************************************************************
	 * List
	 ******************************************************************************/
	
	public ArrayList<DetalleMantenimiento> list() throws Throwable {
		
		ArrayList<DetalleMantenimiento> detallesMantenimientos = new ArrayList<DetalleMantenimiento>();
		ResultSet rs;
		int c�digoDetalleMantenimiento;
		int c�digoServicios;
		int c�digoEmpresa;
		int c�digoMantenimiento;
		int cantidad;
		Date fecha;
		
		conexion.SQL("Select * from DetalleMantenimiento");

		rs = conexion.resultSet();

		while (rs.next()) {
			
			c�digoDetalleMantenimiento = rs.getInt("c�digoDetalleMantenimiento");
			c�digoServicios = rs.getInt("c�digoServicios");
			c�digoEmpresa= rs.getInt("c�digoEmpresa");
			c�digoMantenimiento = rs.getInt("c�digoMantenimiento");
			cantidad = rs.getInt("cantidad");
			fecha = rs.getDate("fecha");
			
			
			
			detallesMantenimientos.add(new DetalleMantenimiento(c�digoDetalleMantenimiento, c�digoServicios, c�digoEmpresa,c�digoMantenimiento, cantidad, fecha));
						
		}

		return detallesMantenimientos;
	}
	

	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	
	public void insert(DetalleMantenimiento detalleMantenimiento) throws Throwable{
		
		conexion.SQL("Insert into detallemantenimiento(c�digoDetalleMantenimiento, c�digoServicios, c�digoEmpresa, c�digoMantenimiento, cantidad, fecha) VALUES(?,?,?,?,?,?)");
		// ? SON PARAMETROS
		conexion.preparedStatement().setInt(1, detalleMantenimiento.getC�digoDetalleMantenimiento());
		//Vamos a mandar una cadena de caracteres
		conexion.preparedStatement().setInt(2, detalleMantenimiento.getC�digoServicios());
		conexion.preparedStatement().setInt(3, detalleMantenimiento.getC�digoEmpresa());
		conexion.preparedStatement().setInt(4, detalleMantenimiento.getCantidad());
		conexion.preparedStatement().setDate( 5, new java.sql.Date (detalleMantenimiento.getFecha().getTime()));
		conexion.CUD();
	}
	
	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search(DetalleMantenimiento detallesMantenimientos) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from DetalleMantenimiento where c�digoDetalleMantenimiento = ?");
		conexion.preparedStatement().setInt(1,detallesMantenimientos.getC�digoMantenimiento());
		rs = conexion.resultSet();

		while (rs.next()) {
			
			detallesMantenimientos.setC�digoServicios(rs.getInt("c�digoServicios"));
			detallesMantenimientos.setC�digoEmpresa(rs.getInt("c�digoEmpresa"));
			detallesMantenimientos.setCantidad(rs.getInt("cantidad"));
			detallesMantenimientos.setFecha(rs.getDate("fecha"));
			
		}

		rs.close();

	}
	
	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update(DetalleMantenimiento detalleMantenimiento) throws Throwable {
		
		int c�digoDetalleMantenimiento;
		int c�digoServicios;
		int c�digoEmpresa;
		int c�digoMantenimiento;
		int cantidad;
		Date fecha;
		
		if (detalleMantenimiento != null) {
			
			c�digoDetalleMantenimiento = detalleMantenimiento.getC�digoDetalleMantenimiento();
			c�digoServicios = detalleMantenimiento.getC�digoServicios();
			c�digoEmpresa = detalleMantenimiento.getC�digoEmpresa();
			c�digoMantenimiento = detalleMantenimiento.getC�digoMantenimiento();
			cantidad = detalleMantenimiento.getCantidad();
			fecha = detalleMantenimiento.getFecha();
			

			conexion.SQL("Update mantenimiento set c�digoServicios = ?, c�digoEmpresa = ?, c�digoMantenimiento = ?, cantidad = ?, fecha = ? where c�digoDetalleMantenimiento = ?");
			conexion.preparedStatement().setInt(1, c�digoServicios);
			conexion.preparedStatement().setInt(2, c�digoEmpresa);
			conexion.preparedStatement().setInt(3, c�digoMantenimiento);
			conexion.preparedStatement().setInt(4, cantidad);
			conexion.preparedStatement().setDate( 5, new java.sql.Date (detalleMantenimiento.getFecha().getTime()));
			conexion.preparedStatement().setInt(6, c�digoDetalleMantenimiento);
			conexion.CUD();
		}
	}

	

}

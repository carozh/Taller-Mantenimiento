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
		int códigoDetalleMantenimiento;
		int códigoServicios;
		int códigoEmpresa;
		int códigoMantenimiento;
		int cantidad;
		Date fecha;
		
		conexion.SQL("Select * from DetalleMantenimiento");

		rs = conexion.resultSet();

		while (rs.next()) {
			
			códigoDetalleMantenimiento = rs.getInt("códigoDetalleMantenimiento");
			códigoServicios = rs.getInt("códigoServicios");
			códigoEmpresa= rs.getInt("códigoEmpresa");
			códigoMantenimiento = rs.getInt("códigoMantenimiento");
			cantidad = rs.getInt("cantidad");
			fecha = rs.getDate("fecha");
			
			
			
			detallesMantenimientos.add(new DetalleMantenimiento(códigoDetalleMantenimiento, códigoServicios, códigoEmpresa,códigoMantenimiento, cantidad, fecha));
						
		}

		return detallesMantenimientos;
	}
	

	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	
	public void insert(DetalleMantenimiento detalleMantenimiento) throws Throwable{
		
		conexion.SQL("Insert into detallemantenimiento(códigoDetalleMantenimiento, códigoServicios, códigoEmpresa, códigoMantenimiento, cantidad, fecha) VALUES(?,?,?,?,?,?)");
		// ? SON PARAMETROS
		conexion.preparedStatement().setInt(1, detalleMantenimiento.getCódigoDetalleMantenimiento());
		//Vamos a mandar una cadena de caracteres
		conexion.preparedStatement().setInt(2, detalleMantenimiento.getCódigoServicios());
		conexion.preparedStatement().setInt(3, detalleMantenimiento.getCódigoEmpresa());
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

		conexion.SQL("Select * from DetalleMantenimiento where códigoDetalleMantenimiento = ?");
		conexion.preparedStatement().setInt(1,detallesMantenimientos.getCódigoMantenimiento());
		rs = conexion.resultSet();

		while (rs.next()) {
			
			detallesMantenimientos.setCódigoServicios(rs.getInt("códigoServicios"));
			detallesMantenimientos.setCódigoEmpresa(rs.getInt("códigoEmpresa"));
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
		
		int códigoDetalleMantenimiento;
		int códigoServicios;
		int códigoEmpresa;
		int códigoMantenimiento;
		int cantidad;
		Date fecha;
		
		if (detalleMantenimiento != null) {
			
			códigoDetalleMantenimiento = detalleMantenimiento.getCódigoDetalleMantenimiento();
			códigoServicios = detalleMantenimiento.getCódigoServicios();
			códigoEmpresa = detalleMantenimiento.getCódigoEmpresa();
			códigoMantenimiento = detalleMantenimiento.getCódigoMantenimiento();
			cantidad = detalleMantenimiento.getCantidad();
			fecha = detalleMantenimiento.getFecha();
			

			conexion.SQL("Update mantenimiento set códigoServicios = ?, códigoEmpresa = ?, códigoMantenimiento = ?, cantidad = ?, fecha = ? where códigoDetalleMantenimiento = ?");
			conexion.preparedStatement().setInt(1, códigoServicios);
			conexion.preparedStatement().setInt(2, códigoEmpresa);
			conexion.preparedStatement().setInt(3, códigoMantenimiento);
			conexion.preparedStatement().setInt(4, cantidad);
			conexion.preparedStatement().setDate( 5, new java.sql.Date (detalleMantenimiento.getFecha().getTime()));
			conexion.preparedStatement().setInt(6, códigoDetalleMantenimiento);
			conexion.CUD();
		}
	}

	

}

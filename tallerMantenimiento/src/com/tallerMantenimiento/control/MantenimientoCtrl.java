package com.tallerMantenimiento.control;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import com.tallerMantenimiento.entity.Mantenimiento;

public class MantenimientoCtrl implements Control  <Mantenimiento>{
	
	private Conexion conexion;
	
	public MantenimientoCtrl(Conexion conexion){
		this.conexion = conexion;
	}
	
	/******************************************************************************
	 * List
	 ******************************************************************************/
	
	public ArrayList<Mantenimiento> list() throws Throwable {
		
		ArrayList<Mantenimiento> mantenimientos = new ArrayList<Mantenimiento>();
		ResultSet rs;
		int c�digoMantenimiento;
		String chasis;
		int c�digoMec�nico;
		Date fecha;
		
		conexion.SQL("Select * from mantenimiento");

		rs = conexion.resultSet();

		while (rs.next()) {
			
			c�digoMantenimiento = rs.getInt("c�digoMantenimiento");
			chasis = rs.getString("chasis");
			c�digoMec�nico = rs.getInt("c�digoMec�nico");
			fecha = rs.getDate("fecha");
			
			mantenimientos.add(new Mantenimiento(c�digoMantenimiento, chasis, c�digoMec�nico, fecha));
						
		}

		return mantenimientos;
	}
	
	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	
	public void insert(Mantenimiento mantenimiento) throws Throwable{
		
		conexion.SQL("Insert into mantenimiento(c�digoMantenimiento, chasis, c�digoMec�nico, fecha) VALUES(?,?,?,?)");
		// ? SON PARAMETROS
		conexion.preparedStatement().setInt(1, mantenimiento.getC�digoMantenimiento());
		//Vamos a mandar una cadena de caracteres
		conexion.preparedStatement().setString(2, mantenimiento.getChasis());
		conexion.preparedStatement().setInt(3, mantenimiento.getC�digoMec�nico());
		conexion.preparedStatement().setDate( 4, new java.sql.Date (mantenimiento.getFecha().getTime()));
		conexion.CUD();
	}
	
	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search(Mantenimiento mantenimientos) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from mantenimiento where c�digoMantenimiento = ?");
		conexion.preparedStatement().setInt(1, mantenimientos.getC�digoMantenimiento());
		rs = conexion.resultSet();

		while (rs.next()) {
			
			mantenimientos.setChasis(rs.getString("chasis"));
			mantenimientos.setC�digoMec�nico(rs.getInt("c�digoMec�nico"));
			mantenimientos.setFecha(rs.getDate("fecha"));
			
		}

		rs.close();

	}
	
	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update(Mantenimiento mantenimiento) throws Throwable {
		
		int c�digoMantenimiento;
		String chasis;
		int c�digoMec�nico;
		Date fecha;
		
		if (mantenimiento != null) {
			
			c�digoMantenimiento = mantenimiento.getC�digoMantenimiento();
			chasis = mantenimiento.getChasis();
			c�digoMec�nico = mantenimiento.getC�digoMec�nico();
			fecha = mantenimiento.getFecha();
			

			conexion.SQL("Update mantenimiento set chasis = ?, c�digoMec�nico = ?, fecha = ? where c�digoMantenimiento = ?");
			conexion.preparedStatement().setString(1, chasis);
			conexion.preparedStatement().setInt(2, c�digoMec�nico);
			conexion.preparedStatement().setDate( 3, new java.sql.Date (mantenimiento.getFecha().getTime()));
			conexion.preparedStatement().setInt(4, c�digoMantenimiento);
			conexion.CUD();
		}
	}

}

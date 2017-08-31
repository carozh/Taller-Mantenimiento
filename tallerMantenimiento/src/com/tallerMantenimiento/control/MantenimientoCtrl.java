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
		int códigoMantenimiento;
		String chasis;
		int códigoMecánico;
		Date fecha;
		
		conexion.SQL("Select * from mantenimiento");

		rs = conexion.resultSet();

		while (rs.next()) {
			
			códigoMantenimiento = rs.getInt("códigoMantenimiento");
			chasis = rs.getString("chasis");
			códigoMecánico = rs.getInt("códigoMecánico");
			fecha = rs.getDate("fecha");
			
			mantenimientos.add(new Mantenimiento(códigoMantenimiento, chasis, códigoMecánico, fecha));
						
		}

		return mantenimientos;
	}
	
	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	
	public void insert(Mantenimiento mantenimiento) throws Throwable{
		
		conexion.SQL("Insert into mantenimiento(códigoMantenimiento, chasis, códigoMecánico, fecha) VALUES(?,?,?,?)");
		// ? SON PARAMETROS
		conexion.preparedStatement().setInt(1, mantenimiento.getCódigoMantenimiento());
		//Vamos a mandar una cadena de caracteres
		conexion.preparedStatement().setString(2, mantenimiento.getChasis());
		conexion.preparedStatement().setInt(3, mantenimiento.getCódigoMecánico());
		conexion.preparedStatement().setDate( 4, new java.sql.Date (mantenimiento.getFecha().getTime()));
		conexion.CUD();
	}
	
	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search(Mantenimiento mantenimientos) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from mantenimiento where códigoMantenimiento = ?");
		conexion.preparedStatement().setInt(1, mantenimientos.getCódigoMantenimiento());
		rs = conexion.resultSet();

		while (rs.next()) {
			
			mantenimientos.setChasis(rs.getString("chasis"));
			mantenimientos.setCódigoMecánico(rs.getInt("códigoMecánico"));
			mantenimientos.setFecha(rs.getDate("fecha"));
			
		}

		rs.close();

	}
	
	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update(Mantenimiento mantenimiento) throws Throwable {
		
		int códigoMantenimiento;
		String chasis;
		int códigoMecánico;
		Date fecha;
		
		if (mantenimiento != null) {
			
			códigoMantenimiento = mantenimiento.getCódigoMantenimiento();
			chasis = mantenimiento.getChasis();
			códigoMecánico = mantenimiento.getCódigoMecánico();
			fecha = mantenimiento.getFecha();
			

			conexion.SQL("Update mantenimiento set chasis = ?, códigoMecánico = ?, fecha = ? where códigoMantenimiento = ?");
			conexion.preparedStatement().setString(1, chasis);
			conexion.preparedStatement().setInt(2, códigoMecánico);
			conexion.preparedStatement().setDate( 3, new java.sql.Date (mantenimiento.getFecha().getTime()));
			conexion.preparedStatement().setInt(4, códigoMantenimiento);
			conexion.CUD();
		}
	}

}

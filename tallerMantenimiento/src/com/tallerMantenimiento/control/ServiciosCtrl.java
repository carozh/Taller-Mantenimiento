package com.tallerMantenimiento.control;

import java.sql.ResultSet;
import java.util.ArrayList;
import com.tallerMantenimiento.entity.Servicios;


public class ServiciosCtrl implements Control<Servicios> {
	
	private Conexion conexion;
	
	public ServiciosCtrl (Conexion conexion) {
		this.conexion = conexion;
	}
	
	/*
	 * *****************************************************************************
	 * List
	 ******************************************************************************/
	
	public ArrayList<Servicios> list() throws Throwable {
		//se encarga de listar todos los servicios
		ArrayList<Servicios> servicios = new ArrayList<Servicios>();
		ResultSet rs;
		int códigoServicios;
		String nombre;
		String descripción;
		int precio;
		String tipo;
		
		conexion.SQL("Select * from servicios");

		rs = conexion.resultSet();

		while (rs.next()) {
			códigoServicios = rs.getInt("códigoServicios");
			nombre = rs.getString("nombre");
			descripción = rs.getString("descripción");
			precio = rs.getInt("precio");
			tipo = rs.getString("tipo");
			servicios.add(new Servicios(códigoServicios, nombre, descripción, precio, tipo));
			
		}

		return servicios;

	}
	
	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	public void insert(Servicios servicios) throws Throwable {

		conexion.SQL("Insert into servicios(códigoServicios, nombre, descripción, precio, tipo) VALUES(?,?,?,?,?)");
		// ? SON PARAMETROS
		conexion.preparedStatement().setInt(1, servicios.getCódigoServicios());
		//Vamos a mandar una cadena de caracteres
		conexion.preparedStatement().setString(2, servicios.getNombre());
		conexion.preparedStatement().setString(3, servicios.getDescripción());
		conexion.preparedStatement().setInt(4, servicios.getPrecio());
		conexion.preparedStatement().setString(5,servicios.getTipo());
		conexion.CUD();
	}
	
	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search(Servicios servicios) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from servicios where códigoServicios=?");
		conexion.preparedStatement().setInt(1, servicios.getCódigoServicios());
		rs = conexion.resultSet();

		while (rs.next()) {
			
			servicios.setNombre(rs.getString("nombre"));
			servicios.setDescripción(rs.getString("descripción"));
			servicios.setPrecio(rs.getInt("precio"));
			servicios.setTipo(rs.getString("tipo"));
		}

		rs.close();

	}
	
	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update(Servicios servicios) throws Throwable {
		int códigoServicios;
		String nombre;
		String descripción;
		int precio;
		String tipo;
		
		
		if (servicios != null) {
			
			códigoServicios = servicios.getCódigoServicios();
			nombre = servicios.getNombre();
			descripción = servicios.getDescripción();
			precio = servicios.getPrecio();
			tipo = servicios.getTipo();
					

			conexion.SQL("Update servicios set nombre = ?, descripción = ?, precio = ?, tipo = ? where códigoServicios=?");
			conexion.preparedStatement().setString(1, nombre);
			conexion.preparedStatement().setString(2, descripción);
			conexion.preparedStatement().setInt(3, precio);
			conexion.preparedStatement().setString(4, tipo);
			conexion.preparedStatement().setInt(5, códigoServicios);
			conexion.CUD();
		}
	}

	


}

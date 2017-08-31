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
		int c�digoServicios;
		String nombre;
		String descripci�n;
		int precio;
		String tipo;
		
		conexion.SQL("Select * from servicios");

		rs = conexion.resultSet();

		while (rs.next()) {
			c�digoServicios = rs.getInt("c�digoServicios");
			nombre = rs.getString("nombre");
			descripci�n = rs.getString("descripci�n");
			precio = rs.getInt("precio");
			tipo = rs.getString("tipo");
			servicios.add(new Servicios(c�digoServicios, nombre, descripci�n, precio, tipo));
			
		}

		return servicios;

	}
	
	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	public void insert(Servicios servicios) throws Throwable {

		conexion.SQL("Insert into servicios(c�digoServicios, nombre, descripci�n, precio, tipo) VALUES(?,?,?,?,?)");
		// ? SON PARAMETROS
		conexion.preparedStatement().setInt(1, servicios.getC�digoServicios());
		//Vamos a mandar una cadena de caracteres
		conexion.preparedStatement().setString(2, servicios.getNombre());
		conexion.preparedStatement().setString(3, servicios.getDescripci�n());
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

		conexion.SQL("Select * from servicios where c�digoServicios=?");
		conexion.preparedStatement().setInt(1, servicios.getC�digoServicios());
		rs = conexion.resultSet();

		while (rs.next()) {
			
			servicios.setNombre(rs.getString("nombre"));
			servicios.setDescripci�n(rs.getString("descripci�n"));
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
		int c�digoServicios;
		String nombre;
		String descripci�n;
		int precio;
		String tipo;
		
		
		if (servicios != null) {
			
			c�digoServicios = servicios.getC�digoServicios();
			nombre = servicios.getNombre();
			descripci�n = servicios.getDescripci�n();
			precio = servicios.getPrecio();
			tipo = servicios.getTipo();
					

			conexion.SQL("Update servicios set nombre = ?, descripci�n = ?, precio = ?, tipo = ? where c�digoServicios=?");
			conexion.preparedStatement().setString(1, nombre);
			conexion.preparedStatement().setString(2, descripci�n);
			conexion.preparedStatement().setInt(3, precio);
			conexion.preparedStatement().setString(4, tipo);
			conexion.preparedStatement().setInt(5, c�digoServicios);
			conexion.CUD();
		}
	}

	


}

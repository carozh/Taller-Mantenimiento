package com.tallerMantenimiento.control;

import java.sql.ResultSet;
import java.util.ArrayList;
import com.tallerMantenimiento.entity.Mecánico;

public class MecánicoCtrl implements Control <Mecánico> {
	private Conexion conexion;
	
	public MecánicoCtrl(Conexion conexion){
		this.conexion = conexion;
	}
	
	/*
	 * *****************************************************************************
	 * List
	 ******************************************************************************/
	
	public ArrayList<Mecánico> list() throws Throwable {
		//se encarga de listar a todos los mécanicos
		ArrayList<Mecánico> mecánicos = new ArrayList<Mecánico>();
		ResultSet rs;
		
		int códigoMecánico;
		String nombre;
		String apellidos;
		int telfDomicilio;
		int celular;

		conexion.SQL("Select * from mecánico");

		rs = conexion.resultSet();

		while (rs.next()) {
			códigoMecánico = rs.getInt("códigoMecánico");
			nombre = rs.getString("nombre");
			apellidos = rs.getString("apellidos");
			telfDomicilio = rs.getInt("telfDomicilio");
			celular = rs.getInt("celular");
			mecánicos.add(new Mecánico(códigoMecánico, nombre, apellidos, telfDomicilio, celular));
		}

		return mecánicos;

	}
	
	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	public void insert(Mecánico mecánicos) throws Throwable {

		conexion.SQL("Insert into mecánicos(códigoMecánico, nombre, apellidos, telfDomicilio, celular) VALUES(?,?,?,?,?)");
		// ? SON PARAMETROS
		conexion.preparedStatement().setInt(1, mecánicos.getCódigoMecánico());
		//Vamos a mandar una cadena de caracteres
		conexion.preparedStatement().setString(2, mecánicos.getNombre());
		conexion.preparedStatement().setString(3, mecánicos.getApellidos());
		conexion.preparedStatement().setInt(4, mecánicos.getTelfDomicilio());
		conexion.preparedStatement().setInt(5, mecánicos.getCelular());
		conexion.CUD();
	}
	
	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search(Mecánico mecánicos) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from cliente where códigoMecánico=?");
		conexion.preparedStatement().setInt(1, mecánicos.getCódigoMecánico());
		rs = conexion.resultSet();

		while (rs.next()) {
			
			mecánicos.setNombre(rs.getString("nombre"));
			mecánicos.setApellidos(rs.getString("apellidos"));
			mecánicos.setTelfDomicilio(rs.getInt("telfDomicilio"));
			mecánicos.setCelular(rs.getInt("celular"));
			
		}

		rs.close();

	}
	

	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update(Mecánico mecánicos) throws Throwable {
		int códigoMecánico;
		String nombre;
		String apellidos;
		int telfDomicilio;
		int celular;
		
		if (mecánicos != null) {
			
			códigoMecánico = mecánicos.getCódigoMecánico();
			nombre = mecánicos.getNombre();
			apellidos = mecánicos.getApellidos();
			telfDomicilio = mecánicos.getTelfDomicilio();
			celular = mecánicos.getCelular();
					

			conexion.SQL("Update mecánicos set nombre = ?, apellidos = ?, telfDomicilio = ?, celular = ? where códigoMecánico = ?");
			conexion.preparedStatement().setString(1, nombre);
			conexion.preparedStatement().setString(2, apellidos);
			conexion.preparedStatement().setInt(3, telfDomicilio);
			conexion.preparedStatement().setInt(4, celular);
			conexion.preparedStatement().setInt(5, códigoMecánico);
			conexion.CUD();
		}
	}

}

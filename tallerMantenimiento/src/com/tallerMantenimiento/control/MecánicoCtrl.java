package com.tallerMantenimiento.control;

import java.sql.ResultSet;
import java.util.ArrayList;
import com.tallerMantenimiento.entity.Mec�nico;

public class Mec�nicoCtrl implements Control <Mec�nico> {
	private Conexion conexion;
	
	public Mec�nicoCtrl(Conexion conexion){
		this.conexion = conexion;
	}
	
	/*
	 * *****************************************************************************
	 * List
	 ******************************************************************************/
	
	public ArrayList<Mec�nico> list() throws Throwable {
		//se encarga de listar a todos los m�canicos
		ArrayList<Mec�nico> mec�nicos = new ArrayList<Mec�nico>();
		ResultSet rs;
		
		int c�digoMec�nico;
		String nombre;
		String apellidos;
		int telfDomicilio;
		int celular;

		conexion.SQL("Select * from mec�nico");

		rs = conexion.resultSet();

		while (rs.next()) {
			c�digoMec�nico = rs.getInt("c�digoMec�nico");
			nombre = rs.getString("nombre");
			apellidos = rs.getString("apellidos");
			telfDomicilio = rs.getInt("telfDomicilio");
			celular = rs.getInt("celular");
			mec�nicos.add(new Mec�nico(c�digoMec�nico, nombre, apellidos, telfDomicilio, celular));
		}

		return mec�nicos;

	}
	
	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	public void insert(Mec�nico mec�nicos) throws Throwable {

		conexion.SQL("Insert into mec�nicos(c�digoMec�nico, nombre, apellidos, telfDomicilio, celular) VALUES(?,?,?,?,?)");
		// ? SON PARAMETROS
		conexion.preparedStatement().setInt(1, mec�nicos.getC�digoMec�nico());
		//Vamos a mandar una cadena de caracteres
		conexion.preparedStatement().setString(2, mec�nicos.getNombre());
		conexion.preparedStatement().setString(3, mec�nicos.getApellidos());
		conexion.preparedStatement().setInt(4, mec�nicos.getTelfDomicilio());
		conexion.preparedStatement().setInt(5, mec�nicos.getCelular());
		conexion.CUD();
	}
	
	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search(Mec�nico mec�nicos) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from cliente where c�digoMec�nico=?");
		conexion.preparedStatement().setInt(1, mec�nicos.getC�digoMec�nico());
		rs = conexion.resultSet();

		while (rs.next()) {
			
			mec�nicos.setNombre(rs.getString("nombre"));
			mec�nicos.setApellidos(rs.getString("apellidos"));
			mec�nicos.setTelfDomicilio(rs.getInt("telfDomicilio"));
			mec�nicos.setCelular(rs.getInt("celular"));
			
		}

		rs.close();

	}
	

	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update(Mec�nico mec�nicos) throws Throwable {
		int c�digoMec�nico;
		String nombre;
		String apellidos;
		int telfDomicilio;
		int celular;
		
		if (mec�nicos != null) {
			
			c�digoMec�nico = mec�nicos.getC�digoMec�nico();
			nombre = mec�nicos.getNombre();
			apellidos = mec�nicos.getApellidos();
			telfDomicilio = mec�nicos.getTelfDomicilio();
			celular = mec�nicos.getCelular();
					

			conexion.SQL("Update mec�nicos set nombre = ?, apellidos = ?, telfDomicilio = ?, celular = ? where c�digoMec�nico = ?");
			conexion.preparedStatement().setString(1, nombre);
			conexion.preparedStatement().setString(2, apellidos);
			conexion.preparedStatement().setInt(3, telfDomicilio);
			conexion.preparedStatement().setInt(4, celular);
			conexion.preparedStatement().setInt(5, c�digoMec�nico);
			conexion.CUD();
		}
	}

}

package com.tallerMantenimiento.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.tallerMantenimiento.entity.Cliente;




public class ClienteCtrl implements Control <Cliente>{
	
	private Conexion conexion;
	
	public ClienteCtrl (Conexion conexion) {
		this.conexion = conexion;
		//atributos de la clase
	}
	

	/*
	 * *****************************************************************************
	 * List
	 ******************************************************************************/
	
	public ArrayList<Cliente> list() throws Throwable {
		//se encarga de listar a todos los clientes
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		ResultSet rs;
		String NIT;
		String nombre;
		String apellido;
		int telfDomicilio;
		int telfOficina;
		int m�vil;

		conexion.SQL("Select * from cliente");

		rs = conexion.resultSet();

		while (rs.next()) {
			NIT = rs.getString("NIT");
			nombre = rs.getString("nombre");
			apellido = rs.getString("apellido");
			telfDomicilio = rs.getInt("telfDomicilio");
			telfOficina = rs.getInt("telfOficina");
			m�vil = rs.getInt("m�vil");
			clientes.add(new Cliente(NIT, nombre, apellido, telfDomicilio, telfOficina, m�vil));
		}

		return clientes;

	}
	
	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	public void insert(Cliente cliente) throws Throwable {

		conexion.SQL("Insert into cliente(NIT,nombre, apellido, telfDomicilio, telfOficina, m�vil) VALUES(?,?,?,?,?,?)");
		// ? SON PARAMETROS
		conexion.preparedStatement().setString(1, cliente.getNIT());
		//Vamos a mandar una cadena de caracteres
		conexion.preparedStatement().setString(2, cliente.getNombre());
		conexion.preparedStatement().setString(3, cliente.getApellido());
		conexion.preparedStatement().setInt(4, cliente.getTelfDomicilio());
		conexion.preparedStatement().setInt(5,cliente.getTelfOficina());
		conexion.preparedStatement().setInt(6, cliente.getM�vil());
		conexion.CUD();
	}
	

	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search(Cliente cliente) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from cliente where NIT=?");
		conexion.preparedStatement().setString(1, cliente.getNIT());
		rs = conexion.resultSet();

		while (rs.next()) {

			cliente.setNombre(rs.getString("nombre"));
			cliente.setApellido(rs.getString("apellido"));
			cliente.setTelfDomicilio(rs.getInt("telfDomicilio"));
			cliente.setTelfOficina(rs.getInt("telfOficina"));
			cliente.setM�vil(rs.getInt("m�vil"));
		}

		rs.close();

	}
	
	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update(Cliente cliente) throws Throwable {
		String nombre;
		String NIT;
		String apellido;
		int telfDomicilio;
		int telfOficina;
		int m�vil;
		
		if (cliente != null) {
			
			nombre = cliente.getNombre();
			NIT = cliente.getNIT();
			apellido = cliente.getApellido();
			telfDomicilio = cliente.getTelfDomicilio();
			telfOficina = cliente.getTelfOficina();
			m�vil = cliente.getM�vil();
					

			conexion.SQL("Update cliente set nombre = ?, apellido = ?, telfDomicilio = ?, telfOficina=?, m�vil=? where NIT=?");
			conexion.preparedStatement().setString(1, nombre);
			conexion.preparedStatement().setString(2, apellido);
			conexion.preparedStatement().setInt(3, telfDomicilio);
			conexion.preparedStatement().setInt(4, telfOficina);
			conexion.preparedStatement().setInt(5, m�vil);
			conexion.preparedStatement().setString(6, NIT);
			conexion.CUD();
		}
	}




}

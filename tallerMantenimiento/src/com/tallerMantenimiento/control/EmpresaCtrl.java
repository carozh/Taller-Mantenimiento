package com.tallerMantenimiento.control;

import java.sql.ResultSet;
import java.util.ArrayList;
import com.tallerMantenimiento.entity.Empresa;

public class EmpresaCtrl implements Control <Empresa>{
	
	private Conexion conexion;
	
	public EmpresaCtrl(Conexion conexion){
		this.conexion = conexion;
	}
	
	 /******************************************************************************
	 * List
	 ******************************************************************************/
	
	public ArrayList<Empresa> list() throws Throwable {
		
		ArrayList<Empresa> empresas = new ArrayList<Empresa>();
		ResultSet rs;
		int códigoEmpresa;
		String nombre;
		int teléfono;
		String dirección;
		
		conexion.SQL("Select * from empresa");

		rs = conexion.resultSet();

		while (rs.next()) {
			códigoEmpresa = rs.getInt("códigoEmpresa");
			nombre = rs.getString("nombre");
			teléfono = rs.getInt("teléfono");
			dirección = rs.getString("dirección");
			
			empresas.add(new Empresa(códigoEmpresa, nombre, teléfono, dirección));
						
		}

		return empresas;
		
	}
	
	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	public void insert(Empresa empresas) throws Throwable {

		conexion.SQL("Insert into empresa(códigoEmpresa, nombre, teléfono, dirección) VALUES(?,?,?,?)");
		// ? SON PARAMETROS
		conexion.preparedStatement().setInt(1, empresas.getCódigoEmpresa());
		//Vamos a mandar una cadena de caracteres
		conexion.preparedStatement().setString(2, empresas.getNombre());
		conexion.preparedStatement().setInt(3, empresas.getTeléfono());
		conexion.preparedStatement().setString(4,empresas.getDirección());
		conexion.CUD();
	}
	
	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search(Empresa empresas) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from empresa where códigoEmpresa=?");
		conexion.preparedStatement().setInt(1, empresas.getCódigoEmpresa());
		rs = conexion.resultSet();

		while (rs.next()) {
			
			empresas.setNombre(rs.getString("nombre"));
			empresas.setTeléfono(rs.getInt("teléfono"));
			empresas.setDirección(rs.getString("dirección"));
			
		}

		rs.close();

	}
	
	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update(Empresa empresa) throws Throwable {
		
		int códigoEmpresa;
		String nombre;
		int teléfono;
		String dirección;
		
		
		if (empresa != null) {
			
			códigoEmpresa = empresa.getCódigoEmpresa();
			nombre = empresa.getNombre();
			teléfono = empresa.getTeléfono();
			dirección = empresa.getDirección();
		

			conexion.SQL("Update empresa set nombre = ?, teléfono = ?, dirección = ? where códigoEmpresa=?");
			conexion.preparedStatement().setString(1, nombre);
			conexion.preparedStatement().setInt(2, teléfono);
			conexion.preparedStatement().setString(3, dirección);
			conexion.preparedStatement().setInt(4, códigoEmpresa);
			conexion.CUD();
		}
	}
	


}

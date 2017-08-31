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
		int c�digoEmpresa;
		String nombre;
		int tel�fono;
		String direcci�n;
		
		conexion.SQL("Select * from empresa");

		rs = conexion.resultSet();

		while (rs.next()) {
			c�digoEmpresa = rs.getInt("c�digoEmpresa");
			nombre = rs.getString("nombre");
			tel�fono = rs.getInt("tel�fono");
			direcci�n = rs.getString("direcci�n");
			
			empresas.add(new Empresa(c�digoEmpresa, nombre, tel�fono, direcci�n));
						
		}

		return empresas;
		
	}
	
	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	public void insert(Empresa empresas) throws Throwable {

		conexion.SQL("Insert into empresa(c�digoEmpresa, nombre, tel�fono, direcci�n) VALUES(?,?,?,?)");
		// ? SON PARAMETROS
		conexion.preparedStatement().setInt(1, empresas.getC�digoEmpresa());
		//Vamos a mandar una cadena de caracteres
		conexion.preparedStatement().setString(2, empresas.getNombre());
		conexion.preparedStatement().setInt(3, empresas.getTel�fono());
		conexion.preparedStatement().setString(4,empresas.getDirecci�n());
		conexion.CUD();
	}
	
	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search(Empresa empresas) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from empresa where c�digoEmpresa=?");
		conexion.preparedStatement().setInt(1, empresas.getC�digoEmpresa());
		rs = conexion.resultSet();

		while (rs.next()) {
			
			empresas.setNombre(rs.getString("nombre"));
			empresas.setTel�fono(rs.getInt("tel�fono"));
			empresas.setDirecci�n(rs.getString("direcci�n"));
			
		}

		rs.close();

	}
	
	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update(Empresa empresa) throws Throwable {
		
		int c�digoEmpresa;
		String nombre;
		int tel�fono;
		String direcci�n;
		
		
		if (empresa != null) {
			
			c�digoEmpresa = empresa.getC�digoEmpresa();
			nombre = empresa.getNombre();
			tel�fono = empresa.getTel�fono();
			direcci�n = empresa.getDirecci�n();
		

			conexion.SQL("Update empresa set nombre = ?, tel�fono = ?, direcci�n = ? where c�digoEmpresa=?");
			conexion.preparedStatement().setString(1, nombre);
			conexion.preparedStatement().setInt(2, tel�fono);
			conexion.preparedStatement().setString(3, direcci�n);
			conexion.preparedStatement().setInt(4, c�digoEmpresa);
			conexion.CUD();
		}
	}
	


}

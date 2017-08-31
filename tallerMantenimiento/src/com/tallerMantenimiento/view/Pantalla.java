package com.tallerMantenimiento.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.tallerMantenimiento.control.Conexion;

public class Pantalla {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Conexion conexion = new Conexion();
		ClienteView clienteView = new ClienteView(conexion, scanner);
		DetalleMantenimientoView detalleMantenimientoView = new DetalleMantenimientoView(conexion, scanner);
		EmpresaView empresaView = new EmpresaView(conexion, scanner);
		Mec�nicoView mec�nicoView = new Mec�nicoView(conexion, scanner);
		ServiciosView serviciosView = new ServiciosView(conexion, scanner);
		Veh�culoView veh�culoView = new Veh�culoView(conexion, scanner);
		
		serviciosView.listar();
		
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
		
		
		scanner.close();
		

	}

}

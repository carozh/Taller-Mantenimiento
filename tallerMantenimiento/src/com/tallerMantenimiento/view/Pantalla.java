package com.tallerMantenimiento.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.tallerMantenimiento.control.Conexion;
import com.tallerMantenimiento.view.Men�.MenusCliente;
import com.tallerMantenimiento.view.Men�.Principal;

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
		MenusCliente menusClientes = new MenusCliente();
		Principal principal = new Principal();
		MenusCliente menusCliente = new MenusCliente();
		
		principal.subMenu(scanner, conexion);
		//menusClientes.subMenuActualizar(scanner);
		
		//clienteView.insertar();
		/*clienteView.listar();
		clienteView.buscar(ReadTypes.leerCadena(scanner, "Ingrese el NIT del cliente"));
		clienteView.actualizar();
		
		detalleMantenimientoView.insertar();
		detalleMantenimientoView.listar();
		detalleMantenimientoView.buscar(ReadTypes.leerEntero(scanner, "Ingrese el c�digo Detalle Mantenimiento"));
		detalleMantenimientoView.actualizar();
		
		empresaView.insertar();
		empresaView.listar();
		empresaView.buscar(ReadTypes.leerEntero(scanner,"ingrese el c�digo de la Empresa "));
		empresaView.actualizar();
		
		mec�nicoView.insertar();
		mec�nicoView.listar();
		mec�nicoView.buscar(ReadTypes.leerEntero(scanner, "Ingrese el c�digo Mec�nico"));
		mec�nicoView.actualizar();
		
		serviciosView.insertar();
		serviciosView.listar();
		serviciosView.buscar(ReadTypes.leerEntero(scanner, "Ingrese el c�digo de Servicios"));
		serviciosView.actualizar();
		
		veh�culoView.insertar();
		veh�culoView.listar();
		veh�culoView.buscar(ReadTypes.leerCadena(scanner, "Ingrese el chasis del veh�culo"));
		veh�culoView.actualizar();*/
		
		
		
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
		
		
		scanner.close();
		

	}

}

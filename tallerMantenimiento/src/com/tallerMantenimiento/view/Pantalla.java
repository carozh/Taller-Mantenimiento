package com.tallerMantenimiento.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.tallerMantenimiento.control.Conexion;
import com.tallerMantenimiento.view.Menú.MenusCliente;
import com.tallerMantenimiento.view.Menú.Principal;

public class Pantalla {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Conexion conexion = new Conexion();
		ClienteView clienteView = new ClienteView(conexion, scanner);
		DetalleMantenimientoView detalleMantenimientoView = new DetalleMantenimientoView(conexion, scanner);
		EmpresaView empresaView = new EmpresaView(conexion, scanner);
		MecánicoView mecánicoView = new MecánicoView(conexion, scanner);
		ServiciosView serviciosView = new ServiciosView(conexion, scanner);
		VehículoView vehículoView = new VehículoView(conexion, scanner);
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
		detalleMantenimientoView.buscar(ReadTypes.leerEntero(scanner, "Ingrese el código Detalle Mantenimiento"));
		detalleMantenimientoView.actualizar();
		
		empresaView.insertar();
		empresaView.listar();
		empresaView.buscar(ReadTypes.leerEntero(scanner,"ingrese el código de la Empresa "));
		empresaView.actualizar();
		
		mecánicoView.insertar();
		mecánicoView.listar();
		mecánicoView.buscar(ReadTypes.leerEntero(scanner, "Ingrese el código Mecánico"));
		mecánicoView.actualizar();
		
		serviciosView.insertar();
		serviciosView.listar();
		serviciosView.buscar(ReadTypes.leerEntero(scanner, "Ingrese el código de Servicios"));
		serviciosView.actualizar();
		
		vehículoView.insertar();
		vehículoView.listar();
		vehículoView.buscar(ReadTypes.leerCadena(scanner, "Ingrese el chasis del vehículo"));
		vehículoView.actualizar();*/
		
		
		
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
		
		
		scanner.close();
		

	}

}

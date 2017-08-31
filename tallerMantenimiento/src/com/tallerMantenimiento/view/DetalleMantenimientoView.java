package com.tallerMantenimiento.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.tallerMantenimiento.control.Conexion;
import com.tallerMantenimiento.control.DetalleMantenimientoCtrl;
import com.tallerMantenimiento.entity.DetalleMantenimiento;
import com.tallerMantenimiento.view.Menú.MenusDetalleMantenimiento;

public class DetalleMantenimientoView {
	
	private Scanner scanner;
	private DetalleMantenimiento detalleMantenimiento;
	private DetalleMantenimientoCtrl detalleMantenimientoCtrl;
	
	public DetalleMantenimientoView( Conexion conexion, Scanner scanner){
		
		this.scanner = scanner;
		detalleMantenimientoCtrl = new DetalleMantenimientoCtrl(conexion);
		
	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar() {
		
		int códigoDetalleMantenimiento;
		int códigoServicios;
		int códigoEmpresa;
		int códigoMantenimiento;
		int cantidad;
		Date fecha;
		

		códigoDetalleMantenimiento = ReadTypes.leerEntero(scanner, "Ingrese código de Detalle Mantenimiento:");
		códigoServicios = ReadTypes.leerEntero(scanner, "Ingrese el código de Servicio:");
		códigoEmpresa = ReadTypes.leerEntero(scanner, "Ingrese el código de Empresa:");
		códigoMantenimiento = ReadTypes.leerEntero(scanner, "Ingrese el código de Mantenimiento:");
		cantidad = ReadTypes.leerEntero(scanner, "Ingrese la cantidad:");
		fecha = ReadTypes.leerFecha(scanner, "Ingrese la fecha: ");
		
		detalleMantenimiento = new DetalleMantenimiento(códigoDetalleMantenimiento,códigoServicios, códigoEmpresa, códigoMantenimiento, cantidad, fecha);

		
		try {
			detalleMantenimientoCtrl.insert(detalleMantenimiento);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {
		ArrayList<DetalleMantenimiento> detalleMantenimientos;

		try {
			detalleMantenimientos = detalleMantenimientoCtrl.list();
			for (int i = 0; i < detalleMantenimientos.size(); i++) {
				System.out.println(detalleMantenimientos.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int códigoDetalleMantenimiento) {
		//solo mediante la llave primaria
		detalleMantenimiento = new DetalleMantenimiento(códigoDetalleMantenimiento);
		try {
			detalleMantenimientoCtrl.search(detalleMantenimiento);
			System.out.println(detalleMantenimiento);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
		int códigoDetalleMantenimiento;
			
		códigoDetalleMantenimiento = ReadTypes.leerEntero(scanner, "Ingrese el código del Detalle Mantenimiento a modificar; ");
		detalleMantenimiento = new DetalleMantenimiento(códigoDetalleMantenimiento);
		
		
		try {
			detalleMantenimientoCtrl.search(detalleMantenimiento);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusDetalleMantenimiento.menuModificar(scanner, detalleMantenimiento);

		try {
			detalleMantenimientoCtrl.update(detalleMantenimiento);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	

}

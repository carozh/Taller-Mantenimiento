package com.tallerMantenimiento.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.tallerMantenimiento.control.Conexion;
import com.tallerMantenimiento.control.DetalleMantenimientoCtrl;
import com.tallerMantenimiento.entity.DetalleMantenimiento;
import com.tallerMantenimiento.view.Men�.MenusDetalleMantenimiento;

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
		
		int c�digoDetalleMantenimiento;
		int c�digoServicios;
		int c�digoEmpresa;
		int c�digoMantenimiento;
		int cantidad;
		Date fecha;
		

		c�digoDetalleMantenimiento = ReadTypes.leerEntero(scanner, "Ingrese c�digo de Detalle Mantenimiento:");
		c�digoServicios = ReadTypes.leerEntero(scanner, "Ingrese el c�digo de Servicio:");
		c�digoEmpresa = ReadTypes.leerEntero(scanner, "Ingrese el c�digo de Empresa:");
		c�digoMantenimiento = ReadTypes.leerEntero(scanner, "Ingrese el c�digo de Mantenimiento:");
		cantidad = ReadTypes.leerEntero(scanner, "Ingrese la cantidad:");
		fecha = ReadTypes.leerFecha(scanner, "Ingrese la fecha: ");
		
		detalleMantenimiento = new DetalleMantenimiento(c�digoDetalleMantenimiento,c�digoServicios, c�digoEmpresa, c�digoMantenimiento, cantidad, fecha);

		
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
	public void buscar(int c�digoDetalleMantenimiento) {
		//solo mediante la llave primaria
		detalleMantenimiento = new DetalleMantenimiento(c�digoDetalleMantenimiento);
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
		int c�digoDetalleMantenimiento;
			
		c�digoDetalleMantenimiento = ReadTypes.leerEntero(scanner, "Ingrese el c�digo del Detalle Mantenimiento a modificar; ");
		detalleMantenimiento = new DetalleMantenimiento(c�digoDetalleMantenimiento);
		
		
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

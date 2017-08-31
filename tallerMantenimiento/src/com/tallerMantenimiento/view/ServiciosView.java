package com.tallerMantenimiento.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.tallerMantenimiento.control.Conexion;
import com.tallerMantenimiento.control.ServiciosCtrl;
import com.tallerMantenimiento.entity.Servicios;
import com.tallerMantenimiento.view.Men�.MenusServicios;

public class ServiciosView {
	
	private Scanner scanner;
	private Servicios servicios;
	private ServiciosCtrl serviciosCtrl;
	
	
	public ServiciosView(Conexion conexion, Scanner scanner){
		
		this.scanner = scanner;
		serviciosCtrl = new ServiciosCtrl(conexion);
		
	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar() {
		
		int c�digoServicios;
		String nombre;
		String descripci�n;
		int precio;
		String tipo;
		

		c�digoServicios = ReadTypes.leerEntero(scanner, "Ingrese el c�digo de Servicio: ");
		nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre del servicio: ");
		descripci�n = ReadTypes.leerCadena(scanner, "Ingrese el item del servicio: ");
		descripci�n = ReadTypes.leerCadena(scanner, "Ingrese la funcionalidad del servicio: ");
		precio = ReadTypes.leerEntero(scanner, "Ingrese el precio unitario del servicio: ");
		tipo = ReadTypes.leerCadena(scanner, "Ingrese los diferentes tipos de servicios disponibles:");
		
		servicios = new Servicios(c�digoServicios,nombre, descripci�n, precio, tipo);

		
		try {
			serviciosCtrl.insert(servicios);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {
		ArrayList<Servicios> servicios;

		try {
			servicios = serviciosCtrl.list();
			for (int i = 0; i < servicios.size(); i++) {
				System.out.println(servicios.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int c�digoServicios) {
		//solo mediante la llave primaria
		servicios = new Servicios(c�digoServicios);
		try {
			serviciosCtrl.search(servicios);
			System.out.println(servicios);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
		
		int c�digoServicios;
		
		c�digoServicios = ReadTypes.leerEntero(scanner, "Ingrese el c�digo de Servicio a modificar:");
		servicios.setC�digoServicios(c�digoServicios);
		
		
		try {
			serviciosCtrl.search(servicios);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusServicios.menuModificar(scanner, servicios);

		try {
			serviciosCtrl.update(servicios);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

}

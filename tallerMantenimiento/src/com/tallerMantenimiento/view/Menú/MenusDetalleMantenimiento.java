package com.tallerMantenimiento.view.Menú;

import java.util.Scanner;

import com.tallerMantenimiento.entity.Cliente;
import com.tallerMantenimiento.entity.DetalleMantenimiento;
import com.tallerMantenimiento.view.ReadTypes;

public class MenusDetalleMantenimiento {
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	
	
	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar Cantidad");
				System.out.println("2. Actualizar Fecha");
				System.out.println("0. Salir");
				System.out.println();

				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 2) {
					return opcion;
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingrese solo valores numéricos");
				System.out.println();
				scanner.nextLine();
			}
		}
	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	
	
	public static void menuModificar(Scanner scanner, DetalleMantenimiento detalleMantenimiento) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Cantidad anterior: ");
				System.out.println(detalleMantenimiento.getCantidad());
				int cantidad = ReadTypes.leerEntero(scanner, "Ingrese la nueva cantidad: ");
				detalleMantenimiento.setCantidad(cantidad);
				break;
			case 2:
				System.out.print("Fecha anterior: ");
				System.out.println(detalleMantenimiento.getFecha());
				String apellido = ReadTypes.leerCadena(scanner, "Ingrese la nueva fecha: ");
				detalleMantenimiento.setFecha(fecha);
				break;
			
			}
		}
	}

}

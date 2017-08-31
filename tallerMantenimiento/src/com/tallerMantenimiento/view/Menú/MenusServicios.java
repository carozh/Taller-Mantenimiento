package com.tallerMantenimiento.view.Men�;

import java.util.Scanner;
import com.tallerMantenimiento.entity.Servicios;
import com.tallerMantenimiento.view.ReadTypes;

public class MenusServicios {
	
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	
	
	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar Nombre del Servicio");
				System.out.println("2. Actualizar la descripcion del item");
				System.out.println("3. Actualizar precio del Servicio");
				System.out.println("4. Actualizar los diferentes tipos de servicios ");
				System.out.println("0. Salir");
				System.out.println();

				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 4) {
					return opcion;
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingrese solo valores num�ricos");
				System.out.println();
				scanner.nextLine();
			}
		}
	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	
	
	public static void menuModificar(Scanner scanner, Servicios servicios) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Nombre anterior: ");
				System.out.println(servicios.getNombre());
				String nombre = ReadTypes.leerCadena(scanner, "Ingrese el nuevo Nombre del Servicio: ");
				servicios.setNombre(nombre);
				break;
			case 2:
				System.out.print("Descripci�n anterior: ");
				System.out.println(servicios.getDescripci�n());
				String descripci�n = ReadTypes.leerCadena(scanner, "Ingrese la nueva descripci�n del Item: ");
				servicios.setDescripci�n(descripci�n);
				break;
			case 3:
				System.out.print("precio del Servicio anterior: ");
				System.out.println(servicios.getPrecio());
				int precio = ReadTypes.leerEntero(scanner, "Ingrese el nuevo precio del Servicio: ");
				servicios.setPrecio(precio);
				break;
			case 4:
				System.out.print("nombre de los diferentes tipos de servicios anteriores: ");
				System.out.println(servicios.getTipo());
				String tipo = ReadTypes.leerCadena(scanner, "Ingrese el nuevo tipo de servicio: ");
				servicios.setTipo(tipo);
				break;
			
			}
		}
	}

}

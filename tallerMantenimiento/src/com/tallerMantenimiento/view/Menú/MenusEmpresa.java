package com.tallerMantenimiento.view.Menú;

import java.util.Scanner;
import com.tallerMantenimiento.entity.Empresa;
import com.tallerMantenimiento.view.ReadTypes;

public class MenusEmpresa {
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	
	
	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar Nombre");
				System.out.println("2. Actualizar Teléfono");
				System.out.println("3. Actualizar Dirección");
				System.out.println("0. Salir");
				System.out.println();

				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 3) {
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
	
	
	public static void menuModificar(Scanner scanner, Empresa empresa) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Nombre anterior: ");
				System.out.println(empresa.getNombre());
				String nombre = ReadTypes.leerCadena(scanner, "Ingrese el nuevo Nombre: ");
				empresa.setNombre(nombre);
				break;
			case 2:
				System.out.print("Teléfono anterior: ");
				System.out.println(empresa.getTeléfono());
				int teléfono = ReadTypes.leerEntero(scanner, "Ingrese el nuevo Teléfono: ");
				empresa.setTeléfono(teléfono);
				break;
			case 3:
				System.out.print("Dirección anterior: ");
				System.out.println(empresa.getDirección());
				String dirección = ReadTypes.leerCadena(scanner, "Ingrese la nueva Dirección: ");
				empresa.setDirección(dirección);
				break;
			
			}
		}
	}

}

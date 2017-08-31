package com.tallerMantenimiento.view.Menú;



import java.util.Scanner;
import com.tallerMantenimiento.entity.Mecánico;
import com.tallerMantenimiento.view.ReadTypes;

public class MenusMecánico {
	
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
				System.out.println("2. Actualizar Apellidos");
				System.out.println("3. Actualizar teléfono Domicilio");
				System.out.println("4. Actualizar teléfono celular");
				System.out.println("0. Salir");
				System.out.println();

				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 4) {
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
	
	
	public static void menuModificar(Scanner scanner, Mecánico mecánico) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Nombre anterior: ");
				System.out.println(mecánico.getNombre());
				String nombre = ReadTypes.leerCadena(scanner, "Ingrese el nuevo Nombre: ");
				mecánico.setNombre(nombre);
				break;
			case 2:
				System.out.print("Apellidos anteriores: ");
				System.out.println(mecánico.getApellidos());
				String apellidos = ReadTypes.leerCadena(scanner, "Ingrese los nuevos Apellidos: ");
				mecánico.setApellidos(apellidos);
				break;
			case 3:
				System.out.print("Teléfono Domicilio anterior: ");
				System.out.println(mecánico.getTelfDomicilio());
				int telfDomicilio = ReadTypes.leerEntero(scanner, "Ingrese el nuevo Teléfono Domicilio: ");
				mecánico.setTelfDomicilio(telfDomicilio);
				break;
			case 4:
				System.out.print("Número de Celular anterior: ");
				System.out.println(mecánico.getCelular());
				int celular = ReadTypes.leerEntero(scanner, "Ingrese el nuevo número de celular: ");
				mecánico.setCelular(celular);
				break;
			
			}
		}
	}

}

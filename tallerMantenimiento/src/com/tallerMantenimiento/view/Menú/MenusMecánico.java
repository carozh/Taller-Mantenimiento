package com.tallerMantenimiento.view.Men�;



import java.util.Scanner;
import com.tallerMantenimiento.entity.Mec�nico;
import com.tallerMantenimiento.view.ReadTypes;

public class MenusMec�nico {
	
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
				System.out.println("3. Actualizar tel�fono Domicilio");
				System.out.println("4. Actualizar tel�fono celular");
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
	
	
	public static void menuModificar(Scanner scanner, Mec�nico mec�nico) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Nombre anterior: ");
				System.out.println(mec�nico.getNombre());
				String nombre = ReadTypes.leerCadena(scanner, "Ingrese el nuevo Nombre: ");
				mec�nico.setNombre(nombre);
				break;
			case 2:
				System.out.print("Apellidos anteriores: ");
				System.out.println(mec�nico.getApellidos());
				String apellidos = ReadTypes.leerCadena(scanner, "Ingrese los nuevos Apellidos: ");
				mec�nico.setApellidos(apellidos);
				break;
			case 3:
				System.out.print("Tel�fono Domicilio anterior: ");
				System.out.println(mec�nico.getTelfDomicilio());
				int telfDomicilio = ReadTypes.leerEntero(scanner, "Ingrese el nuevo Tel�fono Domicilio: ");
				mec�nico.setTelfDomicilio(telfDomicilio);
				break;
			case 4:
				System.out.print("N�mero de Celular anterior: ");
				System.out.println(mec�nico.getCelular());
				int celular = ReadTypes.leerEntero(scanner, "Ingrese el nuevo n�mero de celular: ");
				mec�nico.setCelular(celular);
				break;
			
			}
		}
	}

}

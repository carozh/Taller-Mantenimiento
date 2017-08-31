package com.tallerMantenimiento.view.Men�;

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
				System.out.println("2. Actualizar Tel�fono");
				System.out.println("3. Actualizar Direcci�n");
				System.out.println("0. Salir");
				System.out.println();

				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 3) {
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
				System.out.print("Tel�fono anterior: ");
				System.out.println(empresa.getTel�fono());
				int tel�fono = ReadTypes.leerEntero(scanner, "Ingrese el nuevo Tel�fono: ");
				empresa.setTel�fono(tel�fono);
				break;
			case 3:
				System.out.print("Direcci�n anterior: ");
				System.out.println(empresa.getDirecci�n());
				String direcci�n = ReadTypes.leerCadena(scanner, "Ingrese la nueva Direcci�n: ");
				empresa.setDirecci�n(direcci�n);
				break;
			
			}
		}
	}

}

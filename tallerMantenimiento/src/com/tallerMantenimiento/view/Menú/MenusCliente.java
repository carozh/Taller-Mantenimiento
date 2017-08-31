package com.tallerMantenimiento.view.Men�;

import java.util.Scanner;

import com.tallerMantenimiento.entity.Cliente;
import com.tallerMantenimiento.view.ReadTypes;



public class MenusCliente {
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
				System.out.println("2. Actualizar Apellido");
				System.out.println("3. Actualizar tel�fono Domicilio");
				System.out.println("4. Actualizar tel�fono Oficina");
				System.out.println("5. Actualizar tel�fono m�vil");
				System.out.println("0. Salir");
				System.out.println();

				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 5) {
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
	
	
	public static void menuModificar(Scanner scanner, Cliente cliente) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Nombre anterior: ");
				System.out.println(cliente.getNombre());
				String nombre = ReadTypes.leerCadena(scanner, "Ingrese el nuevo Nombre: ");
				cliente.setNombre(nombre);
				break;
			case 2:
				System.out.print("Apellido anterior: ");
				System.out.println(cliente.getApellido());
				String apellido = ReadTypes.leerCadena(scanner, "Ingrese el nuevo Apellido: ");
				cliente.setApellido(apellido);
				break;
			case 3:
				System.out.print("Tel�fono Domicilio anterior: ");
				System.out.println(cliente.getTelfDomicilio());
				int telfDomicilio = ReadTypes.leerEntero(scanner, "Ingrese el nuevo Tel�fono Domicilio: ");
				cliente.setTelfDomicilio(telfDomicilio);
				break;
			case 4:
				System.out.print("Tel�fono Oficina anterior: ");
				System.out.println(cliente.getTelfOficina());
				int telfOficina = ReadTypes.leerEntero(scanner, "Ingrese el nuevo Tel�fono Oficina: ");
				cliente.setTelfOficina(telfOficina);
				break;
			case 5:
				System.out.print("Tel�fono m�vil anterior: ");
				System.out.println(cliente.getM�vil());
				int m�vil = ReadTypes.leerEntero(scanner, "Ingrese el nuevo n�mero de m�vil: ");
				cliente.setM�vil(m�vil);
				break;
			}
		}
	}


}

package com.tallerMantenimiento.view.Menú;

import java.util.Scanner;

import com.tallerMantenimiento.control.Conexion;
import com.tallerMantenimiento.entity.Cliente;

public class Principal {
	
	public static int menu(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Menú Cliente" );
				System.out.println("2. Menú Vehículos " );
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

	public static void subMenu(Scanner leer, Conexion conexion) {
		boolean salir = false;
		Cliente cliente = null;
	
		while (!salir) {
			switch (menu(leer)) {
			case 0:
				salir = true;
				break;
			case 1:
				//MenusCliente.actualizar(leer);
				MenusCliente.subMenu(leer, conexion);
				//MenusCliente.opcionesModificar(leer);
				//MenusCliente.menuModificar(leer, cliente);
				//MenusCliente.actualizar(leer);
				//MenusCliente.subMenuActualizar(leer);
				

				break;
			case 2:
				//MenuProducto.subMenu(leer, "Producto");
				break;
			case 3:

				break;
			case 4:

				break;
			}
		}
	}

}

package com.tallerMantenimiento.view.Men�;

import java.util.Scanner;
import com.tallerMantenimiento.entity.Veh�culo;
import com.tallerMantenimiento.view.ReadTypes;

public class MenusVeh�culo {
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	
	
	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar Marca del veh�culo");
				System.out.println("2. Actualizar clase del veh�culo");
				System.out.println("3. Actualizar tipo del veh�culo");
				System.out.println("4. Actualizar color del veh�culo");
				System.out.println("5. Actualizar a�o del veh�culo");
				System.out.println("6. Actualizar placa del veh�culo");
				System.out.println("7. Actualizar Kilometraje del veh�culo");
				System.out.println("0. Salir");
				System.out.println();

				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 7) {
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
	
	
	public static void menuModificar(Scanner scanner, Veh�culo veh�culo) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Marca anterior: ");
				System.out.println(veh�culo.getMarca());
				String marca = ReadTypes.leerCadena(scanner, "Ingrese la nueva marca del veh�culo: ");
				veh�culo.setMarca(marca);
				break;
			case 2:
				System.out.print("Clase anterior: ");
				System.out.println(veh�culo.getClase());
				String clase = ReadTypes.leerCadena(scanner, "Ingrese la nueva clase del veh�culo: ");
				veh�culo.setClase(clase);
				break;
			case 3:
				System.out.print("Tipo anterior: ");
				System.out.println(veh�culo.getTipo());
				String tipo = ReadTypes.leerCadena(scanner, "Ingrese el nuevo tipo de veh�culo: ");
				veh�culo.setTipo(tipo);
				break;
			case 4:
				System.out.print("Color anterior: ");
				System.out.println(veh�culo.getColor());
				String color = ReadTypes.leerCadena(scanner, "Ingrese el nuevo color del veh�culo: ");
				veh�culo.setColor(color);
				break;
			case 5:
				System.out.print("Tel�fono m�vil anterior: ");
				System.out.println(veh�culo.getA�o());
				int a�o = ReadTypes.leerEntero(scanner, "Ingrese el nuevo a�o del veh�culo: ");
				veh�culo.setA�o(a�o);
				break;
			case 6:
				System.out.print("Placa anterior: ");
				System.out.println(veh�culo.getPlaca());
				String placa = ReadTypes.leerCadena(scanner, "Ingrese la nueva placa del veh�culo: ");
				veh�culo.setPlaca(placa);
				break;
			case 7:
				System.out.print("Kilometraje anterior: ");
				System.out.println(veh�culo.getKilometraje());
				int kilometraje = ReadTypes.leerEntero(scanner, "Ingrese el nuevo kilometraje del veh�culo: ");
				veh�culo.setKilometraje(kilometraje);
				break;
			}
		}
	}

}

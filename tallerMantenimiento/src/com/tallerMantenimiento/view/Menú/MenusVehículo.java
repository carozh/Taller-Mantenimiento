package com.tallerMantenimiento.view.Menú;

import java.util.Scanner;
import com.tallerMantenimiento.entity.Vehículo;
import com.tallerMantenimiento.view.ReadTypes;

public class MenusVehículo {
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	
	
	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar Marca del vehículo");
				System.out.println("2. Actualizar clase del vehículo");
				System.out.println("3. Actualizar tipo del vehículo");
				System.out.println("4. Actualizar color del vehículo");
				System.out.println("5. Actualizar año del vehículo");
				System.out.println("6. Actualizar placa del vehículo");
				System.out.println("7. Actualizar Kilometraje del vehículo");
				System.out.println("0. Salir");
				System.out.println();

				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 7) {
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
	
	
	public static void menuModificar(Scanner scanner, Vehículo vehículo) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Marca anterior: ");
				System.out.println(vehículo.getMarca());
				String marca = ReadTypes.leerCadena(scanner, "Ingrese la nueva marca del vehículo: ");
				vehículo.setMarca(marca);
				break;
			case 2:
				System.out.print("Clase anterior: ");
				System.out.println(vehículo.getClase());
				String clase = ReadTypes.leerCadena(scanner, "Ingrese la nueva clase del vehículo: ");
				vehículo.setClase(clase);
				break;
			case 3:
				System.out.print("Tipo anterior: ");
				System.out.println(vehículo.getTipo());
				String tipo = ReadTypes.leerCadena(scanner, "Ingrese el nuevo tipo de vehículo: ");
				vehículo.setTipo(tipo);
				break;
			case 4:
				System.out.print("Color anterior: ");
				System.out.println(vehículo.getColor());
				String color = ReadTypes.leerCadena(scanner, "Ingrese el nuevo color del vehículo: ");
				vehículo.setColor(color);
				break;
			case 5:
				System.out.print("Teléfono móvil anterior: ");
				System.out.println(vehículo.getAño());
				int año = ReadTypes.leerEntero(scanner, "Ingrese el nuevo año del vehículo: ");
				vehículo.setAño(año);
				break;
			case 6:
				System.out.print("Placa anterior: ");
				System.out.println(vehículo.getPlaca());
				String placa = ReadTypes.leerCadena(scanner, "Ingrese la nueva placa del vehículo: ");
				vehículo.setPlaca(placa);
				break;
			case 7:
				System.out.print("Kilometraje anterior: ");
				System.out.println(vehículo.getKilometraje());
				int kilometraje = ReadTypes.leerEntero(scanner, "Ingrese el nuevo kilometraje del vehículo: ");
				vehículo.setKilometraje(kilometraje);
				break;
			}
		}
	}

}

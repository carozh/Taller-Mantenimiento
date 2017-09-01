package com.tallerMantenimiento.view.Menú;



import java.util.ArrayList;
import java.util.Scanner;

import com.tallerMantenimiento.control.Conexion;
import com.tallerMantenimiento.entity.Cliente;
import com.tallerMantenimiento.entity.Mecánico;
import com.tallerMantenimiento.view.ClienteView;
import com.tallerMantenimiento.view.MecánicoView;
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
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	
	public static int menu(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Ingresar mecánico ");
				System.out.println("2. Buscar ");
				System.out.println("3. Listar ");
				System.out.println("4. Actualizar ");
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
	

	public static void subMenu(Scanner leer, Conexion conexion) {
		
		boolean salir = false;
		MecánicoView mecánicoView = null;
		Mecánico mecánico = new Mecánico(ReadTypes.leerEntero(leer, "Ingrese el código del Mecánico"));
		
	

		while (!salir) {
			switch (menu(leer)) {
			case 0:
				salir = true;
				break;
			case 1:
				mecánicoView = new MecánicoView(conexion, leer);
				mecánicoView.insertar();
				try {
					mecánicoView.insertar();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				mecánico = new Mecánico(ReadTypes.leerEntero(leer, "Ingrese el código del mecánico"));
				try {
					mecánicoView.buscar(ReadTypes.leerEntero(leer, "Ingrese el código del mecánico"));;
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				ArrayList<Mecánico> mecánicos = null ;
				int tamaño;
				try {
					mecánicoView.listar();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tamaño = mecánicos.size();
				for (int i = 0; i < tamaño; i++){
					System.out.println(mecánicos.get(i));
				}
				break;
			case 4:
				mecánico = new Mecánico(ReadTypes.leerEntero(leer, "Ingrese el código del Mecánico"));
				try {
					mecánicoView.buscar(ReadTypes.leerEntero(leer, "Ingrese el código del Mecánico"));;
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (mecánico.getCódigoMecánico() == 0) {
					System.out.println("Código Inexistente ");
				} else {
					System.out.println(mecánico);
					System.out.println();
					subMenuActualizar(leer);
					System.out.println(mecánico);
					try {
						mecánicoView.actualizar();
						
					} catch (Throwable e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				break;
			}
		}

	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	
	public static int actualizar(Scanner leer) {
		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Nombre ");
				System.out.println("2. Apellidos ");
				System.out.println("3. Teléfono Domicilio ");
				System.out.println("4. celular");
				System.out.println("0. Salir");
				System.out.println();

				opcion = leer.nextInt();

				if (opcion >= 0 && opcion <= 4) {
					leer.nextLine();
					return opcion;
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingrese solo valores numéricos");
				System.out.println();
				leer.nextLine();
			}
		}
	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	
	public static void subMenuActualizar(Scanner leer) {
		boolean salir = false;
		
		Mecánico mecánico = new Mecánico(ReadTypes.leerEntero(leer, "Ingrese el código del Mecánico"));
		
		
		
		while (!salir) {
			switch (actualizar(leer)) {
			case 0:
				salir = true;
				break;
			case 1:
				mecánico.setNombre(ReadTypes.leerCadena(leer, "Ingrese el nuevo nombre del mecánico "));
				break;
			case 2:
				mecánico.setApellidos(ReadTypes.leerCadena(leer, "Ingrese el  nuevo apellido del mecánico "));
				break;
			case 3:
				mecánico.setTelfDomicilio(ReadTypes.leerEntero(leer, "Ingresar el nuevo teléfono del Domicilio del mecánico"));
				break;
			case 4:
				mecánico.setCelular(ReadTypes.leerEntero(leer, "Ingresar el nuevo  teléfono celular del mecánico"));
				break;
			
			}
		}

	}

}

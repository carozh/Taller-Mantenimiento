package com.tallerMantenimiento.view.Men�;



import java.util.ArrayList;
import java.util.Scanner;

import com.tallerMantenimiento.control.Conexion;
import com.tallerMantenimiento.entity.Cliente;
import com.tallerMantenimiento.entity.Mec�nico;
import com.tallerMantenimiento.view.ClienteView;
import com.tallerMantenimiento.view.Mec�nicoView;
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
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	
	public static int menu(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Ingresar mec�nico ");
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
				System.out.println("Ingrese solo valores num�ricos");
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
		Mec�nicoView mec�nicoView = null;
		Mec�nico mec�nico = new Mec�nico(ReadTypes.leerEntero(leer, "Ingrese el c�digo del Mec�nico"));
		
	

		while (!salir) {
			switch (menu(leer)) {
			case 0:
				salir = true;
				break;
			case 1:
				mec�nicoView = new Mec�nicoView(conexion, leer);
				mec�nicoView.insertar();
				try {
					mec�nicoView.insertar();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				mec�nico = new Mec�nico(ReadTypes.leerEntero(leer, "Ingrese el c�digo del mec�nico"));
				try {
					mec�nicoView.buscar(ReadTypes.leerEntero(leer, "Ingrese el c�digo del mec�nico"));;
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				ArrayList<Mec�nico> mec�nicos = null ;
				int tama�o;
				try {
					mec�nicoView.listar();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tama�o = mec�nicos.size();
				for (int i = 0; i < tama�o; i++){
					System.out.println(mec�nicos.get(i));
				}
				break;
			case 4:
				mec�nico = new Mec�nico(ReadTypes.leerEntero(leer, "Ingrese el c�digo del Mec�nico"));
				try {
					mec�nicoView.buscar(ReadTypes.leerEntero(leer, "Ingrese el c�digo del Mec�nico"));;
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (mec�nico.getC�digoMec�nico() == 0) {
					System.out.println("C�digo Inexistente ");
				} else {
					System.out.println(mec�nico);
					System.out.println();
					subMenuActualizar(leer);
					System.out.println(mec�nico);
					try {
						mec�nicoView.actualizar();
						
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
				System.out.println("3. Tel�fono Domicilio ");
				System.out.println("4. celular");
				System.out.println("0. Salir");
				System.out.println();

				opcion = leer.nextInt();

				if (opcion >= 0 && opcion <= 4) {
					leer.nextLine();
					return opcion;
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingrese solo valores num�ricos");
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
		
		Mec�nico mec�nico = new Mec�nico(ReadTypes.leerEntero(leer, "Ingrese el c�digo del Mec�nico"));
		
		
		
		while (!salir) {
			switch (actualizar(leer)) {
			case 0:
				salir = true;
				break;
			case 1:
				mec�nico.setNombre(ReadTypes.leerCadena(leer, "Ingrese el nuevo nombre del mec�nico "));
				break;
			case 2:
				mec�nico.setApellidos(ReadTypes.leerCadena(leer, "Ingrese el  nuevo apellido del mec�nico "));
				break;
			case 3:
				mec�nico.setTelfDomicilio(ReadTypes.leerEntero(leer, "Ingresar el nuevo tel�fono del Domicilio del mec�nico"));
				break;
			case 4:
				mec�nico.setCelular(ReadTypes.leerEntero(leer, "Ingresar el nuevo  tel�fono celular del mec�nico"));
				break;
			
			}
		}

	}

}

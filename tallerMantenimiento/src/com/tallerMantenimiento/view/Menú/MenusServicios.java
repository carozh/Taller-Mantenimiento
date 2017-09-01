package com.tallerMantenimiento.view.Men�;

import java.util.ArrayList;
import java.util.Scanner;

import com.tallerMantenimiento.control.Conexion;
import com.tallerMantenimiento.entity.Cliente;
import com.tallerMantenimiento.entity.Servicios;
import com.tallerMantenimiento.view.ClienteView;
import com.tallerMantenimiento.view.ReadTypes;
import com.tallerMantenimiento.view.ServiciosView;

public class MenusServicios {
	
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	
	
	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar Nombre del Servicio");
				System.out.println("2. Actualizar la descripcion del item");
				System.out.println("3. Actualizar precio del Servicio");
				System.out.println("4. Actualizar los diferentes tipos de servicios ");
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
	
	
	public static void menuModificar(Scanner scanner, Servicios servicios) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Nombre anterior: ");
				System.out.println(servicios.getNombre());
				String nombre = ReadTypes.leerCadena(scanner, "Ingrese el nuevo Nombre del Servicio: ");
				servicios.setNombre(nombre);
				break;
			case 2:
				System.out.print("Descripci�n anterior: ");
				System.out.println(servicios.getDescripci�n());
				String descripci�n = ReadTypes.leerCadena(scanner, "Ingrese la nueva descripci�n del Item: ");
				servicios.setDescripci�n(descripci�n);
				break;
			case 3:
				System.out.print("precio del Servicio anterior: ");
				System.out.println(servicios.getPrecio());
				int precio = ReadTypes.leerEntero(scanner, "Ingrese el nuevo precio del Servicio: ");
				servicios.setPrecio(precio);
				break;
			case 4:
				System.out.print("nombre de los diferentes tipos de servicios anteriores: ");
				System.out.println(servicios.getTipo());
				String tipo = ReadTypes.leerCadena(scanner, "Ingrese el nuevo tipo de servicio: ");
				servicios.setTipo(tipo);
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
				System.out.println("1. Ingresar servicios");
				System.out.println("2. Buscar ");
				System.out.println("3. Listar " );
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
		ServiciosView serviciosView = null;
		Servicios servicios = new Servicios(ReadTypes.leerEntero(leer, "Ingrese el c�digo de servicios"));
		

		while (!salir) {
			switch (menu(leer)) {
			case 0:
				salir = true;
				break;
			case 1:
				serviciosView = new ServiciosView(conexion, leer);
				serviciosView.insertar();
				try {
					serviciosView.insertar();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				//servicios = new Servicios(ReadTypes.leerEntero(leer, "Ingrese el c�digo de Servicio a buscar: "));
				try {
					serviciosView.buscar(ReadTypes.leerEntero(leer, "Ingrese el c�digo del servicio"));;
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				ArrayList<Servicios> servicio = null ;
				int tama�o;
				try {
					serviciosView.listar();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tama�o = servicio.size();
				for (int i = 0; i < tama�o; i++){
					System.out.println(servicio.get(i));
				}
				break;
			case 4:
				//cliente = new Cliente(ReadTypes.leerCadena(leer, "Ingrese el c�digo a actualizar: "));
				try {
					serviciosView.buscar(ReadTypes.leerEntero(leer, "Ingrese el c�digo del servicio"));;
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (servicios.getC�digoServicios() == 0) {
					System.out.println("C�digo Inexistente ");
				} else {
					System.out.println(servicios);
					System.out.println();
					subMenuActualizar(leer);
					System.out.println(servicios);
					try {
						serviciosView.actualizar();
						//clienteCtrl.update(cliente);
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
				System.out.println("2. Descripci�n ");
				System.out.println("3. Precio ");
				System.out.println("4. Tipo ");
				System.out.println("0. Salir");
				System.out.println();

				opcion = leer.nextInt();

				if (opcion >= 0 && opcion <= 6) {
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
		
		Servicios servicios = new Servicios(ReadTypes.leerEntero(leer, "Ingrese el c�digo del servicio"));
		
		
		
		while (!salir) {
			switch (actualizar(leer)) {
			case 0:
				salir = true;
				break;
			case 1:
				servicios.setNombre(ReadTypes.leerCadena(leer, "Ingrese el nuevo nombre del servicio "));
				break;
			case 2:
				servicios.setDescripci�n(ReadTypes.leerCadena(leer, "Ingrese la nueva descripci�n o item del servicio "));
				break;
			case 3:
				servicios.setPrecio(ReadTypes.leerEntero(leer, "Ingresar el nuevo precio del servicio"));
				break;
			case 4:
				servicios.setTipo(ReadTypes.leerCadena(leer, "Ingresar el nuevo tipo de servicios"));
				break;
						
			}
		}

	}
	
}

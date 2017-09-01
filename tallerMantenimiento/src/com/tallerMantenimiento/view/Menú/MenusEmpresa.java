package com.tallerMantenimiento.view.Men�;

import java.util.ArrayList;
import java.util.Scanner;

import com.tallerMantenimiento.control.ClienteCtrl;
import com.tallerMantenimiento.control.Conexion;
import com.tallerMantenimiento.control.EmpresaCtrl;
import com.tallerMantenimiento.entity.Cliente;
import com.tallerMantenimiento.entity.Empresa;
import com.tallerMantenimiento.view.ClienteView;
import com.tallerMantenimiento.view.EmpresaView;
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
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	
	public static int menu(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Ingresar datos de la Empresa");
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
		EmpresaView empresaView = null;
		Empresa empresa = new Empresa(ReadTypes.leerEntero(leer, "Ingrese el c�digo de la Empresa"));
		
		
	

		while (!salir) {
			switch (menu(leer)) {
			case 0:
				salir = true;
				break;
			case 1:
				empresaView = new EmpresaView(conexion, leer);
				empresaView.insertar();
				
				try {
					empresaView.insertar();
					
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				empresa = new Empresa(ReadTypes.leerEntero(leer, "Ingrese el c�digo de la Empresa"));
				
				try {
					empresaView.buscar(ReadTypes.leerEntero(leer, "Ingrese el c�digo de la Empresa"));
					
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				ArrayList<Empresa> empresas = null ;
				int tama�o;
				try {
					empresaView.listar();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tama�o = empresas.size();
				for (int i = 0; i < tama�o; i++){
					System.out.println(empresas.get(i));
				}
				break;
			case 4:
				empresa = new Empresa(ReadTypes.leerEntero(leer, "Ingrese el c�digo de la Empresa"));
				
				try {
					empresaView.buscar(ReadTypes.leerEntero(leer, "Ingrese el c�digo de la Empresa"));
					
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (empresa.getC�digoEmpresa() == 0) {
					System.out.println("C�digo Inexistente ");
				} else {
					System.out.println(empresa);
					System.out.println();
					subMenuActualizar(leer);
					System.out.println(empresa);
					try {
						empresaView.actualizar();
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
				System.out.println("2. Tel�fono ");
				System.out.println("3. Direcci�n ");
				System.out.println("0. Salir");
				System.out.println();

				opcion = leer.nextInt();

				if (opcion >= 0 && opcion <= 3) {
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
    
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public static void subMenuActualizar(Scanner leer) {
		boolean salir = false;
		
		
		Empresa empresa = new Empresa(ReadTypes.leerEntero(leer, "Ingrese el c�digo de la Empresa"));
		
		
		while (!salir) {
			switch (actualizar(leer)) {
			case 0:
				salir = true;
				break;
			case 1:
				empresa.setNombre(ReadTypes.leerCadena(leer, "Ingrese el nuevo nombre de la Empresa"));
				break;
			case 2:
				empresa.setTel�fono(ReadTypes.leerEntero(leer, "Ingrese el nuevo t�fono de la Empresa "));
				break;
			case 3:
				empresa.setDirecci�n(ReadTypes.leerCadena(leer, "Ingrese la nueva direcci�n de la Empresa"));
				break;
			
			
			}
		}

	}


}

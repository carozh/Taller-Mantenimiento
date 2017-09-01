package com.tallerMantenimiento.view.Menú;

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
				System.out.println("2. Actualizar Teléfono");
				System.out.println("3. Actualizar Dirección");
				System.out.println("0. Salir");
				System.out.println();

				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 3) {
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
				System.out.print("Teléfono anterior: ");
				System.out.println(empresa.getTeléfono());
				int teléfono = ReadTypes.leerEntero(scanner, "Ingrese el nuevo Teléfono: ");
				empresa.setTeléfono(teléfono);
				break;
			case 3:
				System.out.print("Dirección anterior: ");
				System.out.println(empresa.getDirección());
				String dirección = ReadTypes.leerCadena(scanner, "Ingrese la nueva Dirección: ");
				empresa.setDirección(dirección);
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
		EmpresaView empresaView = null;
		Empresa empresa = new Empresa(ReadTypes.leerEntero(leer, "Ingrese el código de la Empresa"));
		
		
	

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
				empresa = new Empresa(ReadTypes.leerEntero(leer, "Ingrese el código de la Empresa"));
				
				try {
					empresaView.buscar(ReadTypes.leerEntero(leer, "Ingrese el código de la Empresa"));
					
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				ArrayList<Empresa> empresas = null ;
				int tamaño;
				try {
					empresaView.listar();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tamaño = empresas.size();
				for (int i = 0; i < tamaño; i++){
					System.out.println(empresas.get(i));
				}
				break;
			case 4:
				empresa = new Empresa(ReadTypes.leerEntero(leer, "Ingrese el código de la Empresa"));
				
				try {
					empresaView.buscar(ReadTypes.leerEntero(leer, "Ingrese el código de la Empresa"));
					
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (empresa.getCódigoEmpresa() == 0) {
					System.out.println("Código Inexistente ");
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
				System.out.println("2. Teléfono ");
				System.out.println("3. Dirección ");
				System.out.println("0. Salir");
				System.out.println();

				opcion = leer.nextInt();

				if (opcion >= 0 && opcion <= 3) {
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
    
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public static void subMenuActualizar(Scanner leer) {
		boolean salir = false;
		
		
		Empresa empresa = new Empresa(ReadTypes.leerEntero(leer, "Ingrese el código de la Empresa"));
		
		
		while (!salir) {
			switch (actualizar(leer)) {
			case 0:
				salir = true;
				break;
			case 1:
				empresa.setNombre(ReadTypes.leerCadena(leer, "Ingrese el nuevo nombre de la Empresa"));
				break;
			case 2:
				empresa.setTeléfono(ReadTypes.leerEntero(leer, "Ingrese el nuevo téfono de la Empresa "));
				break;
			case 3:
				empresa.setDirección(ReadTypes.leerCadena(leer, "Ingrese la nueva dirección de la Empresa"));
				break;
			
			
			}
		}

	}


}

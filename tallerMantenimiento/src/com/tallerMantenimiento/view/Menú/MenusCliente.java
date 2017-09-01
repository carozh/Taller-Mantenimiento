package com.tallerMantenimiento.view.Men�;

import java.util.ArrayList;
import java.util.Scanner;
import com.tallerMantenimiento.control.Conexion;
import com.tallerMantenimiento.entity.Cliente;
import com.tallerMantenimiento.view.ClienteView;
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
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	
	
	public static int menu(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Ingresar cliente");
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
	
	//@SuppressWarnings("null")
	public static void subMenu(Scanner leer, Conexion conexion) {
		
		boolean salir = false;
		ClienteView clienteView;
		//Cliente cliente = new Cliente(ReadTypes.leerCadena(leer, "Ingrese el NIT del cliente"));
		//ClienteCtrl clienteCtrl = new ClienteCtrl(conexion);
	

		while (!salir) {
			switch (menu(leer)) {
			case 0:
				salir = true;
				break;
			case 1:
				clienteView = new ClienteView(conexion, leer);
				
				try {
					clienteView.insertar();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				
				//cliente = new Cliente(ReadTypes.leerCadena(leer, "Ingrese el NIT del cliente a buscar: "));
				clienteView = new ClienteView(conexion, leer);
				try {
					clienteView.buscar(ReadTypes.leerCadena(leer, "Ingrese el NIT del cliente"));;
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				ArrayList<Cliente> clientes;
				
				clienteView = new ClienteView(conexion, leer);
				clienteView.listar();
				
				break;
			case 4:
				Cliente cliente = new Cliente(ReadTypes.leerCadena(leer, "Ingrese el NIT del cliente a actualizar: "));
				/*try {
					clienteView.buscar(ReadTypes.leerCadena(leer, "Ingrese el NIT del cliente"));;
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				clienteView = new ClienteView(conexion, leer);
				if (cliente.getNIT() == null) {
					System.out.println("C�digo Inexistente ");
				} 
				else {
					/*System.out.println(cliente);
					System.out.println();*/
					menuModificar(leer, cliente);
					//System.out.println(cliente);
					try {
						clienteView.actualizar();
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
			System.out.println("2. Apellido ");
			System.out.println("3. Tel�fono Domicilio ");
			System.out.println("4. Tel�fono Oficina ");
			System.out.println("5. M�vil ");
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

/*public static void subMenuActualizar(Scanner leer) {
	boolean salir = false;
	
	//ClienteView clienteView = new ClienteView(conexion, leer);
	Cliente cliente = new Cliente(ReadTypes.leerCadena(leer, "Ingrese el NIT del cliente"));
	
	//cliente.setNombre(cliente);
	//iUProducto.setProducto(producto);
	
	
	while (!salir) {
		switch (actualizar(leer)) {
		case 0:
			salir = true;
			break;
		case 1:
			cliente.setNombre(ReadTypes.leerCadena(leer, "Ingrese el nuevo nombre del cliente "));
			break;
		case 2:
			cliente.setApellido(ReadTypes.leerCadena(leer, "Ingrese el nuevo apellido del cliente "));
			break;
		case 3:
			cliente.setTelfDomicilio(ReadTypes.leerEntero(leer, "Ingresar el nuevo tel�fono del Domicilio del cliente"));
			break;
		case 4:
			cliente.setTelfOficina(ReadTypes.leerEntero(leer, "Ingresar el nuevo tel�fono de la Oficina del cliente"));
			break;
		case 5:
			cliente.setM�vil(ReadTypes.leerEntero(leer, "Ingrese el nuevo n�mero del tel�fono m�vil del celular del cliente"));
			break;
		
		}
	}

}
*/

}

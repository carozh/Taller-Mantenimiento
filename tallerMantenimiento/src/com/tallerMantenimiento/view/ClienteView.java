package com.tallerMantenimiento.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.tallerMantenimiento.control.ClienteCtrl;
import com.tallerMantenimiento.control.Conexion;
import com.tallerMantenimiento.entity.Cliente;
import com.tallerMantenimiento.view.Menú.MenusCliente;


public class ClienteView {
	
	private Scanner scanner;
	private Cliente cliente;
	private ClienteCtrl clienteCtrl;
	
	public ClienteView(Conexion conexion, Scanner scanner){
		
		this.scanner = scanner;
		clienteCtrl = new  ClienteCtrl(conexion);
	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar() {
		
		String NIT;
		String nombre;
		String apellido;
		int telfDomicilio;
		int telfOficina;
		int móvil;

		NIT = ReadTypes.leerCadena(scanner, "Ingrese el NIT: ");
		nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre: ");
		apellido = ReadTypes.leerCadena(scanner, "Ingrese el primer apellido: ");
		telfDomicilio = ReadTypes.leerEntero(scanner, "Ingrese el teléfono de su Domicilio:");
		telfOficina = ReadTypes.leerEntero(scanner, "Ingrese el teléfono de su Oficina:");
		móvil = ReadTypes.leerEntero(scanner, "Ingrese el número de su teléfono celular:");
		
		cliente = new Cliente(NIT,nombre, apellido, telfDomicilio, telfOficina, móvil);

		
		try {
			clienteCtrl.insert(cliente);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {
		ArrayList<Cliente> clientes;

		try {
			clientes = clienteCtrl.list();
			for (int i = 0; i < clientes.size(); i++) {
				System.out.println(clientes.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(String NIT) {
		//solo mediante la llave primaria
		cliente = new Cliente(NIT);
		try {
			clienteCtrl.search(cliente);
			System.out.println(cliente);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
		String NIT;
			
		NIT = ReadTypes.leerCadena(scanner, "Ingrese el NIT del cliente a modificar; ");
		cliente = new Cliente(NIT);
		
		
		try {
			clienteCtrl.search(cliente);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusCliente.menuModificar(scanner, cliente);

		try {
			clienteCtrl.update(cliente);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}

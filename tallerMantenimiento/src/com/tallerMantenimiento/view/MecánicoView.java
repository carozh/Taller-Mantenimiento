package com.tallerMantenimiento.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.tallerMantenimiento.control.Conexion;
import com.tallerMantenimiento.control.MecánicoCtrl;
import com.tallerMantenimiento.entity.Mecánico;
import com.tallerMantenimiento.view.Menú.MenusMecánico;

public class MecánicoView {
	
	private Scanner scanner;
	private Mecánico mecánico;
	private MecánicoCtrl mecánicoCtrl;
	
	public MecánicoView(Conexion conexion, Scanner scanner){
		
		this.scanner = scanner;
		mecánicoCtrl = new MecánicoCtrl(conexion);
	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar() {
		
		int códigoMecánico;
		String nombre;
		String apellidos;
		int telfDomicilio;
		int celular;
		

		códigoMecánico = ReadTypes.leerEntero(scanner, "Ingrese el código del Mecánico: ");
		nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre: ");
		apellidos = ReadTypes.leerCadena(scanner, "Ingrese los apellidos: ");
		telfDomicilio = ReadTypes.leerEntero(scanner, "Ingrese el teléfono de su Domicilio:");
		celular = ReadTypes.leerEntero(scanner, "Ingrese el celular:");
		
		
		mecánico = new Mecánico(códigoMecánico,nombre, apellidos, telfDomicilio, celular);

		
		try {
			mecánicoCtrl.insert(mecánico);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {
		ArrayList<Mecánico> mecánicos;

		try {
			mecánicos = mecánicoCtrl.list();
			for (int i = 0; i < mecánicos.size(); i++) {
				System.out.println(mecánicos.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int códigoMecánico) {
		//solo mediante la llave primaria
		mecánico = new Mecánico(códigoMecánico);
		try {
			mecánicoCtrl.search(mecánico);
			System.out.println(mecánico);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
		int códigoMecánico;
			
		códigoMecánico = ReadTypes.leerEntero(scanner, "Ingrese el código del Mecánico a modificar; ");
		mecánico = new Mecánico(códigoMecánico);
		
		
		try {
			mecánicoCtrl.search(mecánico);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusMecánico.menuModificar(scanner, mecánico);

		try {
			mecánicoCtrl.update(mecánico);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	

}

package com.tallerMantenimiento.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.tallerMantenimiento.control.Conexion;
import com.tallerMantenimiento.control.Mec�nicoCtrl;
import com.tallerMantenimiento.entity.Mec�nico;
import com.tallerMantenimiento.view.Men�.MenusMec�nico;

public class Mec�nicoView {
	
	private Scanner scanner;
	private Mec�nico mec�nico;
	private Mec�nicoCtrl mec�nicoCtrl;
	
	public Mec�nicoView(Conexion conexion, Scanner scanner){
		
		this.scanner = scanner;
		mec�nicoCtrl = new Mec�nicoCtrl(conexion);
	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar() {
		
		int c�digoMec�nico;
		String nombre;
		String apellidos;
		int telfDomicilio;
		int celular;
		

		c�digoMec�nico = ReadTypes.leerEntero(scanner, "Ingrese el c�digo del Mec�nico: ");
		nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre: ");
		apellidos = ReadTypes.leerCadena(scanner, "Ingrese los apellidos: ");
		telfDomicilio = ReadTypes.leerEntero(scanner, "Ingrese el tel�fono de su Domicilio:");
		celular = ReadTypes.leerEntero(scanner, "Ingrese el celular:");
		
		
		mec�nico = new Mec�nico(c�digoMec�nico,nombre, apellidos, telfDomicilio, celular);

		
		try {
			mec�nicoCtrl.insert(mec�nico);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {
		ArrayList<Mec�nico> mec�nicos;

		try {
			mec�nicos = mec�nicoCtrl.list();
			for (int i = 0; i < mec�nicos.size(); i++) {
				System.out.println(mec�nicos.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int c�digoMec�nico) {
		//solo mediante la llave primaria
		mec�nico = new Mec�nico(c�digoMec�nico);
		try {
			mec�nicoCtrl.search(mec�nico);
			System.out.println(mec�nico);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
		int c�digoMec�nico;
			
		c�digoMec�nico = ReadTypes.leerEntero(scanner, "Ingrese el c�digo del Mec�nico a modificar; ");
		mec�nico = new Mec�nico(c�digoMec�nico);
		
		
		try {
			mec�nicoCtrl.search(mec�nico);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusMec�nico.menuModificar(scanner, mec�nico);

		try {
			mec�nicoCtrl.update(mec�nico);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	

}

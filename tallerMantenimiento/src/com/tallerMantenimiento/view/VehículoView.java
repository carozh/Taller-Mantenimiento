package com.tallerMantenimiento.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.tallerMantenimiento.control.Conexion;
import com.tallerMantenimiento.control.Veh�culoCtrl;
import com.tallerMantenimiento.entity.Veh�culo;
import com.tallerMantenimiento.view.Men�.MenusVeh�culo;

public class Veh�culoView {
	
	private Scanner scanner;
	private Veh�culo veh�culo;
	private Veh�culoCtrl veh�culoCtrl;
	
	public Veh�culoView(Conexion conexion, Scanner scanner){
		
		this.scanner = scanner;
		veh�culoCtrl = new Veh�culoCtrl(conexion);
	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar() {
		
		String chasis;
		String marca;
		String clase;
		String tipo;
		String color;
		int a�o;
		String placa;
		int kilometraje;
		String NIT;

		chasis = ReadTypes.leerCadena(scanner, "Ingrese el chasis: ");
		marca = ReadTypes.leerCadena(scanner, "Ingrese la marca: ");
		clase = ReadTypes.leerCadena(scanner, "Ingrese la clase: ");
		tipo = ReadTypes.leerCadena(scanner, "Ingrese el tipo: ");
		color = ReadTypes.leerCadena(scanner, "Ingrese el color: ");
		a�o = ReadTypes.leerEntero(scanner, "Ingrese el a�o:");
		placa = ReadTypes.leerCadena(scanner, "Ingrese la placa: ");
		kilometraje = ReadTypes.leerEntero(scanner, "Ingrese el kilometraje:");
		NIT = ReadTypes.leerCadena(scanner, "Ingrese el NIT del cliente: ");
		
		veh�culo = new Veh�culo(chasis, marca, clase, tipo, color, a�o, placa, kilometraje, NIT);

		
		try {
			veh�culoCtrl.insert(veh�culo);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {
		ArrayList<Veh�culo> veh�culos;

		try {
			veh�culos = veh�culoCtrl.list();
			for (int i = 0; i < veh�culos.size(); i++) {
				System.out.println(veh�culos.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(String chasis) {
		//solo mediante la llave primaria
		veh�culo = new Veh�culo(chasis);
		try {
			veh�culoCtrl.search(veh�culo);
			System.out.println(veh�culo);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
		String chasis;
			
		chasis = ReadTypes.leerCadena(scanner, "Ingrese el chasis del veh�culo a modificar; ");
		veh�culo = new Veh�culo(chasis);
		
		
		try {
			veh�culoCtrl.search(veh�culo);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusVeh�culo.menuModificar(scanner, veh�culo);

		try {
			veh�culoCtrl.update(veh�culo);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
	

}

package com.tallerMantenimiento.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.tallerMantenimiento.control.Conexion;
import com.tallerMantenimiento.control.VehículoCtrl;
import com.tallerMantenimiento.entity.Vehículo;
import com.tallerMantenimiento.view.Menú.MenusVehículo;

public class VehículoView {
	
	private Scanner scanner;
	private Vehículo vehículo;
	private VehículoCtrl vehículoCtrl;
	
	public VehículoView(Conexion conexion, Scanner scanner){
		
		this.scanner = scanner;
		vehículoCtrl = new VehículoCtrl(conexion);
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
		int año;
		String placa;
		int kilometraje;
		String NIT;

		chasis = ReadTypes.leerCadena(scanner, "Ingrese el chasis: ");
		marca = ReadTypes.leerCadena(scanner, "Ingrese la marca: ");
		clase = ReadTypes.leerCadena(scanner, "Ingrese la clase: ");
		tipo = ReadTypes.leerCadena(scanner, "Ingrese el tipo: ");
		color = ReadTypes.leerCadena(scanner, "Ingrese el color: ");
		año = ReadTypes.leerEntero(scanner, "Ingrese el año:");
		placa = ReadTypes.leerCadena(scanner, "Ingrese la placa: ");
		kilometraje = ReadTypes.leerEntero(scanner, "Ingrese el kilometraje:");
		NIT = ReadTypes.leerCadena(scanner, "Ingrese el NIT del cliente: ");
		
		vehículo = new Vehículo(chasis, marca, clase, tipo, color, año, placa, kilometraje, NIT);

		
		try {
			vehículoCtrl.insert(vehículo);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {
		ArrayList<Vehículo> vehículos;

		try {
			vehículos = vehículoCtrl.list();
			for (int i = 0; i < vehículos.size(); i++) {
				System.out.println(vehículos.get(i));
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
		vehículo = new Vehículo(chasis);
		try {
			vehículoCtrl.search(vehículo);
			System.out.println(vehículo);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
		String chasis;
			
		chasis = ReadTypes.leerCadena(scanner, "Ingrese el chasis del vehículo a modificar; ");
		vehículo = new Vehículo(chasis);
		
		
		try {
			vehículoCtrl.search(vehículo);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusVehículo.menuModificar(scanner, vehículo);

		try {
			vehículoCtrl.update(vehículo);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
	

}

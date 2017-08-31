package com.tallerMantenimiento.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.tallerMantenimiento.control.Conexion;
import com.tallerMantenimiento.control.EmpresaCtrl;
import com.tallerMantenimiento.entity.Empresa;
import com.tallerMantenimiento.view.Menú.MenusEmpresa;

public class EmpresaView {
	
	private Scanner scanner;
	private Empresa empresa;
	private EmpresaCtrl empresaCtrl;
	
	public EmpresaView(Conexion conexion, Scanner scanner){
		
		this.scanner = scanner;
		empresaCtrl = new EmpresaCtrl(conexion);
	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar() {
		
		int códigoEmpresa;
		String nombre;
		int teléfono;
		String dirección;
		

		códigoEmpresa = ReadTypes.leerEntero(scanner, "Ingrese el código de Empresa: ");
		nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre: ");
		teléfono = ReadTypes.leerEntero(scanner, "Ingrese el teléfono:");
		dirección = ReadTypes.leerCadena(scanner, "Ingrese la dirección: ");
		
		
		empresa = new Empresa(códigoEmpresa,nombre, teléfono, dirección);

		
		try {
			empresaCtrl.insert(empresa);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {
		ArrayList<Empresa> empresas;

		try {
			empresas = empresaCtrl.list();
			for (int i = 0; i < empresas.size(); i++) {
				System.out.println(empresas.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int códigoEmpresa) {
		//solo mediante la llave primaria
		empresa = new Empresa(códigoEmpresa);
		try {
			empresaCtrl.search(empresa);
			System.out.println(empresa);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
		int códigoEmpresa;
			
		códigoEmpresa = ReadTypes.leerEntero(scanner, "Ingrese el código de Empresa a modificar; ");
		empresa = new Empresa(códigoEmpresa);
		
		
		try {
			empresaCtrl.search(empresa);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusEmpresa.menuModificar(scanner, empresa);

		try {
			empresaCtrl.update(empresa);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

}

package com.tallerMantenimiento.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.tallerMantenimiento.control.Conexion;
import com.tallerMantenimiento.control.EmpresaCtrl;
import com.tallerMantenimiento.entity.Empresa;
import com.tallerMantenimiento.view.Men�.MenusEmpresa;

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
		
		int c�digoEmpresa;
		String nombre;
		int tel�fono;
		String direcci�n;
		

		c�digoEmpresa = ReadTypes.leerEntero(scanner, "Ingrese el c�digo de Empresa: ");
		nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre: ");
		tel�fono = ReadTypes.leerEntero(scanner, "Ingrese el tel�fono:");
		direcci�n = ReadTypes.leerCadena(scanner, "Ingrese la direcci�n: ");
		
		
		empresa = new Empresa(c�digoEmpresa,nombre, tel�fono, direcci�n);

		
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
	public void buscar(int c�digoEmpresa) {
		//solo mediante la llave primaria
		empresa = new Empresa(c�digoEmpresa);
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
		int c�digoEmpresa;
			
		c�digoEmpresa = ReadTypes.leerEntero(scanner, "Ingrese el c�digo de Empresa a modificar; ");
		empresa = new Empresa(c�digoEmpresa);
		
		
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

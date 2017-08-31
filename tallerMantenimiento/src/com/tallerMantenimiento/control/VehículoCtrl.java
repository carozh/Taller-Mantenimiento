package com.tallerMantenimiento.control;


import java.sql.ResultSet;
import java.util.ArrayList;
import com.tallerMantenimiento.entity.Veh�culo;

public class Veh�culoCtrl implements Control<Veh�culo> {
	
	private Conexion conexion;
	
	public Veh�culoCtrl(Conexion conexion){
		this.conexion = conexion;
	}
	
	/*
	 * *****************************************************************************
	 * List
	 ******************************************************************************/
	
	public ArrayList<Veh�culo> list() throws Throwable {
		//se encarga de listar a todos los veh�culos 
		ArrayList<Veh�culo> veh�culos = new ArrayList<Veh�culo>();
		ResultSet rs;
		String chasis;
		String marca;
		String clase;
		String tipo;
		String color;
		int a�o;
		String placa;
		int kilometraje;
		String NIT;

		conexion.SQL("Select * from cliente");

		rs = conexion.resultSet();

		while (rs.next()) {
			
			chasis = rs.getString("chasis");
			marca = rs.getString("marca");
			clase = rs.getString("clase");
			tipo = rs.getString("tipo");
			color = rs.getString("color");
			a�o = rs.getInt("a�o");
			placa = rs.getString("placa");
			kilometraje = rs.getInt("kilometraje");
			NIT = rs.getString("NIT");
			veh�culos.add(new Veh�culo(chasis, marca, clase, tipo, color, a�o, placa, kilometraje, NIT));
			
		}

		return veh�culos;

	}
	
	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	public void insert(Veh�culo veh�culo) throws Throwable {

		conexion.SQL("Insert into veh�culo(chasis, marca, clase, tipo, color, a�o, placa, kilometraje, NIT) VALUES(?,?,?,?,?,?,?,?,?)");
		// ? SON PARAMETROS
		conexion.preparedStatement().setString(1, veh�culo.getChasis());
		conexion.preparedStatement().setString(2, veh�culo.getMarca());
		conexion.preparedStatement().setString(3, veh�culo.getClase());
		conexion.preparedStatement().setString(4, veh�culo.getTipo());
		conexion.preparedStatement().setString(5, veh�culo.getColor());
		conexion.preparedStatement().setInt(6, veh�culo.getA�o());
		conexion.preparedStatement().setString(7, veh�culo.getPlaca());
		conexion.preparedStatement().setInt(8, veh�culo.getKilometraje());
		conexion.preparedStatement().setString(9, veh�culo.getNIT());
		
		//Vamos a mandar una cadena de caracteres
		conexion.CUD();
	}
	
	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search(Veh�culo veh�culo) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from veh�culo where chasis=?");
		conexion.preparedStatement().setString(1, veh�culo.getChasis());
		rs = conexion.resultSet();

		while (rs.next()) {

			veh�culo.setMarca(rs.getString("marca"));
		}

		rs.close();

	}
	
	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update(Veh�culo veh�culo) throws Throwable {
		String chasis;
		String marca;
		String clase;
		String tipo;
		String color;
		int a�o;
		String placa;
		int kilometraje;
		String NIT;
		
		if (veh�culo != null) {
			
			chasis = veh�culo.getChasis();
			marca = veh�culo.getMarca();
			clase = veh�culo.getClase();
			tipo = veh�culo.getTipo();
			color = veh�culo.getColor();
			a�o = veh�culo.getA�o();
			placa = veh�culo.getPlaca();
			kilometraje = veh�culo.getKilometraje();
			NIT = veh�culo.getNIT();
			
					

			conexion.SQL("Update veh�culo set marca = ?, clase = ?, tipo = ?, color = ?, a�o = ?, placa = ?, kilometraje = ?, NIT = ? where chasis=?");
			conexion.preparedStatement().setString(1, marca);
			conexion.preparedStatement().setString(2, clase);
			conexion.preparedStatement().setString(3, tipo);
			conexion.preparedStatement().setString(4, color);
			conexion.preparedStatement().setInt(5, a�o);
			conexion.preparedStatement().setString(6, placa);
			conexion.preparedStatement().setInt(7, kilometraje);
			conexion.preparedStatement().setString(8, NIT);
			conexion.preparedStatement().setString(9, chasis);
			conexion.CUD();
			
		}
	}


	
	

}

package com.tallerMantenimiento.control;


import java.sql.ResultSet;
import java.util.ArrayList;
import com.tallerMantenimiento.entity.Vehículo;

public class VehículoCtrl implements Control<Vehículo> {
	
	private Conexion conexion;
	
	public VehículoCtrl(Conexion conexion){
		this.conexion = conexion;
	}
	
	/*
	 * *****************************************************************************
	 * List
	 ******************************************************************************/
	
	public ArrayList<Vehículo> list() throws Throwable {
		//se encarga de listar a todos los vehículos 
		ArrayList<Vehículo> vehículos = new ArrayList<Vehículo>();
		ResultSet rs;
		String chasis;
		String marca;
		String clase;
		String tipo;
		String color;
		int año;
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
			año = rs.getInt("año");
			placa = rs.getString("placa");
			kilometraje = rs.getInt("kilometraje");
			NIT = rs.getString("NIT");
			vehículos.add(new Vehículo(chasis, marca, clase, tipo, color, año, placa, kilometraje, NIT));
			
		}

		return vehículos;

	}
	
	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	public void insert(Vehículo vehículo) throws Throwable {

		conexion.SQL("Insert into vehículo(chasis, marca, clase, tipo, color, año, placa, kilometraje, NIT) VALUES(?,?,?,?,?,?,?,?,?)");
		// ? SON PARAMETROS
		conexion.preparedStatement().setString(1, vehículo.getChasis());
		conexion.preparedStatement().setString(2, vehículo.getMarca());
		conexion.preparedStatement().setString(3, vehículo.getClase());
		conexion.preparedStatement().setString(4, vehículo.getTipo());
		conexion.preparedStatement().setString(5, vehículo.getColor());
		conexion.preparedStatement().setInt(6, vehículo.getAño());
		conexion.preparedStatement().setString(7, vehículo.getPlaca());
		conexion.preparedStatement().setInt(8, vehículo.getKilometraje());
		conexion.preparedStatement().setString(9, vehículo.getNIT());
		
		//Vamos a mandar una cadena de caracteres
		conexion.CUD();
	}
	
	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search(Vehículo vehículo) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from vehículo where chasis=?");
		conexion.preparedStatement().setString(1, vehículo.getChasis());
		rs = conexion.resultSet();

		while (rs.next()) {

			vehículo.setMarca(rs.getString("marca"));
		}

		rs.close();

	}
	
	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update(Vehículo vehículo) throws Throwable {
		String chasis;
		String marca;
		String clase;
		String tipo;
		String color;
		int año;
		String placa;
		int kilometraje;
		String NIT;
		
		if (vehículo != null) {
			
			chasis = vehículo.getChasis();
			marca = vehículo.getMarca();
			clase = vehículo.getClase();
			tipo = vehículo.getTipo();
			color = vehículo.getColor();
			año = vehículo.getAño();
			placa = vehículo.getPlaca();
			kilometraje = vehículo.getKilometraje();
			NIT = vehículo.getNIT();
			
					

			conexion.SQL("Update vehículo set marca = ?, clase = ?, tipo = ?, color = ?, año = ?, placa = ?, kilometraje = ?, NIT = ? where chasis=?");
			conexion.preparedStatement().setString(1, marca);
			conexion.preparedStatement().setString(2, clase);
			conexion.preparedStatement().setString(3, tipo);
			conexion.preparedStatement().setString(4, color);
			conexion.preparedStatement().setInt(5, año);
			conexion.preparedStatement().setString(6, placa);
			conexion.preparedStatement().setInt(7, kilometraje);
			conexion.preparedStatement().setString(8, NIT);
			conexion.preparedStatement().setString(9, chasis);
			conexion.CUD();
			
		}
	}


	
	

}

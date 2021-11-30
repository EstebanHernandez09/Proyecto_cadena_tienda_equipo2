package com.equipo2.misiontic2022.tiendasgenericas.tiendavirtual.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "consolidado")
public class Consolidado {
	@Id
	private String id;
	private String ciudad;
	private int id_consolidado;
	private double total_ventas;
	
	//constructores
	public Consolidado() {
		
	}

	public Consolidado(String ciudad, int id_consolidado, double total_ventas) {
		super();
		this.ciudad = ciudad;
		this.id_consolidado = id_consolidado;
		this.total_ventas = total_ventas;
	}
	
	//getters and setters

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getId_consolidado() {
		return id_consolidado;
	}

	public void setId_consolidado(int id_consolidado) {
		this.id_consolidado = id_consolidado;
	}

	public double getTotal_ventas() {
		return total_ventas;
	}

	public void setTotal_ventas(double total_ventas) {
		this.total_ventas = total_ventas;
	}
	
	
}

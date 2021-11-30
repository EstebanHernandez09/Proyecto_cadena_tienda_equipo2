package com.equipo2.misiontic2022.tiendasgenericas.tiendavirtual.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes")
public class Clientes {
	@Id
	private String id;
	private String cedulacliente;
	private String direccion_cliente;
	private String email_cliente;
	private String nombre_cliente;
	private String telefono_cliente;
	
	//constructores
	public Clientes() {
		
	}

	public Clientes(String cedulacliente, String direccion_cliente, String email_cliente,
			String nombre_cliente, String telefono_cliente) {
		super();
		this.cedulacliente = cedulacliente;
		this.direccion_cliente = direccion_cliente;
		this.email_cliente = email_cliente;
		this.nombre_cliente = nombre_cliente;
		this.telefono_cliente = telefono_cliente;
	}

	//getter and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCedulacliente() {
		return cedulacliente;
	}

	public void setCedulacliente(String cedulacliente) {
		this.cedulacliente = cedulacliente;
	}

	public String getDireccion_cliente() {
		return direccion_cliente;
	}

	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}

	public String getEmail_cliente() {
		return email_cliente;
	}

	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getTelefono_cliente() {
		return telefono_cliente;
	}

	public void setTelefono_cliente(String telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}
	
}

package com.equipo2.misiontic2022.tiendasgenericas.tiendavirtual.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productos")
public class Productos {
	@Id
	private String id;
	
	@Indexed(unique=true)
	private Long codigoproducto;
	private Double ivacompra;
	private Long nitproveedor;
	private String nombreproducto;
	private Double preciocompra;
	private Double precioventa;
	
	//constructores
	public Productos() {
		
	}

	public Productos(Long codigoproducto, double ivacompra, Long nitproveedor, String nombreproducto,
			double preciocompra, double precioventa) {
		super();
		this.codigoproducto = codigoproducto;
		this.ivacompra = ivacompra;
		this.nitproveedor = nitproveedor;
		this.nombreproducto = nombreproducto;
		this.preciocompra = preciocompra;
		this.precioventa = precioventa;
	}
	
	//getters and setters

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getCodigoproducto() {
		return codigoproducto;
	}

	public void setCodigoproducto(Long codigoproducto) {
		this.codigoproducto = codigoproducto;
	}

	public double getIvacompra() {
		return ivacompra;
	}

	public void setIvacompra(double ivacompra) {
		this.ivacompra = ivacompra;
	}

	public Long getNitproveedor() {
		return nitproveedor;
	}

	public void setNitproveedor(Long nitproveedor) {
		this.nitproveedor = nitproveedor;
	}

	public String getNombreproducto() {
		return nombreproducto;
	}

	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}

	public double getPreciocompra() {
		return preciocompra;
	}

	public void setPreciocompra(double preciocompra) {
		this.preciocompra = preciocompra;
	}

	public double getPrecioventa() {
		return precioventa;
	}

	public void setPrecioventa(double precioventa) {
		this.precioventa = precioventa;
	}
	
}

package com.equipo2.misiontic2022.tiendasgenericas.tiendavirtual.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.equipo2.misiontic2022.tiendasgenericas.tiendavirtual.model.Productos;
import com.equipo2.misiontic2022.tiendasgenericas.tiendavirtual.repository.ProductosRepository;

@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProductosController {
	@Autowired
	ProductosRepository productosRepository;
	
	
	//buscar todos los productos
	@GetMapping("/productos")
	public ResponseEntity<List<Productos>> getAllProductos(@RequestParam(required = false) String nombreproducto) {
		try {
			List<Productos> productos = new ArrayList<Productos>();
			
			if(nombreproducto == null) {
				productosRepository.findAll().forEach(productos::add);			
				}else {
					productosRepository.findByNombreproducto(nombreproducto).forEach(productos::add);
			}
			
			if(productos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(productos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//buscar por id de producto
	@GetMapping("/productos/{id}")
	public ResponseEntity<Productos> getProductosById(@PathVariable("id") String id) {
		Optional<Productos> productoData = productosRepository.findById(id);
		
		if(productoData.isPresent()) {
			return new ResponseEntity<>(productoData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//ingresar varios productos
	@PostMapping("/productos")
	public ResponseEntity<Productos> createProductos(@RequestBody Productos producto) {
		try {
			Productos _productos = productosRepository.save(new Productos(producto.getCodigoproducto(), producto.getIvacompra(), producto.getNitproveedor(), producto.getNombreproducto(), producto.getPreciocompra(), producto.getPrecioventa()));
			return new ResponseEntity<>(_productos, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//actualizar un producto
	@PutMapping("/productos/{id}")
	  public ResponseEntity<Productos> updateProducto(@PathVariable("id") String id, @RequestBody Productos producto) {
	    Optional<Productos> productoData = productosRepository.findById(id);

	    if (productoData.isPresent()) {
	    	Productos _producto = productoData.get();
	    	_producto.setCodigoproducto(producto.getCodigoproducto());
	    	_producto.setIvacompra(producto.getIvacompra());
	    	_producto.setNitproveedor(producto.getNitproveedor());
	    	_producto.setNombreproducto(producto.getNombreproducto());
	    	_producto.setPreciocompra(producto.getPreciocompra());
	    	_producto.setPrecioventa(producto.getPrecioventa());
	      return new ResponseEntity<>(productosRepository.save(_producto), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	
	 //eliminar un producto definido
	  @DeleteMapping("/productos/{id}")
	  public ResponseEntity<HttpStatus> deleteProducto(@PathVariable("id") String id) {
	    try {
	    	productosRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  
	  //eliminar todos los productos
	  @DeleteMapping("productos/")
	  public ResponseEntity<HttpStatus> deleteAllProductos() {
	    try {
	    	productosRepository.deleteAll();
	      return new ResponseEntity<>(HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	//buscar por codigo de producto

	 @GetMapping("/productos/codigo/{codigoproducto}")
	  public ResponseEntity<List<Productos>> findByCodigoproducto(@PathVariable("codigoproducto") Long codigoproducto) {
	    try {
	      List<Productos> productos = productosRepository.findByCodigoproducto(codigoproducto);

	      if (productos.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(productos, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}

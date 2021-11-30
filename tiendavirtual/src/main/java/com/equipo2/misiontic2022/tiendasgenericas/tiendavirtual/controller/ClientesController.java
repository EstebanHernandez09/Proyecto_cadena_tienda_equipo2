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

import com.equipo2.misiontic2022.tiendasgenericas.tiendavirtual.model.Clientes;
import com.equipo2.misiontic2022.tiendasgenericas.tiendavirtual.repository.ClientesRepository;



@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ClientesController {
	@Autowired
	ClientesRepository clientesRepository;
	
	
	//busacr todos los clientes
	@GetMapping("/clientes")
	public ResponseEntity<List<Clientes>> getAllClientes(@RequestParam(required = false) String cedulacliente) {
		try {
			List<Clientes> clientes = new ArrayList<Clientes>();
			
			if(cedulacliente == null) {
				clientesRepository.findAll().forEach(clientes::add);			
				}else {
				clientesRepository.findByCedulacliente(cedulacliente).forEach(clientes::add);
			}
			
			if(clientes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(clientes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//buscar por id de cliente
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Clientes> getClientesById(@PathVariable("id") String id) {
		Optional<Clientes> clienteData = clientesRepository.findById(id);
		
		if(clienteData.isPresent()) {
			return new ResponseEntity<>(clienteData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//ingresar varios usuarios
	@PostMapping("/clientes")
	public ResponseEntity<Clientes> createClientes(@RequestBody Clientes cliente) {
		try {
			Clientes _clientes = clientesRepository.save(new Clientes(cliente.getCedulacliente(), cliente.getDireccion_cliente(), cliente.getEmail_cliente(), cliente.getNombre_cliente(), cliente.getTelefono_cliente()));
			return new ResponseEntity<>(_clientes, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//actualizar un usuario
	@PutMapping("/clientes/{id}")
	  public ResponseEntity<Clientes> updateCliente(@PathVariable("id") String id, @RequestBody Clientes cliente) {
	    Optional<Clientes> clienteData = clientesRepository.findById(id);

	    if (clienteData.isPresent()) {
	    	Clientes _cliente = clienteData.get();
	    	_cliente.setCedulacliente(cliente.getCedulacliente());
	    	_cliente.setDireccion_cliente(cliente.getDireccion_cliente());
	    	_cliente.setEmail_cliente(cliente.getEmail_cliente());
	    	_cliente.setNombre_cliente(cliente.getNombre_cliente());
	    	_cliente.setTelefono_cliente(cliente.getTelefono_cliente());
	      return new ResponseEntity<>(clientesRepository.save(_cliente), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	
	 //eliminar un cliente definido
	  @DeleteMapping("/clientes/{id}")
	  public ResponseEntity<HttpStatus> deleteClientes(@PathVariable("id") String id) {
	    try {
	      clientesRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  
	  //eliminar todos los clientes
	  @DeleteMapping("/clientes")
	  public ResponseEntity<HttpStatus> deleteAllClientes() {
	    try {
	      clientesRepository.deleteAll();
	      return new ResponseEntity<>(HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	//buscar por cedula de cliente

	 /* @GetMapping("/clientes/buscar/{cedulacliente}")
	  public ResponseEntity<List<Clientes>> findByCedulacliente(@PathVariable("cedulacliente") String cedulacliente) {
	    try {
	      List<Clientes> clientes = clientesRepository.findByCedulacliente(cedulacliente);

	      if (clientes.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(clientes, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }*/
	  
}

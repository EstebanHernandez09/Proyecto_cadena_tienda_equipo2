package com.equipo2.misiontic2022.tiendasgenericas.tiendavirtual.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.equipo2.misiontic2022.tiendasgenericas.tiendavirtual.model.Clientes;


public interface ClientesRepository extends MongoRepository<Clientes, String>{
	List<Clientes> findByCedulacliente(String cedulacliente);
}

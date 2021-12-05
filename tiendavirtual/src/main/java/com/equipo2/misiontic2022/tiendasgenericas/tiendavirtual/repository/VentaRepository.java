package com.equipo2.misiontic2022.tiendasgenericas.tiendavirtual.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.equipo2.misiontic2022.tiendasgenericas.tiendavirtual.model.Venta;

public interface VentaRepository extends MongoRepository<Venta, String>{
	List<Venta> findByCodigoventa(Long codigoventa);
	List<Venta> findByCedulacliente(Long cedulacliente);
	
	
	void deleteByCodigoventa(Long codigoventa);
	void deleteByCedulacliente(Long cedulacliente);
}

package com.equipo2.misiontic2022.tiendasgenericas.tiendavirtual.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.equipo2.misiontic2022.tiendasgenericas.tiendavirtual.model.Productos;

public interface ProductosRepository extends MongoRepository<Productos, String>{
	List<Productos> findByCodigoproducto(Long codigoproducto);
	List<Productos> findByNombreproducto(String nombreproducto);
}

package org.XpertCode.VengadoresDeLaLimpieza.services;

import java.util.Optional;

import org.XpertCode.VengadoresDeLaLimpieza.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
	//	Producto es de Producto.java
@Query("SELECT p FROM Producto p WHERE p.nombre=?1")  // ? indica que es un par�metro, si hubiera otro ser�a ?2 y as� // 
Optional<Producto> findByNombre(String nombre);  //quiero un opciontal de tipo producto, es lo que arroja el find

}

package org.XpertCode.VengadoresDeLaLimpieza.services;

import java.util.Optional;

import org.XpertCode.VengadoresDeLaLimpieza.models.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {
	
@Query("SELECT p FROM Servicio p WHERE p.nombre=?1")  // ? indica que es un parámetro, si hubiera otro sería ?2 y así // 
Optional<Servicio> findByNombre(String nombre);  //quiero un opciontal de tipo producto, es lo que arroja el find

}

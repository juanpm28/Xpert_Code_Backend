package org.XpertCode.VengadoresDeLaLimpieza.services;

import java.util.Optional;

import org.XpertCode.VengadoresDeLaLimpieza.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
@Query("SELECT u FROM Usuario u WHERE u.correo=?1")  // ? indica que es un par�metro, si hubiera otro ser�a ?2 y as� // 
Optional<Usuario> findByCorreo(String correo);  //quiero un opciontal de tipo producto, es lo que arroja el find

}

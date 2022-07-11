package org.XpertCode.VengadoresDeLaLimpieza.services;

import java.util.Optional;

import org.XpertCode.VengadoresDeLaLimpieza.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
@Query("SELECT p FROM Usuario p WHERE p.correo=?1")  // ? indica que es un parámetro, si hubiera otro sería ?2 y así // 
Optional<Usuario> findByCorreo(String correo);  //quiero un opciontal de tipo producto, es lo que arroja el find

@Query("SELECT h FROM Usuario h WHERE h.correo=?1 AND h.contrasena=?2")
Optional<Usuario> findByCorreoAndContrasena(String correo, String contrasena);


}

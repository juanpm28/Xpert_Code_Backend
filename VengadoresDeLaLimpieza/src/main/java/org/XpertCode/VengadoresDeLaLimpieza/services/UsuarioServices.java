package org.XpertCode.VengadoresDeLaLimpieza.services;

import java.util.List;
import java.util.Optional;

import org.XpertCode.VengadoresDeLaLimpieza.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServices {

	
	private final UsuarioRepository usuarioRepository;  //constante del repositorio dentro de services para conectame a la base de datos

	@Autowired
	public UsuarioServices(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	} //inyección de dependencias por constructor
	
	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}//get para mapear todos los usuarios
	
	public Usuario getUsuario(Long id) {
		return usuarioRepository.findById(id).orElseThrow(
				()->new IllegalArgumentException("El Usuario con el id " + id + " no existe.")
				);
	}//getUsuarios, para obtener get por ID
	
	
	public Usuario addUsuario(Usuario usuario) {  //buscar mejor por SKU
		Usuario tmpUsuario = null;
		Optional<Usuario> usuarioByCorreo = usuarioRepository.findByCorreo(usuario.getCorreo());
		
		if(usuarioByCorreo.isPresent()) {  // no se puede repetir con esto
			throw new IllegalArgumentException("El Usuario con el id [" + usuario.getCorreo() + "] no existe.");
		} else {
			usuarioRepository.save(usuario);
			tmpUsuario = usuario;
		}
		return tmpUsuario;
	}
	
	
	
	public boolean login (String correo, String contrasena) {
		boolean autorizacion = false;
		Optional<Usuario> usuarioByLogin = usuarioRepository.findByCorreoAndContrasena(correo, contrasena);
		if(usuarioByLogin.isPresent()) {
			autorizacion = true;
			System.out.println("Inicio de sesión exitoso");
		}else {
			System.out.println("Inicio de sesión fallido");
		}
		return autorizacion;
	}//login
	
	

}

		
		
		


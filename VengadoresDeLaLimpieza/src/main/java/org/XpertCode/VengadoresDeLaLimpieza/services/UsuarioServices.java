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
	
	public Usuario deleteUsuario(Long id) {
		Usuario tmpUsuario= null;
		if (usuarioRepository.existsById(id)) {
			tmpUsuario = usuarioRepository.findById(id).get();  //return optional
			usuarioRepository.deleteById(id);  // delete no regresa, o¿solo elimina
		}		
		return tmpUsuario;
	}
	
	public Usuario addUsuario(Usuario usuario) {  //buscar mejor por SKU
		Usuario tmpUsuario = null;
		Optional<Usuario> usuarioByCorreo = usuarioRepository.findByCorreo(usuario.getCorreo());
		
		if(usuarioByCorreo.isPresent()) {  // no se puede repetir con esto
			throw new IllegalArgumentException("El Usuario con el correo [" + usuario.getCorreo() + "] YA existe.");
		} else {
			usuarioRepository.save(usuario);
			tmpUsuario = usuario;
		}
		return tmpUsuario;
	}
	
	public Usuario updateUsuario(Long id, String contrasena, String newContrasena) {
		Usuario tmpUsuario= null;
		if (usuarioRepository.existsById(id)) {
			tmpUsuario = usuarioRepository.findById(id).get();
			if (tmpUsuario.getContrasena().equals(contrasena)) { //comparando con la contraseña anterior
				tmpUsuario.setContrasena(newContrasena);
				usuarioRepository.save(tmpUsuario);
			} else {
				System.out.println("Error al comparar las contraseñas...");
			}
				//if equals password
			}
		return tmpUsuario;
	} //if
	
	public boolean validateUsuario(Usuario usuario) {
		boolean res = false;
		Optional<Usuario> userByCorreo = usuarioRepository.findByCorreo(usuario.getCorreo());
		if (userByCorreo.isPresent()) {
			Usuario u = userByCorreo.get();
			if (u.getContrasena().equals(usuario.getContrasena())) {
				res = true;
			}
		}
		return res;
	}
	
	

}

		
		
		


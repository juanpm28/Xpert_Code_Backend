package org.XpertCode.VengadoresDeLaLimpieza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.XpertCode.VengadoresDeLaLimpieza.models.Usuario;
import org.XpertCode.VengadoresDeLaLimpieza.services.UsuarioServices;


@RestController
@RequestMapping (path="/api/registros/")  //nivel clase// único endpoint, en los métodos se cambía lo último de la url
public class RegistroController {

	private final UsuarioServices usuarioServices;  // se instancia lo de la otra clase ya que nunca se mandó a llamar, es una constante
	
	@Autowired  
	public RegistroController(UsuarioServices registroServices) { 
		this.usuarioServices = registroServices;
	}
	
	@GetMapping //nivel método
	public List<Usuario> getAllUsuarios() {
		return usuarioServices.getUsuarios();
	}
	
	@GetMapping (path="{usuarioId}")  // para traer productos de forma individual
	public Usuario getRegistro(@PathVariable("usuarioId") Long id) {  // se le asigna al Long id
		return usuarioServices.getUsuario(id);
	}
	
	
	@PostMapping
	public Usuario addUsuario(@RequestBody Usuario usuario) { //viene en formato json
		return usuarioServices.addUsuario(usuario); 
	}
	
	
	
}

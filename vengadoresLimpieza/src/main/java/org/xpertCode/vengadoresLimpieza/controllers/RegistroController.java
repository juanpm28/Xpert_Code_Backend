package org.xpertCode.vengadoresLimpieza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xpertCode.vengadoresLimpieza.models.Registro;
import org.xpertCode.vengadoresLimpieza.services.RegistroServices;


@RestController
@RequestMapping (path="/api/registros/")  //nivel clase// único endpoint, en los métodos se cambía lo último de la url
@CrossOrigin(origins = "*")
public class RegistroController {

	private final RegistroServices registroServices;  // se instancia lo de la otra clase ya que nunca se mandó a llamar, es una constante
	
	@Autowired  
	public RegistroController(RegistroServices registroServices) { 
		this.registroServices = registroServices;
	}
	
	@GetMapping //nivel método
	public List<Registro> getAllRegistros() {
		return registroServices.getRegistros();
	}
	
	@GetMapping (path="{registroId}")  // para traer productos de forma individual
	public Registro getRegistro(@PathVariable("registroId") Long id) {  // se le asigna al Long id
		return registroServices.getRegistro(id);
	}
	
	
	@PostMapping
	public Registro addRegistro(@RequestBody Registro registro) { //viene en formato json
		return registroServices.addRegistro(registro); 
	}
	

	
}

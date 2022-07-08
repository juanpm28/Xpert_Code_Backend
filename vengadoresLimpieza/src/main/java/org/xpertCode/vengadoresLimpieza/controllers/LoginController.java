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
import org.xpertCode.vengadoresLimpieza.models.Login;
import org.xpertCode.vengadoresLimpieza.services.LoginServices;

@RestController
@RequestMapping (path="/api/logins/")  //nivel clase// único endpoint, en los métodos se cambía lo último de la url
@CrossOrigin(origins = "*")
public class LoginController {

	private final LoginServices loginServices;  // se instancia lo de la otra clase ya que nunca se mandó a llamar, es una constante
	
	@Autowired  
	public LoginController(LoginServices loginServices) { 
		this.loginServices = loginServices;
	}
	
	@GetMapping //nivel método
	public List<Login> getAllLogins() {
		return loginServices.getLogins();
	}
	
	@GetMapping (path="{loginId}")  // para traer Logins de forma individual
	public Login getLogin(@PathVariable("loginId") Long id) {  // se le asigna al Long id
		return loginServices.getLogin(id);
	}
	
	
	@PostMapping
	public Login addLogin(@RequestBody Login login) { //viene en formato json
		return loginServices.addLogin(login); 
	}

	
	
}

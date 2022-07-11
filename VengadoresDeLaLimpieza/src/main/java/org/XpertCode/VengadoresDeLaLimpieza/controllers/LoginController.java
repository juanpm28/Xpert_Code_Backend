package org.XpertCode.VengadoresDeLaLimpieza.controllers;

import java.util.List;

import org.XpertCode.VengadoresDeLaLimpieza.models.Login;
import org.XpertCode.VengadoresDeLaLimpieza.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/us/")
public class LoginController {
	private final LoginService loginService;
	
	@Autowired
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}//constructor
	
	//CRUD
	@GetMapping
	public List<Login> getAllLogins(){
		return loginService.getLogins();
	}//getAllUsuario
	
	@GetMapping (path="{UsId}")
	public Login getAllLogins(@PathVariable("UsId") Long id){
		return loginService.getLogin(id);
	}//getUsuario
	
	@DeleteMapping(path="{UsId}")
	public Login deleteLogins(@PathVariable("UsId") Long id){
		return loginService.deleteLogin(id);
	}//deleteUsuario
	
	@PostMapping
	public Login addLogin(@RequestBody Login login){
		return loginService.addLogin(login);
	}//addUsuario
	
	@PutMapping (path="{UsId}")
	public Login updateLogin(@PathVariable("UsId") Long id,
	@RequestParam(required = false) String correo,
	@RequestParam(required = false) String contrasena){
		return loginService.updateLogin(id, correo, contrasena);
	}//getUsuario
	
}//class UsuarioController

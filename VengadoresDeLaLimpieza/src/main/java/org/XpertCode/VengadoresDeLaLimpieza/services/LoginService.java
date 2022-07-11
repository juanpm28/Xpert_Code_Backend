package org.XpertCode.VengadoresDeLaLimpieza.services;

import java.util.List;
import java.util.Optional;

import org.XpertCode.VengadoresDeLaLimpieza.models.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	private final LoginRepository loginRepository;
	
	@Autowired
	public LoginService(LoginRepository loginRepository) {
		super();
		this.loginRepository = loginRepository;
	}//constructor -> trae todos los Logins 
	
	public List<Login> getLogins() {
		return loginRepository.findAll();
	}//getLogin -> trae un Login 
	
	public Login getLogin(Long idLogins) {
		return loginRepository.findById(idLogins).orElseThrow(
				()->new IllegalArgumentException("El Login con el idLogins " + idLogins + " no existe.")
				);
	}//getLogin -> Buscar un Login no existente 
	
	public Login deleteLogin(Long idLogins) {
		Login tmpUs= null;
		if(loginRepository.existsById(idLogins)){
			tmpUs=loginRepository.findById(idLogins).get();
			loginRepository.deleteById(idLogins);
		}//if exist 
		return tmpUs;
	}//deleteLogin -> Borrar un Login
	
	public Login addLogin(Login login) {
		Login tmpUs= null;
		Optional<Login> prodByName = loginRepository.finByCorreo(login.getCorreo());
		if(prodByName.isPresent()) {
			throw new IllegalArgumentException("El Login con el nombre["+
					login.getCorreo() + "] ya existe");
		}else {
			loginRepository.save(login);
			tmpUs=login;
		}
		return tmpUs;
	}//addLogin -> agregar Login
	
	public Login updateLogin(Long idLogins, String correo, String contrasena) {
		Login tmpUs=null;
		if(loginRepository.existsById(idLogins)){
			tmpUs=loginRepository.findById(idLogins).get();
			if (correo!=null) tmpUs.setCorreo(correo);
			if (contrasena!=null) tmpUs.setContrasena(contrasena);
			loginRepository.save(tmpUs);
		}else {
			System.out.println("El Login con el idLogins" + idLogins + "no existe.");
		}//if 
		return tmpUs;
	}//update Login 

}//class

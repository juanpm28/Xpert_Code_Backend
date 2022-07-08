package org.xpertCode.vengadoresLimpieza.services;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;
import org.xpertCode.vengadoresLimpieza.models.Login;

@Service
public class LoginServices {
	public final ArrayList<Login> lista = new ArrayList<Login>();
	
	public LoginServices() {
		Arrays.asList();
		

		lista.add(new Login("davidmunoz@gmail.com", "ABCD1234"));
		lista.add(new Login("omarbeltber@gmail.com", "ABCD1234"));
		lista.add(new Login("gusmaniaco@gmail.com","ABCD1234"));
		lista.add(new Login("pedromtz@hotmail.com", "ABCD1234"));
		lista.add(new Login("omarbeltber@gmail.com", "ABCD1234"));

		
	}//constructor
	
	public ArrayList<Login> getLogins(){
		return lista;
	}
	

	public Login getLogin(Long id) {
		Login tmpLogin = null;
		for (Login login: lista) {   
			if(login.getId()==id) {
				tmpLogin = login;
				break;
			}
			
		}//foreach  // para recorrer la lista, buscar
		return tmpLogin;
	}//getLogin
	

	public Login addLogin(Login Login) {
		lista.add(Login);
		return Login;
	}
	
}






package org.xpertCode.vengadoresLimpieza.services;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;
import org.xpertCode.vengadoresLimpieza.models.Login;
import org.xpertCode.vengadoresLimpieza.models.Registro;

@Service
public class RegistroServices {
	public final ArrayList<Registro> lista = new ArrayList<Registro>();
	
	public RegistroServices() {
		Arrays.asList();
		

		lista.add(new Registro("David Munoz", 667144998, "davidmunoz@gmail.com", "ABCD1234"));
		lista.add(new Registro("Omar Beltber", 112334455, "omarbeltber@gmail.com", "ABCD1234"));
		lista.add(new Registro("Gus Maniaco", 332244555, "gusmaniaco@gmail.com","ABCD1234"));
		lista.add(new Registro("Pedro Martinez", 254789543, "pedromtz@hotmail.com", "ABCD1234"));
		lista.add(new Registro("Omar Beltber", 685431026, "omarbeltber@gmail.com", "ABCD1234"));

		
	}//constructor
	
	public ArrayList<Registro> getRegistros(){
		return lista;
	}
	

	public Registro getRegistro(Long id) {
		Registro tmpRegistro = null;
		for (Registro registro: lista) {   
			if(registro.getId()==id) {
				tmpRegistro = registro;
				break;
			}
			
		}//foreach  // para recorrer la lista, buscar
		return tmpRegistro;
	}//getLogin
	

	public Registro addRegistro(Registro registro) {
		lista.add(registro);
		return registro;
	}
}
	
	
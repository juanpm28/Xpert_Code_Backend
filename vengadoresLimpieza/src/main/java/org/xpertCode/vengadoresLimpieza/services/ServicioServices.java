package org.xpertCode.vengadoresLimpieza.services;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;
import org.xpertCode.vengadoresLimpieza.models.Servicio;

@Service
public class ServicioServices {

	public final ArrayList<Servicio> lista = new ArrayList<Servicio>();
	
	public ServicioServices() {
		Arrays.asList();
		
//		private String nombre;
//		private String URL_imagen;
//		private double precio;
//		private String SKU;
//		private String fecha; 
//		private String hora;
		
		lista.add(new Servicio("Paquete Basic, hasta 70m²", "/src/imagenes/paquete1.png", 1499.00, "PAENT10", "21/08/2022", "10:30 p.m."));
		lista.add(new Servicio("Paquete Deluxe, hasta 110m²", "/src/imagenes/paquete2.png", 2599.00, "PAEME25", "22/09/2022", "03:45 p.m."));
		lista.add(new Servicio("Paquete Premium, hasta 200m²", "/src/imagenes/paquete3.png", 3999.00, "PASUM40", "11/11/2022", "05:10 p.m."));


		
	}//constructor
	
	public ArrayList<Servicio> getServicios(){
		return lista;
	}

	public Servicio getServicio(Long id) {
		Servicio tmpServ = null;
		for (Servicio servicio : lista) {   
			if(servicio.getId()==id) {
				tmpServ = servicio;
				break;
			}
			
		}//foreach  // para recorrer la lista, buscar
		return tmpServ;
	}//getProducto

	public Servicio deleteServicio(Long id) {
		Servicio tmpServ = null;  // variable a nivel metodo
		for (Servicio servicio : lista) {   
			if(servicio.getId()==id) {
				tmpServ = lista.remove(lista.indexOf(servicio));
				break;
			}
		}//foreach  // para recorrer la lista
		return tmpServ;
	}//deleteProduct

	public Servicio addServicio(Servicio servicio) {
		lista.add(servicio);
		return servicio;
	}

	public Servicio updateServicio(Long id, String nombre, String uRL_imagen, Double precio, String sKU, String fecha, String hora) {
		Servicio tmpServ = null;  // variable a nivel metodo
		for (Servicio servicio : lista) {   
			if(servicio.getId()==id) {
				if(nombre!=null) servicio.setNombre(nombre);
				if(uRL_imagen!=null) servicio.setURL_imagen(uRL_imagen);
				if(precio>0) servicio.setPrecio(precio.doubleValue());
				if(sKU!=null) servicio.setSKU(sKU);
				if(fecha!=null) servicio.setFecha(fecha);
				if(hora!=null) servicio.setHora(hora);
				tmpServ = servicio;
				break;
			}
			
		}//foreach  // para recorrer la lista, buscar
		return tmpServ;
	}
}

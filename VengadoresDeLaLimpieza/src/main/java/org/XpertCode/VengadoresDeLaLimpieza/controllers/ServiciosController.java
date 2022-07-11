package org.XpertCode.VengadoresDeLaLimpieza.controllers;

import java.util.List;

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
import org.XpertCode.VengadoresDeLaLimpieza.models.Servicio;
import org.XpertCode.VengadoresDeLaLimpieza.services.ServicioServices;

@RestController
@RequestMapping (path="/api/servicios/")  //nivel clase// único endpoint, en los métodos se cambía lo último de la url
public class ServiciosController {

	private final ServicioServices servicioServices;
	
	@Autowired  
	public ServiciosController(ServicioServices servicioServices) { 
		this.servicioServices = servicioServices;
	}
	
	@GetMapping //nivel método
	public List<Servicio> getAllServicios() { // o services
		return servicioServices.getServicios();
	}
	
	@GetMapping (path="{servId}")  // para traer productos de forma individual
	public Servicio getServicio(@PathVariable("servId") Long id) {  // se le asigna al Long id
		return servicioServices.getServicio(id);
	}
	
	@DeleteMapping (path="{servId}") 
	public Servicio deleteServicio(@PathVariable("servId") Long id) {
		return servicioServices.deleteServicio(id);
	}
	
	@PostMapping
	public Servicio addServicio(@RequestBody Servicio servicio) { //viene en formato json
		return servicioServices.addServicio(servicio); 
	}
	
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY) // es autoincremental
//	@Column(name="idservicios", unique = true, nullable = false)
//	private Long id;
//	@Column(name="nombrepaquete")
//	private String nombrePaquete;
//	@Column(name="url_imagen")
//	private String URL_imagen;
//	private double precio;
//	private String SKU;
//	private String fecha; 
//	private String hora;
	
	@PutMapping (path="{servId}") 
	public Servicio updateServicio (@PathVariable("servId") Long id,
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) String uRL_imagen, 
			@RequestParam(required = false) Double precio,
			@RequestParam(required = false) String sKU,
			@RequestParam(required = false) String fecha,
			@RequestParam(required = false) String hora) {

		return servicioServices.updateServicio(id, nombre, uRL_imagen, precio, sKU, fecha, hora);
	}    // required funciona para que no solicite a fuerza todos los parámetros a actualizar


	
	
	
}

package org.XpertCode.VengadoresDeLaLimpieza.controllers;

import java.util.List;

import org.XpertCode.VengadoresDeLaLimpieza.models.PedidoServicios;
import org.XpertCode.VengadoresDeLaLimpieza.services.PedidoServiciosServices;
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
@RequestMapping (path="/api/pedidosservicios/")  //nivel clase// único endpoint, en los métodos se cambía lo último de la url
public class PedidosServiciosController {


	private final PedidoServiciosServices pedidoServiciosServices;  // se instancia lo de la otra clase ya que nunca se mandó a llamar, es una constante
	
	@Autowired  
	public PedidosServiciosController(PedidoServiciosServices pedidoServiciosServices) { 
		this.pedidoServiciosServices = pedidoServiciosServices;
	}
	
	//CRUD
	@GetMapping //nivel método
	public List<PedidoServicios> getAllPedidosServicios() {
		return pedidoServiciosServices.getPedidosServicios();
	}
	
	@GetMapping (path="{pedidoServiciosId}")  // para traer pedidoServicioss de forma individual
	public PedidoServicios getPedidoServicios(@PathVariable("pedidoServiciosId") Long id) {  // se le asigna al Long id
		return pedidoServiciosServices.getPedidoServicios(id);
	}
	
	@DeleteMapping (path="{pedidoServiciosId}") 
	public PedidoServicios deletePedidoServicios(@PathVariable("pedidoServiciosId") Long id) {
		return pedidoServiciosServices.deletePedidoServicios(id);
	}
	
	@PostMapping
	public PedidoServicios addPedidoServicios(@RequestBody PedidoServicios pedidoServicios) { //viene en formato json
		return pedidoServiciosServices.addPedidoServicios(pedidoServicios); 
	}
	
	
//	private Long id;
//	private String resumenPedido;
////	@Column(name="url_img")
////	private String URL_imagen;
//	private double costoTotal;
//	private int usuarios_idusuarios;
//	private int productos_idProducto;
	
	
	@PutMapping (path="{pedidoServiciosId}") 
	public PedidoServicios updatePedidoServicios (@PathVariable("pedidoServiciosId") Long id,
			@RequestParam(required = false) String resumenPedido,
//			@RequestParam(required = false) String uRL_imagen, 
			@RequestParam(required = false) Double costoTotal,
			@RequestParam(required = false) Integer servicios_idservicios,
			@RequestParam(required = false) Integer usuarios_idusuarios) {

		return pedidoServiciosServices.updatePedidoServicios(id, resumenPedido, costoTotal, servicios_idservicios, usuarios_idusuarios);
	}    // required funciona para que no solicite a fuerza todos los parámetros a actualizar

	
}

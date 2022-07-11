package org.XpertCode.VengadoresDeLaLimpieza.controllers;

import java.util.List;

import org.XpertCode.VengadoresDeLaLimpieza.models.Pedido;
import org.XpertCode.VengadoresDeLaLimpieza.services.PedidoServices;
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
@RequestMapping (path="/api/pedidos/")  //nivel clase// único endpoint, en los métodos se cambía lo último de la url
public class PedidosController {


	private final PedidoServices pedidoServices;  // se instancia lo de la otra clase ya que nunca se mandó a llamar, es una constante
	
	@Autowired  
	public PedidosController(PedidoServices pedidoServices) { 
		this.pedidoServices = pedidoServices;
	}
	
	//CRUD
	@GetMapping //nivel método
	public List<Pedido> getAllPedidos() {
		return pedidoServices.getPedidos();
	}
	
	@GetMapping (path="{pedidoId}")  // para traer pedidos de forma individual
	public Pedido getPedido(@PathVariable("pedidoId") Long id) {  // se le asigna al Long id
		return pedidoServices.getPedido(id);
	}
	
	@DeleteMapping (path="{pedidoId}") 
	public Pedido deletePedido(@PathVariable("pedidoId") Long id) {
		return pedidoServices.deletePedido(id);
	}
	
	@PostMapping
	public Pedido addPedido(@RequestBody Pedido pedido) { //viene en formato json
		return pedidoServices.addPedido(pedido); 
	}
	
	
//	private Long id;
//	private String resumenPedido;
////	@Column(name="url_img")
////	private String URL_imagen;
//	private double costoTotal;
//	private int usuarios_idusuarios;
//	private int productos_idProducto;
	
	
	@PutMapping (path="{pedidoId}") 
	public Pedido updatePedido (@PathVariable("pedidoId") Long id,
			@RequestParam(required = false) String resumenPedido,
//			@RequestParam(required = false) String uRL_imagen, 
			@RequestParam(required = false) Double costoTotal,
			@RequestParam(required = false) Integer usuarios_idusuarios,
			@RequestParam(required = false) Integer productos_idProducto) {

		return pedidoServices.updatePedido(id, resumenPedido, costoTotal, usuarios_idusuarios, productos_idProducto);
	}    // required funciona para que no solicite a fuerza todos los parámetros a actualizar

	
}

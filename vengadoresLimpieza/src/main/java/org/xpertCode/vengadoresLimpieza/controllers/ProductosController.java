package org.xpertCode.vengadoresLimpieza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xpertCode.vengadoresLimpieza.models.Producto;
import org.xpertCode.vengadoresLimpieza.services.ProductoServices;


@RestController
@RequestMapping (path="/api/productos/")  //nivel clase// único endpoint, en los métodos se cambía lo último de la url
@CrossOrigin(origins = "*")
public class ProductosController {


	private final ProductoServices productoServices;  // se instancia lo de la otra clase ya que nunca se mandó a llamar, es una constante
	
	@Autowired  
	public ProductosController(ProductoServices productoServices) { 
		this.productoServices = productoServices;
	}
	
	@GetMapping //nivel método
	public List<Producto> getAllProducts() {
		return productoServices.getProductos();
	}
	
	@GetMapping (path="{prodId}")  // para traer productos de forma individual
	public Producto getProduct(@PathVariable("prodId") Long id) {  // se le asigna al Long id
		return productoServices.getProducto(id);
	}
	
	@DeleteMapping (path="{prodId}") 
	public Producto deleteProduct(@PathVariable("prodId") Long id) {
		return productoServices.deleteProducto(id);
	}
	
	@PostMapping
	public Producto addProducto(@RequestBody Producto producto) { //viene en formato json
		return productoServices.addProducto(producto); 
	}
	
	@PutMapping (path="{prodId}") 
	public Producto updateProduct (@PathVariable("prodId") Long id,
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) String uRL_imagen, 
			@RequestParam(required = false) Double precio,
			@RequestParam(required = false) String sKU,
			@RequestParam(required = false) int cantidad) {

		return productoServices.updateProducto(id, nombre, uRL_imagen, precio, sKU, cantidad);
	}    // required funciona para que no solicite a fuerza todos los parámetros a actualizar


	
}

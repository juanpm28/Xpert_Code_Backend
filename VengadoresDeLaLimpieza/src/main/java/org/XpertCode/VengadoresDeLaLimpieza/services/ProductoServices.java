package org.XpertCode.VengadoresDeLaLimpieza.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.XpertCode.VengadoresDeLaLimpieza.models.Producto;

@Service
public class ProductoServices {

		
		private final ProductoRepository productoRepository;  //constante del repositorio dentro de services para conectame a la base de datos

		@Autowired
		public ProductoServices(ProductoRepository productoRepository) {
			this.productoRepository = productoRepository;
		} //inyección de dependencias por constructor
		
		public List<Producto> getProductos() {
			return productoRepository.findAll();
		}//get para mapear todos los productos
		
		public Producto getProducto(Long id) {
			return productoRepository.findById(id).orElseThrow(
					()->new IllegalArgumentException("El Producto con el id " + id + " no existe.")
					);
		}//getProductos, para obtener get por ID
		
		public Producto deleteProducto(Long id) {
			Producto tmpProd = null;
			if (productoRepository.existsById(id)) {
				tmpProd = productoRepository.findById(id).get();  //return optional
				productoRepository.deleteById(id);
			}		
			return tmpProd;
		}
		
		public Producto addProducto(Producto producto) {  //buscar mejor por SKU
			Producto tmpProd = null;
			Optional<Producto> prodByNombre = productoRepository.findByNombre(producto.getNombre());
			
			if(prodByNombre.isPresent()) {  // no se puede repetir con esto
				throw new IllegalArgumentException("El Producto con el id [" + producto.getNombre() + "] no existe.");
			} else {
				productoRepository.save(producto);
				tmpProd = producto;
			}
			return tmpProd;
		}
		
		
		public Producto updateProducto(Long id, String nombre, String uRL_imagen, Double precio, String sKU, Integer cantidad) { //se cambió de int a Integer
			Producto tmpProd = null;
			if (productoRepository.existsById(id)) {
				tmpProd = productoRepository.findById(id).get();  //return optional
				if(nombre!=null) tmpProd.setNombre(nombre);
				if(uRL_imagen!=null) tmpProd.setURL_imagen(uRL_imagen);
				if(precio!=null) tmpProd.setPrecio(precio.doubleValue());
				if(sKU!=null) tmpProd.setSKU(sKU);
				if(cantidad!=null) tmpProd.setCantidad(cantidad);

				productoRepository.save(tmpProd);
			} else {
				System.out.println("El Producto con el id " + id + " no existe.");  // para ver en consola que el producto no existe
			}
			return tmpProd;
		}
		
		

}

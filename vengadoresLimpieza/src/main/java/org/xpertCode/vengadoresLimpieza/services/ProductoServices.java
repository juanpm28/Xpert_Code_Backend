package org.xpertCode.vengadoresLimpieza.services;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;
import org.xpertCode.vengadoresLimpieza.models.Producto;

@Service
public class ProductoServices {
	public final ArrayList<Producto> lista = new ArrayList<Producto>();
	
	public ProductoServices() {
		Arrays.asList();
		
//		private String nombre;
//		private String URL_imagen;
//		private double precio;
//		private String SKU;
		
		lista.add(new Producto("Súper Kit de Limpieza Completo VengaClean", "/src/imagenes/1_kit3.jpg", 587.00, "DW195B3", 2));
		lista.add(new Producto("Scotch-Brite Guantes de Cocina, Medianos", "/src/imagenes/2_guant1_EDITADO.jpg", 31.82, "MMS195S9", 15));
		lista.add(new Producto("Scotch-Brite Paño Microfibra de Colores", "/src/imagenes/3_trapo1_EDITADO.jpg", 13.00, "JG953M4", 1));
		lista.add(new Producto("Trapeador Plano Atrapa Polvo Microfibra", "/src/imagenes/4_trapeador1_EDITADO.jpg", 249, "LM347G1", 4));
		lista.add(new Producto("Recogedor de Basura Rojo Multiusos", "/src/imagenes/5_recoge1_EDITADO.jpg", 200.00, "PPV110T7", 3));
		
	}//constructor
	
	public ArrayList<Producto> getProductos(){
		return lista;
	}

	public Producto getProducto(Long id) {
		Producto tmpProd = null;
		for (Producto producto : lista) {   
			if(producto.getId()==id) {
				tmpProd = producto;
				break;
			}
			
		}//foreach  // para recorrer la lista, buscar
		return tmpProd;
	}//getProducto

	public Producto deleteProducto(Long id) {
		Producto tmpProd = null;  // variable a nivel metodo
		for (Producto producto : lista) {   
			if(producto.getId()==id) {
				tmpProd = lista.remove(lista.indexOf(producto));
				break;
			}
		}//foreach  // para recorrer la lista
		return tmpProd;
	}//deleteProduct

	public Producto addProducto(Producto producto) {
		lista.add(producto);
		return producto;
	}

	public Producto updateProducto(Long id, String nombre, String uRL_imagen, Double precio, String sKU, int cantidad) {
		Producto tmpProd = null;  // variable a nivel metodo
		for (Producto producto : lista) {   
			if(producto.getId()==id) {
				if(nombre!=null) producto.setNombre(nombre);
				if(uRL_imagen!=null) producto.setURL_imagen(uRL_imagen);
				if(precio>0) producto.setPrecio(precio.doubleValue());
				if(sKU!=null) producto.setSKU(sKU);
				if(cantidad>0) producto.setCantidad(cantidad);
				tmpProd = producto;
				break;
			}
			
		}//foreach  // para recorrer la lista, buscar
		return tmpProd;
	}


}

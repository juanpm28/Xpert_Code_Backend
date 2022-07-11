package org.XpertCode.VengadoresDeLaLimpieza.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // es autoincremental
	@Column(name="idproducto", unique = true, nullable = false)
		private Long id;
		private String nombre;
		@Column(name="url_img")
		private String URL_imagen;
		private double precio;
		private String SKU;
		private int cantidad; 
		
		public Producto(Long id, String nombre, String uRL_imagen, double precio, String sKU, int cantidad) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.URL_imagen = uRL_imagen;
			this.precio = precio;
			this.SKU = sKU;
			this.cantidad = cantidad;


		}

		public Producto() { //para un nuevo producto

		}
		
		public Long getId() {
			return id;
		}
		
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getURL_imagen() {
			return URL_imagen;
		}

		public void setURL_imagen(String uRL_imagen) {
			URL_imagen = uRL_imagen;
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}

		public String getSKU() {
			return SKU;
		}

		public void setSKU(String sKU) {
			SKU = sKU;
		}


		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}

		@Override
		public String toString() {
			return "Producto [id=" + id + ", nombre=" + nombre + ", URL_imagen=" + ", precio=" + precio
					+ ", SKU=" + SKU + ", cantidad=" + cantidad + "]";
		}


}

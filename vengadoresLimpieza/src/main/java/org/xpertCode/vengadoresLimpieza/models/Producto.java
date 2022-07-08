package org.xpertCode.vengadoresLimpieza.models;

public class Producto {
	
		private String nombre;
		private String URL_imagen;
		private double precio;
		private String SKU;
		private int cantidad; 
		private int id;
		private static int total=0;
		
		public Producto(String nombre, String uRL_imagen, double precio, String sKU, int cantidad) {
			super();
			this.nombre = nombre;
			URL_imagen = uRL_imagen;
			this.precio = precio;
			SKU = sKU;
			this.cantidad = cantidad;
			total ++;
			this.id = total;

		}

		public Producto() { //para un nuevo producto

		}
		
		public int getId() {
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
			return "Producto [nombre=" + nombre + ", URL_imagen=" + URL_imagen + ", precio=" + precio + ", SKU=" + SKU
					+ ", cantidad=" + cantidad + ", id=" + id + "]";
		}


		
}

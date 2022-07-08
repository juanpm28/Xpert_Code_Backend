package org.xpertCode.vengadoresLimpieza.models;

public class Servicio {
	
	private String nombre;
	private String URL_imagen;
	private double precio;
	private String SKU;
	private String fecha; 
	private String hora;
	private int id;
	private static int total=0;
	
	
	public Servicio(String nombre, String uRL_imagen, double precio, String sKU, String fecha, String hora) {
		super();
		this.nombre = nombre;
		URL_imagen = uRL_imagen;
		this.precio = precio;
		SKU = sKU;
		this.fecha = fecha;
		this.hora = hora;
		total ++;
		this.id = total;
	}


	public Servicio() { 

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


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	@Override
	public String toString() {
		return "Servicio [nombre=" + nombre + ", URL_imagen=" + URL_imagen + ", precio=" + precio + ", SKU=" + SKU
				+ ", fecha=" + fecha + ", hora=" + hora + ", id=" + id + "]";
	}

	
	
	
}

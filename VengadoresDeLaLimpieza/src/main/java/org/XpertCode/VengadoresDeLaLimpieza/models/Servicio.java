package org.XpertCode.VengadoresDeLaLimpieza.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="servicios")
public class Servicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // es autoincremental
	@Column(name="idservicios", unique = true, nullable = false)
	private Long id;
	@Column(name="nombrepaquete")
	private String nombre;
	@Column(name="url_imagen")
	private String URL_imagen;
	private double precio;
	private String SKU;
	private String fecha; 
	private String hora;
	
	public Servicio(Long id, String nombre, String uRL_imagen, double precio, String sKU, String fecha,
			String hora) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.URL_imagen = uRL_imagen;
		this.precio = precio;
		this.SKU = sKU;
		this.fecha = fecha;
		this.hora = hora;
	}
	
	public Servicio() { 

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

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Servicio [id=" + id + ", nombre=" + nombre + ", URL_imagen=" + URL_imagen + ", precio="
				+ precio + ", SKU=" + SKU + ", fecha=" + fecha + ", hora=" + hora + "]";
	}

	
}
	
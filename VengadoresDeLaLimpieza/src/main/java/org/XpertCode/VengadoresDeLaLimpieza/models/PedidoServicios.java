package org.XpertCode.VengadoresDeLaLimpieza.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pedidosservicios")
public class PedidoServicios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // es autoincremental
	@Column(name="idpedidos", unique = true, nullable = false)
	private Long id;
	@Column(name="resumenpedido")
	private String resumenPedido;
	@Column(name="costototal")
	private double costoTotal;
	private int servicios_idservicios;
	private int usuarios_idusuarios;
	
	
	public PedidoServicios(Long id, String resumenPedido, double costoTotal, int servicios_idservicios,
			int usuarios_idusuarios) {
		super();
		this.id = id;
		this.resumenPedido = resumenPedido;
		this.costoTotal = costoTotal;
		this.servicios_idservicios = servicios_idservicios;
		this.usuarios_idusuarios = usuarios_idusuarios;
	}


	public PedidoServicios() {
		
	}
	
	public String getResumenPedido() {
		return resumenPedido;
	}


	public void setResumenPedido(String resumenPedido) {
		this.resumenPedido = resumenPedido;
	}


	public double getCostoTotal() {
		return costoTotal;
	}


	public void setCostoTotal(double costoTotal) {
		this.costoTotal = costoTotal;
	}


	public int getServicios_idservicios() {
		return servicios_idservicios;
	}


	public void setServicios_idservicios(int servicios_idservicios) {
		this.servicios_idservicios = servicios_idservicios;
	}


	public int getUsuarios_idusuarios() {
		return usuarios_idusuarios;
	}


	public void setUsuarios_idusuarios(int usuarios_idusuarios) {
		this.usuarios_idusuarios = usuarios_idusuarios;
	}


	public Long getId() {
		return id;
	}


	@Override
	public String toString() {
		return "PedidoServicios [id=" + id + ", resumenPedido=" + resumenPedido + ", costoTotal=" + costoTotal
				+ ", servicios_idservicios=" + servicios_idservicios + ", usuarios_idusuarios=" + usuarios_idusuarios
				+ "]";
	}
	
	
	
	
}

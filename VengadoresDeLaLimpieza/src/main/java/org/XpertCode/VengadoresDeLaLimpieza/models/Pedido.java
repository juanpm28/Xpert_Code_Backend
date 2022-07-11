package org.XpertCode.VengadoresDeLaLimpieza.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pedidos")
public class Pedido {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) // es autoincremental
		@Column(name="idpedidos", unique = true, nullable = false)
			private Long id;
			@Column(name="resumenpedido")
			private String resumenPedido;
//			@Column(name="url_img")
//			private String URL_imagen;
			@Column(name="costototal")
			private double costoTotal;
			private int usuarios_idusuarios;
			@Column(name="productos_idproducto")
			private int productos_idProducto;
			
			
			
			public Pedido(Long id, String resumenPedido, double costoTotal, int usuarios_idusuarios,
					int productos_idProducto) {
				super();
				this.id = id;
				this.resumenPedido = resumenPedido;
				this.costoTotal = costoTotal;
				this.usuarios_idusuarios = usuarios_idusuarios;
				this.productos_idProducto = productos_idProducto;
			}


			public Pedido() {
				
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



			public int getUsuarios_idusuarios() {
				return usuarios_idusuarios;
			}



			public void setUsuarios_idusuarios(int usuarios_idusuarios) {
				this.usuarios_idusuarios = usuarios_idusuarios;
			}



			public int getProductos_idProducto() {
				return productos_idProducto;
			}



			public void setProductos_idProducto(int productos_idProducto) {
				this.productos_idProducto = productos_idProducto;
			}



			public Long getId() {
				return id;
			}


			
			
			
}
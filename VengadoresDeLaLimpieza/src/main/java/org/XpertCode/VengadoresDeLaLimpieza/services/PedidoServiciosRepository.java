package org.XpertCode.VengadoresDeLaLimpieza.services;

import java.util.Optional;

import org.XpertCode.VengadoresDeLaLimpieza.models.PedidoServicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PedidoServiciosRepository extends JpaRepository<PedidoServicios, Long> {
	
	//	Pedido es de Pedido.java
@Query("SELECT p FROM PedidoServicios p WHERE p.resumenPedido=?1")  // ? indica que es un par�metro, si hubiera otro ser�a ?2 y as� // 
Optional<PedidoServicios> findByResumenPedido(String resumenPedido);  //quiero un opciontal de tipo producto, es lo que arroja el find

}

package org.XpertCode.VengadoresDeLaLimpieza.services;

import java.util.Optional;

import org.XpertCode.VengadoresDeLaLimpieza.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	//	Pedido es de Pedido.java
@Query("SELECT p FROM Pedido p WHERE p.resumenPedido=?1")  // ? indica que es un par�metro, si hubiera otro ser�a ?2 y as� // 
Optional<Pedido> findByResumenPedido(String resumenPedido);  //quiero un opciontal de tipo producto, es lo que arroja el find

}

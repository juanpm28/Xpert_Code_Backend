package org.XpertCode.VengadoresDeLaLimpieza.services;

import java.util.List;
import java.util.Optional;

import org.XpertCode.VengadoresDeLaLimpieza.models.PedidoServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiciosServices {

		
		private final PedidoServiciosRepository pedidoServiciosRepository;  //constante del repositorio dentro de services para conectame a la base de datos

		@Autowired
		public PedidoServiciosServices(PedidoServiciosRepository pedidoServiciosRepository) {
			this.pedidoServiciosRepository = pedidoServiciosRepository;
		} //inyección de dependencias por constructor
		
		
		public List<PedidoServicios> getPedidosServicios() {
			return pedidoServiciosRepository.findAll();
		}//get para mapear todos los pedidoServicioss
		
		
		public PedidoServicios getPedidoServicios(Long id) {
			return pedidoServiciosRepository.findById(id).orElseThrow(
					()->new IllegalArgumentException("El PedidoServicios con el id " + id + " no existe.")
					);
		}//getPedidoServicioss, para obtener get por ID
		
		
		public PedidoServicios deletePedidoServicios(Long id) {
			PedidoServicios tmpPedidoServicios = null;
			if (pedidoServiciosRepository.existsById(id)) {
				tmpPedidoServicios = pedidoServiciosRepository.findById(id).get();  //return optional
				pedidoServiciosRepository.deleteById(id);
			}		
			return tmpPedidoServicios;
		}
		
		
		public PedidoServicios addPedidoServicios(PedidoServicios pedidoServicios) {  //buscar mejor por SKU
			PedidoServicios tmpPedidoServicios = null;
			Optional<PedidoServicios> pedidoServiciosByResumenPedido = pedidoServiciosRepository.findByResumenPedido(pedidoServicios.getResumenPedido());
			
			if(pedidoServiciosByResumenPedido.isPresent()) {  // no se puede repetir con esto
				throw new IllegalArgumentException("El PedidoServicios con el id [" + pedidoServicios.getResumenPedido() + "] no existe.");
			} else {
				pedidoServiciosRepository.save(pedidoServicios);
				tmpPedidoServicios = pedidoServicios;
			}
			return tmpPedidoServicios;
		}
		
		
		public PedidoServicios updatePedidoServicios(Long id, String resumenPedido, Double costoTotal, Integer servicios_idservicios, Integer usuarios_idusuarios) { //se cambió de int a Integer
			PedidoServicios tmpPedidoServicios = null;
			if (pedidoServiciosRepository.existsById(id)) {
				tmpPedidoServicios = pedidoServiciosRepository.findById(id).get();  //return optional
				if(resumenPedido!=null) tmpPedidoServicios.setResumenPedido(resumenPedido);
				if(costoTotal!=null) tmpPedidoServicios.setCostoTotal(costoTotal.doubleValue());
				if(usuarios_idusuarios!=null) tmpPedidoServicios.setUsuarios_idusuarios(usuarios_idusuarios);
				if(servicios_idservicios!=null) tmpPedidoServicios.setServicios_idservicios(servicios_idservicios);

				pedidoServiciosRepository.save(tmpPedidoServicios);
			} else {
				System.out.println("El PedidoServicios con el id " + id + " no existe.");  // para ver en consola que el pedidoServicios no existe
			}
			return tmpPedidoServicios;
		}
		
}

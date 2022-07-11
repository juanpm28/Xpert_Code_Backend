package org.XpertCode.VengadoresDeLaLimpieza.services;

import java.util.List;
import java.util.Optional;

import org.XpertCode.VengadoresDeLaLimpieza.models.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServices {

		
		private final PedidoRepository pedidoRepository;  //constante del repositorio dentro de services para conectame a la base de datos

		@Autowired
		public PedidoServices(PedidoRepository pedidoRepository) {
			this.pedidoRepository = pedidoRepository;
		} //inyección de dependencias por constructor
		
		
		public List<Pedido> getPedidos() {
			return pedidoRepository.findAll();
		}//get para mapear todos los pedidos
		
		
		public Pedido getPedido(Long id) {
			return pedidoRepository.findById(id).orElseThrow(
					()->new IllegalArgumentException("El Pedido con el id " + id + " no existe.")
					);
		}//getPedidos, para obtener get por ID
		
		
		public Pedido deletePedido(Long id) {
			Pedido tmpPedido = null;
			if (pedidoRepository.existsById(id)) {
				tmpPedido = pedidoRepository.findById(id).get();  //return optional
				pedidoRepository.deleteById(id);
			}		
			return tmpPedido;
		}
		
		
		public Pedido addPedido(Pedido pedido) {  //buscar mejor por SKU
			Pedido tmpPedido = null;
			Optional<Pedido> pedidoByResumenPedido = pedidoRepository.findByResumenPedido(pedido.getResumenPedido());
			
			if(pedidoByResumenPedido.isPresent()) {  // no se puede repetir con esto
				throw new IllegalArgumentException("El Pedido con el id [" + pedido.getResumenPedido() + "] no existe.");
			} else {
				pedidoRepository.save(pedido);
				tmpPedido = pedido;
			}
			return tmpPedido;
		}
		
		
		public Pedido updatePedido(Long id, String resumenPedido, Double costoTotal, Integer usuarios_idusuarios, Integer productos_idProducto) { //se cambió de int a Integer
			Pedido tmpPedido = null;
			if (pedidoRepository.existsById(id)) {
				tmpPedido = pedidoRepository.findById(id).get();  //return optional
				if(resumenPedido!=null) tmpPedido.setResumenPedido(resumenPedido);
				if(costoTotal!=null) tmpPedido.setCostoTotal(costoTotal.doubleValue());
				if(usuarios_idusuarios!=null) tmpPedido.setUsuarios_idusuarios(usuarios_idusuarios);
				if(productos_idProducto!=null) tmpPedido.setProductos_idProducto(productos_idProducto);

				pedidoRepository.save(tmpPedido);
			} else {
				System.out.println("El Pedido con el id " + id + " no existe.");  // para ver en consola que el pedido no existe
			}
			return tmpPedido;
		}
		
		
		
		
		
		
		
		
		

}
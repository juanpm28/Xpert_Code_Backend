package org.XpertCode.VengadoresDeLaLimpieza.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.XpertCode.VengadoresDeLaLimpieza.models.Servicio;

@Service
public class ServicioServices {

		
		private final ServicioRepository servicioRepository;  //constante del repositorio dentro de services para conectame a la base de datos

		@Autowired
		public ServicioServices(ServicioRepository servicioRepository) {
			this.servicioRepository = servicioRepository;
		} //inyección de dependencias por constructor
		
		public List<Servicio> getServicios() {
			return servicioRepository.findAll();
		}//get para mapear todos los servicios
		
		public Servicio getServicio(Long id) {
			return servicioRepository.findById(id).orElseThrow(
					()->new IllegalArgumentException("El Servicio con el id " + id + " no existe.")
					);
		}//getServicios, para obtener get por ID
		
		public Servicio deleteServicio(Long id) {
			Servicio tmpServicio = null;
			if (servicioRepository.existsById(id)) {
				tmpServicio = servicioRepository.findById(id).get();  //return optional
				servicioRepository.deleteById(id);
			}		
			return tmpServicio;
		}
		
		public Servicio addServicio(Servicio servicio) {  //buscar mejor por SKU
			Servicio tmpServicio = null;
			Optional<Servicio> servicioByNombre = servicioRepository.findByNombre(servicio.getNombre());
			
			if(servicioByNombre.isPresent()) {  // no se puede repetir con esto
				throw new IllegalArgumentException("El Servicio con el SKU [" + servicio.getNombre() + "] no existe.");
			} else {
				servicioRepository.save(servicio);
				tmpServicio = servicio;
			}
			return tmpServicio;
		}
		
		
		
		public Servicio updateServicio(Long id, String nombre, String uRL_imagen, Double precio, String sKU, String fecha, String hora) {
			Servicio tmpServicio = null;
			if (servicioRepository.existsById(id)) {
				tmpServicio = servicioRepository.findById(id).get();  //return optional
				if(nombre!=null) tmpServicio.setNombre(nombre);
				if(uRL_imagen!=null) tmpServicio.setURL_imagen(uRL_imagen);
				if(precio!=null) tmpServicio.setPrecio(precio.doubleValue());
				if(sKU!=null) tmpServicio.setSKU(sKU);
				if(fecha!=null) tmpServicio.setFecha(sKU);
				if(hora!=null) tmpServicio.setHora(sKU);


				servicioRepository.save(tmpServicio);
			} else {
				System.out.println("El Servicio con el id " + id + " no existe.");  // para ver en consola que el servicio no existe
			}
			return tmpServicio;
		}
		
		

}

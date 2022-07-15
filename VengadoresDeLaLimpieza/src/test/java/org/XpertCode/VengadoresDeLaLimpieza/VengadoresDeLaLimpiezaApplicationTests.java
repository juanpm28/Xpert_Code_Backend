package org.XpertCode.VengadoresDeLaLimpieza;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.XpertCode.VengadoresDeLaLimpieza.models.Producto;
import org.XpertCode.VengadoresDeLaLimpieza.models.ChangePassword;
import org.XpertCode.VengadoresDeLaLimpieza.models.Usuario;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class VengadoresDeLaLimpiezaApplicationTests {
	
	@Autowired  // para instanciar de forma automática al momento de ejecutar la prueba
	private MockMvc mockMvc;

	@Test
	public void pruebaProductosPOST() throws Exception {
		Producto p = new Producto();
		p.setNombre("Clorito 2.5L K-POP BTS Kawaii");
		p.setURL_imagen("cloro.jpg");
		p.setSKU("ARITO15");
		p.setPrecio(10.50);
		p.setCantidad(50);
		
		this.mockMvc.perform( post("/api/productoslimpieza/")
				.contentType(MediaType.APPLICATION_JSON)  //tipo de contenidoi
				.content(asUsuariosJsonString(p)) // objeto convertiod a json string
				)
		   .andDo( print() )
		   .andExpect( status().isOk() ) /// status 200
		   .andExpect( content().string(containsString("Clorito") ) );
		
	}
	
	public static String asProductosJsonString(final Object obj) {
	    try {
	      return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }//catch
 } // asJsonString

	
	@Test
//	@Disabled("Deshabilitado temporalmente") //nos estaría mandando un failure
	public void pruebaProductosDELETE() throws Exception {
		this.mockMvc.perform( delete("/api/productoslimpieza/42") )
		   .andDo( print() )
		   .andExpect( status().isOk() ) /// status 200
		   .andExpect( content().string(containsString("Cloro") ) );
		
	}
	
	@Test
	public void pruebaProductosPUT() throws Exception {
		this.mockMvc.perform(put("/api/productoslimpieza/4")
				.queryParam("nombre", "Scotch-Brite Trapeador Limpiador")
//				.header("Authorization", "Bearer: XXXXXXXXXXXXXX")
				)
		.andDo( print() )
		.andExpect( status().isOk() ) /// status 200
			.andExpect( content().string(containsString("Limpiador") ) ); //pregunta si contiene estas palabras

	}
	
	
	@Test
	public void pruebaProductosGET() throws Exception {
	   this.mockMvc.perform( get("/api/productoslimpieza/7") )
	   .andDo( print() )
	   .andExpect( status().isOk() ) /// status 200
	   .andExpect( content().string(containsString("Microfibra") ) );
	
	
	   this.mockMvc.perform( get("/api/productoslimpieza/1") )
	   .andDo( print() )
	   .andExpect( status().isOk() ) /// status 200
	   .andExpect( content().string(containsString("Paquete") ) );

	
	
	   this.mockMvc.perform( get("/api/productoslimpieza/5") )
	   .andDo( print() )
	   .andExpect( status().isOk() ) /// status 200
	   .andExpect( content().string(containsString("Toallas") ) );

	}// pruebaGET


	@Test
	@Disabled("Se validará posteriormente")
	public void pruebaProductos404() throws Exception {
		this.mockMvc.perform( get("/api/productoslimpieza/20") )
		.andDo( print() )
		.andExpect( status().is5xxServerError() ); /// status 200
	}

	
	
// PRUEBAS UNITARIAS USUARIOS	
	
	@Test
//	@Disabled("Deshabilitado temporalmente")
	public void pruebaUsuariosPOST() throws Exception {
		Usuario u = new Usuario();
		u.setNombre("Alfonso Turri");
		u.setCorreo("turri@gmail.com");
		u.setTelefono("5201800666");
		u.setContrasena("password123");
		
		this.mockMvc.perform( post("/api/registros/")
				.contentType(MediaType.APPLICATION_JSON)  //tipo de contenidoi
				.content(asUsuariosJsonString(u)) // objeto convertiod a json string
				)
		   .andDo( print() )
		   .andExpect( status().isOk() ) /// status 200
		   .andExpect( content().string(containsString("Alfonso") ) );
		
	}
	
	public static String asUsuariosJsonString(final Object obj) {
	    try {
	      return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }//catch
 } // asJsonString

	
	@Test
//	@Disabled("Deshabilitado temporalmente") //nos estaría mandando un failure
	public void pruebaUsuariosDELETE() throws Exception {
		this.mockMvc.perform( delete("/api/registros/10") )
		   .andDo( print() )
		   .andExpect( status().isOk() ) /// status 200
		   .andExpect( content().string(containsString("Gustavo") ) );
		
	}
	
	
	@Test
//	@Disabled("Deshabilitado temporalmente")
	public void pruebaUsuariosGET() throws Exception {
	   this.mockMvc.perform( get("/api/registros/7") )
	   .andDo( print() )
	   .andExpect( status().isOk() ) /// status 200
	   .andExpect( content().string(containsString("Pepe") ) );
	
	
	   this.mockMvc.perform( get("/api/registros/9") )
	   .andDo( print() )
	   .andExpect( status().isOk() ) /// status 200
	   .andExpect( content().string(containsString("David") ) );

	
	
	   this.mockMvc.perform( get("/api/registros/3") )
	   .andDo( print() )
	   .andExpect( status().isOk() ) /// status 200
	   .andExpect( content().string(containsString("Juan") ) );

	}// pruebaGET


	@Test
	@Disabled("Se validará posteriormente")
	public void pruebaUsuarios404() throws Exception {
		this.mockMvc.perform( get("/api/registros/20") )
		.andDo( print() )
		.andExpect( status().is5xxServerError() ); /// status 200
	}
	
	
	
}





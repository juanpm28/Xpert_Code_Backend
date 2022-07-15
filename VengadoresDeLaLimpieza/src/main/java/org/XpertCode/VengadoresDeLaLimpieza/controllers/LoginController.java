package org.XpertCode.VengadoresDeLaLimpieza.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import org.XpertCode.VengadoresDeLaLimpieza.models.Token;
import org.XpertCode.VengadoresDeLaLimpieza.models.Usuario;
import org.XpertCode.VengadoresDeLaLimpieza.jwt.config.JwtFilter;
import org.XpertCode.VengadoresDeLaLimpieza.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path="/api/login/")
public class LoginController {
	private final UsuarioServices usuarioServices;
	
	@Autowired
	public LoginController (UsuarioServices usuarioServices) {
		this.usuarioServices = usuarioServices;
	}
	

	@PostMapping
	public Token login (@RequestBody Usuario usuario) throws ServletException {
		if(usuarioServices.validateUsuario(usuario)) {
			return new Token(generateToken(usuario.getCorreo()));
		}
		throw new ServletException("Nombre de usuario o contraseña incorrectos.");
	}
	
	private String generateToken(String correo) {
		Calendar calendar = Calendar.getInstance();  // fecha y hora actual
		calendar.add(Calendar.HOUR, 10);  // para que expire el token en 10 horas
		return Jwts.builder().setSubject(correo).claim("role", "user")  // se genera web token
				.setIssuedAt(new Date()).setExpiration(calendar.getTime())  // va a expirar dentro de...
				.signWith(SignatureAlgorithm.HS256, JwtFilter.secret).compact();  // lo vas a firmar con este alhoritmo
	}// generateToken

	
}//class UsuarioController

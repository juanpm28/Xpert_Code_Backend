package org.XpertCode.VengadoresDeLaLimpieza.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idusuarios", unique=true, nullable=false)
	private Long id;
    private String nombre;
	@Column(name="correo", nullable = false)
    private String correo;
    private String telefono;
	@Column(name="contrasena", nullable = false)
    private String contrasena;

    
public Usuario (Long id, String nombre, String correo, String telefono, String contrasena) {
super();
this.id=id;
this.nombre = nombre;
this.correo = correo;
this.telefono = telefono;
this.contrasena = contrasena;
}//constructor

public Usuario() {
}


public Long getid() {
	return id;
}


public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getCorreo() {
	return correo;
}

public void setCorreo(String correo) {
	this.correo = correo;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

public String getContrasena() {
	return contrasena;
}

public void setContrasena(String contrasena) {
	this.contrasena = contrasena;
}

@Override
public String toString() {
	return "Usuario [idusuarios=" + id + ", nombre=" + nombre + ", correo=" + correo + ", telefono="
			+ telefono + ", contrasena=" + contrasena + "]";
}
}

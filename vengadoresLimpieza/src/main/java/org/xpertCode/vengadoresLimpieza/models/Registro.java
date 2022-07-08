package org.xpertCode.vengadoresLimpieza.models;

public class Registro {

	private String nombre;
	private int telefono;
	private String correo;
	private String password;
	private int id;
	private static int total = 0;

public Registro (String nombre, int telefono, String correo, String password) {
super ();
	this.nombre=nombre;
	this.telefono=telefono;
	this.correo=correo;
	this.password=password;
	total ++;
	this.id = total;
}

public Registro() {
	
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public int getTelefono() {
	return telefono;
}

public void setTelefono(int telefono) {
	this.telefono = telefono;
}

public String getCorreo() {
	return correo;
}

public void setCorreo(String correo) {
	this.correo = correo;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public int getId() {
	return id;
}

@Override
public String toString() {
	return "Registro [nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo + ", password=" + password
			+ ", id=" + id + "]";
}
	

	
 

}













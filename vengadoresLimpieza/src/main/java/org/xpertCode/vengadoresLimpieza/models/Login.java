package org.xpertCode.vengadoresLimpieza.models;

public class Login {

	private String correo;
	private String password;
	private int id;
	private static int total = 0;

public Login (String correo, String password) {
super ();
	this.correo=correo;
	this.password=password;
	total ++;
	this.id = total;
}

public Login() {
	
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
	return "Login [correo=" + correo + ", password=" + password
			+ ", id=" + id + "]";
	}



}
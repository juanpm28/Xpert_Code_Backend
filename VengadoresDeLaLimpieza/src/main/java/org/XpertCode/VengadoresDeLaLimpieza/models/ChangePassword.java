package org.XpertCode.VengadoresDeLaLimpieza.models;

public class ChangePassword{
	private String correo; // es el correo, validación
	private String contrasena;
	private String newContrasena;
	
	
	public ChangePassword(String correo, String contrasena, String newContrasena) {
		super();
		this.correo = correo;
		this.contrasena = contrasena;
		this.newContrasena = newContrasena;
	}

	public ChangePassword() {
		
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNewContrasena() {
		return newContrasena;
	}

	public void setNewContrasena(String newContrasena) {
		this.newContrasena = newContrasena;
	}

	@Override
	public String toString() {
		return "ChangePassword [correo=" + correo + ", contrasena=" + contrasena + ", newContrasena=" + newContrasena
				+ "]";
	}

	
	
}

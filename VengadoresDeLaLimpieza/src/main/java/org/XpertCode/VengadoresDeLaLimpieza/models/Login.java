package org.XpertCode.VengadoresDeLaLimpieza.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Login {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idusuarios", unique=true, nullable=false)
	private Long id;
    private String correo;
    private String contrasena;

    
public Login (Long id, String correo, String contrasena) {
super();
this.id=id;
this.correo = correo;
this.contrasena = contrasena;
}//constructor

public Login() {
}//constructor



public Long getid() {
	return id;
}

public void setidusuarios(Long id) {
	this.id = id;
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

@Override
public String toString() {
	return "Login [id=" + id + ", correo=" + correo + ", contrasena=" + contrasena + "]";
}
}

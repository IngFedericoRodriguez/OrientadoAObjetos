package model;

import java.util.Date;

public class Usuario {
	
	private String nombre;
	//private Date fechaNac;
	
	public Usuario(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

//	public Date getFechaNac() {
//		return fechaNac;
//	}
//
//	public void setFechaNac(Date fechaNac) {
//		this.fechaNac = fechaNac;
//	}

}

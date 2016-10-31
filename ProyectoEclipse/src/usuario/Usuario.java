package usuario;

import java.util.ArrayList;

public class Usuario  {

	private String nombre;
	private String email;
	private ArrayList<Score> scores;

	public Usuario(String nombre, String email) {
		this.nombre = nombre;
		this.email = email;
		scores = new ArrayList<Score>();
	}
	// sobrecarga
	public Usuario(String nombre, String email, ArrayList<Score> scores) {
		this.nombre = nombre;
		this.email = email;
		this.scores = scores;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean soselUsuario(String clave) {
		return this.nombre.equals(clave);
	}
}

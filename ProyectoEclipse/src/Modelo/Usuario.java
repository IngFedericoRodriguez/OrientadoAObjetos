package Modelo;

public class Usuario  {

	private String nombre;
	private String email;
	private int score;

	public Usuario(String nombre, String email) {
		this.nombre = nombre;
		this.email = email;
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
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public boolean soselUsuario(String clave) {
		return this.nombre.equals(clave);
	}
	
	// Metodos de Negocio
	// FIXME: Propuesta disenio:
	// Para que el score este aca, el usuario tiene que conocer a todos los juegos. Esto genera dependencia.
	// Para mi lo mejor es pasar el user al controlador del juego y que el score lo tenga el. 
	
	public void sumarScore(int puntos){
		this.score = puntos + this.score;
	}
}

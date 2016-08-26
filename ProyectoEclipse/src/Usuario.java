
public class Usuario  {

	private String nombre;
	private String email;
	private float score;
	// constructor
	public Usuario(String nombre, String email) {
		super();
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
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public boolean soselUsuario(String clave)
	{
		return this.nombre.equals(clave);
	}
	// Metodos de Negocio
	public void sumarScore(float puntos){
		this.score = puntos + this.score;
	}
	
}

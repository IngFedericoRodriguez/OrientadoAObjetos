
public class Usuario  {

	public String nombre;
	public String email;
	public float score;
	
	public Usuario(String nombre2, String email2) {
		// TODO Auto-generated constructor stub
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

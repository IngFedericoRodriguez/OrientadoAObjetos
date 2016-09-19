package CartasIguales;

public class Carta {
	private int id;
	private String img;
	private String nombre;
	
	public Carta(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public String getImagen() {
		return img;
	}
	
	public String getName() {
		return nombre;
	}
	
	public int getId() {
		return id;
	}

}

package model;

public class Pieza {

	private String nombre;
	private String path;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean soslaPieza(String pieza1) {
		
		return this.getNombre().equals(pieza1);
	}

}

package Modelo;

public class Carta {
	private int id;
	private String imgSource;
	private String texto;
	
	public Carta(int id, String imgSource, String texto) {
		this.id = id;
		this.imgSource = imgSource;
		this.texto = texto;
	}
	
	public Carta(int id, String imgSource) {
		this.id = id;
		this.imgSource = imgSource;
		this.texto = "";
	}
	
	public String imgSource() {
		return imgSource;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTexto() {
		return texto;
	}

}

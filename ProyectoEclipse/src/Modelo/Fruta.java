package Modelo;

public class Fruta extends Carta {
	private int id;
	private String imgSource;
	private String color;
	
	public Fruta(int id,String imgSource, String color) {
		super(id, imgSource);
		this.color=color;
	}
	public String getImgSource() {
		return imgSource;
	}
	
	public int getId() {
		return id;
	}
	
	public String getColor() {
		return color;
	}
}

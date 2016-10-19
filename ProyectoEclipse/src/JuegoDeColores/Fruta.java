package JuegoDeColores;


//es un objeto. Parte del Modelo.
//clase y constructor en mayuscula.
public class Fruta {
	private int id;
	private String imgSource;
	private String color;
	
	
	//constructor
	public Fruta(int id,String imgSource, String color) {
		this.id = id;
		this.imgSource = imgSource;
		this.color=color;
	}
	
	//Getters
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

package CartasIguales;

public class Carta {
	private int id;
	private String imgSource;
	
	public Carta(int id, String imgSource) {
		this.id = id;
		this.imgSource = imgSource;
	}
	
	public String imgSource() {
		return imgSource;
	}
	
	public int getId() {
		return id;
	}

}

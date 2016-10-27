package JuegoDeColores;


import java.awt.*;
import javax.swing.*;

public class ImagenFruta extends JButton{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String color;
	
	
	
	public ImagenFruta(int id, String color) {
		this.id = id;
		this.color =color;
		this.setText(color);
	}
	

	
	public String getColor() {
		return color;
	}
	
	public int getId() {
		return id;
	}
}

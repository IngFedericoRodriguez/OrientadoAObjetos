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
		setPreferredSize(new Dimension(200, 200));
		setBorder(BorderFactory.createEmptyBorder());
		setContentAreaFilled(false);
		setBorder(null);
	}
	

	
	public String getColor() {
		return color;
	}
	
	public int getId() {
		return id;
	}
}

package JuegoDeColores;


import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ImagenFruta extends JButton{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String color;
	ActionListener e;
	
	
	
	public ImagenFruta(int id, String color) {
		this.id = id;
		this.color =color;
		this.setText(color);
		this.addActionListener(e);
	}
	

	
	public String getColor() {
		return color;
	}
	
	public int getId() {
		return id;
	}
}

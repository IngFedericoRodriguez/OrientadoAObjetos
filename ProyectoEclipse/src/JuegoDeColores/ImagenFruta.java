package JuegoDeColores;


import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
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
		setImagen("/imagenes/card.jpg");
	}
	

	
	public String getColor() {
		return color;
	}
	
	public int getId() {
		return id;
	}
	
	private void setImagen(String imgSource) {
		  try {
			    Image img = ImageIO.read(getClass().getResource(imgSource));
			    Image newimg = img.getScaledInstance( 100, 100,  java.awt.Image.SCALE_SMOOTH ) ;
			    setIcon(new ImageIcon(newimg));
			  } catch (IOException ex) {
			  }
		}
}

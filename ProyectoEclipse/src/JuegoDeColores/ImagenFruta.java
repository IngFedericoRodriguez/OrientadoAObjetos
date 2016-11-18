package JuegoDeColores;


import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ImagenFruta extends JButton{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String imgSorce;
	private String color;
	ActionListener e;
	
	
	
	public ImagenFruta(int id,String imgSorce, String color) {
		this.id = id;
		this.color =color;
		this.imgSorce= imgSorce;
		this.setText(color);
		this.addActionListener(e);
		setImagen(imgSorce);
	}
	

	
	public String getColor() {
		return color;
	}
	
	public int getId() {
		return id;
	}
	
	public String getImgSource() {
		return imgSorce;
	}
	
	private void setImagen(String imgSource) {
		  try {
			    Image img = ImageIO.read(getClass().getResource(imgSource));
			//	System.out.println("Imagen fruta "+imgSource);
			    Image newimg = img.getScaledInstance( 100, 100,  java.awt.Image.SCALE_SMOOTH ) ;
			    this.setIcon(new ImageIcon(newimg));
			 //   System.out.println("Imagen fruta "+img);
			 //   System.out.println("Imagen fruta "+newimg);
			  } catch (IOException ex) {
			  }
		}
}

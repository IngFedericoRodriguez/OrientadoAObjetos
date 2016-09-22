package CartasIguales;


import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class VistaCarta extends JButton {

	private static final long serialVersionUID = 1L;
	private int id;
	private String img;
	private String frente;
	private boolean locked;
	private boolean flipped;
	private static final int width = 200;
	private static final int height = 200;
	private static final String tapa = "/imagenes/pokeball.jpg";
	
	public VistaCarta(int id, String frente) {
		this.id = id;
		this.frente = frente;
		locked = false;
		flipped = false;
		setImagen(tapa);
		setPreferredSize(new Dimension(200, 200));
		setBorder(BorderFactory.createEmptyBorder());
		setContentAreaFilled(false);
		setBorder(null);
	}
	
	public boolean isFlipped(){
		return flipped;
	}
	
	
	public void flip() {
		if(!locked) {
			if(!flipped) {
				setImagen(frente);
				flipped = true;
			} else {
				setImagen(tapa);
				flipped = false;
			}
		}
	}
	
	public void lock() {
		locked = true;
	}
	
	public String getImagen() {
		return img;
	}
	
	public int getId() {
		return id;
	}
		
	private void setImagen(String imgSource) {
	  try {
		    Image img = ImageIO.read(getClass().getResource(imgSource));
		    setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
		  }
	}

}

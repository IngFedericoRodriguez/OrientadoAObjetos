package Vista;


import java.awt.Dimension;
import java.awt.Image;
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
	private boolean flipeable;
	private static final String tapa = "/imagenes/card.jpg";
	
	public VistaCarta(int id, String frente, boolean flipeable) {
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
	
	public void setFlipeable(boolean flipeable) {
		this.flipeable = flipeable;
		setImagen(flipeable ? tapa : frente);
	}
	
	public boolean isFlipped(){
		return flipped;
	}
	
	
	public void flip() {
		if(!locked && flipeable) {
			if(!flipped) {
				setImagen(frente);
				flipped = true;
			} else {
				setImagen(tapa);
				flipped = false;
			}
		}
		this.repaint();
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
		    Image newimg = img.getScaledInstance( 100, 100,  java.awt.Image.SCALE_SMOOTH ) ;
		    setIcon(new ImageIcon(newimg));
		  } catch (IOException ex) {
		  }
	}

}

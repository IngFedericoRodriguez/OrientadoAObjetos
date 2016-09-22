package CartasIguales;


import javax.swing.JButton;

public class VistaCarta extends JButton {

	private static final long serialVersionUID = 1L;
	private int id;
	private String img;
	private String nombre;
	private boolean locked;
	private boolean flipped;
	private static final int width = 120;
	private static final int height = 30;
	
	public VistaCarta(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		locked = false;
		flipped = false;
	}
	
	public boolean isFlipped(){
		return flipped;
	}
	
	
	public void flip() {
		if(!locked) {
			if(!flipped) {
				setText(nombre);
				flipped = true;
			} else {
				setText("_____ ");
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
	
	public void render(int row, int cell) {
		// TODO : Change 34 for Final "spacing";
		int posx = 34 + width*cell;
		int posy = 34 + height*row;
		this.setBounds(posx, posy, width, height);
		this.setVisible(true);
		setText("_____ ");
	}

}

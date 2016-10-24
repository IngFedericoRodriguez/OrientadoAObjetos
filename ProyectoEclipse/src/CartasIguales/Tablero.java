package CartasIguales;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Tablero extends JPanel {
	/**
	 *  TODO : Que onda con filas y columnas? parece no ser necesario.
	 */
	private static final long serialVersionUID = 1L;
	private int filas;
	private int columnas;
	private GridLayout layout;
	
	
	public Tablero(int filas, int columnas) {
		
		this.filas = filas;
		this.columnas = columnas;
		// hardcoded dimension. Hay que meter un config file o algo asi.
		setPreferredSize(new Dimension(750, 600));
		crearLayout();
		setearGaps();
	}
	
	private void setearGaps() {
		layout.setHgap(2);
		layout.setVgap(2);
	}
	
	private void crearLayout() {
		layout = new GridLayout(filas, columnas);
		setLayout(layout);
	}
	
	public void agregarCartas(ArrayList<VistaCarta> vistaCartas) {
		for(VistaCarta vista : vistaCartas) {
			add(vista);
			vista.setVisible(true);
			
		}
	}
	
	public void nuevoLayout(int filas, int columnas, ArrayList<VistaCarta> vistaCartas) {
		this.filas = filas;
		this.columnas = columnas;
		crearLayout();
		agregarCartas(vistaCartas);
	}
	

}

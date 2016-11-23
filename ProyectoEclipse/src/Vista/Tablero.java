package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

abstract public class Tablero extends JPanel {

	private static final long serialVersionUID = 1L;
	protected int filas;
	protected int columnas;
	protected boolean usesFliplableCards;
	private GridLayout layout;
	protected ArrayList<VistaCarta> vistas;
	
	
	public Tablero() {
		setPreferredSize(new Dimension(750, 600));
	}
	
	public void setVistaCartas(ArrayList<VistaCarta> vistaCartas) {
		vistas = vistaCartas;
	}
	
	private void setearGaps() {
		layout.setHgap(2);
		layout.setVgap(2);
	}
	
	private void crearLayout() {
		layout = new GridLayout(filas, columnas);
		setLayout(layout);
	}
	
	private void agregarCartas() {
		Collections.shuffle(vistas);
		for(VistaCarta vista : vistas) {
			add(vista);
			vista.setFlipeable(usesFliplableCards);
			vista.setVisible(true);		
		}
	}
	
	public void setVisible(boolean aFlag) {
		nuevoLayout();
		super.setVisible(aFlag);
	}
	
	private void nuevoLayout() {
		crearFilasYColumnas();
		crearLayout();
		agregarCartas();
	}
	
	abstract void crearFilasYColumnas();
}

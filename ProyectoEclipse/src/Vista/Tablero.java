package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

public class Tablero extends JPanel {
	/**
	 *  TODO : Que onda con filas y columnas? parece no ser necesario.
	 */
	private static final long serialVersionUID = 1L;
	private int filas;
	private int columnas;
	private GridLayout layout;
	private ArrayList<VistaCarta> vistas;
	
	
	public Tablero(ArrayList<VistaCarta> vistaCartas) {
		vistas = vistaCartas;
		// hardcoded dimension. Hay que meter un config file o algo asi.
		setPreferredSize(new Dimension(750, 600));
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
			vista.setVisible(true);		
		}
	}
	
	public void setVisible(boolean aFlag) {
		nuevoLayout();
		super.setVisible(aFlag);
	}
	
	private void nuevoLayout() {
		int elementosTotales = vistas.size();
		int filas = 2;
		int columnas = elementosTotales%3 == 0 ? elementosTotales/3 : elementosTotales/2;
		boolean encontrado = false;
		while (!encontrado && filas < elementosTotales) {
			if(filas * columnas == elementosTotales) {
				encontrado = true;
			} else {
				filas++;
			} 
		}
		this.filas = filas;
		this.columnas = columnas;
		crearLayout();
		agregarCartas();
	}
}

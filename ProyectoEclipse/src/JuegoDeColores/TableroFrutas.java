package JuegoDeColores;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

public class TableroFrutas extends JPanel {
	/**
	 *  TODO : Que onda con filas y columnas? parece no ser necesario.
	 */
	private static final long serialVersionUID = 1L;
	private int filas;
	private int columnas;
	private GridLayout layout;
	private ArrayList<ImagenFruta> vistas;
	
	
	public TableroFrutas(ArrayList<ImagenFruta> vistaCartas) {
		vistas = vistaCartas;
		// hardcoded dimension. Hay que meter un config file o algo asi.
		setPreferredSize(new Dimension(700, 300));
		//setBounds(100,100,100,100);
		
	}
	
	private void setearGaps() {
		layout.setHgap(2);
		layout.setVgap(1);
	}
	
	private void crearLayout() {
		layout = new GridLayout(filas, columnas);
		setLayout(layout);
	}
	
	private void agregarCartas() {
		Collections.shuffle(vistas);
		for(ImagenFruta vista : vistas) {
			add(vista);
			vista.setVisible(true);		
		}
	}
	
	public void setVisible(boolean aFlag) {
		nuevoLayout();
		super.setVisible(aFlag);
	}
	
	public void setVisible1() {
		layout = new GridLayout(3, 0);
		layout.setHgap(2);
		layout.setVgap(2);
		setLayout(layout);
		setVisible(true);
		
	}
	
	private void nuevoLayout() {
		int elementosTotales = vistas.size();
		int filas = 5;
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

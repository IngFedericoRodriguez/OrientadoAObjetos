package CartasIguales;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class VentanaJuego extends JFrame {
 
	private static final long serialVersionUID = 1L;
	private Marcador marcador;
	private Tablero tablero;

	
	public VentanaJuego() {
		super("PokeMemoria");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBaseLayout();
	}
	
	private void setBaseLayout(){
		GridLayout layout = new GridLayout(2,0);
		layout.setHgap(5);
		layout.setVgap(5);
		getContentPane().setLayout(layout);
	}
	
	public void agregarMarcador(Marcador marcador) {
		this.marcador = marcador;
		this.getContentPane().add(marcador, BorderLayout.SOUTH);
	}
	
	public void agregarTablero(Tablero tablero) {
		this.tablero = tablero;
		this.getContentPane().add(tablero, BorderLayout.CENTER);
	}
	
	public void setVisible(boolean flag) {
		tablero.setVisible(flag);
		marcador.setVisible(flag);
		pack();
		super.setVisible(flag);
	}

	// Como parte de la vista, esto solo tiene que devolver la opcion elejida y delegar en el controlador la accion.
	public int juegoGanado() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult =  JOptionPane.showConfirmDialog (null, "Queres jugar el proximo nivel?","PokeCards", dialogButton);
		return dialogResult;
	}
}

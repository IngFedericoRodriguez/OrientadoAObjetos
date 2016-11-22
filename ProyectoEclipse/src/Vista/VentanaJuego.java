package Vista;

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

import Controlador.ControladorJuego;

abstract public class VentanaJuego extends JFrame implements ActionListener {
 
	private static final long serialVersionUID = 1L;
	protected Marcador marcador;
	protected Tablero tablero;
	protected ControladorJuego controladorJuego;


	public VentanaJuego(Tablero tablero) {
		super("PokeMemoria");
		this.tablero = tablero;
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBaseLayout();
	}
	
	public void setControladorJuego(ControladorJuego controladorJuego) {
		this.controladorJuego = controladorJuego;
	}
	
	abstract protected void setBaseLayout();
	
	abstract public void reset();
	
	public void agregarMarcador() {
		marcador = new Marcador();
		this.getContentPane().add(marcador, BorderLayout.SOUTH);
	}
	
	public void agregarTablero(ArrayList<VistaCarta> vistaCartas){
		for(VistaCarta vistaCarta : vistaCartas) {
			vistaCarta.addActionListener(this);
		}
		tablero.setVistaCartas(vistaCartas);
		this.getContentPane().add(tablero, BorderLayout.CENTER);
	}
	
	public void setVisible(boolean flag) {
		tablero.setVisible(flag);
		marcador.setVisible(flag);
		pack();
		super.setVisible(flag);
	}

	
	protected void updateSocre() {
		marcador.updatePuntos(Integer.toString(controladorJuego.getPuntos()));
		marcador.updateAdivinadas(Integer.toString(controladorJuego.getAdivinadas()));
		marcador.updateIntentos(Integer.toString(controladorJuego.getIntentos()));
	}
	
	
	public int jugarNuevo() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult =  JOptionPane.showConfirmDialog (null, "Queres jugar el proximo nivel?","PokeCards", dialogButton);
		return dialogResult;
	}
}

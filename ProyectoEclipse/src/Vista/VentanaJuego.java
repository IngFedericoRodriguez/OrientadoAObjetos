package Vista;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Controlador.Controlador;
import Controlador.ControladorJuego;

abstract public class VentanaJuego extends JFrame implements ActionListener {
 
	private static final long serialVersionUID = 1L;
	protected Marcador marcador;
	protected Tablero tablero;
	protected Controlador controladorJuego;


	public VentanaJuego(Tablero tablero) {
		this.tablero = tablero;
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBaseLayout();
	}
	
	public void setControladorJuego(Controlador controladorJuego) {
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

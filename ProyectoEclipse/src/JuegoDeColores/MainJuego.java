package JuegoDeColores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import CartasIguales.Juego;
import CartasIguales.VentanaJuego;
import JuegoDeColores.JuegoColores;

public class MainJuego {
	private JuegoColores juegoColores;
	private Ventana ventana;
	private int state;
	
	public static void main(String[] args) {

		MainJuego inst = new MainJuego(new JuegoColores());
		inst.jugar();
	}

	public MainJuego(JuegoColores juego) {
		this.juegoColores = juego;
	}
	
	public void resetState() {
		this.state = 0;
	}
	
	public void jugar() {
		juegoColores.init();
		ventana = new Ventana("Jueguito de frutas");
		ventana.setController(this);
		ventana.setVisible(true);
	}
	
	public void adivinarColor(String color) {
		if(juegoColores.compararColor(color)) {
			System.out.println("Ganaste");
		} else {
			System.out.println("Perdiste");
		}
	}
	
	
}

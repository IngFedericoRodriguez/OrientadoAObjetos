package JuegoDeColores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

import Modelo.Carta;
import Modelo.JuegoColores;
import Modelo.Usuario;
import Vista.TableroJuegoColores;
import Vista.VentanaJuego;
import Vista.VentanaJuegoFrutas;
import Vista.VistaCarta;

public class MainJuego {
	private JuegoColores juegoColores;
	private VentanaJuegoFrutas ventana;
//	private int nivel=0;
	private Usuario usuario;
	
	public static void main(String[] args) {

		MainJuego inst = new MainJuego(new JuegoColores(new Usuario("fede","mail")));//hardcoded
		inst.jugar();
	}

	public MainJuego(JuegoColores juego) {
		this.juegoColores = juego;
		juegoColores.inicializar();
		jugar();
	}
	

	public void jugar() {
		ventana = new VentanaJuegoFrutas(new TableroJuegoColores());
		ventana.agregarTablero(generarVistaCartas(juegoColores.getCartas()));
		ventana.agregarVistaPregunta();
		//ventana.setControladorJuego(this);
	 	ventana.agregarMarcador();
		ventana.setVisible(true);
	//	ventana.agregarTablero2(listaImagenFruta(juegoColores.getLevel()));
	//	juegoNuevo();
	}
	
	private ArrayList<VistaCarta> generarVistaCartas(ArrayList<Carta> cartas) {
		ArrayList<VistaCarta> vistaCartas = new ArrayList<VistaCarta>();
		for(Carta carta : cartas) {
			VistaCarta vistaCarta = new VistaCarta(carta.getId(), carta.imgSource(), false);
			vistaCartas.add(vistaCarta);
		}
		return vistaCartas;
	}
	

}

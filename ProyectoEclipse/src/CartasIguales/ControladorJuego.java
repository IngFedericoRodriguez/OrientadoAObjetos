package CartasIguales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import usuario.Usuario;

public class ControladorJuego {
	private Juego juego;
	private VentanaJuego ventana;
	private Usuario usuario;
	
	public ControladorJuego(Juego juego, Usuario usuario) {
		this.juego = juego;
		this.usuario = usuario;
		juego.setLevel(usuario.getScore("CartasIguales").getNivel());
		ventana = new VentanaJuego();
	}
	
	public void jugar() {
		juego.init();
	 	ventana.agregarTablero(generarVistaCartas(juego.getCartas()));
	 	ventana.agregarMarcador();
		// Hacer todos estos elementos de UI injectables
		// TODO : Crear un UI builder. Abstraer el controlador para los dos juegos.
		ventana.setControladorJuego(this);
		ventana.setVisible(true);
	}
	
	private ArrayList<VistaCarta> generarVistaCartas(ArrayList<Carta> cartas) {
		ArrayList<VistaCarta> vistaCartas = new ArrayList<VistaCarta>();
		for(Carta carta : cartas) {
			VistaCarta vistaCarta = new VistaCarta(carta.getId(), carta.imgSource());
			vistaCartas.add(vistaCarta);
		}
		return vistaCartas;
	}
		
	public void nuevoNivel(int continuar){
		switch (continuar) {
			case 0 :
				crearNuevoNivel();
				break;
			case 1 :
				ventana.setVisible(false);
			    ventana.dispose();
				break;
		}
	}
	
	public int getAdivinadas() {
		return juego.getAdivinadas();
	}
	
	public int getIntentos() {
		return juego.getIntentos();
	}
	
	public int getPuntos() {
		return juego.getPuntos();
	}
	
	private void crearNuevoNivel() {
		juego.nuevoLevel();
		juego.reset();
		ventana.getContentPane().removeAll();
		jugar();
	}
	
	public boolean match(int id1, int id2) {
		return juego.match(id1, id2);
	}
	
	public boolean nivelGanado() {
		if(juego.nivelGanado()) {
			usuario.getScore("CartasIguales").agregarPuntos(juego.getPuntos());
			usuario.getScore("CartasIguales").setNivel(juego.getLevel()+1);
			return true;
		} 
		return false;
	}
	


}

package CartasIguales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import usuario.Usuario;

public class ControladorJuego {
	private JuegoCartas juegoCartas;
	private VentanaJuego ventana;
	private Usuario usuario;
	
	public ControladorJuego(JuegoCartas juegoCartas, Usuario usuario) {
		this.juegoCartas = juegoCartas;
		this.usuario = usuario;
		juegoCartas.setLevel(usuario.getScore("CartasIguales").getNivel());
		ventana = new VentanaJuego();
	}
	
	public void jugar() {
		juegoCartas.init();
	 	ventana.agregarTablero(generarVistaCartas(juegoCartas.getCartas()));
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
		return juegoCartas.getAdivinadas();
	}
	
	public int getIntentos() {
		return juegoCartas.getIntentos();
	}
	
	public int getPuntos() {
		return juegoCartas.getPuntos();
	}
	
	private void crearNuevoNivel() {
		juegoCartas.nuevoLevel();
		juegoCartas.reset();
		ventana.getContentPane().removeAll();
		jugar();
	}
	
	public boolean match(int id1, int id2) {
		return juegoCartas.match(id1, id2);
	}
	
	public boolean nivelGanado() {
		if(juegoCartas.nivelGanado()) {
			usuario.getScore("CartasIguales").agregarPuntos(juegoCartas.getPuntos());
			usuario.getScore("CartasIguales").setNivel(juegoCartas.getLevel()+1);
			return true;
		} 
		return false;
	}
	


}

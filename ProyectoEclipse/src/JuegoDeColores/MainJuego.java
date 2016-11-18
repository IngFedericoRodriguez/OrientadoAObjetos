package JuegoDeColores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

import CartasIguales.Juego;
import CartasIguales.VentanaJuego;
import JuegoDeColores.JuegoColores;
import usuario.Usuario;

public class MainJuego {
	private JuegoColores juegoColores;
	private Ventana ventana;
	private int nivel=0;
	private Usuario usuario;
	
	public static void main(String[] args) {

		MainJuego inst = new MainJuego(new JuegoColores(),new Usuario("fede","mail"));
		inst.jugar();
	}

	public MainJuego(JuegoColores juego, Usuario usuario) {
		this.juegoColores = juego;
		this.usuario = usuario;
	}
	

	public void jugar() {
		
		ventana = new Ventana("Jueguito de frutas");
		ventana.setController(this);
		ventana.setVisible(true);
		ventana.agregarTablero2(listaImagenFruta(nivel));
	//	juegoNuevo();
	}
	
	public boolean adivinarColor(String color) {
		if(juegoColores.compararColor(color)) {
			System.out.println("Ganaste");
			return true;
		} else {
			System.out.println("Perdiste");
			return false;
		}
	}
	
	public void juegoNuevo(){
		System.out.println("Has iniciado un juego Nuevo");
		juegoColores.init();
		String colorGanador= juegoColores.getColorGanador();
		ventana.modificarPregunta("Elige la fruta Color "+ colorGanador);
		ventana.modificarTablero2(listaImagenFruta(nivel));
	}
	
	private ArrayList<ImagenFruta> listaImagenFruta(int nivel){
		ArrayList<ImagenFruta> listaImagenFruta = new ArrayList<ImagenFruta>();
		for(int i=1;i<nivel+5;i++){
			Fruta frutadepaso= juegoColores.getFrutaNoGanadora();
			ImagenFruta botonFruta= new ImagenFruta(i,frutadepaso.getImgSource(),frutadepaso.getColor());
			listaImagenFruta.add(botonFruta);
		}
		Fruta frutadepaso= juegoColores.getFrutaGanadora();
		ImagenFruta botonFruta= new ImagenFruta(0,frutadepaso.getImgSource(),frutadepaso.getColor());
		listaImagenFruta.add(botonFruta);
		//System.out.println("estees el color ganador "+botonFruta.getColor()+ botonFruta.getImgSource());
		
		return listaImagenFruta;
		
		
	}
	

	
	public void nuevoNivel(int continuar){
		switch (continuar) {
			case 0 :
				juegoNuevo();
				//crearNuevoNivel();
				break;
			case 1 :
				ventana.setVisible(false);
			    ventana.dispose();
				break;
		}
	}
	
	public boolean nivelGanado() {
		if(juegoColores.nivelGanado()) {
			usuario.getScore("JuegoDeColores").agregarPuntos(juegoColores.getPuntos());
			usuario.getScore("JuegoDeColores").setNivel(juegoColores.getLevel()+1);
			return true;
		} 
		return false;
	}
	
}

package CartasIguales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

public class ControladorJuego implements ActionListener {
	private Juego juego;
	private int state;
	private Timer myTimer;
	private VistaCarta carta1;
	private VistaCarta carta2;
	private Tablero tablero;
	private VentanaJuego ventana;
	private Marcador marcador;
	
	public ControladorJuego(Juego juego) {
		this.juego = juego;
		ventana = new VentanaJuego();
		 myTimer = new Timer(250, this);
	}
	
	public void resetState() {
		this.state = 0;
	}
	
	public void jugar() {
		juego.init();
		ArrayList<VistaCarta> vistaCartas = generarVistaCartas(juego.getCartas());
		// Hacer todos estos elementos de UI injectables
		// TODO : Crear un UI builder. Abstraer el controlador para los dos juegos.
		tablero = new Tablero(vistaCartas);
		ventana.agregarTablero(tablero);
		marcador = new Marcador();
		ventana.agregarMarcador(marcador);
		ventana.setVisible(true);
	}
	
	private ArrayList<VistaCarta> generarVistaCartas(ArrayList<Carta> cartas) {
		ArrayList<VistaCarta> vistaCartas = new ArrayList<VistaCarta>();
		for(Carta carta : cartas) {
			VistaCarta vistaCarta = new VistaCarta(carta.getId(), carta.imgSource());
			vistaCarta.addActionListener(this);
			vistaCartas.add(vistaCarta);
		}
		return vistaCartas;
	}

	// TODO: Crear event listeners que sean objetos.
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == myTimer) {
			carta1.flip();
			carta2.flip();
			myTimer.stop();
		} else {
			VistaCarta vistaCarta = (VistaCarta) e.getSource();
			if(!vistaCarta.isFlipped()){
				switch (state) {
					case 0:
						carta1 = vistaCarta;
						carta1.flip();
						break;
					case 1:
						carta2 = vistaCarta;
						carta2.flip();
						break;
				}
				state++;
			}
			if (state == 2) {
				boolean match = juego.match(carta1.getId(), carta2.getId());
				if(match) {
					carta2.lock();
					carta1.lock();
				} else {
					myTimer.start();
				}
				state = 0;
				updateSocre();
				if (juego.nivelGanado()) {
					juegoGanado();
				}	
			}
		}
    }
	
	public void wait(int n){
        long t0, t1;
        t0 =  System.currentTimeMillis();
        do{
            t1 = System.currentTimeMillis();
        }
        while ((t1 - t0) < (n * 1000));
    }
	
	private void juegoGanado(){
		int continuar = ventana.juegoGanado();
		switch (continuar) {
			case 0 :
				newLevel();
				break;
			case 1 :
				ventana.setVisible(false);
			    ventana.dispose();
				break;
		}
	}
	
	
	private void newLevel() {
		juego.nuevoLevel();
		juego.reset();
		ventana.getContentPane().removeAll();
		jugar();
	
	}
	
	private void updateSocre() {
		marcador.updateAdivinadas(Integer.toString(juego.getAdivinadas()));
		marcador.updateIntentos(Integer.toString(juego.getIntentos()));
	}

}

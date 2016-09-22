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
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

// TODO Crear "Tablero" que implemente el ActionListener y Runneable
// Mover toda la logica de creacion de botones al tablero.
// Mover los marcadores al tablero.
// Volver a hacer que esta clase extienda a Jframe? No se, hay que ver cuando lo unamos con el resto del programa.
// Si esto puede ser un JPanel, esto se convierte en el tablero, para MVC es medio raro, el modelo interactua con las vistas directamente?.
// 


public class MainJuego extends JFrame implements ActionListener, Runnable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Juego juego;
	private VistaCarta carta1;
	private VistaCarta carta2;
	private int state;
	private Marcador marcador;
	private Tablero tablero;
	
	public static void main(String[] args) {
		MainJuego inst = new MainJuego();
		inst.run();
	}
	
	public MainJuego() {
		super("PokeMemoria");
		this.setResizable(true);
		this.setSize(800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		juego = new Juego();
		juego.init();
		state = 0;
	}
	
	public void run() {
		setBaseLayout();
		crearTablero(juego.getCuentaCartas());
		llenarTablero();
		tablero.setVisible(true);
		crearMarcador();
		marcador.setVisible(true);
		this.setVisible(true);
		pack();

	}
		
	private void setBaseLayout(){
		GridLayout layout = new GridLayout(2,0);
		layout.setHgap(15);
		layout.setVgap(10);
		setLayout(layout);
	}
	
	private void crearTablero(int total) {
		int i = 2;
		boolean encontrado = false;
		while (i <= 9 && !encontrado) {
			// tengo que encontrar una matris de NxN
			if(total%i == 0) {
				tablero = new Tablero(i, i);
				encontrado = true;
				this.getContentPane().add(tablero, BorderLayout.NORTH);
			}
			i++;
		}
	}
	
	public void resetState() {
		this.state = 0;
	}
	

	
	private void crearMarcador() {
		marcador = new Marcador();
		this.getContentPane().add(marcador, BorderLayout.SOUTH);
	}
	
	private void llenarTablero() {
		ArrayList<Carta> cartas = juego.getCartas();
		ArrayList<VistaCarta> vistaCartas = new ArrayList<VistaCarta>();
		for(Carta carta : cartas) {
			vistaCartas.add(new VistaCarta(carta.getId(), carta.imgSource()));
		}
		Collections.shuffle(vistaCartas);
		for(VistaCarta vista : vistaCartas) {
			vista.addActionListener(this);
		}
		tablero.agregarCartas(vistaCartas);
	}

	public void actionPerformed(ActionEvent e) {
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
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				carta1.flip();
				carta2.flip();
			}
			state = 0;
			updateSocre();
			if (juego.nivelGanado()) {
				juegoGanado();
			}
				
		}
	}
	
	private void updateSocre() {
		marcador.updateAdivinadas(Integer.toString(juego.getAdivinadas()));
		marcador.updateIntentos(Integer.toString(juego.getIntentos()));
	}
	
	private void juegoGanado() {

	}

}

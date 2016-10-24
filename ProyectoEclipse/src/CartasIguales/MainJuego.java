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
	private Timer myTimer;

	
	public static void main(String[] args) {
		MainJuego inst = new MainJuego();
		inst.run();
	}
	
	public MainJuego() {
		super("PokeMemoria");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBaseLayout();
		juego = new Juego();
		juego.init();
		state = 0;
		myTimer = new Timer(250, this);
	}
	
	public void run() {
		crearTablero(juego.getCuentaCartas());
		llenarTablero();
		tablero.setVisible(true);
		crearMarcador();
		marcador.setVisible(true);
		pack();
		this.setVisible(true);
	}
	
		
	private void setBaseLayout(){
		GridLayout layout = new GridLayout(2,0);
		layout.setHgap(5);
		layout.setVgap(5);
		getContentPane().setLayout(layout);
	}
	
	private void crearTablero(int total) {
		int filas = 2;
		int columnas = total%3 == 0 ? total/3 : total/2;
		boolean encontrado = false;
		while (!encontrado && filas < total) {
			if(filas * columnas == total) {
				tablero = new Tablero(columnas, filas);
				encontrado = true;
				this.getContentPane().add(tablero, BorderLayout.CENTER);
			} else {
				filas++;
			} 
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
		if(e.getSource() == myTimer) {
			carta1.flip();
			carta2.flip();
			myTimer.stop();
		} else {
			VistaCarta vistaCarta = (VistaCarta) e.getSource();
			if(!vistaCarta.isFlipped()){
				System.out.println(Integer.toString(state));
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
	
	private void newLevel() {
		juego.nuevoLevel();
		juego.reset();
		juego.init();
		this.getContentPane().removeAll();
		this.run();
		this.repaint();
		
	}
	
	private void updateSocre() {
		marcador.updateAdivinadas(Integer.toString(juego.getAdivinadas()));
		marcador.updateIntentos(Integer.toString(juego.getIntentos()));
	}
	
	private void juegoGanado() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult =  JOptionPane.showConfirmDialog (null, "Queres jugar el proximo nivel?","PokeCards",dialogButton);
		switch (dialogResult) {
			case 0:
				this.newLevel();
				break;
			case 1:
				break;
			default:
				break;
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


}

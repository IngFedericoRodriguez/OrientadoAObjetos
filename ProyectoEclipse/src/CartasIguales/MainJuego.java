package CartasIguales;

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


public class MainJuego extends JPanel implements ActionListener, Runnable {
 
	private Juego juego;
	private VistaCarta carta1;
	private VistaCarta carta2;
	private int state;
	private Marcador intentos;
	private Marcador aciertos;
	
	public static void main(String[] args) {
		MainJuego inst = new MainJuego();

	}
	
	public MainJuego() {
		super();
		juego = new Juego();
		juego.init();
		run();
		state = 0;
	}
	
	public void resetState() {
		this.state = 0;
	}
	
	public void run() {
		JFrame frame = new JFrame("Memory");
		frame.add(this);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		crearVistaDeCartas();
		crearMarcadores();
	}
	
	private void crearMarcadores() {
		intentos = new Marcador("Intentos:", JLabel.TOP, JLabel.CENTER);
		aciertos = new Marcador("Aciertos", JLabel.BOTTOM, JLabel.CENTER);
		add(intentos);
		add(aciertos);
	}
	
	private void crearVistaDeCartas() {
		ArrayList<Carta> cartas = juego.getCartas();
		ArrayList<VistaCarta> vistaCartas = new ArrayList<VistaCarta>();
		for(Carta carta : cartas) {
			vistaCartas.add(new VistaCarta(carta.getId(), carta.getName()));
		}
		Collections.shuffle(vistaCartas);
		int row = 1;
		int cell = 1;
		for(VistaCarta vista : vistaCartas) {
			// on new row
			if(cell%5 == 0) {
				row++;
				cell = 1;
			}
			vista.render(row, cell);
			vista.addActionListener(this);
			vista.setVisible(true);
			add(vista);
			cell++;
		}
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
					carta1.flip();
					carta2.flip();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			state = 0;
			updateSocre();
			if (juego.nivelGanado()) {
				juegoGanado();
			}
				
		}
	}
	
	private void updateSocre() {
		intentos.updateScore(Integer.toString(juego.getIntentos()));
		aciertos.updateScore(Integer.toString(juego.getAdivinadas()));
	}
	
	private void juegoGanado() {
		Marcador pepe = new Marcador("JUEGO GANADO!!!!!", JLabel.BOTTOM, JLabel.LEFT);
		add(pepe);
		
	}

}

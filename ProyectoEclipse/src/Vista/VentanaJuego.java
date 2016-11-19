package Vista;

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

import Controlador.ControladorJuego;

public class VentanaJuego extends JFrame implements ActionListener {
 
	private static final long serialVersionUID = 1L;
	private Marcador marcador;
	private Tablero tablero;
	private Timer myTimer;
	private VistaCarta carta1;
	private VistaCarta carta2;
	private ControladorJuego controladorJuego;
	private int state;


	
	public VentanaJuego() {
		super("PokeMemoria");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBaseLayout();
		 myTimer = new Timer(250, this);
	}
	
	public void setControladorJuego(ControladorJuego controladorJuego) {
		this.controladorJuego = controladorJuego;
	}
	
	private void setBaseLayout(){
		GridLayout layout = new GridLayout(2,0);
		layout.setHgap(5);
		layout.setVgap(5);
		getContentPane().setLayout(layout);
	}
	
	public void agregarMarcador() {
		marcador = new Marcador();;
		this.getContentPane().add(marcador, BorderLayout.SOUTH);
	}
	
	public void agregarTablero(ArrayList<VistaCarta> vistaCartas){
		for(VistaCarta vistaCarta : vistaCartas) {
			vistaCarta.addActionListener(this);
		}
		tablero = new Tablero(vistaCartas);
		this.getContentPane().add(tablero, BorderLayout.CENTER);
	}
	
	public void setVisible(boolean flag) {
		tablero.setVisible(flag);
		marcador.setVisible(flag);
		pack();
		super.setVisible(flag);
	}

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
				boolean match = controladorJuego.match(carta1.getId(), carta2.getId());
				if(match) {
					carta2.lock();
					carta1.lock();
				} else {
					myTimer.start();
				}
				state = 0;
				updateSocre();
				if (controladorJuego.nivelGanado()) {
					controladorJuego.nuevoNivel(jugarNuevo());
				}	
			}
		}
    }
	
	private void updateSocre() {
		marcador.updatePuntos(Integer.toString(controladorJuego.getPuntos()));
		marcador.updateAdivinadas(Integer.toString(controladorJuego.getAdivinadas()));
		marcador.updateIntentos(Integer.toString(controladorJuego.getIntentos()));
	}
	
	public void wait(int n){
        long t0, t1;
        t0 =  System.currentTimeMillis();
        do{
            t1 = System.currentTimeMillis();
        }
        while ((t1 - t0) < (n * 1000));
    }
	
	public int jugarNuevo() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult =  JOptionPane.showConfirmDialog (null, "Queres jugar el proximo nivel?","PokeCards", dialogButton);
		return dialogResult;
	}
}

package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.Timer;

public class VentanaJuegoCartas extends VentanaJuego{
	private static final long serialVersionUID = 1L;
	private VistaCarta carta1;
	private VistaCarta carta2;
	private int state;
	private Timer myTimer;
	
	public VentanaJuegoCartas(Tablero tablero) {
		super(tablero);
		 myTimer = new Timer(250, this);
	}

	protected void setBaseLayout(){
		GridLayout layout = new GridLayout(2,0);
		layout.setHgap(5);
		layout.setVgap(5);
		getContentPane().setLayout(layout);
	}
	
	public void reset() {
		this.tablero.removeAll();
		this.marcador.removeAll();
		getContentPane().removeAll();
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
	
	public void setVisible(boolean aflag) {
		tablero.setVisible(aflag);
		marcador.setVisible(aflag);
		super.setVisible(aflag);
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

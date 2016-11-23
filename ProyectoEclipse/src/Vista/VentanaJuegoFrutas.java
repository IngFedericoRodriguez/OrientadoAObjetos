package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import JuegoDeColores.VistaPregunta;

public class VentanaJuegoFrutas extends VentanaJuego {

	
	private static final long serialVersionUID = 1L;
	private VistaPregunta vistaPregunta;
	
	public VentanaJuegoFrutas(Tablero tablero) {
		super(tablero);
		agregarVistaPregunta();
	}
	
	public void setVisible(boolean aflag) {
		vistaPregunta.setPregunta("pepe");
		tablero.setVisible(aflag);
		vistaPregunta.setVisible(aflag);
		marcador.setVisible(aflag);
		super.setVisible(aflag);
	}

	@Override
	protected void setBaseLayout() {
		GridLayout layout = new GridLayout(3,0);
		layout.setHgap(5);
		layout.setVgap(5);
		getContentPane().setLayout(layout);
		
	}
	
	 private void agregarVistaPregunta() {
		 vistaPregunta = new VistaPregunta();
		 this.add(vistaPregunta);
	 }

	@Override
	public void reset() {
		this.tablero.removeAll();
		this.marcador.removeAll();
		getContentPane().removeAll();
	}
	
	public void actionPerformed(ActionEvent e) {
		VistaCarta vistaCarta = (VistaCarta) e.getSource();
			System.out.println(vistaCarta.getId());
	}

}

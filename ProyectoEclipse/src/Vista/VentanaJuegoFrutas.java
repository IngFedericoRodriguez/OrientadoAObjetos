package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import JuegoDeColores.VistaPregunta;

public class VentanaJuegoFrutas extends VentanaJuego {

	
	private static final long serialVersionUID = 1L;
	private VistaPregunta vistaPregunta;
	
	public VentanaJuegoFrutas(Tablero tablero) {
		super(tablero);
	}
	
	public void setVisible(boolean aflag) {
		tablero.setVisible(aflag);
		vistaPregunta.setVisible(aflag);
		marcador.setVisible(aflag);
		super.setVisible(aflag);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setBaseLayout() {
		GridLayout layout = new GridLayout(3,0);
		layout.setHgap(5);
		layout.setVgap(5);
		getContentPane().setLayout(layout);
		
	}
	
	 public void agregarVistaPregunta() {
		 vistaPregunta = new VistaPregunta();
		 this.add(vistaPregunta);
	 }

	@Override
	public void reset() {
		this.tablero.removeAll();
		this.marcador.removeAll();
		getContentPane().removeAll();
	}

}

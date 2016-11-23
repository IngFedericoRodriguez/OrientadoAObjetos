package Vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class VentanaJuegoFrutas extends VentanaJuego {

	
	private static final long serialVersionUID = 1L;
	private VistaPregunta vistaPregunta;
	
	public VentanaJuegoFrutas(Tablero tablero) {
		super(tablero);
	}
	
	public void setVisible(boolean aflag) {
		agregarVistaPregunta();
		vistaPregunta.setPregunta(this.controladorJuego.getLevelExtraInfo());
		tablero.setVisible(aflag);
		vistaPregunta.setVisible(aflag);
		marcador.setVisible(aflag);
		updateSocre();
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
		this.getContentPane().add(vistaPregunta, BorderLayout.NORTH);
	 }

	@Override
	public void reset() {
		this.vistaPregunta.removeAll();
		this.tablero.removeAll();
		this.marcador.removeAll();
		getContentPane().removeAll();
	}
	
	public void actionPerformed(ActionEvent e) {
		VistaCarta vistaCarta = (VistaCarta) e.getSource();
			if(controladorJuego.match(vistaCarta.getId())) {
				updateSocre();
				controladorJuego.nivelGanado("JuegoFrutas");
				controladorJuego.nuevoNivel(jugarNuevo());
			} else {
				updateSocre();
			}
	}

}

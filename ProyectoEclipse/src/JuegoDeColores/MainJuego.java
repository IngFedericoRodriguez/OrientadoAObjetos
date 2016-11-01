package JuegoDeColores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import CartasIguales.Juego;
import CartasIguales.VentanaJuego;
import JuegoDeColores.JuegoColores;

public class MainJuego implements ActionListener {
	private JuegoColores juegoColores;
	private Ventana ventana;
	private int state;
	
	public static void main(String[] args) {
		MainJuego inst = new MainJuego(new JuegoColores());
		inst.jugar();
	}

	public MainJuego(JuegoColores juego) {
		this.juegoColores = juego;
		ventana = new Ventana();
	}
	
	public void resetState() {
		this.state = 0;
	}
	

	
	public void jugar() {
		System.out.print("Estoy corriendo");
		juegoColores.init();
		String colorGanador = juegoColores.getColorGanador();
		ventana=new Ventana();
		ventana.setLocationRelativeTo(null);//centra la pantalla 
		ventana.setVisible(true); 
		
		//listeners
		ventana.fileNew.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
				  ventana.actualizarFrase("Elija fruta color "+colorGanador);
				  ventana.actualizarPuntos(0);
				  }
		 });
		
		
	
		

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getSource());
	}
	


}

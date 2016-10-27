package JuegoDeColores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import JuegoDeColores.JuegoColores;

public class MainJuego {

	public static void main(String[] args) {
		MainJuego inst = new MainJuego();
		inst.run();
	}
	
	public void run() {
		System.out.print("Estoy corriendo");
		JuegoColores juego= new JuegoColores();
		String colorGanador = juego.getColorGanador();
		Ventana ventana=new Ventana();
		ventana.setVisible(true); 
		
		ventana.fileNew.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
				   ventana.textField.setText(colorGanador);
				    ventana.frase.setText("Elija la fruta color "+ventana.textField.getText());
				  }
		 });
		


	}
	


}

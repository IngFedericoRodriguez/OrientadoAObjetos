package JuegoDeColores;

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
/*		ImagenFruta imagenFruta1= new ImagenFruta(1,"rojo");
		imagenFruta1.setBounds(800,20,200,20);
		ventana.getContentPane().add(imagenFruta1);*/
		


	}
	
	public String nuevoJuego(){
		JuegoColores juego= new JuegoColores();
		String colorGanador = juego.getColorGanador();
		return colorGanador;
	}

}

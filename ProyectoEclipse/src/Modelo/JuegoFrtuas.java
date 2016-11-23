package Modelo;

import java.util.ArrayList;
import java.util.Collections;

public class JuegoFrtuas extends Juego {
	private ArrayList<Carta> cartas; 
	private Carta frutaGanadora;
	
	public JuegoFrtuas(Usuario usuario) {
		super(usuario, "Juego Colores");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void inicializar() {
		generarFrutas();
		frutaGanadora();
		generarFrutasDelNivel();
	}

	@Override
	public boolean nivelGanado() {
		return false;
	}
	
	private void generarFrutas (){
		cartas = new ArrayList<Carta>();
		cartas.add(new Carta(1,"/imagenes/Mora.png","Mora"));
		cartas.add(new Carta(2,"/imagenes/Cherry.png","Cereza"));
		cartas.add(new Carta(3,"/imagenes/Orange.png","Naranja"));
		cartas.add(new Carta(4,"/imagenes/Melon.png","Melon"));
		cartas.add(new Carta(5,"/imagenes/Lemon.png","Limon"));
		cartas.add(new Carta(6,"/imagenes/Mango.png","Mango"));	
		cartas.add(new Carta(7,"/imagenes/RaspBerry.png","Mora"));	
		cartas.add(new Carta(8,"/imagenes/Grape.png","Uva"));	
		cartas.add(new Carta(9,"/imagenes/GrapeFruit.jpg","Pomelo"));	
		cartas.add(new Carta(10,"/imagenes/PineApple.png","Anana"));	
	}
	
	private void frutaGanadora() {
		cartasDelNivel = new ArrayList<Carta>();
		Collections.shuffle(cartas);
		frutaGanadora = cartas.get(0);
		cartasDelNivel.add(frutaGanadora);
	}
	
	public boolean match(int selected) {
		if(frutaGanadora.getId() == selected) {
			adivinadas++;
			incrementarPuntos();
			return true;
		} else {
			intentos++;
			return false;
		}
	}
	 
	private void generarFrutasDelNivel() {
		int x=0;
		int y = 0;
		while(x<2 && y < cartas.size()) {
			if(cartas.get(y).getId() != frutaGanadora.getId()){
				cartasDelNivel.add(cartas.get(y));
				x++;
				y++;
			} else {
				y++;
			}
		}
	}
	@Override
	public String getExtraInfoNivel() {
		return frutaGanadora.getTexto();
	}
	
}

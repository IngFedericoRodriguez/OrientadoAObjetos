package Modelo;

import java.util.ArrayList;
import java.util.Random;

public class JuegoColores extends Juego {
	private ArrayList<Carta> cartas; 
	private Carta frutaGanadora;
	
	public JuegoColores(Usuario usuario) {
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
		Random randomGenerator= new Random();
		frutaGanadora = (Carta) cartas.get(randomGenerator.nextInt(cartas.size()));
		cartasDelNivel.add(frutaGanadora);
	}
	
	public boolean match(int selected) {
		return frutaGanadora.getId() == selected;
	}
	 
	private void generarFrutasDelNivel() {
		int x=0;
		while(x<3) {
			if(cartas.get(x).getId() != frutaGanadora.getId()){
				cartasDelNivel.add(cartas.get(x));
				x++;
			}
		}
	}
	
}

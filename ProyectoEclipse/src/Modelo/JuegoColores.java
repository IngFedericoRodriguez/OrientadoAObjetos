package Modelo;

import java.util.ArrayList;
import java.util.Random;

public class JuegoColores extends Juego {
	private ArrayList<Carta> frutas; 
	private Carta frutaGanadora;
	private ArrayList<Carta> frutasDelNivel;
	
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
		// TODO Auto-generated method stub
		return false;
	}
	
	private void generarFrutas (){
		frutas = new ArrayList<Carta>();
		frutas.add(new Carta(1,"/imagenes/Frutas/Mora.png","Morado"));
		frutas.add(new Carta(2,"/imagenes/Frutas/Cherry.png","Rojo"));
		frutas.add(new Carta(3,"/imagenes/Frutas/Orange.png","Naranja"));
		frutas.add(new Carta(4,"/imagenes/Frutas/Melon.png","Verde"));
		frutas.add(new Carta(5,"/imagenes/Frutas/Lemon.png","Amarillo"));
		frutas.add(new Carta(6,"/imagenes/Frutas/Mango.png","Amarillo"));	
		frutas.add(new Carta(7,"/imagenes/Frutas/RaspBerry.png","Rojo"));	
		frutas.add(new Carta(8,"/imagenes/Frutas/Grape.png","Violeta"));	
		frutas.add(new Carta(9,"/imagenes/Frutas/GrapeFruit.jpg","Rosado"));	
		frutas.add(new Carta(10,"/imagenes/Frutas/PineApple.png","Amarillo"));	
	}
	
	private void frutaGanadora() {
		frutasDelNivel = new ArrayList<Carta>();
		Random randomGenerator= new Random();
		frutaGanadora = (Carta) frutas.get(randomGenerator.nextInt(frutas.size()));
		frutasDelNivel.add(frutaGanadora);
	}
	
	private void generarFrutasDelNivel() {
		int x=0;
		while(x<3) {
			if(frutas.get(x).getId() != frutaGanadora.getId()){
				frutasDelNivel.add(frutas.get(x));
				x++;
			}
		}
	}
	
	public ArrayList<Carta> getCartas() {
		return frutasDelNivel;
	}
}

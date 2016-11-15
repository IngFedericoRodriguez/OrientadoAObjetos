package JuegoDeColores;

import java.util.ArrayList;
import java.util.Random;


// es un objeto. Parte del modelo
//reglas del juego y fichas del juego
public class JuegoColores {

	private ArrayList<Fruta> frutas; // arraylist de  clases Fruta. un array  listas enlasazadas de punteros a cada Fruta
	private Fruta frutaGanadora;
	
	public JuegoColores(){
		generarFrutas(); //es como pegar el codigoaca dento
		frutaGanadora();
		FrutasNoGanadoras();
		
	}
	
	private void generarFrutas(){
		frutas = new ArrayList<Fruta>();//ya esta declarada en la clase no hace falta(ArrayList<Fruta>) al principio
		Fruta fruta1= new Fruta(1,"/imagenes/Frutas/Mora.png","Morado");
		frutas.add(fruta1);
		Fruta fruta2= new Fruta(2,"/imagenes/Frutas/Cherry.png","Rojo");
		frutas.add(fruta2);
		Fruta fruta3= new Fruta(3,"/imagenes/Frutas/Orange.png","Naranja");
		frutas.add(fruta3);
		Fruta fruta4= new Fruta(4,"/imagenes/Frutas/Melon.png","Verde");
		frutas.add(fruta4);
		Fruta fruta5= new Fruta(5,"/imagenes/Frutas/Lemon.png","Amarillo");
		frutas.add(fruta5);
		Fruta fruta6= new Fruta(6,"/imagenes/Frutas/Mango.png","Amarillo");
		frutas.add(fruta6);	
		Fruta fruta7= new Fruta(7,"/imagenes/Frutas/RaspBerry.png","Rojo");
		frutas.add(fruta7);	
		Fruta fruta8= new Fruta(8,"/imagenes/Frutas/Grape.png","Violeta");
		frutas.add(fruta8);	
		Fruta fruta9= new Fruta(9,"/imagenes/Frutas/GrapeFruit.jpg","Rosado");
		frutas.add(fruta9);	
		Fruta fruta10= new Fruta(10,"/imagenes/Frutas/PineApple.png","Amarillo");
		frutas.add(fruta10);	
	}
	
	private void frutaGanadora(){
		Random randomGenerator= new Random();
		frutaGanadora = frutas.get(randomGenerator.nextInt(frutas.size())); //tomo un elemento random del arraylist	
	}
	
	public String getColorGanador(){
		return frutaGanadora.getColor();
		
	}
	
	public Fruta getFrutaNoGanadora(){
		Fruta frutaNoGanadora;
		Random randomGenerator= new Random();
		frutaNoGanadora = frutas.get(randomGenerator.nextInt(frutas.size())); //tomo un elemento random del arraylist	
		if(!frutaNoGanadora.getColor().equals(frutaGanadora))
			return frutaNoGanadora;
		else
			return null;
	}
	
	public ArrayList<Fruta> FrutasNoGanadoras(){
		ArrayList<Fruta> frutasLocal = new ArrayList<Fruta>();
		int i=0;
		for(int x=0;x<frutas.size();x++) {
			if(!frutas.get(x).getColor().equals(frutaGanadora.getColor()))//si la fruta tiene color diferente al ganador
			{	frutasLocal.add(frutas.get(x));
				System.out.println(frutasLocal.get(i).getColor());	
				i++;
			
			}
			else
				System.out.println("estees el color ganador "+frutaGanadora.getColor());	
			
		}
		return frutasLocal;
		
	}
	
	//compara el color pasado con la fruta ganadora
	public boolean compararColor(String color){
		return color.equals(frutaGanadora.getColor());		
	}

	public void init() {
		// TODO Auto-generated method stub
		frutaGanadora();
		FrutasNoGanadoras();
	}
}

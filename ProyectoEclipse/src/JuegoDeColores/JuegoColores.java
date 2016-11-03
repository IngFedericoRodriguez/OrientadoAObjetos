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
		
	}
	
	private void generarFrutas(){
		frutas = new ArrayList<Fruta>();//ya esta declarada en la clase no hace falta(ArrayList<Fruta>) al principio
		Fruta fruta1= new Fruta(1,"Manzana","Rojo");
		frutas.add(fruta1);
		Fruta fruta2= new Fruta(2,"Pera","Verde");
		frutas.add(fruta2);
		Fruta fruta3= new Fruta(3,"Banana","Amarilla");
		frutas.add(fruta3);
		Fruta fruta4= new Fruta(4,"Sandia","Verde");
		frutas.add(fruta4);
		Fruta fruta5= new Fruta(5,"Pomelo","Amarillo");
		frutas.add(fruta5);		
	}
	
	private void frutaGanadora(){
		Random randomGenerator= new Random();
		frutaGanadora = frutas.get(randomGenerator.nextInt(frutas.size())); //tomo un elemento random del arraylist	
	}
	
	public String getColorGanador(){
		return frutaGanadora.getColor();
		
	}
	
	//compara el color pasado con la fruta ganadora
	public boolean compararColor(String color){
		return color.equals(frutaGanadora.getColor());		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}
}

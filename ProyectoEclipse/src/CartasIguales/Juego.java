package CartasIguales;

import java.util.ArrayList;
import java.util.Collections;

// MODELO
public class Juego {
	private int level;
	private int intentos;
	private int adivinadas;
	private ArrayList<Carta> cartas;
	private ArrayList<Carta> cartasDelNivel;
	
	//Sobrecarga
	public Juego(int level) {
		this.level = level;
		cartas = new ArrayList<Carta>();
		reset();
	}
	
	public Juego() {
		level = 1;
		cartas = new ArrayList<Carta>();
		reset();
	}
	
	public void nuevoLevel() {
		level++;
	}
	
	public void reset() {
		intentos = 0;
		adivinadas = 0;
		cartasDelNivel = new ArrayList<Carta>();
	}
	
	public void sumarIntento() {
		intentos++;
	}
	
	public void init() {
		crearCartas();
		mezclarCartas();
		crearCartasParaNivel();
	}
	
	public void proximoLevel() {
		level++;
		init();
	}
	
	public ArrayList<Carta> getCartas() {
		return cartasDelNivel;
	}
	
	public int getCuentaCartas() {
		return cartasDelNivel.size();
	}
	
	private void repartir() {
		int cantidadPares = level+1;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public void win() {
		level++;
	}
	
	public boolean match(int selected1, int selected2) {
		boolean match = selected1 == selected2;
		if(match) {
			adivinadas++;
		} else {
			intentos++;
		}
		return match;
	}
	
	public boolean nivelGanado() {
		return adivinadas == level+1;
	}
	
	private void crearCartas(){
		//TODO: Buscar forma de generar Random.
		cartas.add(new Carta(1, "/imagenes/pikachu.png"));
		cartas.add(new Carta(2, "/imagenes/abra.png"));
		cartas.add(new Carta(3, "/imagenes/bellsprout.png"));
		cartas.add(new Carta(4, "/imagenes/bulbasaur.png"));
		cartas.add(new Carta(5, "/imagenes/charmander.png"));
		cartas.add(new Carta(6, "/imagenes/ditto.png"));
		cartas.add(new Carta(7, "/imagenes/dratini.png"));
		cartas.add(new Carta(8, "/imagenes/eevee.png"));
		cartas.add(new Carta(9, "/imagenes/horsea.png"));
		cartas.add(new Carta(10, "/imagenes/Jigglypuff.png"));
		cartas.add(new Carta(11, "/imagenes/ponyta.png"));
		cartas.add(new Carta(12, "/imagenes/psyduck.png"));
		cartas.add(new Carta(13, "/imagenes/snorlax.png"));
		cartas.add(new Carta(14, "/imagenes/squirtle.png"));
		cartas.add(new Carta(15, "/imagenes/togepi.png"));
	}
	
	private void crearCartasParaNivel() {
		int cartasDiferentes = level+1;
		for (int i = 0; i < cartasDiferentes; i++ ) {
			// tengo que crear la dupla de cartas.
			cartasDelNivel.add(cartas.get(i));
			cartasDelNivel.add(cartas.get(i));
		}
	}
	
	private void mezclarCartas() {
		Collections.shuffle(cartas);
	}
	
	public int getIntentos() {
		return intentos;
	}
	
	public int getAdivinadas() {
		return adivinadas;
	}

}

package CartasIguales;

import java.util.ArrayList;

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
		reset();
	}
	
	public Juego() {
		level = 1;
		reset();
	}
	
	public void nuevoLevel() {
		level++;
		reset();
	}
	
	public void reset() {
		intentos = 0;
		adivinadas = 0;
		cartas = new ArrayList<Carta>();
		cartasDelNivel = new ArrayList<Carta>();
	}
	
	public void sumarIntento() {
		intentos++;
	}
	
	public void init() {
		crearCartas();
		crearCartasParaNivel();
	}
	
	public void proximoLevel() {
		level++;
		repartir(level);
	}
	
	public ArrayList<Carta> getCartas() {
		return cartasDelNivel;
	}
	
	public int getCuentaCartas() {
		return cartasDelNivel.size();
	}
	
	private void repartir(int level) {
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
		return adivinadas == level*2;
	}
	
	private void crearCartas(){
		//TODO: Buscar forma de generar Random.
		Carta carta = new Carta(1, "carta1");
		carta.getId();
		cartas.add(carta);
		Carta carta2 = new Carta(2, "carta2");
		cartas.add(carta2);
	}
	
	private void crearCartasParaNivel() {
		int cartasDiferentes = level*2;
		for(int i=0; i < cartasDiferentes; i++ ) {
			// tengo que crear la dupla de cartas.
			cartasDelNivel.add(cartas.get(i));
			cartasDelNivel.add(cartas.get(i));
		}
	}
	
	public int getIntentos() {
		return intentos;
	}
	
	public int getAdivinadas() {
		return adivinadas;
	}

}
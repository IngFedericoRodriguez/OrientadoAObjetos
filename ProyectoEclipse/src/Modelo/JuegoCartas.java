
package Modelo;

import java.util.ArrayList;
import java.util.Collections;

public class JuegoCartas extends Juego {
	private ArrayList<Carta> cartas;

	
	public JuegoCartas(Usuario usuario) {
		super(usuario, "JuegoCartas");
		cartas = new ArrayList<Carta>();
		reset();
	}
	
	public void reset() {
		super.reset();
		cartasDelNivel = new ArrayList<Carta>();
	}
	
	
	public int getCuentaCartas() {
		return cartasDelNivel.size();
	}
	
	
	public void win() {
		nivel++;
	}
	
	
	public boolean nivelGanado() {
		return adivinadas == nivel+1;
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
		int cartasDiferentes = nivel+1;
		for (int i = 0; i < cartasDiferentes; i++ ) {
			// tengo que crear la dupla de cartas.
			cartasDelNivel.add(cartas.get(i));
			cartasDelNivel.add(cartas.get(i));
		}
	}
	
	private void mezclarCartas() {
		Collections.shuffle(cartas);
	}
	
	@Override
	public void inicializar() {
		crearCartas();
		mezclarCartas();
		crearCartasParaNivel();
	}

	@Override
	public String getExtraInfoNivel() {
		return null;
	}



}

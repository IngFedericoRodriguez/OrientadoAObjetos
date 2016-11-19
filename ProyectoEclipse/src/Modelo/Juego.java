package Modelo;


import java.util.Collections;

import usuario.Usuario;


abstract public class Juego {
	private Usuario usuario;
	protected int nivel;
	protected int intentos;
	protected int adivinadas;
	protected int puntos;

	public Juego(Usuario usuario, String nombreJuego) {
		this.usuario = usuario;
		this.nivel = usuario.getScore(nombreJuego).getNivel();
		this.puntos = usuario.getScore(nombreJuego).getPuntos();
		this.intentos = usuario.getScore(nombreJuego).getIntentos();
	}
	
	public abstract void inicializar();
	public abstract boolean nivelGanado();

	
	// Esto esta raro porque proximo nivel hace lo mismo./
	public void nuevoNivel() {
		nivel++;
	}
	
	public void reset() {
		intentos = 0;
		adivinadas = 0;
	}
	
	public void proximoLevel() {
		nivel++;
		inicializar();
	}
	
	public void sumarIntento() {
		intentos++;
	}
	
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	
	public int getIntentos() {
		return intentos;
	}
	
	public int getAdivinadas() {
		return adivinadas;
	}
	
	private void incrementarPuntos() {
		puntos += 10;
	}
	
	public int getPuntos() {
		return this.puntos;
	}
	
	public int getNivel() {
		return nivel;
	}
	
	public boolean match(int selected1, int selected2) {
		boolean match = selected1 == selected2;
		if(match) {
			adivinadas++;
			incrementarPuntos();
		} else {
			intentos++;
		}
		return match;
	}
}

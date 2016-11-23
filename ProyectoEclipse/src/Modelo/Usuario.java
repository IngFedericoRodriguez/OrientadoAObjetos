package Modelo;

import java.util.ArrayList;

public class Usuario {

	private String nombre;
	private String email;
	private ArrayList<Score> scores;

	public Usuario(String nombre, String email) {
		this.nombre = nombre;
		this.email = email;
		scores = new ArrayList<Score>();
	}

	public Usuario(String nombre, String email, ArrayList<Score> scores) {
		this.nombre = nombre;
		this.email = email;
		this.scores = scores;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public  Score getScore(String nombreJuego) {
		for (Score score : scores) {
			if (score.getJuego() == nombreJuego) {
				return score;
			}
		}
		Score newscore = new Score(nombreJuego);
		this.scores.add(newscore);
		return newscore;
	}
	
	public int getPuntuacion(String nombreJuego) {
		for (Score score : scores) {
			if (score.getJuego() == nombreJuego) {
				return score.getPuntos();
			}
		}
		return 0;
	}
}

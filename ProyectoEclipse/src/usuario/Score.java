package usuario;

public class Score {
	private int nivel;
	private String juego;
	private int intentos;
	private int aciertos;
	private int puntos;

	public Score(String juego, int nivel, int intentos, int aciertos, int puntos) {
		this.juego = juego;
		this.intentos = intentos;
		this.aciertos = aciertos;
		this.puntos = puntos;
		this.nivel = nivel;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getJuego() {
		return juego;
	}

	public void setJuego(String juego) {
		this.juego = juego;
	}

	public int getIntentos() {
		return intentos;
	}

	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}

	public int getAciertos() {
		return aciertos;
	}

	public void setAciertos(int aciertos) {
		this.aciertos = aciertos;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	public void agregarPuntos(int puntos) {
		this.puntos+= puntos;
	}
	
}

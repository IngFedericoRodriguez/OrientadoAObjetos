package model;

public class ItemRanking {

	private Usuario usuario;
	private Nivel ultNivel;
	private int puntaje;

	public ItemRanking(Usuario usuario,Nivel ultimoNivel,int puntaje){
		this.usuario=usuario;
		this.ultNivel=ultimoNivel;
		this.puntaje=puntaje;	
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Nivel getUltimoNivel() {
		return ultNivel;
	}

	public void setUltimoNivel(Nivel ultimoNivel) {
		this.ultNivel = ultimoNivel;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

}

package model;

import java.util.Collection;
import java.util.Vector;

public class Memoria extends Juego {
	
	public Memoria(Collection<ItemRanking> ranking,String nombre,Vector<Nivel> niveles){
		super(nombre);
	}
	
	public boolean validarPar(String nomPiezaSel1,String nomPiezaSel2,Usuario usuarioActual,int nroNivel){
		Nivel nivelActual= buscarnivel(nroNivel);
		return nivelActual.validarParPiezas(nomPiezaSel1, nomPiezaSel2);
	}

	/**Ve el nivelActual del UsuarioActual y pregunta a Nivel que valide
	 * @UsuarioActual
	 * */
    public boolean validarNivel(Usuario usuarioActual){
		Nivel nivelActual= getNivelActual(usuarioActual);
		String aux = String.valueOf(nivelActual.cantPiezas);
		return nivelActual.validarNivel(aux);

	}


	@Override
	public boolean validarPar(String nomPiezaSel1, String nomPiezaSel2, Usuario usuarioActual) {
		// TODO Auto-generated method stub
		return false;
	}
}

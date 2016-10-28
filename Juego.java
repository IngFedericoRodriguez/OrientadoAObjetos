package model;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

public abstract class Juego {

	protected Vector<ItemRanking> ranking;
	protected String nombre;
	protected Vector<Nivel> niveles;

	public Juego(String nombre){
		this.nombre=nombre;
		this.ranking=new Vector<ItemRanking>();
		this.niveles=new Vector<Nivel>();
	}

	public Collection<Nivel> getNiveles() {
		return this.niveles;
	}

	public Collection<ItemRanking> getRanking() {
		return ranking;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
//	public Collection<Pieza> getdatosnivel(Usuario usuarioActual){ //Pasarle el "nivelActual"(La variable del controlador)
//		ItemRanking itRanking =buscarRankingUsuario(usuarioActual); 
//		return itRanking.getUltimoNivel().getPiezas();//Esto es correcto pero hacerlo pasandole el nivelActual
//
//	}

	public Collection<Pieza> getdatosnivel(Usuario usuarioActual,int nroNivel){
	Nivel n =null;
	n=buscarnivel(nroNivel);
	return n.getPiezas();

}
	
	public int getCantPiezasNivelDelUsuario(Usuario usuarioActual){
        ItemRanking itRanking =buscarRankingUsuario(usuarioActual);
		return itRanking.getUltimoNivel().getCantPiezas();
	}
	
	/*con esto obtengo el itemRanking del usuarioActual*/
	private ItemRanking buscarRankingUsuario(Usuario usuarioActual){
		ItemRanking result= null;	
	    Iterator<ItemRanking> itRanking = ranking.iterator();
			while (result == null && itRanking.hasNext()) {
				ItemRanking u = itRanking.next();
					if (u.getUsuario().equals(usuarioActual)) {
					result = u;
				}	
			}
			return result;
	}
	
	protected Nivel getNivelActual(Usuario usuarioActual){
		ItemRanking itemRank = buscarRankingUsuario(usuarioActual);
		Nivel nivelActual=itemRank.getUltimoNivel();
		return nivelActual;
	}
	
	public  Nivel buscarnivel(int nroNivel)
	{
		for (int i=0;i<niveles.size();i++)
			if(niveles.elementAt(i).getNro()==nroNivel)
				return niveles.elementAt(i);
				
		return null;
	}
	
	public abstract boolean validarNivel(Usuario usuarioActual);
	public abstract boolean validarPar(String nomPiezaSel1,String nomPiezaSel2,Usuario usuarioActual);

}

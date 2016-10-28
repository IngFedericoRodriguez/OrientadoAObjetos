package model;

import java.util.Collection;
import java.util.Vector;

public class Nivel {
	
	private Vector<Pieza> piezas;
	private int Nro;
	protected int cantPiezas;
	
	public Nivel(Vector<Pieza> piezas,int Nro,int cantPiezas){
		super();
		this.piezas= piezas;
		this.Nro=Nro;
		this.cantPiezas= cantPiezas;
	}

	public Collection<Pieza> getPiezas() {
		return piezas;
	}

	public void setPiezas(Vector<Pieza> piezas) {
		this.piezas = piezas;
	}

	public int getNro() {
		return Nro;
	}

	public void setNro(int Nro) {
		this.Nro = Nro;
	}

	public int getCantPiezas() {
		return cantPiezas;
	}

	public void setCantPiezas(int cantPiezas) {
		this.cantPiezas = cantPiezas;
	}
	
	public boolean validarNivel(String nombrePieza)
	{
		
		return false;	
	}

	public boolean validarParPiezas(String pieza1, String pieza2) {
		Pieza p1=buscarpieza(pieza1);
		Pieza p2=buscarpieza(pieza2);		
		return p1.getNombre().equals(p2.getNombre());
	}

	private Pieza buscarpieza(String pieza1) {
		int i=0;
		for (i=0;i<=piezas.size();i++);
			if (piezas.elementAt(i).soslaPieza(pieza1))
				return piezas.elementAt(i);
		return null;
	}


}

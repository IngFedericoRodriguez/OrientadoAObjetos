package controller;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import exception.ValidationException;
import model.IdentificacionObjetos;
import model.Juego;
import model.Memoria;
import model.Pieza;
import model.Usuario;

public class Controlador {

	private List<Usuario> usuarios;
	private List<Juego> juegos;
	private List<Pieza> piezas;
	private Usuario usuarioActual;
	private int nroNivel;

	public Controlador() {
		this.usuarios = new ArrayList<Usuario>();
		this.juegos = new ArrayList<Juego>();
		this.piezas = new ArrayList<Pieza>();
		this.nroNivel=nroNivel;
	}

	public void altaUsuario(String nombre){
		if (buscarUsuario(nombre) == null) {
			this.usuarios.add(new Usuario(nombre));
		} else {
			//Mostrar por pantalla "El usuario ya existe"
		}
	}

	private Usuario buscarUsuario(String nombre) {
		Usuario result = null;
		Iterator<Usuario> it = usuarios.iterator();
		while (result == null && it.hasNext()) {
			Usuario u = it.next();
			if (nombre.equals(u.getNombre())) {
				result = u;
			}
		}
		return result;
	}

	public void bajaUsuario(String nombre) {
		this.usuarios.remove(buscarUsuario(nombre));
	}

//	public void modificacionFechaUsuario(Date fechaNac) {
//		this.usuarioActual.setFechaNac(fechaNac);
//	}

	public boolean validarUsuario(String nombreUsuario) {
		return buscarUsuario(nombreUsuario) != null;
	}

	public String[] obtenerNombreJuegos() {
		String[] result = new String[this.juegos.size()];
		for (int i = 0; i < this.juegos.size(); i++) {
			result[i] = this.juegos.get(i).getNombre();
		}
		return result;
	}

	public Vector<String> cargarNivel(String nombreJuego,int nroNivel) {

		Vector<String> pathPiezas = new Vector<String>();
		Juego juegoActual = buscarJuego(nombreJuego);
		/* obtengo las piezas del nivel y la cantidad del mismo */
		Collection<Pieza> piezasNivel = juegoActual.getdatosnivel(usuarioActual,nroNivel);
		for(int i=0;i<piezasNivel.size();i++)
		{
			//agrego los path de las piezas al vector "pathPiezas"
		}

		return pathPiezas;

	}

	private Juego buscarJuego(String nombreJuego) {
		//Juego juegoActual = Memoria;
		Juego juegoActual = null;
		Iterator<Juego> it = juegos.iterator();
		while (juegoActual == null && it.hasNext()) {
			Juego u = it.next();
			if (nombreJuego.equals(u.getNombre())) {
				juegoActual = u;
			}
		}
		

		return juegoActual;
	}


	public boolean validarParPiezas(String nomPiezaSel1, String nomPiezaSel2, String nombreJuego,int nroNivel) {
		boolean i = false;
		Juego juegoActual = buscarJuego(nombreJuego);
		//if (nomPiezaSel1.equals(nomPiezaSel2))
			i = ((Memoria) juegoActual).validarPar(nomPiezaSel1, nomPiezaSel2, usuarioActual,nroNivel);
		return i;
	}

	/**
	 * Ve el juegoActual y pregunta a Juego
	 * 
	 * @nombreJuego
	 */
	public boolean validarNivel(String nombreJuego) {
		Juego juegoActual = buscarJuego(nombreJuego);
		return juegoActual.validarNivel(usuarioActual);
	}

	/**
	 * Ve el JuegoActual y pregunta a Juego que valide
	 * 
	 * @nombrePieza
	 * @nombreJuego
	 */
	public boolean validarNivelObjetos(String nombrePieza, String nombreJuego) {

		Juego juegoActual = buscarJuego(nombreJuego);
		return ((IdentificacionObjetos) juegoActual).validarIdentPieza(nombrePieza, usuarioActual);
	}

}

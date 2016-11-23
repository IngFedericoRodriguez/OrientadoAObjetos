package Controlador;


import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JFrame;

import Modelo.Carta;
import Modelo.Juego;
import Modelo.JuegoCartas;
import Modelo.JuegoColores;
import Modelo.Usuario;
import Vista.TableroJuegoColores;
import Vista.VentanaJuego;
import Vista.VentanaJuegoCartas;
import Vista.VentanaJuegoFrutas;
import Vista.VistaCarta;
import Vista.VistaCrearUsuario;
import Vista.VistaJuego;
import Vista.VistaListarUsuarios;
import Vista.VistaLogin;
import Vista.tableroJuegoCartas;

public class Controlador {
	
	private ArrayList<Usuario> usuarios;
	private Usuario usuario;
	private boolean usuarioLogueado;
	private VistaJuego ventana;
	private ControladorJuego cartasIguales;
	private VistaCrearUsuario vistaCrearUsuario;
	private VistaLogin vistaLogin;
	private VistaListarUsuarios vistaListarUsuarios;
	private Juego juego;
	private VentanaJuego VentanaJuego;


	public Controlador() {
		usuarios = new ArrayList<Usuario>();
		usuarioLogueado = false;
	}
	
	public void grabarUsuario(Hashtable<String, String> userData){
		String nombre = userData.get("nombre");
		String email = userData.get("email");
		if (nombre.length() == 0|| email.length() == 0){
			this.vistaCrearUsuario.camposVacios();
		} else {
			Usuario user = new Usuario(nombre, email); 
			usuarios.add(user);
			this.vistaCrearUsuario.usuarioCreado();
			closeWindow(vistaCrearUsuario);
		}
	}
	
	public void listarUsuarios() {
		if (!usuarios.isEmpty()) {
			for(int i=0; i < usuarios.size(); i++) {
				// esto deberia crear una vista y pasarsela al frame ppal.
			}
		}
	}
	
	private void closeWindow(JFrame frame) {
		frame.setVisible(false);
		frame.dispose();
	}
	
	public void loguearUsuario(String email) {
		boolean found = false;
		int i = 0;
		
		while (!found && i< usuarios.size()) {
			if (usuarios.get(i).getEmail().equals(email)) {
				this.usuario = usuarios.get(i);
				usuarioLogueado = true;
				found = true;
			} else {
				i++;
			}
		}
		if(found) {
			vistaLogin.usuarioLogueado();
			ventana.showGames();
			closeWindow(vistaLogin);
		} else {
			vistaLogin.usuarioNoEncontrado();
		}
		
	}
	
	public void jugarCartasIguales() {
		if (usuarioLogueado) {
			juego = new JuegoCartas(usuario);
			VentanaJuego = new VentanaJuegoCartas(new tableroJuegoCartas());
			jugar();
		}
	}
	
	public void jugarJuegoColores() {
		if (usuarioLogueado) {
			juego = new JuegoColores(usuario);
			VentanaJuego = new VentanaJuegoFrutas(new TableroJuegoColores());
			jugar();
		}
	}
	
	public void desloguearUsuario() {
		this.usuarioLogueado = false;
	}
	
	private boolean emailEnUso (String email) {
		boolean enUso = false;
		int i = 0;
		while (!enUso || i< usuarios.size()) {
			if (usuarios.get(i).getEmail() == email) {
				enUso = true;
			} else {
				i++;
			}
		}
		return enUso;
	}
	
	public void iniciarGuiLogin() {
		vistaLogin = new VistaLogin(this);
		vistaLogin.setVisible(true);
	}
	
	public void iniciarGuiCrearUsuario() {
		vistaCrearUsuario = new VistaCrearUsuario(this);
		vistaCrearUsuario.setVisible(true);
	}
	
	public void crearVista() {
		ventana = new VistaJuego();
		ventana.setControlador(this);
		ventana.setVisible(true);
	}
	
	public void iniciarGuiListarUsuarios() {
	    Object[][] rows = new Object[usuarios.size()][4];

	    for (int i = 0; i < usuarios.size(); i++) {
	        rows[i][0] = usuarios.get(i).getNombre();
	        rows[i][1] = usuarios.get(i).getEmail();
	        rows[i][2] = usuarios.get(i).getPuntuacion("CartasIguales");
	        rows[i][3] = usuarios.get(i).getPuntuacion("JuegoColores");
	    }
		vistaListarUsuarios = new VistaListarUsuarios(rows);
		vistaListarUsuarios.setVisible(true);
	}
	
	private void jugar() {
		juego.inicializar();
		VentanaJuego.agregarTablero(generarVistaCartas(juego.getCartas()));
		VentanaJuego.agregarMarcador();
		VentanaJuego.setControladorJuego(this);
		VentanaJuego.setVisible(true);
	}
	
	private ArrayList<VistaCarta> generarVistaCartas(ArrayList<Carta> cartas) {
		ArrayList<VistaCarta> vistaCartas = new ArrayList<VistaCarta>();
		for(Carta carta : cartas) {
			VistaCarta vistaCarta = new VistaCarta(carta.getId(), carta.imgSource(), true);
			vistaCartas.add(vistaCarta);
		}
		return vistaCartas;
	}
		
	public void nuevoNivel(int continuar){
		switch (continuar) {
			case 0 :
				crearNuevoNivel();
				break;
			case 1 :
				VentanaJuego.setVisible(false);
				VentanaJuego.dispose();
				break;
		}
	}
	
	public int getAdivinadas() {
		return juego.getAdivinadas();
	}
	
	public int getIntentos() {
		return juego.getIntentos();
	}
	
	public int getPuntos() {
		return juego.getPuntos();
	}
	
	private void crearNuevoNivel() {
		juego.nuevoNivel();
		juego.reset();
		VentanaJuego.reset();
		jugar();
	}
	
	public boolean match(int id1, int id2) {
		return juego.match(id1, id2);
	}
	
	public boolean match(int id1) {
		return juego.match(id1);
	}
	
	
	public boolean nivelGanado() {
		if(juego.nivelGanado()) {
			usuario.getScore("CartasIguales").agregarPuntos(juego.getPuntos());
			usuario.getScore("CartasIguales").setNivel(juego.getNivel()+1);
			return true;
		} 
		return false;
	}
	
	public static void main(String[] args) {
		Controlador inst = new Controlador();
		inst.crearVista();
	}
}

package usuario;


import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JFrame;

import CartasIguales.ControladorJuego;
import CartasIguales.JuegoCartas;
import Vista.VistaCrearUsuario;
import Vista.VistaJuego;
import Vista.VistaListarUsuarios;
import Vista.VistaLogin;

public class ControladorUsuarios {
	
	private ArrayList<Usuario> usuarios;
	private Usuario usuario;
	private boolean usuarioLogueado;
	private VistaJuego ventana;
	private ControladorJuego cartasIguales;
	private VistaCrearUsuario vistaCrearUsuario;
	private VistaLogin vistaLogin;
	private VistaListarUsuarios vistaListarUsuarios;

	public ControladorUsuarios() {
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
		// TODO: Dejar jugar Si hay usuario logueado.
		if (usuarioLogueado) {
			//jugar
		} else {
			// tirar warning no usuario logueado.
		}
		cartasIguales = new ControladorJuego(new JuegoCartas(), usuario);
		cartasIguales.jugar();
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

	public static void main(String[] args) {
		ControladorUsuarios inst = new ControladorUsuarios();
		inst.crearVista();
	}
	
}

package usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JButton;

import CartasIguales.ControladorJuego;
import CartasIguales.Juego;
import CartasIguales.VistaCarta;
import Vista.VistaCrearUsuario;
import Vista.VistaJuego;

// Main modelo controlador.-

public class ControladorUsuarios implements ActionListener {
	
	private ArrayList<Usuario> usuarios;
	// Esto representa el usuario logueado. Si esta el usuario podemos jugar.	
	private Usuario usuario;
	private boolean usuarioLogueado;
	private VistaJuego ventana;
	private ControladorJuego cartasIguales;
	private VistaCrearUsuario vistaCrearUsuario;

	public ControladorUsuarios() {
		usuarios = new ArrayList<Usuario>();
		usuarioLogueado = false;
	}
	
	public void grabarUsuario(Hashtable<String, String> userData){
		String nombre = userData.get("nombre");
		String email = userData.get("email");
		// Esta validacion a nivel controlador es media pedorra.
		if(nombre.length() == 0|| email.length() == 0){
			this.vistaCrearUsuario.camposVacios();
		}
		Usuario user = new Usuario(nombre, email); 
		this.vistaCrearUsuario.usuarioCreado();
		this.vistaCrearUsuario.setVisible(false);
		this.vistaCrearUsuario.dispose();
	}
	
	public void listarUsuarios() {
		if (!usuarios.isEmpty()) {
			for(int i=0; i < usuarios.size(); i++) {
				// esto deberia crear una vista y pasarsela al frame ppal.
			}
		}
	}
	
	public void quitarUsuario(String email){
		
	}
	
	public void buscarUsuario(){
		
	}
	
	public void loguearUsuario(String email) {
		boolean found = false;
		int i = 0;
		while (!found && i< usuarios.size()) {
			if (usuarios.get(i).getEmail() == email) {
				this.usuario = usuarios.get(i);
				usuarioLogueado = true;
				found = true;
			} else {
				i++;
			}
		}
	}
	
	private void jugarCartasIguales() {
		// TODO: Dejar jugar Si hay usuario logueado.
		if (usuarioLogueado) {
			//jugar
		} else {
			// tirar warning no usuario logueado.
		}
		cartasIguales = new ControladorJuego(new Juego());
		cartasIguales.jugar();
	}
	
	public void desloguearUsuario() {
		this.usuarioLogueado = false;
	}
	
	private boolean emailEnUso(String email) {
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
	
	public void crearVista() {
		JButton btnjugar = new JButton("Jugar Cartas Iguales");
		// no se puede jugar hasta no tener un usuario logueado.
		btnjugar.addActionListener(this);
		JButton btncrearUsuarios = new JButton("Crear Usuario");
		btncrearUsuarios.addActionListener(this);
		JButton btnlistarUsuarios = new JButton("Listar Usuarios");
		btnlistarUsuarios.addActionListener(this);
		JButton login = new JButton("loguearse");
		login.addActionListener(this);
		ventana = new VistaJuego(btnjugar, btncrearUsuarios, btnlistarUsuarios, login);
		ventana.setVisible(true);
	}

	public static void main(String[] args) {
		ControladorUsuarios inst = new ControladorUsuarios( );
		inst.crearVista();
	}
	
	private void iniciarGuiCrearUsuario() {
		JButton btnCrearUsuario = new JButton("Grabar usuario");
		btnCrearUsuario.addActionListener(this);
		vistaCrearUsuario = new VistaCrearUsuario(btnCrearUsuario);
		vistaCrearUsuario.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		// Esto es re cabeza, hay que cambiarlo, vamos a switchear por labels los botones para ver que hacemos.
		// Hay que buscar una forma de que sepamos que botones se estan apretando para no tener que hacer esto.
		JButton pressedButton = (JButton) e.getSource();
		switch (pressedButton.getText()) {
			case "Jugar Cartas Iguales":
				this.jugarCartasIguales();
				break;
			case "Crear Usuario": 
				this.iniciarGuiCrearUsuario();
				break;
			case "Listar Usuarios":
				break;
			case "loguearse": 
				break;
			case "Grabar usuario":
				grabarUsuario(vistaCrearUsuario.getUserData());
				break;
			default:
				System.out.println(pressedButton.getText());
		}
	}

}
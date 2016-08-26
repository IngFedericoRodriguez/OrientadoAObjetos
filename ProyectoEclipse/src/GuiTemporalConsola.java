import java.util.*;
import java.io.*;
/// Simulacion para el modelo vista.-

public class GuiTemporalConsola {
	@SuppressWarnings("unused")
	
	private mainJuego game;
	
	public GuiTemporalConsola(){
		game = new mainJuego();
	}
	public static void main(String[] args) {
		GuiTemporalConsola main = new GuiTemporalConsola();
		main.mostrarMenu();
	}
	public  void mostrarMenu() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("MENU DE OPCIONES temporal.-");
		System.out.println("-------------------------------------------------------");
		System.out.println("0.- Salir");
		System.out.println("1.- Crear Usuario");
		System.out.println("2.- Quitar Usuario");
		System.out.println("3.- Consultar tabla Puntos");
		System.out.println("4.- Ver Usuarios");
		System.out.println("5.- Jugar");
		System.out.println("-------------------------------------------------------");
		System.out.print("Opcion:");
		try {
			char s = (char) reader.read();
			switch (s) {
			case '1': {
				crear();
				break;
			}
			case '2': {
		//		this.crearCliente();
				break;
			}
			case '3': {
		//		this.abrirCuenta();
				break;
			}
			case '4': {
				//		this.abrirCuenta();
				break;
			}
			case '5': {
				//		this.abrirCuenta();
				break;
			}
			case '0': {
		//		this.salir();
			}
			}
		} catch (Exception e) {
		}
	}
	public void crear() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(" --- Agregar Usuario ---");
			System.out.print("Ingrese nombre:");
			String nombre = reader.readLine();
			System.out.print("Ingrese email");
			String email = reader.readLine();
			System.out.println(" -----------------------");
			// creo usuario
			game.crearUsuario(nombre, email);
			mostrarMenu();
		} catch (Exception e) {
		}
		
	}
}

import java.util.Vector;

// Main modelo controlador.-

public class mainJuego {
	
	public Vector<Usuario> usuarios;
	public Vector<Juego> juegos;

	public mainJuego() {
	}
	public static void main(String[] args) {
		System.out.println("Bienvenidos al proyecto del juego");
	}
	public void crearUsuario(String nombre, String email){
		Usuario user = new Usuario(nombre, email); 
		usuarios.addElement(user);
	}
	public boolean existeUsuario(String buscado){
		if(usuarios.isEmpty()){
			return false;
		} else {
			for (int i=0;i<usuarios.size();i++){
				if(usuarios.elementAt(i).getNombre().equals(buscado)){
					return true;
				}
			}
			return false;
		}
	}
}

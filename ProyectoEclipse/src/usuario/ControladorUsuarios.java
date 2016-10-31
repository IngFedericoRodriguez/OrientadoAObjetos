package usuario;
import java.util.Vector;

// Main modelo controlador.-

public class ControladorUsuarios {
	
	public Vector<Usuario> usuarios;

	public ControladorUsuarios() {
		usuarios = new Vector<Usuario>();
	}
	
	public void crearUsuario(String nombre, String email){
		Usuario user = new Usuario(nombre, email); 
		usuarios.addElement(user);
	}
	
	public void listarUsuarios(){
		if(!usuarios.isEmpty()){
			for(int i=0; i < usuarios.size(); i++){
				System.out.printf("Nombre=%s\n", usuarios.elementAt(i).getNombre());
				System.out.printf("Email=%s\n", usuarios.elementAt(i).getEmail());
			}
		}
	}
	
	public void quitarUsuario(String nombre){
		
	}
	
	public void buscarUsuario(){
		
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

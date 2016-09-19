package CartasIguales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;


public class MainJuego  extends javax.swing.JFrame {
 
	private Juego juego;
	
	public static void main(String[] args) {
		MainJuego inst = new MainJuego();
		inst.setVisible(true);
		inst.setSize(400, 300);

	}
	
	public MainJuego() {
		super();
		juego = new Juego();
		juego.init();
		generateView();
	}
	
	private void generateView() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		ArrayList<Carta> cartas = juego.getCartas();
		ArrayList<VistaCarta> vistaCartas = new ArrayList<VistaCarta>();
		for(Carta carta : cartas) {
			vistaCartas.add(new VistaCarta(carta.getId(), carta.getName()));
		}
		int row = 1;
		int cell = 1;
		for(VistaCarta vista : vistaCartas) {
			// on new row
			if(cell%5 == 0) {
				row++;
				cell = 1;
			}
			vista.render(row, cell);
			vista.setVisible(true);
			getContentPane().add(vista);
			cell++;
		}
	}
	
	
}

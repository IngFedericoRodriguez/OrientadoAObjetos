package JuegoDeColores;


import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MarcadorFrutas extends JPanel {
	private JLabel intentos;
	private JLabel puntos;
	private JLabel adivinadas;
	private GridLayout layout;
	private final static String intString = "Intentos: ";
	private final static String pString  = "Puntos: ";
	private final static String  adString = "Advinadas: ";
	
	public MarcadorFrutas() {
		setPreferredSize(new Dimension(750, 200)); //este size setea el size inicial de la pantalla por ser el primero en agregarse
		generarLayout();
		intentos = new JLabel(intString + "0");
		puntos = new JLabel(pString + "0 ");
		adivinadas = new JLabel(adString + "0           ");
		addLabels();
	}
	
	public MarcadorFrutas(int in, int ad, int pun) {
		generarLayout();
		intentos = new JLabel(intString + in);
		puntos = new JLabel(pString + ad);
		adivinadas = new JLabel(adString + pun);
	}
		
	private void addLabels() {
		add(intentos);
		add(puntos);
		add(adivinadas);
	}
	
	private void generarLayout() {
		layout = new GridLayout(0, 3);
		setLayout(layout);
		layout.setHgap(10);
		layout.setVgap(1);
	}
	
	public void updateIntentos(String intent) {
		intentos.setText(intString + intent );
	}
	
	public void updatePuntos(String punt) {
		puntos.setText(pString + punt);
	}
	
	public void updateAdivinadas(String adiv) {
		adivinadas.setText(adString + adiv);
	}
}

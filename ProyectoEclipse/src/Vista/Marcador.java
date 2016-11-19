package Vista;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Marcador extends JPanel {
	private JLabel intentos;
	private JLabel puntos;
	private JLabel adivinadas;
	private GridLayout layout;
	private final static String intString = "Intentos: ";
	private final static String pString  = "Puntos: ";
	private final static String  adString = "Advinadas: ";
	
	public Marcador() {
		setPreferredSize(new Dimension(50, 600));
		generarLayout();
		intentos = new JLabel(intString + "0");
		puntos = new JLabel(pString + "0");
		adivinadas = new JLabel(adString + "0");
		addLabels();
	}
	
	public Marcador(int in, int ad, int pun) {
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
		layout.setVgap(10);
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

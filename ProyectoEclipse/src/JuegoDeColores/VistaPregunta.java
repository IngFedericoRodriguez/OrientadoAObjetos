package JuegoDeColores;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaPregunta extends JPanel{
	private JLabel pregunta;
	
	public VistaPregunta(String pregunta) {
		this.pregunta = new JLabel();
		this.pregunta.setText(pregunta);
	}
	
	public VistaPregunta() {
		this.pregunta = new JLabel();
		this.pregunta.setText("Estoy funcioanando");
	}
	
	public void setPregunta(String pregunta) {
		this.pregunta.setText(pregunta);
	}
	
	public void setVisible(boolean aFlag) {
		this.add(this.pregunta);
		super.setVisible(aFlag);
	}

}

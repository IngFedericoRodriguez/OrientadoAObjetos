package Vista;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaPregunta extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel pregunta;
	private static String basePregunta = "Encuentra la siguiente fruta para ganar: ";
	

	public VistaPregunta() {
		this.pregunta = new JLabel();
	}
	
	public void setPregunta(String pregunta) {
		this.pregunta.setText(basePregunta + pregunta);
	}
	
	public void setVisible(boolean aFlag) {
		this.add(this.pregunta);
		super.setVisible(aFlag);
	}

}

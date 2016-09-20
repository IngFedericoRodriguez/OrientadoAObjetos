package CartasIguales;

import javax.swing.JLabel;

public class Marcador extends JLabel {
	private String score;
	private String fixedTest;

	public Marcador(String fixedTest, int pos1, int pos2) {
		score = "0";
		this.fixedTest = fixedTest;
		setText(fixedTest + " " + score );
		setVisible(true);
		setVerticalTextPosition(pos1);
		setHorizontalTextPosition(pos2);
	}
	
	public void updateScore(String score){
		this.score = score;
		setText(fixedTest + " " + score );
	}
	
	
}

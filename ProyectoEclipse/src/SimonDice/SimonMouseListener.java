package SimonDice;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SimonMouseListener  implements MouseListener{

	private int clickedXpos;
	private int clickedYpos;
	private int xPos;
	private int yPos;
	
	public void mouseClicked(MouseEvent me) {
		clickedXpos = me.getX();
		clickedYpos = me.getY();
	}
	
	public int getXpos(){
		return clickedXpos;
	}
	
	public int getYpos(){
		return clickedYpos;
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		xPos = me.getX();
		yPos = me.getY();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

}

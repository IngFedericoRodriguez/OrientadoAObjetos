package SimonDice;

import java.awt.Color;
import java.awt.Graphics2D;

public class SimonButton {
	private int posx;
	private int posy;
	private Color color;
	private int id;
	private boolean mouseHoverMe = false;
	private int finalx;
	private int finaly;
	
	public SimonButton(int id, int posx, int posy, int finalx, int finaly, Color color) {
		this.posx = posx;
		this.posy = posy;
		this.color = color;
		this.id = id;
		this.finalx = finalx;
		this.finaly = finaly;
	}
	
/*	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	} */
	
	public void mouseInBounds(int posx, int posy) {
		if((this.posx <= posx && posx <= finalx) && (this.posy <= posy && posy <= finaly)) {
			mouseHoverMe = true;
		} else {
			mouseHoverMe = false;
		}
	}
	
	
	public int getId() {
		return id;
	}
	
	private Color getColor() {
		// Solo mostramos shiny si esta presionado
		return mouseHoverMe == true ? color : color.darker();
	}
	
	public void paint(Graphics2D g){
		g.setColor(this.getColor());
		g.fillRect(posx, posy, 200, 200);
		
	}
	
}

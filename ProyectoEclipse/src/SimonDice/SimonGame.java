package SimonDice;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimonGame extends JPanel{

	private static final long serialVersionUID = 1L;
	private SimonButton topLeftButton;
	private SimonButton topRightButton;
	private SimonButton bottomLeftButton;
	private SimonButton bottomRightButton;
	private ArrayList secuence;
	private SimonMouseListener mouselistener;
	
	public SimonGame() {
		mouselistener = new SimonMouseListener();
		topLeftButton = new SimonButton(1, 0, 0, 199, 199, Color.RED);
		topRightButton = new SimonButton(2, 200, 0, 400, 199, Color.BLUE);
		bottomLeftButton = new SimonButton(3, 0, 200, 199, 400, Color.GREEN);
		bottomRightButton = new SimonButton(4, 200, 200, 400, 400, Color.YELLOW);
		secuence = new ArrayList<SimonButton>();
	}
	
	public MouseListener getMouseListener(){
		return mouselistener;
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		topLeftButton.paint(g2d);
		topRightButton.paint(g2d);
		bottomLeftButton.paint(g2d);
		bottomRightButton.paint(g2d);
		this.paintCanvas(g2d);
	}
	
	public void update() {
		// FIXME: CopyPaste. Make it smarter.
		topLeftButton.mouseInBounds(mouselistener.getXpos(), mouselistener.getYpos());
		topRightButton.mouseInBounds(mouselistener.getXpos(), mouselistener.getYpos());
		bottomLeftButton.mouseInBounds(mouselistener.getXpos(), mouselistener.getYpos());
		bottomRightButton.mouseInBounds(mouselistener.getXpos(), mouselistener.getYpos());
	}
	
	// FIXME tiene que ser un objeto 'fondo' que tenga un metodo paint()
	private void paintCanvas(Graphics2D g) {
		// Circulo del medio
		g.setColor(Color.BLACK);
		g.fillOval(150, 150, 100, 100);
		// Linea de circulo central
		g.setStroke(new BasicStroke(5));
		g.drawOval(0, 0, 400, 400);
		// fondo gris.
		g.setColor(Color.GRAY);
		g.setStroke(new BasicStroke(200));
		g.drawOval(-100, -100, 600, 600);
	}
	
	public static void main(String[] args) throws InterruptedException {
		   JFrame frm2 = new JFrame("frame2");
	        frm2.setTitle("Simon Dice");
	        frm2.setAutoRequestFocus(true);
	        frm2.setSize(400-5, 400-5);
	        frm2.setVisible(true);
	        frm2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        SimonGame game = new SimonGame();
	        frm2.add(game);
	        frm2.addMouseListener(game.getMouseListener());
	        while (true) {
	        	game.update();
	        	game.repaint();
	        	Thread.sleep(100);
		}
	}
	
	
	
}

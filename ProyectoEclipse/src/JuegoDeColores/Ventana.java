package JuegoDeColores;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ventana extends JFrame 
{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int WIDTH = 1000;
	 private int HEIGHT = 800;
	
	
	 // Swing components
	 JLabel puntos = new JLabel();
	 JTextField textField = new JTextField(150);
	 JMenuBar menuBar = new JMenuBar();
	 JMenu fileMenu = new JMenu("File");
	 JMenuItem fileNew = new JMenuItem("New");
	 JMenuItem fileExit = new JMenuItem("Exit");

	 
	 public Ventana() 
	 {
		 
		  buildGUI();
		  setSize(WIDTH,HEIGHT);
		  setResizable(false);
	 }
	 
	 void buildGUI() 
	 {
		 setTitle("SwingWin");
		 menuBar = new JMenuBar();
		 fileMenu = new JMenu("Opciones");
		 fileNew = new JMenuItem("Nuevo Juego");
		 fileExit = new JMenuItem("Exit");
		 
		 setupMenuBar();
		 layoutComponents();
		  
		 
		 //listener
		 addWindowListener(new WindowAdapter(){
			  public void windowClosing(WindowEvent e) {
				   System.exit(0);
				  }
				 });
		  fileNew.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
				   textField.setText("NEW");
				  }
				 });
		  fileExit.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
				   System.exit(0);
				   
				  }
				 });
				 
				
	 }
	
	 private void setupMenuBar() 
	 {
		  fileMenu.add(fileNew); 
		  fileMenu.add(fileExit); 
		  menuBar.add(fileMenu);
		  setJMenuBar(menuBar);
	 }
	
	 public void layoutComponents() 
	 {
		 getContentPane().setLayout(null);
		 textField.setBounds(80,80,150,30);
//		 getContentPane().add(textField);
		 puntos.setText("puntos:");
		 puntos.setBounds(800,20,200,20);
		 getContentPane().add(puntos);
	 }
	
 



 
}
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
	 JLabel frase = new JLabel();
	 JLabel textField = new JLabel();
	 int puntosNum=0;
	 JMenuBar menuBar = new JMenuBar();
	 JMenu fileMenu = new JMenu("File");
	 JMenuItem fileNew = new JMenuItem("New");
	 JMenuItem fileExit = new JMenuItem("Exit");

//	 JButton imagenFruta1 =new JButton("rojo");
	 
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
				   textField.setText("RojoClick");
				    frase.setText("Elija la fruta color "+textField.getText());
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
		 puntos.setText("puntos: "+puntosNum);
		 puntos.setBounds(800,20,200,20);
		 getContentPane().add(puntos);
		 
		 frase.setText("Seleccione juego Nuevo");
		 frase.setBounds(300,100,700,40);
		 frase.setVerticalAlignment(SwingConstants.CENTER);
		 frase.setFont(new java.awt.Font("SansSerif", Font.BOLD, 30));
		 getContentPane().add(frase);
		 setButtons();
	 }
	 
	 public void setButtons (){
		 int altura= 300;
		 int ancho = 200;
		 ImagenFruta imagenFruta1 =new ImagenFruta(1,"rojo");	
		 imagenFruta1.setBounds(100,300,ancho,altura);
		 getContentPane().add(imagenFruta1);
		 ImagenFruta imagenFruta2 =new ImagenFruta(2,"verde");	
		 imagenFruta2.setBounds(400,300,ancho,altura);
		 getContentPane().add(imagenFruta2);
		 ImagenFruta imagenFruta3 =new ImagenFruta(3,"azul");	
		 imagenFruta3.setBounds(700,300,ancho,altura);
		 getContentPane().add(imagenFruta3);
	 }


	
 



 
}
package JuegoDeColores;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("unused")
public  class VistaMenu extends JMenuBar
{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	 // Swing components
	public JMenuBar menu = new JMenuBar();
	public  JMenu fileMenu = new JMenu("Archivo");
	public JMenuItem fileNew = new JMenuItem("Nuevo Juego");
	 public JMenuItem fileExit = new JMenuItem("Exit");
//	 Ventana miVentana;

 
	 public VistaMenu( ) 
	 {
//		  miVentana= ventana;
		  fileMenu.add(fileNew); 
		  fileMenu.add(fileExit);
		  menu.add(fileMenu);
//		  buildGUI();
	 }
	 
/*	 void buildGUI() 
	 { 
		  fileNew.addActionListener(this);
					
		  fileExit.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
				   System.exit(0);
				   
				  }
				 });
				 
				
	 }

	@Override
	public void actionPerformed(ActionEvent ev) {
		// TODO Auto-generated method stub
		Object control=ev.getSource();
		if(control.equals(fileNew)){
			System.out.println("Se ha pulsado el botón Aceptar");
			miVentana.
		}
	}
	*/


	
}
package JuegoDeColores;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import Vista.Marcador;
import Vista.Tablero;
import CartasIguales.VistaCarta;

public class Ventana extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private int WIDTH = 1000;
	private int HEIGHT = 1000;
	private MarcadorFrutas marcador;
	private VistaPregunta vistaPregunta;
	private TableroFrutas tablero;
	private MainJuego controller;
	
	 public Ventana(String name) {
		  super(name);
		  setSize(WIDTH,HEIGHT);
		  setResizable(false);
		  setListeners();
	 }
	 
	 public void setController(MainJuego controller) {
		 this.controller = controller;
	 }
	 
	 public void setVisible(boolean aFlag) {
		 setBaseLayout();
		 agregarMarcadorFrutas();
		 agregarPregunta();
		
//		 tablero.setVisible(aFlag);
		
		
		 //agregarTablero2();
		 marcador.setVisible(aFlag);
		 vistaPregunta.setVisible(aFlag);
	
		 super.setVisible(aFlag);
		 this.pack();
	 }
	 
	 private void agregarMarcadorFrutas() {
		 marcador = new MarcadorFrutas();
		 this.add(marcador);
	 }
	 
	 private void agregarPregunta() {
		 vistaPregunta = new VistaPregunta();
		 this.add(vistaPregunta);
	 }
	 
	 public void modificarPregunta(String pregunta){
		 this.vistaPregunta.setPregunta(pregunta);
	 }
	 
	/* private void agregarTablero() {
		 // TODO: Sacar despues:
	//	 ArrayList<VistaCarta> botones = new ArrayList<VistaCarta>();
	//	 TableroFrutas tablero;
		 ArrayList<ImagenFruta> botones = new ArrayList<ImagenFruta>();
	//	 VistaCarta carta1 = new VistaCarta(1, "/imagenes/card.jpg");
	//	 carta1.addActionListener(this);
		 ImagenFruta carta2 = new ImagenFruta(2, "rojo");
		 carta2.addActionListener(this);
	//	 botones.add(carta1);
		 botones.add(carta2);
		 tablero = new TableroFrutas(botones);
		 this.getContentPane().add(tablero);
	 }*/
	 
	 public void agregarTablero2(ArrayList<ImagenFruta> listaImagenFruta) {
		 tablero = new TableroFrutas(listaImagenFruta);
		 //tablero.setVisible(true);
		 this.getContentPane().add(tablero);
	 }
	 
	 public void modificarTablero2(ArrayList<ImagenFruta> listaImagenFruta) {
		 this.getContentPane().remove(tablero);
		 asignarListenersFrutas(listaImagenFruta);
		 tablero = new TableroFrutas(listaImagenFruta);
		 tablero.setVisible(true);
		 this.getContentPane().add(tablero);
	 }
	 
	 private void setBaseLayout() {
		GridLayout layout = new GridLayout(3,0,0,0);
		// JPanel layout = new JPanel();
	/*	layout.setHgap(0);
		layout.setVgap(0);*/
		getContentPane().setLayout(layout);
		VistaMenu menuBar= new VistaMenu();
		
		//selectores desplegables
		menuBar.fileNew.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
				   controller.juegoNuevo();
				   }
				 });
		
		menuBar.fileExit.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
				   System.exit(0);
				   
				  }
				 });
		this.setJMenuBar(menuBar.menu);
		
	 }
	 
	 
	 private void setListeners(){
		 addWindowListener(new WindowAdapter(){
			  public void windowClosing(WindowEvent e) {
				   System.exit(0);
				  }
				 });
		 
		  
			

		 
			 
	 }
	 
	 private void asignarListenersFrutas(ArrayList<ImagenFruta> listaImagenFruta){
		 
		 for(ImagenFruta boton : listaImagenFruta){
			 boton.addActionListener(new ActionListener(){
				 public void actionPerformed(ActionEvent e) {
					 System.out.println("color "+boton.getColor());
					 if(controller.adivinarColor(boton.getColor())){//si es el color ganador
							int dialogButton = JOptionPane.YES_NO_OPTION;
							int dialogResult =  JOptionPane.showConfirmDialog (null, "GANASTE!!! Queres jugar el proximo nivel?","Frutas de Colores", dialogButton);
							controller.nuevoNivel(dialogResult);		
					 }
					 else{//si es el color perdedor
							int dialogButton = JOptionPane.YES_NO_OPTION;
							int dialogResult =  JOptionPane.showConfirmDialog (null, "Perdiste!!! Volver a intentarlo?","Frutas de Colores", dialogButton);
							controller.nuevoNivel(dialogResult);		
					 }
				  }});
		 }
		 
		 
		 
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		ImagenFruta carta = (ImagenFruta) e.getSource();
		if(carta.getId() == 2) {
			controller.adivinarColor("Naranja");
		} else {
			controller.adivinarColor("Rojo");
		}
				
	}
	 	
	 /*public void layoutComponents() 
	 {
		 textField.setBounds(80,80,150,30);
//		 getContentPane().add(textField);
		 puntos.setText("Puntos: "+puntosNum);
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
	 
	 public void actualizarFrase(String Frase){
		 textField.setText(Frase);
		 frase.setText(textField.getText());
		 
	 }

	 public void actualizarPuntos(int Puntos){
		 puntosNum=Puntos;
		 puntos.setText("Puntos: "+" "+ puntosNum);
		 
	 }*/
	
 



 
}
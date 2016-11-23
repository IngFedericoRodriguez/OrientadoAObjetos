package Vista;

import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

import Controlador.Controlador;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Label;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.GridBagLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;

@SuppressWarnings("unused")
public class VistaJuego extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnjugar;
	private JButton btncrearUsuario;
	private JButton btnlistarUsuarios;
	private JButton btnLogin;
	private JButton btnJugarCartasIguales;
	private JButton btnJugarJuegoFrutas;
	private Controlador controlador;
	private Box verticalBox;
	
	public VistaJuego() {
		super("Main menu");
		crearBotones();
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	
	private void crearBotones() {
		btncrearUsuario = new JButton("Crear Usuario");
		btncrearUsuario.addActionListener(this);
		btnlistarUsuarios = new JButton("Listar Usuarios");
		btnlistarUsuarios.addActionListener(this);
		btnLogin = new JButton("loguearse");
		btnLogin.addActionListener(this);
		btnJugarCartasIguales = new JButton("Jugar Cartas Iguales");
		btnJugarCartasIguales.addActionListener(this);
		btnJugarJuegoFrutas = new JButton("Jugar a conocer las frutas");
		btnJugarJuegoFrutas.addActionListener(this);

	}
	
	public void showGames() {
		verticalBox.add(btnJugarCartasIguales);
		btnJugarCartasIguales.setAlignmentX(Component.CENTER_ALIGNMENT);	
		verticalBox.add(btnJugarJuegoFrutas);
		btnJugarJuegoFrutas.setAlignmentX(Component.CENTER_ALIGNMENT);
		super.setVisible(true);
	}

	public void setVisible(boolean aFlag) {
		this.setTitle("Juego");
		this.setAutoRequestFocus(false);
		this.setSize(648, 465);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel Menu = new JPanel();
		FlowLayout flowLayout = (FlowLayout) Menu.getLayout();
		flowLayout.setAlignOnBaseline(true);
		this.getContentPane().add(Menu, BorderLayout.SOUTH);
		
		verticalBox = Box.createVerticalBox();
		verticalBox.setFont(new Font("Dialog", Font.BOLD, 12));
		Menu.add(verticalBox);
		
		verticalBox.add(btnLogin);
		btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		btncrearUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(btncrearUsuario);
		
		btnlistarUsuarios.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(btnlistarUsuarios);
																									
		/*JButton btnBorrarUsuario = new JButton("Borrar Usuario");
		btnBorrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Vamos a borrar usuarios!!!");
			}
		});
		btnBorrarUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(btnBorrarUsuario);
		*/
		JLabel imgJuego = new JLabel("Imagen");
		imgJuego.setHorizontalAlignment(SwingConstants.CENTER);
		this.getContentPane().add(imgJuego, BorderLayout.CENTER);

		super.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton pressedButton = (JButton) e.getSource();
		switch (pressedButton.getText()) {
			case "Jugar Cartas Iguales":
				controlador.jugarCartasIguales();
				break;
			case "Jugar a conocer las frutas":
				controlador.jugarJuegoColores();
				break;
			case "Crear Usuario": 
				controlador.iniciarGuiCrearUsuario();
				break;
			case "Listar Usuarios":
				controlador.iniciarGuiListarUsuarios();
				break;
			case "loguearse": 
				controlador.iniciarGuiLogin();
				break;
		}
	}
	

}

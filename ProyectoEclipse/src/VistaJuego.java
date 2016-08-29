
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;
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
public class VistaJuego {

	private mainJuego game;
	
	public VistaJuego(){
		game = new mainJuego();
	}
	public static void main(String[] args) {
		VistaJuego main = new VistaJuego();
		main.mostrarMenu();
	}

	public void mostrarMenu() {
		JFrame frmJuego = new JFrame("Main menu");
		frmJuego.setTitle("Juego");
		frmJuego.setAutoRequestFocus(false);
		frmJuego.setSize(648, 465);
		frmJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel Menu = new JPanel();
		FlowLayout flowLayout = (FlowLayout) Menu.getLayout();
		flowLayout.setAlignOnBaseline(true);
		frmJuego.getContentPane().add(Menu, BorderLayout.SOUTH);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setFont(new Font("Dialog", Font.BOLD, 12));
		Menu.add(verticalBox);
		
		JButton btnjugar = new JButton("Jugar");
		btnjugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Vamos a jugar!!!");
			}
		});
		verticalBox.add(btnjugar);
		btnjugar.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton btncrearUsuarios = new JButton("Crear Usuario");
		btncrearUsuarios.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(btncrearUsuarios);
		
		JButton btnlistarUsuarios = new JButton("Listar Usuarios");
		btnlistarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Vamos a listar usuarios!!!");
			}
		});
		btnlistarUsuarios.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(btnlistarUsuarios);
		
		JButton btnBorrarUsuario = new JButton("Borrar Usuario");
		btnBorrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Vamos a borrar usuarios!!!");
			}
		});
		btnBorrarUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(btnBorrarUsuario);
		
		JLabel imgJuego = new JLabel("Imagen");
		imgJuego.setHorizontalAlignment(SwingConstants.CENTER);
		frmJuego.getContentPane().add(imgJuego, BorderLayout.CENTER);
		btncrearUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Vamos a Crear Usuarios!!!");			}
		});
		frmJuego.setVisible(true);
	}
}

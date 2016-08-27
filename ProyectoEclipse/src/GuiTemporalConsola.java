
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;


/// Simulacion para el modelo vista.-

@SuppressWarnings("unused")
public class GuiTemporalConsola {

	private mainJuego game;
	
	public GuiTemporalConsola(){
		game = new mainJuego();
	}
	public static void main(String[] args) {
		GuiTemporalConsola main = new GuiTemporalConsola();
		main.mostrarMenu();
	}

	public void mostrarMenu() {
		JFrame frame = new JFrame("Main menu");
		frame.setSize(400, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);
		frame.setVisible(true);
		JButton newUser = new JButton("Crear Usuario");
		newUser.setActionCommand("newUser");
		newUser.setBounds(10, 10, 150, 25);
		panel.add(newUser);
		JButton simon = new JButton("Simon dice");
		simon.setBounds(200, 10, 150, 25);
		panel.add(simon);
	}
}

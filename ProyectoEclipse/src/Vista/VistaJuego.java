package Vista;

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
public class VistaJuego extends JFrame {
	private JButton btnjugar;
	private JButton btncrearUsuarios;
	private JButton btnlistarUsuarios;
	private JButton btnLogin;
	
	public VistaJuego(JButton btnjugar, JButton btncrearUsuarios, JButton btnlistarUsuarios, JButton btnLogin) {
		super("Main menu");
		this.btnjugar = btnjugar;
		this.btncrearUsuarios = btncrearUsuarios;
		this.btnlistarUsuarios = btnlistarUsuarios;
		this.btnLogin = btnLogin;
	}

	
	public JButton getBtnjugar() {
		return btnjugar;
	}

	public void setBtnjugar(JButton btnjugar) {
		this.btnjugar = btnjugar;
	}

	public JButton getBtncrearUsuarios() {
		return btncrearUsuarios;
	}

	public void setBtncrearUsuarios(JButton btncrearUsuarios) {
		this.btncrearUsuarios = btncrearUsuarios;
	}

	public JButton getBtnlistarUsuarios() {
		return btnlistarUsuarios;
	}

	public void setBtnlistarUsuarios(JButton btnlistarUsuarios) {
		this.btnlistarUsuarios = btnlistarUsuarios;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
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
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setFont(new Font("Dialog", Font.BOLD, 12));
		Menu.add(verticalBox);
		
		verticalBox.add(btnjugar);
		btnjugar.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		verticalBox.add(btnLogin);
		btnjugar.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		btncrearUsuarios.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(btncrearUsuarios);
		
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
}

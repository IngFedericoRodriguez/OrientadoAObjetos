package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;

	public class VistaLogin extends JFrame {

		private JPanel contentPane;
		private JTextField txtEmail;
		private JButton btnLogin;

		/**
		 * Launch the application.
		 */
		public VistaLogin(JButton btnLogin) {
			this.btnLogin = btnLogin;
		}

		public void setVisible(boolean aFlag) {
			setTitle("Loguearse");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 362, 194);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
			
			JPanel panel = new JPanel();
			contentPane.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			btnLogin.setBounds(244, 126, 93, 29);
			panel.add(btnLogin);
			
			txtEmail = new JTextField();
			txtEmail.setBounds(119, 71, 218, 26);
			panel.add(txtEmail);
			txtEmail.setColumns(10);
			super.setVisible(aFlag);
		}
		
		public String get() {
			return txtEmail.getText();
		}
		
		public void usuarioLogueado() {
			JOptionPane.showMessageDialog(null, "Logueado!");
		}
		
		public void usuarioNoEncontrado() {
			JOptionPane.showMessageDialog(null, "Usuario no encontrado, por favor ingresar mail existente");
		}	
		
	}

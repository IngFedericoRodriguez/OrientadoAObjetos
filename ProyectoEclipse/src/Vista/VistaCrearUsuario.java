package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;

public class VistaCrearUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCrearUsuario frame = new VistaCrearUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaCrearUsuario() {
		setTitle("Crear Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 362, 194);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(244, 126, 93, 29);
		panel.add(btnAgregar);
		
		JLabel lblNombre = new JLabel("Email");
		lblNombre.setBounds(46, 76, 61, 16);
		panel.add(lblNombre);
		
		JLabel label = new JLabel("Nombre");
		label.setBounds(46, 49, 61, 16);
		panel.add(label);
		
		JLabel lblAgregarUsuarios = new JLabel("Usuario");
		lblAgregarUsuarios.setBounds(151, 16, 61, 16);
		panel.add(lblAgregarUsuarios);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(119, 44, 218, 26);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(119, 71, 218, 26);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
	}
}

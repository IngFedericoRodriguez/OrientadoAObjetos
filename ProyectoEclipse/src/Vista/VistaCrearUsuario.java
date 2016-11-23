package Vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import Controlador.Controlador;

public class VistaCrearUsuario extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtEmail;
	private JButton crearUsuario;
	private Controlador controlador;

	public VistaCrearUsuario(Controlador controlador) {
		crearUsuario = new JButton("Grabar usuario");
		crearUsuario.addActionListener(this);
		this.controlador = controlador;
	}

	public void setVisible(boolean aFlag) {
		setTitle("Crear Usuario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 362, 194);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		crearUsuario.setBounds(244, 126, 93, 29);
		panel.add(crearUsuario);
		
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
		super.setVisible(aFlag);
	}
	
	public Hashtable<String, String> getUserData() {
		Hashtable<String, String> userData = new Hashtable<String, String>();
		userData.put("nombre", txtNombre.getText());
		userData.put("email", txtEmail.getText());
		return userData;
	}
	
	public void camposVacios() {
		JOptionPane.showMessageDialog(null, "Nombre y Email son campos requeridos");
	}
	
	public void usuarioCreado() {
		JOptionPane.showMessageDialog(null, "Usuario creado");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controlador.grabarUsuario(getUserData());	
	}
	
	
	
}

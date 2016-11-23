package Vista;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class VistaListarUsuarios extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public VistaListarUsuarios(Object[][] data) {
		super();
		setTitle("Lista de jugadores");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		String[] columnNames = {"Nombre",
                "Email",
                "Puntos en Cartas iguales",
                "Puntos en Juego de colores"
         };
	
		table = new JTable(data,columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setViewportView(table);
		add(scrollPane);
	}

}

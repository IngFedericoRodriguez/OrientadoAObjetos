package Vista;

public class TableroJuegoColores extends Tablero {

	private static final long serialVersionUID = 1L;

	public TableroJuegoColores() {
		super();
		usesFliplableCards = false;
	}

	@Override
	void crearFilasYColumnas() {
		this.filas = 1;
		this.columnas = 3;	
	}

}

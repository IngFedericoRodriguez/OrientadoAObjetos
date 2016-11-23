package Vista;

public class TableroJuegoFrutas extends Tablero {

	private static final long serialVersionUID = 1L;

	public TableroJuegoFrutas() {
		super();
		usesFliplableCards = false;
	}

	@Override
	void crearFilasYColumnas() {
		this.filas = 1;
		this.columnas = 3;	
	}

}

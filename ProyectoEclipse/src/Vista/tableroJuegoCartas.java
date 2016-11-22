package Vista;

import java.util.ArrayList;

public class tableroJuegoCartas extends Tablero {

	private static final long serialVersionUID = 1L;

	@Override
	void crearFilasYColumnas() {
		int elementosTotales = this.vistas.size();
		System.out.println(Integer.toString(elementosTotales));
		this.filas = 2;
		this.columnas = elementosTotales%3 == 0 ? elementosTotales/3 : elementosTotales/2;
		boolean encontrado = false;
		while (!encontrado && filas < elementosTotales) {
			if(filas * columnas == elementosTotales) {
				encontrado = true;
			} else {
				filas++;
			} 
		}
	}


}

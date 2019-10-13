package game.main;

import java.awt.Color;

import motor.reproduccion.GestorJuego;
import motor.reproduccion.Ventana;

public class Main extends GestorJuego{

	private static final int ANCHO = 700, ALTO = 500, TAM_BUFFER = 2;
	private static final String TITULO = "Motor Juego Java";
	private static Ventana ventana;

	public Main() {
		ventana = crearVentana(TITULO, ANCHO, ALTO, TAM_BUFFER);
	}

	public static void main(String[] args) {		
		new Main();
		
		// INICIAR JUEGO
		ventana.mostrar();

		while (ventana.isIniciado()) {
			ventana.refrescar(Color.BLACK);
			ventana.actualizar();
		}
		ventana.cerrar();

	}

}

package game.main;

import javax.swing.SwingUtilities;

import motor.reproduccion.Ventana;

public class Main {
	
	private static final int ANCHO = 700, ALTO = 500, TAM_BUFFER = 2;
	private static final String TITULO = "Motor Juego Java";
	private static Ventana ventana;

	public Main() {

	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {
			ventana = new Ventana(TITULO, ANCHO, ALTO, TAM_BUFFER);
			ventana.mostrar();

		});

	}

}

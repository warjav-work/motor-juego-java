package game.main;

import game.niveles.Game;
import motor.reproduccion.GestorJuego;
import motor.reproduccion.Ventana;

public class Main extends GestorJuego {

	private static final int ANCHO = 600, ALTO = 400, TAM_BUFFER = 2;
	private static final String TITULO = "Motor Juego Java";
	private static Ventana ventana;

	private static final int ID_GAME = 0;

	public Main() {
		ventana = crearVentana(TITULO, ANCHO, ALTO, TAM_BUFFER);
		ventana.setPantallaCompleta(false);
		ventana.mostrar();
	}

	public static void main(String[] args) {
		
		Main m = new Main();
		m.agregarNivel(new Game(ID_GAME));
		m.ingresaNivel(ID_GAME, true);
		

	}

}

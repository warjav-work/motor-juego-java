package game.objetos;

import java.util.Random;

import motor.fisica.objetos.GestorObjeto;
import motor.fisica.objetos.Objeto;
import motor.reproduccion.GestorJuego;
import motor.reproduccion.Ventana;

public class GeneradorBloque extends Objeto {

	private int actualizaciones;
	private int temporizador = 45;

	public GeneradorBloque(Ventana v, int y) {
		this.lx = 1;
		this.ly = 1;

		this.x = v.getWidth() + 64;
		this.y = y;

		this.id = "bloques";

		Random r = new Random();
		temporizador += r.nextInt(64);

	}

	@Override
	public void actualizar(Ventana v, GestorJuego gj) {
		actualizaciones++;
		if (actualizaciones > temporizador) {
			generar();
			actualizaciones = 0;

		}

	}

	private void generar() {
		if (Jugador.estaVivo()) {
			GestorObjeto.agregarObjeto(new Bloque(x, y));
		}

	}

}

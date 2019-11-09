package game.objetos;

import java.awt.Color;

import motor.fisica.objetos.Objeto;
import motor.reproduccion.GestorJuego;
import motor.reproduccion.Ventana;

public class Bloque extends Objeto {
	private static int velocidad = 3;

	public Bloque(int x, int y) {
		this.x = x;
		this.y = y;
		this.lx = 32;
		this.ly = 32;
		this.color = Color.RED;
		this.id = "bloque";
	}

	@Override
	public void actualizar(Ventana v, GestorJuego gj) {
		this.x -= velocidad;
		if (x < 0 - lx) {
			this.eliminado = true;
		}

	}

}

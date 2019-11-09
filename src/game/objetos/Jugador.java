package game.objetos;

import motor.entradas.Teclado;
import motor.fisica.colisiones.Colision;
import motor.fisica.objetos.GestorObjeto;
import motor.fisica.objetos.Objeto;
import motor.reproduccion.GestorJuego;
import motor.reproduccion.Ventana;

public class Jugador extends Objeto {

	private static boolean estoyVivo = true;
	public static int puntuacion;

	public Jugador(Ventana ventana) {
		this.lx = 32;
		this.ly = lx;

		this.x = 100;
		this.y = ventana.getHeight() / 2 - ly / 2;

		this.id = "jugador";
	}

	@Override
	public void actualizar(Ventana v, GestorJuego gj) {
		Teclado teclado = v.getTeclado();

		colisiona();
		if (!estoyVivo) {
			if (teclado.isPulsada(Teclado.ESPACIO)) {
				estoyVivo = true;
				puntuacion = 0;
				GestorObjeto.limpiar();
				gj.ingresaNivel(0, true);
			}
			return;
		}
		puntuacion++;
		
		if (teclado.isPulsada(Teclado.W)) {
			y -= 10;
		} else if (teclado.isPulsada(Teclado.S)) {
			y += 10;
		}

		if (y > v.getHeight() - ly) {
			y = v.getHeight() - ly;
		} else if (y < 0) {
			y = 0;
		}

	}

	private void colisiona() {
		for (int i = 0; i < GestorObjeto.getObjetos().size(); i++) {
			Objeto o = GestorObjeto.getObjetos().get(i);
			if (o.getId().equals("bloque")) {
				if (Colision.colisiona(this, o)) {
					estoyVivo = false;
				}
			}

		}

	}
	
	public static boolean estaVivo() {
		return estoyVivo;
	}

}

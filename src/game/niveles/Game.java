package game.niveles;

import motor.reproduccion.GestorJuego;
import motor.reproduccion.NivelJuego;
import motor.reproduccion.Ventana;

public class Game extends NivelJuego {

	public Game(int idNivel) {
		this.idNivel = idNivel;
	}

	@Override
	public void iniciar(Ventana ventana, GestorJuego gestor) {
		System.out.println(this.getClass().getSimpleName() + " >> ¡¡JUEGO INICIADO!!");

	}

	@Override
	public void actualizar(Ventana ventana, GestorJuego gestor) {
		

	}

	@Override
	public void reproducir(Ventana ventana, GestorJuego gestor) {
		

	}

}

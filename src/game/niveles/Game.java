package game.niveles;

import motor.reproduccion.GestorJuego;
import motor.reproduccion.NivelJuego;
import motor.reproduccion.Ventana;
import motor.utilidades.Debug;

public class Game extends NivelJuego {

	public Game(int idNivel) {
		this.idNivel = idNivel;
	}

	@Override
	public void iniciar(Ventana ventana, GestorJuego gestor) {
		Debug.LogInfo(this.getClass().getSimpleName() + " >> ¡¡JUEGO INICIADO!!");

	}

	@Override
	public void actualizar(Ventana ventana, GestorJuego gestor) {
		Debug.LogInfo(this.getClass().getSimpleName() + " >> JUEGO ACTUALIZANDO");

	}

	@Override
	public void reproducir(Ventana ventana, GestorJuego gestor) {
		Debug.LogInfo(this.getClass().getSimpleName() + " >> JUEGO REPRODUCIENDO");

	}

}

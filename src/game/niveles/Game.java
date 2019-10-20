package game.niveles;

import motor.reproduccion.GestorJuego;
import motor.reproduccion.NivelJuego;
import motor.reproduccion.Reproductor;
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
	public void reproducir(Ventana ventana, Reproductor r, GestorJuego gestor) {
		
		r.dibujarTexto("Hola mundo", 100, 300);
		r.rectanguloRelleno(200, 200, 36, 36);
	}

}

package game.niveles;

import motor.reproduccion.GestorJuego;
import motor.reproduccion.NivelJuego;
import motor.reproduccion.Reproductor;
import motor.reproduccion.Ventana;
import motor.reproduccion.graficos.Imagen;

public class Game extends NivelJuego {
	private Imagen img;

	public Game(int idNivel) {
		this.idNivel = idNivel;
	}

	@Override
	public void iniciar(Ventana ventana, GestorJuego gestor) {
		System.out.println(this.getClass().getSimpleName() + " >> ¡¡JUEGO INICIADO!!");
		img = new Imagen("imagen");

	}

	@Override
	public void actualizar(Ventana ventana, GestorJuego gestor) {
		

	}

	@Override
	public void reproducir(Ventana ventana, Reproductor r, GestorJuego gestor) {
		
		r.dibujarTexto("Hola mundo", 100, 300);
		r.rectanguloRelleno(200, 200, 36, 36);
		r.dibujarImagen(img, 300, 200);
	}

}

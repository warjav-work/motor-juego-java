package game.niveles;

import motor.entradas.Raton;
import motor.entradas.Teclado;
import motor.reproduccion.GestorJuego;
import motor.reproduccion.NivelJuego;
import motor.reproduccion.Reproductor;
import motor.reproduccion.Ventana;
import motor.reproduccion.graficos.Imagen;

public class Game extends NivelJuego {
	private Imagen img;
	private int x = 300, y=200;
	private String coordenadas = "0, 0";

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
		Teclado teclado = ventana.getTeclado();
		Raton raton = ventana.getRaton();
		
		coordenadas = raton.getX() + ", "+raton.getY();
		if(teclado.isPulsada(Teclado.W)) {
			y -= 2;
		}
		if(teclado.isPulsada(Teclado.S)) {
			y += 1;
		}
		
		if(teclado.isPulsada(Teclado.A)) {
			x -= 2;
		}
		if(teclado.isPulsada(Teclado.D)) {
			x += 1;
		}

	}

	@Override
	public void reproducir(Ventana ventana, Reproductor r, GestorJuego gestor) {
		
		r.dibujarTexto("Coordenadas: " + coordenadas, 10, 20);
		r.rectanguloRelleno(200, 200, 36, 36);
		r.dibujarImagen(img, x, y);
	}

}

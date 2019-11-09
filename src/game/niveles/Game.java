package game.niveles;

import game.objetos.Bloque;
import game.objetos.GeneradorBloque;
import game.objetos.Jugador;
import motor.entradas.Raton;
import motor.entradas.Teclado;
import motor.fisica.objetos.GestorObjeto;
import motor.reproduccion.GestorJuego;
import motor.reproduccion.NivelJuego;
import motor.reproduccion.Reproductor;
import motor.reproduccion.Ventana;
import motor.reproduccion.graficos.HojaSprite;
import motor.reproduccion.graficos.Imagen;

public class Game extends NivelJuego {
	private Imagen img;
	private int x = 300, y = 200;
	private String coordenadas = "0, 0";
	private int cx, cy;

	private HojaSprite hs;
	//private Bloque b;

	public Game(int idNivel) {
		this.idNivel = idNivel;
	}

	@Override
	public void iniciar(Ventana ventana, GestorJuego gestor) {
		System.out.println(this.getClass().getSimpleName() + " >> ¡¡JUEGO INICIADO!!");
		for (int i = 0; i < 5; i++) {
			GestorObjeto.agregarObjeto(new GeneradorBloque(ventana, i*64+64));
		}
		GestorObjeto.agregarObjeto(new Jugador(ventana));
		
		

	}

	@Override
	public void actualizar(Ventana ventana, GestorJuego gestor) {
		
		Raton raton = ventana.getRaton();
		//b.actualizar(ventana, gestor);
		
		coordenadas = raton.getX() + ", " + raton.getY();
		
		x = raton.getX() -50 - cx;
		y = raton.getY() -50 + cy;
		

	}

	@Override
	public void reproducir(Ventana ventana, Reproductor r, GestorJuego gestor) {

		r.dibujarTexto("Coordenadas: " + coordenadas, 10, 20);
		r.dibujarTexto("Puntuacion: " + Jugador.puntuacion, ventana.getWidth()/2 -34, 10);
		if(!Jugador.estaVivo()) {
			r.dibujarTexto("Presiona espacio para reiniciar, puntuacion: " + Jugador.puntuacion, ventana.getWidth()/2 -120,ventana.getHeight()/2 - 30);
		}
		
		// r.rectanguloRelleno(200, 200, 36, 36);
		//r.dibujarImagen(hs.getSprite(0, 0), x, y);
		//b.reproducir(ventana, r);
		//r.setPosicionCamara(cx, cy);
	}

}

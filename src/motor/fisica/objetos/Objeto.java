package motor.fisica.objetos;

import motor.reproduccion.GestorJuego;
import motor.reproduccion.Reproductor;
import motor.reproduccion.Ventana;
import motor.reproduccion.graficos.Imagen;

public abstract class Objeto {

	protected int x, y, lx, ly;
	protected boolean dibujar, dibujada, conImagen, eliminada;
	protected Imagen img;
	
	public abstract void actualizar(Ventana v, GestorJuego gj);
	
	
	public void reproducir(Ventana v, Reproductor r) {
		if(dibujar) {
			if(conImagen) {
				r.dibujarImagen(img, x, y);
			}else {
				r.rectanguloRelleno(x, y, lx, ly);
			}
			dibujada = true;
		}
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getLX() {
		return lx;
	}
	public int getLY() {
		return ly;
	}
	
	public boolean isDibujada() {
		return dibujada;
	}

}

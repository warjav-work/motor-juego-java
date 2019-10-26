package motor.reproduccion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import motor.reproduccion.graficos.Imagen;

public class Reproductor {
	private Ventana ventana;
	private BufferStrategy st;
	private Graphics g;
	
	
	public Reproductor(Ventana ventana) {
		this.ventana = ventana;
		this.st = ventana.getBufferStrategy();
		this.g = st.getDrawGraphics();
		g.setColor(Color.WHITE);
		
	}
	
	public void dibujarImagen(Imagen imagen, int x, int y) {
		g.drawImage(imagen.getImagen(), x, y, null);
	}
	
	public void dibujarTexto(String texto, int x, int y) {		
		g.drawString(texto, x, y);
	}
	
	public void rectanguloRelleno(int x, int y,int ancho, int alto) {
		g.fillRect(x, y, ancho, alto);
	}
	
	public void setColor(Color color) {
		g.setColor(color);
	}

}

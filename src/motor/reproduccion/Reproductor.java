package motor.reproduccion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Reproductor {
	private Ventana ventana;
	private BufferStrategy st;
	private Graphics g;
	
	
	public Reproductor(Ventana ventana) {
		this.ventana = ventana;
		this.st = ventana.getBufferStrategy();
		this.g = st.getDrawGraphics();
		
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

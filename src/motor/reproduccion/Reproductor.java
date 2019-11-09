package motor.reproduccion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import motor.reproduccion.graficos.Imagen;

public class Reproductor {
	private Ventana ventana;
	private BufferStrategy st;
	private Graphics g;
	private int camX, camY;
	
	
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
	
	public void rectanguloRelleno(int x, int y,int ancho, int alto, Color color) {
		Color anterior = g.getColor();
		g.setColor(color);
		g.fillRect(x, y, ancho, alto);
		g.setColor(anterior);
	}
	
	public void setColor(Color color) {
		g.setColor(color);
	}
	
	public void setPosicionCamara(int cx, int cy) {
		g.translate(-camX, -camY);
		camX = cx;
		camY = cy;		
		g.translate(camX, camY);
	}
	
	public void moverCamara(int mx, int my) {
		camX += mx;
		camY += my;
		g.translate(mx, my);
	}
	
	public int getCamX() {
		return camX;
	}
	
	public int getCamY() {
		return camY;
	}

}

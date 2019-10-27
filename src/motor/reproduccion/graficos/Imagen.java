package motor.reproduccion.graficos;

import java.awt.image.BufferedImage;

import motor.utilidades.CargadorRecurso;

public class Imagen {

	private BufferedImage imagen;

	public Imagen(String ruta) {
		imagen = CargadorRecurso.cargarBufferedImagen(ruta);
	}
	
	public Imagen(BufferedImage imagen) {
		this.imagen = imagen;
	}
	
	public BufferedImage getImagen() {
		return imagen;
	}
	
	public int getAncho() {
		return imagen.getWidth(null);
	}
	
	public int getAlto() {
		return imagen.getHeight(null);
	}
}

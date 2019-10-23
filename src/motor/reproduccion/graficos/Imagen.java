package motor.reproduccion.graficos;

import java.awt.Image;

import motor.utilidades.CargadorRecurso;

public class Imagen {

	private Image img;

	public Imagen(String ruta) {
		img = CargadorRecurso.cargarImagen(ruta);
	}
	
	public Image getImagen() {
		return img;
	}
	
	public int getAncho() {
		return img.getWidth(null);
	}
	
	public int getAlto() {
		return img.getHeight(null);
	}
}

package motor.utilidades;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class CargadorRecurso {

	public static Image cargarImagen(String ruta) {
		Image img = null;
		try {
			img = ImageIO.read(new File("res/" + ruta + ".png"));
		} catch (Exception e) {
			System.out.println(CargadorRecurso.class.getSimpleName() + " >> " + e.getMessage());
		}
		return img;
	}
	
	public static BufferedImage cargarBufferedImagen(String ruta) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("res/" + ruta + ".png"));
		} catch (Exception e) {
			System.out.println(CargadorRecurso.class.getSimpleName() + " >> " + e.getMessage());
		}
		return img;
	}

}

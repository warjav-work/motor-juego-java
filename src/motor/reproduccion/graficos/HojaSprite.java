package motor.reproduccion.graficos;

import java.awt.image.BufferedImage;

import motor.utilidades.Debug;

public class HojaSprite {

	private BufferedImage imagen;
	private int ancho, alto;

	/**
	 * 
	 * @param imagen Objeto imagen, hoja de sprites.
	 * @param ancho ancho cuadricula.
	 * @param alto alto cuadricula.
	 */
	public HojaSprite(Imagen imagen, int ancho, int alto) {

		this.imagen = imagen.getImagen();
		this.ancho = ancho;
		this.alto = alto;
	}

	public BufferedImage getImagenSprite(int x, int y) {
		try {
			return imagen.getSubimage(x * ancho, y * alto, ancho, alto);
		} catch (Exception e) {
			Debug.LogError(this.getClass().getSimpleName() + ">>  Fallo al obtener sub-imagen.");
		}
		return null;
	}
	
	/**
	 * 
	 * @param arrayX posición x de cuadricula en la hoja de Sprites.
	 * @param arrayY posición y de cuadricula en la hoja de Sprites.
	 * @return
	 */
	public Imagen getSprite(int arrayX, int arrayY) {
		return new Imagen(getImagenSprite(arrayX, arrayY));
	}

}

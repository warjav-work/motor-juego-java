package motor.reproduccion;

import java.awt.Color;
import java.util.ArrayList;

/**
 * 
 * Gestiona las pantallas del juego (Menu - Game - Pause).
 * 
 * @author warjav-work
 *
 */
public class GestorJuego {

	private ArrayList<NivelJuego> niveles = new ArrayList<NivelJuego>();
	private NivelJuego nivelActual;
	private Ventana ventana;

	// ACCESOS AL JUEGO
	public void agregarNivel(NivelJuego nivel) {
		niveles.add(nivel);
	}

	public void limpiarNiveles(NivelJuego nivel) {
		niveles.clear();
	}

	public void ingresaNivel(int idNivel, boolean iniciado) {
		nivelActual = niveles.get(idNivel);
		if (iniciado) {
			nivelActual.iniciar(ventana, this);
		}
	}

	/**
	 * 
	 * @param titulo Titulo de la ventana del Juego.
	 * @param ancho Ancho de la ventana del Juego.
	 * @param alto Alto de la ventana del Juego.
	 * @param tam_buffer Tamaño del buffer.
	 * @return Devuelve una instancia de la ventana.
	 */
	public Ventana crearVentana(String titulo, int ancho, int alto, int tam_buffer) {
		ventana = new Ventana(titulo, ancho, alto, tam_buffer, this);
		return ventana;
	}

	// ACCESOS A LA VENTANA
	protected void iniciar() {
		if (isNivelAbierto())
			nivelActual.iniciar(ventana, this);
	}

	protected void actualizar() {
		if (isNivelAbierto()) {
			nivelActual.actualizar(ventana, this);
			ventana.actualizaciones++;
		}
	}

	protected void repoducir() {
		if (isNivelAbierto()) {
			ventana.refrescar(Color.BLACK);
			nivelActual.reproducir(ventana, ventana.getReproductor(), this);
			ventana.actualizar();
			ventana.frames++;
		}
	}

	private boolean isNivelAbierto() {
		if (nivelActual == null) {
			return false;
		}
		return true;
	}

}

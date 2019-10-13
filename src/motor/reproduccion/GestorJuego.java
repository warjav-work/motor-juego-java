package motor.reproduccion;

import java.util.ArrayList;

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

	public Ventana crearVentana(String titulo, int ancho, int alto, int tam_buffer) {
		ventana = new Ventana(titulo, ancho, alto, tam_buffer);
		return ventana;
	}

	// ACCESOS A LA VENTANA
	protected void iniciar() {
		if (isNivelAbierto())
			nivelActual.iniciar(ventana, this);
	}

	protected void actualizar() {
		if (isNivelAbierto())
			nivelActual.actualizar(ventana, this);
	}

	protected void repoducir() {
		if (isNivelAbierto())
			nivelActual.reproducir(ventana, this);
	}

	private boolean isNivelAbierto() {
		if (nivelActual == null) {
			return false;
		}
		return true;
	}

}

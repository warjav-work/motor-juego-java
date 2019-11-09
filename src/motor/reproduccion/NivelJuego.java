package motor.reproduccion;

public abstract class NivelJuego {

	protected int idNivel;

	public abstract void iniciar(Ventana ventana, GestorJuego gestor);

	public abstract void actualizar(Ventana ventana, GestorJuego gestor);

	public abstract void reproducir(Ventana ventana, Reproductor reproductor, GestorJuego gestor);

	public int getNivel() {
		return idNivel;
	}
}

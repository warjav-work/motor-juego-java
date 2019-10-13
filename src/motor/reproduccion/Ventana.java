package motor.reproduccion;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import motor.utilidades.Debug;

public class Ventana extends Canvas {

	private static final long serialVersionUID = 1L;

	private static JFrame VENTANA;
	private static int ANCHO, ALTO, TAM_BUFFER;
	private static String TITULO;
	private static boolean iniciado;

	public Ventana(String titulo, int ancho, int alto, int tam_buffer) {

		Ventana.TITULO = titulo;
		Ventana.ANCHO = ancho;
		Ventana.ALTO = alto;
		Ventana.TAM_BUFFER = tam_buffer;

		Dimension dimension = new Dimension(ANCHO, ALTO);
		setPreferredSize(dimension);
		setSize(dimension);
		setFocusable(true);

		VENTANA = new JFrame(TITULO);

		VENTANA.setSize(dimension);
		VENTANA.add(this);
		VENTANA.pack();
		VENTANA.setResizable(false);
		VENTANA.setLocationRelativeTo(null);
		VENTANA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void mostrar() {
		
		this.createBufferStrategy(TAM_BUFFER);
		iniciado = true;
		VENTANA.setVisible(true);
		Debug.LogInfo(this.getClass().getSimpleName() + " >> ¡¡VENTANA INICIADA!!");
		
	}

	/**
	 * Muestra el siguiente Buffer.
	 */
	public void actualizar() {
		this.getBufferStrategy().show();
	}

	/**
	 * Refresca el color de la ventana.
	 * 
	 * @param color Color de refreco de ventana.
	 */
	public void refrescar(Color color) {

		if (!isIniciado()) {
			Debug.LogError(this.getClass().getSimpleName() + " >> VENTANA NO INICIADA");
		}

		BufferStrategy st = this.getBufferStrategy();
		Graphics g = st.getDrawGraphics();
		g.setColor(color);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.dispose();

	}

	/**
	 * Cierra la aplicación.
	 */
	public void cerrar() {

		Debug.LogInfo(this.getClass().getSimpleName() + "¡¡CERRANDO LA APLICACIÓN!!");

		VENTANA.dispose();
		// iniciado = false;
		System.exit(0);
	}

	public boolean isIniciado() {
		return iniciado;
	}

}

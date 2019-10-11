package motor.reproduccion;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Ventana extends Canvas {

	private static final long serialVersionUID = 1L;

	private static JFrame VENTANA;
	private static int ANCHO, ALTO, TAM_BUFFER;
	private static String TITULO;

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
		VENTANA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VENTANA.setSize(dimension);
		VENTANA.add(this);
		VENTANA.pack();
		VENTANA.setResizable(false);
		VENTANA.setLocationRelativeTo(null);
		
		

	}
	
	public void mostrar() {
		VENTANA.setVisible(true);
	}

}

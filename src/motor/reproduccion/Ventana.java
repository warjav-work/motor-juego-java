package motor.reproduccion;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import motor.entradas.Raton;
import motor.entradas.Teclado;

public class Ventana extends Canvas {

	private static final long serialVersionUID = 1L;

	private static JFrame VENTANA;
	private static int ANCHO, ALTO, TAM_BUFFER;
	private static String TITULO;

	private GestorJuego gj;
	private Thread bucle;
	private Reproductor reproductor;
	

	private final double FRECUENCIA = 60;
	int frames, actualizaciones, tiempo;
	private int framesPasados, actualizacionesPasadas;
	
	private static boolean iniciado;
	
	private Teclado teclado = new Teclado();
	private Raton raton = new Raton();

	public Ventana(String titulo, int ancho, int alto, int tam_buffer, GestorJuego gj) {

		this.gj = gj;

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

	/**
	 * Muestra la ventana e inicia el bucle de juego.
	 */
	public void mostrar() {

		this.createBufferStrategy(TAM_BUFFER);
		iniciado = true;
		VENTANA.setVisible(true);

		reproductor = new Reproductor(this);
		iniciarListenersEntrada();
		bucleJuego();

		System.out.println(this.getClass().getSimpleName() + " >> ¡¡VENTANA INICIADA!!");

	}

	private void iniciarListenersEntrada() {
		this.addKeyListener(teclado);
		this.addMouseListener(raton);
		this.addMouseMotionListener(raton);
		
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
			System.err.println(this.getClass().getSimpleName() + " >> VENTANA NO INICIADA");
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

		System.out.println(this.getClass().getSimpleName() + "¡¡CERRANDO LA APLICACIÓN!!");

		VENTANA.dispose();
		// iniciado = false;
		System.exit(0);
	}
	
	public void setPantallaCompleta(boolean pantallaCompleta) {
		if(pantallaCompleta && !iniciado) {
			VENTANA.dispose();
			VENTANA.setUndecorated(true);
			VENTANA.setExtendedState(JFrame.MAXIMIZED_BOTH);
			VENTANA.setVisible(true);			
		}
		ANCHO = VENTANA.getWidth();
		ALTO = VENTANA.getHeight();
	}

	private void bucleJuego() {
		bucle = new Thread("Bucle Ventana") {
			@Override
			public void run() {
				double pasado = System.nanoTime();
				double delta = 0;
				final double ns = 1e9 / FRECUENCIA;

				double iniciar = System.currentTimeMillis();
				int siguente = 1;

				while (isIniciado()) {

					double actual = System.nanoTime();
					double ahora = (System.currentTimeMillis() - iniciar) / 1000;

					delta += (actual - pasado) / ns;
					pasado = actual;
					while (delta >= 1) {

						gj.actualizar();
						delta--;
					}
					gj.repoducir();
					
					if (ahora >= siguente) {
						siguente++;
						tiempo++;
						actualizacionesPasadas = actualizaciones;
						framesPasados = frames;
						System.out.println("Ventana" + " >> FPS: " + framesPasados + ", APS: " + actualizacionesPasadas);
						actualizaciones = 0;
						frames = 0;
					}
				}
			}
		};
		bucle.start();
	}

	public boolean isIniciado() {
		return iniciado;
	}
	
	protected Reproductor getReproductor() {
		return reproductor;
	}
	
	public Teclado getTeclado() {
		return teclado;
	}
	
	public Raton getRaton() {
		return raton;
	}

}

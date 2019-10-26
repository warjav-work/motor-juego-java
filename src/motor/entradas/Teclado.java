package motor.entradas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import motor.utilidades.Debug;

public class Teclado extends Entrada implements KeyListener {
	private ArrayList<Integer> presionadas = new ArrayList<Integer>();
	private ArrayList<Integer> pulsadas = new ArrayList<Integer>();

	@Override
	public void keyPressed(KeyEvent e) {
		int tecla = e.getKeyCode();
		if(pulsadas.indexOf(tecla) == -1) {
			presionadas.add(tecla);
			pulsadas.add(tecla);
			Debug.LogInfo("Entrada >> AÑADIDA TECLA" +tecla);
		}
		

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int tecla = e.getKeyCode();
		if(presionadas.indexOf(tecla) != -1) {
			presionadas.remove(presionadas.indexOf(tecla));		

		}
		
		if(pulsadas.indexOf(tecla) != -1) {
			pulsadas.remove(pulsadas.indexOf(tecla));		

		}
		Debug.LogInfo("Entrada >> ELIMINADA TECLA " +tecla);
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	
	// ACCESO A JUEGO
	public boolean isPresionada(int tecla) {
		boolean presionada = false;
		if (presionadas.indexOf(tecla) != -1) {
			presionadas.remove(presionadas.indexOf(tecla));
			presionada = true;
		}
		
		return presionada;
	}
	
	public boolean isPulsada(int tecla) {
		boolean pulsada = false;
		if (pulsadas.indexOf(tecla) != -1) {
			pulsadas.remove(pulsadas.indexOf(tecla));
			pulsada = true;
		}
		
		return pulsada;
	}

}

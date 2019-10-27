package motor.entradas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import motor.utilidades.Debug;

public class Raton extends Entrada implements MouseListener, MouseMotionListener {

	private ArrayList<Integer> presionados = new ArrayList<Integer>();
	private ArrayList<Integer> pulsados = new ArrayList<Integer>();

	private static int x, y;

	@Override
	public void mousePressed(MouseEvent e) {
		int boton = e.getButton();
		if (pulsados.indexOf(boton) == -1) {
			presionados.add(boton);
			pulsados.add(boton);
		}
		Debug.LogInfo("Raton>> AGREGADO BOTON " + boton);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int boton = e.getButton();
		if (presionados.indexOf(boton) != -1) {
			presionados.remove(presionados.indexOf(boton));
		}

		if (pulsados.indexOf(boton) != -1) {
			pulsados.remove(pulsados.indexOf(boton));
		}

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();

	}

	// ACCESO A JUEGO
	public boolean isBotonPresionado(int boton) {
		boolean presionado = false;
		if (presionados.indexOf(boton) != 0) {
			presionados.remove(presionados.indexOf(boton));
			presionado = true;
		}
		return presionado;
	}

	public boolean isBotoPulsado(int boton) {
		boolean presionado = false;
		if (pulsados.indexOf(boton) != 0) {
			pulsados.remove(pulsados.indexOf(boton));
			presionado = true;
		}
		return presionado;
	}
	
	public boolean isRatonDespulsado(int boton) {
		return pulsados.contains(boton) ? false : true;
	}

	public static int getX() {
		return x;
	}

	public static int getY() {
		return y;
	}

	// METODOS NO USADOS
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

}

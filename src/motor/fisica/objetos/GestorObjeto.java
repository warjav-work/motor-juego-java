package motor.fisica.objetos;

import java.util.ArrayList;

import motor.reproduccion.GestorJuego;
import motor.reproduccion.Reproductor;
import motor.reproduccion.Ventana;

public class GestorObjeto {

	private static ArrayList<Objeto> objetos = new ArrayList<Objeto>();

	// Metodos de objetos
	public static void agregarObjeto(Objeto objeto) {
		objetos.add(objeto);
	}

	public static void borrarObjeto(Objeto objeto) {
		objetos.remove(objeto);
	}

	public static void limpiar() {
		objetos.clear();
	}
	
	public static ArrayList<Objeto> getObjetos() {
		return objetos;
	}

	// Actualizar objetos
	public static void actualizar(Ventana v, GestorJuego gj) {
		for (int i = 0; i < objetos.size(); i++) {
			Objeto objeto = objetos.get(i);
			if (objeto.eliminado) {
				objetos.remove(objeto);
			} else {
				objeto.actualizar(v, gj);
			}
		}
	}

	public static void reproducir(Ventana v, Reproductor r) {
		for (int i = 0; i < objetos.size(); i++) {
			Objeto objeto = objetos.get(i);
			objeto.reproducir(v, r);
		}
	}

}

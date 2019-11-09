package motor.fisica.colisiones;

import java.awt.Rectangle;

import motor.fisica.objetos.Objeto;

public class Colision {
	
	public static boolean colisiona(Objeto o1, Objeto o2) {
		
		Rectangle r1 = new Rectangle(o1.getX(), o1.getY(), o1.getLX(), o1.getLY());
		Rectangle r2 = new Rectangle(o2.getX(), o2.getY(), o2.getLX(), o2.getLY());
		
		return r1.intersects(r2);
	}

}

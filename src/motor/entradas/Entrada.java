package motor.entradas;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public abstract class Entrada {
	
	public static int
	A = KeyEvent.VK_A,
	B = KeyEvent.VK_B,
	C = KeyEvent.VK_C,
	D = KeyEvent.VK_D,
	F = KeyEvent.VK_F,
	G = KeyEvent.VK_G,
	H = KeyEvent.VK_H,
	I = KeyEvent.VK_I,
	J = KeyEvent.VK_J,
	K = KeyEvent.VK_K,
	L = KeyEvent.VK_L,
	M = KeyEvent.VK_M,
	N = KeyEvent.VK_N,
	Ñ = KeyEvent.getExtendedKeyCodeForChar(0),
	O = KeyEvent.VK_O,
	P = KeyEvent.VK_P,
	Q = KeyEvent.VK_Q,
	R = KeyEvent.VK_R,
	S = KeyEvent.VK_S,
	T = KeyEvent.VK_T,
	U = KeyEvent.VK_U,
	V = KeyEvent.VK_V,
	W = KeyEvent.VK_W,
	X = KeyEvent.VK_X,
	Y = KeyEvent.VK_Y,
	Z = KeyEvent.VK_Z,
	ARRIBA = KeyEvent.VK_UP,
	ABAJO = KeyEvent.VK_DOWN,
	IZQDA = KeyEvent.VK_LEFT,
	DCHA = KeyEvent.VK_RIGHT,
	MAYUS = KeyEvent.VK_SHIFT,
	SPACIO = KeyEvent.VK_SPACE,
	ENTER = KeyEvent.VK_ENTER,
	ESCAPE = KeyEvent.VK_ESCAPE,
	
	// Raton
	RATON_IZQDA = MouseEvent.BUTTON1,
	RATON_MEDIO = MouseEvent.BUTTON2,
	RATON_DCHA = MouseEvent.BUTTON3;

}

package motor.utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Debug {
	static Date fecha = new Date();
	static SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");    
    static String fechaAc = formato.format(fecha);

	public static void LogInfo(String mensaje) {
		
		
		System.out.println(mensaje + " | " + fechaAc );
	}

	public static void LogError(String mensaje) {
		System.err.println(mensaje + " | " + fechaAc );
	}

}

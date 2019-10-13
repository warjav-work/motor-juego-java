package motor.utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Debug {

	public static void LogInfo(String mensaje) {
		Date fecha = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss");
        
        String fechaAc = formato.format(fecha);
		System.out.println(mensaje + " | " + fechaAc );
	}

	public static void LogError(String mensaje) {
		System.err.println(mensaje);
	}

}

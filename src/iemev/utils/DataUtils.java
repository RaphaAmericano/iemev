package iemev.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtils {
	
	public static String formatarData(Date data) {
		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String retorno = dataFormat.format(data);
		return retorno;
	}
	
	public static Date parseData(String data) {
		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date retorno = new Date();
		try {
			retorno = dataFormat.parse(data); 
		}catch(Exception e ) {
			e.printStackTrace();
		}
		return retorno;
	}
	public static String horaAtual() {
		Calendar agora = Calendar.getInstance();
		String retorno = agora.get(Calendar.HOUR_OF_DAY)+":"+agora.get(Calendar.MINUTE)+":"+agora.get(Calendar.SECOND);
		return retorno;
	}
}

package iemev.utils;

import java.text.SimpleDateFormat;
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
}

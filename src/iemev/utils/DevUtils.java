package iemev.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

public class DevUtils {
	public static void ListarAtributos(HttpSession session ) {
   		Enumeration e = (Enumeration) (session.getAttributeNames());

        while ( e.hasMoreElements())
        {
            Object tring;
            if((tring = e.nextElement())!=null)
            {
                System.out.println(session.getValue((String) tring));
            }

        }
	}
}

package iemev.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import iemev.models.Empregado;

public class UrlUtils {
	public static String urlPagina(HttpServletRequest request, HttpSession session) {
		String url =  request.getRequestURI();
		String[] parts = url.split("/");
		String pagina = parts[2];
		Empregado empregado = (Empregado) session.getAttribute("empregado");
		String perfil = empregado.getTipoEmpregado();
		return perfil;
	}
}

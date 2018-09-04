package iemev.manager;

import iemev.dao.EmpregadoDAO;
import iemev.models.Empregado;

public class EmpregadoManager {
	public static Empregado buscar(long cpf ) {
		EmpregadoDAO dao = new EmpregadoDAO();
		Empregado retorno = dao.buscar(cpf);
		
		return retorno;
	}
}

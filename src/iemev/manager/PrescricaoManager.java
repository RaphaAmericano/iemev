package iemev.manager;

import iemev.dao.PrescricaoDAO;
import iemev.models.Prescricao;

public class PrescricaoManager {
	public static boolean inserir(int ficha, int servico) {
		PrescricaoDAO dao = new PrescricaoDAO();
		try {
			prescricao = dao.inserir(ficha, servico);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}

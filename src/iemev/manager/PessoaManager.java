package iemev.manager;

import iemev.dao.PessoaDAO;
import iemev.models.Pessoa;

public class PessoaManager {
	public static Pessoa buscarId(long id ) {
		PessoaDAO dao = new PessoaDAO();
		try {
			Pessoa pessoa = dao.buscarId(id);
			return pessoa;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

package iemev.dao;

import java.util.List;

public interface GenericDAO {

	public void inserir( Object o );
	public boolean apagar (int id);
	public void atualizar( Object o );
	public List<?> selecionarTodos();
	public Object selecionarPorID ( int identificado );
}

package iemev.state;

import iemev.models.FichaDeAtendimento;

public class FichaFechadaState implements FichaState{
	FichaDeAtendimento ficha;
	public FichaFechadaState(FichaDeAtendimento ficha ){
		super();
		this.ficha = ficha;
	}	
	@Override
	public void abrir() {
		ficha.setStatusAtual(ficha.getFichaAberta());
	}
	@Override
	public void fechar() {
		return;
	}
	@Override
	public String stateString() {
		return "fechada";
	}
}

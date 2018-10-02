package iemev.state;

import iemev.models.FichaDeAtendimento;

public class FichaAbertaState implements FichaState{
	FichaDeAtendimento ficha;
	public FichaAbertaState(FichaDeAtendimento ficha ){
		super();
		this.ficha = ficha;
	}
	
	@Override
	public void abrir() {
		return;
	}
	@Override
	public void fechar() {
		ficha.setStatusAtual(ficha.getFichaFechada()); 
		
	}
	@Override
	public String stateString() {
		return "aberta";
	}
}

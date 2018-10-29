package iemev.models;

import java.util.Date;
import java.util.List;

import iemev.state.FichaAbertaState;
import iemev.state.FichaFechadaState;
import iemev.state.FichaState;

public class FichaDeAtendimento {
		private int numeroFicha;
		private Date dataAbertura;
		private Date dataFechamento;
		private int idAnimal;
		private int idAtendenteAbriuFicha;
		private int idAtendenteFechouFicha;
		private List<Servico> servicos;
		//private String statusFicha;
		
		
		private FichaState fichaAbertaState = new FichaAbertaState(this);
		private FichaState fichaFechadaState = new FichaFechadaState(this);
		private FichaState statusFicha = fichaAbertaState;
		
		public FichaDeAtendimento() {
			super();
		}
		
		public FichaDeAtendimento(int idFicha, Date dataAbertura, Date dataFechamento, int idAnimal, int idAteAbr, int idAteFec, String status ) {
			this.numeroFicha = idFicha;
			this.dataAbertura = dataAbertura;
			this.dataFechamento = dataFechamento;
			this.idAnimal = idAnimal;
			this.idAtendenteAbriuFicha = idAteAbr;
			this.idAtendenteFechouFicha = idAteFec;
			if(status.equals("aberta")) {
				this.statusFicha.abrir();	
			} else {
				this.statusFicha.fechar();
			}
		}
		
		public FichaDeAtendimento(Date dataAbertura, Date dataFechamento, int idAnimal, int idAteAbr, int idAteFec, String status ) {
			this.dataAbertura = dataAbertura;
			this.dataFechamento = dataFechamento;
			this.idAnimal = idAnimal;
			this.idAtendenteAbriuFicha = idAteAbr;
			this.idAtendenteFechouFicha = idAteFec;
			if(status.equals("aberta")) {
				this.statusFicha.abrir();	
			} else {
				this.statusFicha.fechar();
			}
		}
		//Constructor para abertura de ficha
		public FichaDeAtendimento(Date dataAbertura, int idAnimal, int idAteAbr ) {
			this.dataAbertura = dataAbertura;
			this.idAnimal = idAnimal;
			this.idAtendenteAbriuFicha = idAteAbr;
			//this.statusFicha = "Aberta";
		}
		
		public int getNumeroFicha() {
			return numeroFicha;
		}
		public void setNumeroFicha(int numeroFicha) {
			this.numeroFicha = numeroFicha;
		}
		public Date getDataAbertura() {
			return dataAbertura;
		}
		public void setDataAbertura(Date dataAbertura) {
			this.dataAbertura = dataAbertura;
		}
		public Date getDataFechamento() {
			return dataFechamento;
		}
		public void setDataFechamento(Date dataFechamento) {
			this.dataFechamento = dataFechamento;
		}
		public int getIdAnimal() {
			return idAnimal;
		}
		public void setIdAnimal(int idAnimal) {
			this.idAnimal = idAnimal;
		}
		public int getIdAtendenteAbriuFicha() {
			return idAtendenteAbriuFicha;
		}
		public void setIdAtendenteAbriuFicha(int idAtendenteAbriuFicha) {
			this.idAtendenteAbriuFicha = idAtendenteAbriuFicha;
		}
		public int getIdAtendenteFechouFicha() {
			return idAtendenteFechouFicha;
		}
		public void setIdAtendenteFechouFicha(int idAtendenteFechouFicha) {
			this.idAtendenteFechouFicha = idAtendenteFechouFicha;
		}	
		public void abrirFicha() {
			statusFicha.abrir();
		}
		public void fecharFicha() {
			statusFicha.fechar();
		}
		public FichaState getStatusAtual() {
			return statusFicha;
		}
		public void setStatusAtual(FichaState status) {
			this.statusFicha = status;
		}
		public FichaState getFichaFechada() {
			return fichaFechadaState;
		}
		public FichaState getFichaAberta() {
			return fichaAbertaState;
		}
		public void adicionarServico(Servico servico) {
			this.servicos.add(servico);
		}
}

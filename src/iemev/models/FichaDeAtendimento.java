package iemev.models;

import java.util.Date;

public class FichaDeAtendimento {
		private int numeroFicha;
		private Date dataAbertura;
		private Date dataFechamento;
		private int idAnimal;
		private int idAtendenteAbriuFicha;
		private int idAtendenteFechouFicha;
		private String statusFicha;
		
		public FichaDeAtendimento() {
			super();
		}
		
		public FichaDeAtendimento(Date dataAbertura, Date dataFechamento, int idAnimal, int idAteAbr, int idAteFec, String status ) {
			this.dataAbertura = dataAbertura;
			this.dataFechamento = dataFechamento;
			this.idAnimal = idAnimal;
			this.idAtendenteAbriuFicha = idAteAbr;
			this.idAtendenteFechouFicha = idAteFec;
			this.statusFicha = status;
		}
		//Constructor para abertura de ficha
		public FichaDeAtendimento(Date dataAbertura, int idAnimal, int idAteAbr,  String status ) {
			this.dataAbertura = dataAbertura;
			this.idAnimal = idAnimal;
			this.idAtendenteAbriuFicha = idAteAbr;
			this.statusFicha = status;
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
		public String getStatusFicha() {
			return statusFicha;
		}
		public void setStatusFicha(String statusFicha) {
			this.statusFicha = statusFicha;
		}		
}

package iemev.models;

import java.util.Date;

public class FichaDeAtendimento {
		private int numeroFicha;
		private Date dataAbertura;
		private Date dataFechamento;
		private int idAgendamento;
		private int idAtendenteAbriuFicha;
		private int idAtendenteFechouFicha;
		private String statusFicha;
		
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
		public int getIdAgendamento() {
			return idAgendamento;
		}
		public void setIdAgendamento(int idAgendamento) {
			this.idAgendamento = idAgendamento;
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

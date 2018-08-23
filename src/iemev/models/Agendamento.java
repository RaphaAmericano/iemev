package iemev.models;

import java.util.Date;

public class Agendamento {
	private int idAgendamento;
	private Date dataAgendamento;
	private int idServicoAgendado;
	private int idAnimal;
	private int idAtendenteDeAgendamento;
	
	public int getIdAgendamento() {
		return idAgendamento;
	}
	public void setIdAgendamento(int idAgendamento) {
		this.idAgendamento = idAgendamento;
	}
	public Date getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	public int getIdServicoAgendado() {
		return idServicoAgendado;
	}
	public void setIdServicoAgendado(int idServicoAgendado) {
		this.idServicoAgendado = idServicoAgendado;
	}
	public int getIdAnimal() {
		return idAnimal;
	}
	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}
	public int getIdAtendenteDeAgendamento() {
		return idAtendenteDeAgendamento;
	}
	public void setIdAtendenteDeAgendamento(int idAtendenteDeAgendamento) {
		this.idAtendenteDeAgendamento = idAtendenteDeAgendamento;
	}
	
	
}

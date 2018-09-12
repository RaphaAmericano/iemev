package iemev.models;

import java.util.Date;

public class Agendamento {
	private int idAgendamento;
	private Date dataAgendamento;
	private int idServicoAgendado;
	private int idAnimal;
	private int idAtendenteDeAgendamento;
	
	public Agendamento() {
		super();
	}
	
	public Agendamento(int idAgendamento, Date data, int idSer, int idAnimal, int idAtend) {
		this.idAgendamento = idAgendamento;
		this.dataAgendamento = data;
		this.idServicoAgendado = idSer;
		this.idAnimal = idAnimal;
		this.idAtendenteDeAgendamento = idAtend;
	}
	
	public Agendamento(Date data, int idSer, int idAnimal, int idAtend) {
		this.dataAgendamento = data;
		this.idServicoAgendado = idSer;
		this.idAnimal = idAnimal;
		this.idAtendenteDeAgendamento = idAtend;
	}
	
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

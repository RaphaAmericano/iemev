package iemev.models;

import java.util.Date;

public class Internacao {
	private int idInternacao;
	private Date dataInternacao;
	private int numeroFicha;
	private int numeroBox;
	private int cpfVeterinario;
	
	public int getIdInternacao() {
		return idInternacao;
	}
	public void setIdInternacao(int idInternacao) {
		this.idInternacao = idInternacao;
	}
	public Date getDataInternacao() {
		return dataInternacao;
	}
	public void setDataInternacao(Date dataInternacao) {
		this.dataInternacao = dataInternacao;
	}
	public int getNumeroFicha() {
		return numeroFicha;
	}
	public void setNumeroFicha(int numeroFicha) {
		this.numeroFicha = numeroFicha;
	}
	public int getNumeroBox() {
		return numeroBox;
	}
	public void setNumeroBox(int numeroBox) {
		this.numeroBox = numeroBox;
	}
	public int getCpfVeterinario() {
		return cpfVeterinario;
	}
	public void setCpfVeterinario(int cpfVeterinario) {
		this.cpfVeterinario = cpfVeterinario;
	}
	
}

package iemev.models;

import java.util.Date;

public class Prescricao {
	private int idPrescricao;
	private int numeroFicha;
	private int cpfVeterinario;
	private int idServico;
	private Date dataPrescricaoServico;
	private int idEmpregadoDeOrdenacao;
	private Date dataFila;
	
	public int getIdPrescricao() {
		return idPrescricao;
	}
	public void setIdPrescricao(int idPrescricao) {
		this.idPrescricao = idPrescricao;
	}
	public int getNumeroFicha() {
		return numeroFicha;
	}
	public void setNumeroFicha(int numeroFicha) {
		this.numeroFicha = numeroFicha;
	}
	public int getCpfVeterinario() {
		return cpfVeterinario;
	}
	public void setCpfVeterinario(int cpfVeterinario) {
		this.cpfVeterinario = cpfVeterinario;
	}
	public int getIdServico() {
		return idServico;
	}
	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}
	public Date getDataPrescricaoServico() {
		return dataPrescricaoServico;
	}
	public void setDataPrescricaoServico(Date dataPrescricaoServico) {
		this.dataPrescricaoServico = dataPrescricaoServico;
	}
	public int getIdEmpregadoDeOrdenacao() {
		return idEmpregadoDeOrdenacao;
	}
	public void setIdEmpregadoDeOrdenacao(int idEmpregadoDeOrdenacao) {
		this.idEmpregadoDeOrdenacao = idEmpregadoDeOrdenacao;
	}
	public Date getDataFila() {
		return dataFila;
	}
	public void setDataFila(Date dataFila) {
		this.dataFila = dataFila;
	}
}

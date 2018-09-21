package iemev.models;

import java.util.Date;

public class Prescricao {
	private int idPrescricao;
	private int numeroFicha;
	private long cpfVeterinario;
	private int idServico;
	private Date dataPrescricaoServico;
	private int idEmpregadoDeOrdenacao;
	private Date dataFila;
	
	public Prescricao(){
		super();
	}
	
	public Prescricao(int id, int ficha, long cpf, int servico, Date data, int empregado) {
		this.idPrescricao = id;
		this.numeroFicha = ficha;
		this.cpfVeterinario = cpf;
		this.idServico = servico;
		this.dataPrescricaoServico = data;
		this.idEmpregadoDeOrdenacao = empregado;
	}
	
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
	public long getCpfVeterinario() {
		return cpfVeterinario;
	}
	public void setCpfVeterinario(long cpfVeterinario) {
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

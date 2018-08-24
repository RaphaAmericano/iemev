package iemev.models;

import java.util.Date;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//
//import javax.persistence.Table;

//@Entity
//@Table(name="T_PESSOA")
public class Pessoa {
	
//	@Id
//	@Column(name="cpf")
	private int cpf;
	
//	@Column(name="rg")
	private int rg;
	
//	@Column(name="nome")
	private String nome;
	
//	@Column(name="endereco")
	private String endereco;
	
//	@Column(name="telefoneResidencial")
	private String telefoneResidencial;
	
//	@Column(name="celular")
	private String celular;
	
//	@Column(name="dataDeNascimento")
	private Date dataDeNascimento;
	
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;	
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getRg() {
		return rg;
	}
	public void setRg(int rg) {
		this.rg = rg;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}
	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}	
}

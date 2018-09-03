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
	
	public Pessoa() {
		super();
	}
	
	public Pessoa(long cpf, long rg, String nome, String endereco, String telR, String cel, Date data ) {
		this.cpf = cpf;
		this.rg = rg;
		this.nome = nome;
		this.endereco = endereco;
		this.telefoneResidencial = telR;
		this.celular = cel;
		this.dataDeNascimento = data;
	}

	private long cpf;
	
	private long rg;
	
	private String nome;
	
	private String endereco;
	
	private String telefoneResidencial;
	
	private String celular;
	
	private Date dataDeNascimento;
	
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;	
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getRg() {
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

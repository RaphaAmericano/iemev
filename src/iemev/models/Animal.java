package iemev.models;

import java.util.Date;

public class Animal {
	private int idAnimal;
	private String nomeAnimal;
	private Character sexo;
	private Date dataDeNascimentoAnimal;
	private String especie;
	private String porte;
	private String raca;
	private String pelagem;
	private String temperamento;
	private long cpfCliente;
	private int idAtendimentoDeCadastramento;
	
	public Animal() {
		super();
	}
	
	public Animal(String nome, Character sexo, Date data, String especie, String porte, String raca, String pelagem, String temperamento, long cpf, int idatendente ) {
		
		this.nomeAnimal = nome;
		this.sexo = sexo;
		this.dataDeNascimentoAnimal = data;
		this.especie = especie;
		this.porte = porte;
		this.raca = raca;
		this.pelagem = pelagem;
		this.temperamento = temperamento;
		this.cpfCliente = cpf;
		this.idAtendimentoDeCadastramento = idatendente;
	}
	
	public int getIdAnimal() {
		return idAnimal;
	}
	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}
	public String getNomeAnimal() {
		return nomeAnimal;
	}
	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}
	public Character getSexo() {
		return sexo;
	}
	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}
	public Date getDataDeNascimentoAnimal() {
		return dataDeNascimentoAnimal;
	}
	public void setDataDeNascimentoAnimal(Date dataDeNascimentoAnimal) {
		this.dataDeNascimentoAnimal = dataDeNascimentoAnimal;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getPorte() {
		return porte;
	}
	public void setPorte(String porte) {
		this.porte = porte;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public String getPelagem() {
		return pelagem;
	}
	public void setPelagem(String pelagem) {
		this.pelagem = pelagem;
	}
	public String getTemperamento() {
		return temperamento;
	}
	public void setTemperamento(String temperamento) {
		this.temperamento = temperamento;
	}
	public long getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(long cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	public int getIdAtendimentoDeCadastramento() {
		return idAtendimentoDeCadastramento;
	}
	public void setIdAtendimentoDeCadastramento(int idAtendimentoDeCadastramento) {
		this.idAtendimentoDeCadastramento = idAtendimentoDeCadastramento;
	}
}

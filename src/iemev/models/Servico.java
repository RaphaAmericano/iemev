package iemev.models;

public class Servico {
	private int idServico;
	private String categoria;
	private String nomeServico;
	private double preco;
	private int idAdministradorDeCadastramento;
	
	public Servico() {
		super();
	}
	
	public Servico(int id, String cat, String nome, double preco, int idAdm) {
		this.idServico = id;
		this.categoria = cat;
		this.nomeServico = nome;
		this.preco = preco;
		this.idAdministradorDeCadastramento = idAdm;
	}
	
	public int getIdServico() {
		return idServico;
	}
	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getNomeServico() {
		return nomeServico;
	}
	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getIdAdministradorDeCadastramento() {
		return idAdministradorDeCadastramento;
	}
	public void setIdAdministradorDeCadastramento(int idAdministradorDeCadastramento) {
		this.idAdministradorDeCadastramento = idAdministradorDeCadastramento;
	}
	public double somarPreco() {
		return this.preco;
	}
}

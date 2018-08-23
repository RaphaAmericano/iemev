package iemev.models;

public class Servico {
	private int idServico;
	private String categoria;
	private String nomeServico;
	private double preco;
	private int idAdministradorDeCadastramento;
	
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
	
}

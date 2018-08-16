package model;

public class Cliente extends Pessoa {
	private String emailCliente;
	private int idAtendentDeCadastramento;
	
	public String getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	public int getIdAtendentDeCadastramento() {
		return idAtendentDeCadastramento;
	}
	public void setIdAtendentDeCadastramento(int idAtendentDeCadastramento) {
		this.idAtendentDeCadastramento = idAtendentDeCadastramento;
	}
}

package iemev.models;

import java.util.Date;

public class Cliente extends Pessoa {
	private String emailCliente;
	private int idAtendeneteDeCadastramento;
	
	public Cliente() {
		super();
	}
	
	public Cliente(long cpf, long rg, String nome, String endereco, String telR, String cel, Date data, String email, int idCadastramento) {
		super(cpf, rg, nome, endereco, telR, cel, data);
		this.emailCliente = email;
		this.idAtendeneteDeCadastramento = idCadastramento;
	}
	
	public String getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	public int getIdAtendentDeCadastramento() {
		return idAtendeneteDeCadastramento;
	}
	public void setIdAtendentDeCadastramento(int idAtendentDeCadastramento) {
		this.idAtendeneteDeCadastramento = idAtendentDeCadastramento;
	}
}
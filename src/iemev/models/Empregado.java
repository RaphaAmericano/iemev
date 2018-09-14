package iemev.models;

import java.util.Date;

public class Empregado extends Pessoa{
	private int idEmpregado;
	private Date dataDeAdmissaoEmpregado;
	private int ramal;
	private String emailEmpregado;
	private String senha;
	private boolean indicadorNovaSenha;
	private String tipoEmpregado;
	private int idAdministradoDeCadastramento;
	
	public int getIdEmpregado() {
		return idEmpregado;
	}
	public void setIdEmpregado(int idEmpregado) {
		this.idEmpregado = idEmpregado;
	}
	public Date getDataDeAdmissaoEmpregado() {
		return dataDeAdmissaoEmpregado;
	}
	public void setDataDeAdmissaoEmpregado(Date dataDeAdmissaoEmpregado) {
		this.dataDeAdmissaoEmpregado = dataDeAdmissaoEmpregado;
	}
	public int getRamal() {
		return ramal;
	}
	public void setRamal(int ramal) {
		this.ramal = ramal;
	}
	public String getEmailEmpregado() {
		return emailEmpregado;
	}
	public void setEmailEmpregado(String emailEmpregado) {
		this.emailEmpregado = emailEmpregado;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isIndicadorNovaSenha() {
		return indicadorNovaSenha;
	}
	public void setIndicadorNovaSenha(boolean indicadorNovaSenha) {
		this.indicadorNovaSenha = indicadorNovaSenha;
	}
	public String getTipoEmpregado() {
		return tipoEmpregado;
	}
	public void setTipoEmpregado(String tipoEmpregado) {
		this.tipoEmpregado = tipoEmpregado;
	}
	public int getIdAdministradoDeCadastramento() {
		return idAdministradoDeCadastramento;
	}
	public void setIdAdministradoDeCadastramento(int idAdministradoDeCadastramento) {
		this.idAdministradoDeCadastramento = idAdministradoDeCadastramento;
	}
	
	
}
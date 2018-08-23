package iemev.models;

public class Veterinario extends Empregado{
	private int crmv;
	private String especialidade;
	
	public int getCrmv() {
		return crmv;
	}
	public void setCrmv(int crmv) {
		this.crmv = crmv;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
}

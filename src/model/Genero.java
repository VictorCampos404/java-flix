package model;

public class Genero {
	private int idG;
	private String nomeG;
	
	public Genero() {
	}
	
	public Genero(int idG, String nomeG) {
		this.idG = idG;
		this.nomeG = nomeG;
	}

	public int getIdG() {
		return idG;
	}

	public void setIdG(int idG) {
		this.idG = idG;
	}

	public String getNomeG() {
		return nomeG;
	}

	public void setNomeG(String nomeG) {
		this.nomeG = nomeG;
	}
}

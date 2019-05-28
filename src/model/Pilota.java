package model;

public class Pilota {
	
	public String matricola;
	public String nome;
	public String cognome;
	public int eta;
	
	public Pilota(String matricola, String nome, String cognome, int eta) {
		super();
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}
	
	
	

}

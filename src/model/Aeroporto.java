package model;

public class Aeroporto {
	
	public String codice_iata;
	public String nomeCommerciale;
	public String comune;
	public String tipoUtilizzo;
	
	
	public Aeroporto(String codice_iata, String nomeCommerciale, String comune, String tipoUtilizzo) {
		super();
		this.codice_iata = codice_iata;
		this.nomeCommerciale = nomeCommerciale;
		this.comune = comune;
		this.tipoUtilizzo = tipoUtilizzo;
	}


	public String getCodice_iata() {
		return codice_iata;
	}


	public void setCodice_iata(String codice_iata) {
		this.codice_iata = codice_iata;
	}


	public String getNomeCommerciale() {
		return nomeCommerciale;
	}


	public void setNomeCommerciale(String nomeCommerciale) {
		this.nomeCommerciale = nomeCommerciale;
	}


	public String getComune() {
		return comune;
	}


	public void setComune(String comune) {
		this.comune = comune;
	}


	public String getTipoUtilizzo() {
		return tipoUtilizzo;
	}


	public void setTipoUtilizzo(String tipoUtilizzo) {
		this.tipoUtilizzo = tipoUtilizzo;
	}
	
	
	
	


}

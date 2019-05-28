package model;

public class Aeromobile {
	
	public String matricolaAereo;
	public String modello;
	public String annoAcquisto;
	
	public Aeromobile(String matricolaAereo, String modello, String annoAcquisto) {
		super();
		this.matricolaAereo = matricolaAereo;
		this.modello = modello;
		this.annoAcquisto = annoAcquisto;
	}

	public String getMatricolaAereo() {
		return matricolaAereo;
	}

	public void setMatricolaAereo(String matricolaAereo) {
		this.matricolaAereo = matricolaAereo;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getAnnoAcquisto() {
		return annoAcquisto;
	}

	public void setAnnoAcquisto(String annoAcquisto) {
		this.annoAcquisto = annoAcquisto;
	}
	
	

}

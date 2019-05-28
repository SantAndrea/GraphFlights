package model;

public class Volo {
	
	public int id;
	public String orarioPartenza;
	public String orarioArrivo;
	public String data; //Da decidere se vogliamo gestire la data come Stringa oppure oggetto Data
	public String aeroportoPartenza;
	public String aeroportoArrivo;
	public String aeromobileId; //aeromobile_volo nel csv
	public String idPilota;
	
	
	public Volo(int id, String orarioPartenza, String orarioArrivo, String data, String aeroportoPartenza,
			String aeroportoArrivo, String aeromobileId, String idPilota) {
		super();
		this.id = id;
		this.orarioPartenza = orarioPartenza;
		this.orarioArrivo = orarioArrivo;
		this.data = data;
		this.aeroportoPartenza = aeroportoPartenza;
		this.aeroportoArrivo = aeroportoArrivo;
		this.aeromobileId = aeromobileId;
		this.idPilota = idPilota;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getOrarioPartenza() {
		return orarioPartenza;
	}


	public void setOrarioPartenza(String orarioPartenza) {
		this.orarioPartenza = orarioPartenza;
	}


	public String getOrarioArrivo() {
		return orarioArrivo;
	}


	public void setOrarioArrivo(String orarioArrivo) {
		this.orarioArrivo = orarioArrivo;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public String getAeroportoPartenza() {
		return aeroportoPartenza;
	}


	public void setAeroportoPartenza(String aeroportoPartenza) {
		this.aeroportoPartenza = aeroportoPartenza;
	}


	public String getAeroportoArrivo() {
		return aeroportoArrivo;
	}


	public void setAeroportoArrivo(String aeroportoArrivo) {
		this.aeroportoArrivo = aeroportoArrivo;
	}


	public String getAeromobileId() {
		return aeromobileId;
	}


	public void setAeromobileId(String aeromobileId) {
		this.aeromobileId = aeromobileId;
	}


	public String getIdPilota() {
		return idPilota;
	}


	public void setIdPilota(String idPilota) {
		this.idPilota = idPilota;
	}
	
	
	
	
	


}

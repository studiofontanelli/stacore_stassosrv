package it.csi.stacore.stassosrv.business.dto;

import java.io.Serializable;

public class AutorizzazioneDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1579039772551063181L;

	private String codice = null;
	private String descrizione = null;


	public AutorizzazioneDto() {

	}
	public AutorizzazioneDto(String codice) {
		this.codice = codice;
	}

	public AutorizzazioneDto(String codice, String descrizione) {
		this.codice = codice;
		this.descrizione = descrizione;
	}

	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


}

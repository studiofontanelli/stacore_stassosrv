package it.csi.stacore.stassosrv.business.dto;

import java.io.Serializable;

public class TipoUtenteDto implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2242035087509651838L;
	
	private String codice = null;
	private String descrizione = null;
	
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

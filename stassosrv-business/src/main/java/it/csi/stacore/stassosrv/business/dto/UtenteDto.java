package it.csi.stacore.stassosrv.business.dto;

import java.io.Serializable;

public class UtenteDto implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id = null;
	private String nome = null;
	private String cognome = null;
	private String codiceFiscale = null;
	
	private TipoUtenteDto tipoUtente = null;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TipoUtenteDto getTipoUtente() {
		return tipoUtente;
	}
	public void setTipoUtente(TipoUtenteDto tipoUtente) {
		this.tipoUtente = tipoUtente;
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
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	
	
	
	
	

}

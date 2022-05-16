/*
 * Created on 18-lug-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package it.csi.stacore.stassosrv.integration.bo.utente;

import java.io.Serializable;

import it.csi.stacore.stassosrv.integration.util.EqualsUtil;

/**
 * @author fguglielmelli
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Cassa implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = -6266722972161264281L;
	/**
	 * @uml.property  name="idCassa"
	 */
	private Long idCassa;
	/**
	 * @uml.property  name="denominazione"
	 */
	private String denominazione;
	/**
	 * @uml.property  name="codice"
	 */
	private String codice;
	/**
	 * @uml.property  name="descrizione"
	 */
	private String descrizione;

	/**
	 * @uml.property  name="idSportello"
	 */
	private Long idSportello = null;

	private String idUtente;


	public Cassa() {
	}


	/**
	 * @param idCassa
	 * @param denominazione
	 * @param codice
	 * @param descrizione
	 */
	public Cassa(Long idCassa, String denominazione, String codice,	String descrizione) {
		this.idCassa = idCassa;
		this.denominazione = denominazione;
		this.codice = codice;
		this.descrizione = descrizione;
	}

	/**
	 * @param idCassa
	 * @param denominazione
	 * @param codice
	 * @param descrizione
	 * @param sportello
	 */
	public Cassa(Long idCassa, String denominazione, String codice,
			String descrizione, Long idSportello) {
		super();
		this.idCassa = idCassa;
		this.denominazione = denominazione;
		this.codice = codice;
		this.descrizione = descrizione;
		this.idSportello = idSportello;
	}

	/**
	 * @return  Returns the codice.
	 * @uml.property  name="codice"
	 */
	public String getCodice() {
		return codice;
	}
	/**
	 * @return  Returns the denominazione.
	 * @uml.property  name="denominazione"
	 */
	public String getDenominazione() {
		return denominazione;
	}
	/**
	 * @return  Returns the descrizione.
	 * @uml.property  name="descrizione"
	 */
	public String getDescrizione() {
		return descrizione;
	}
	/**
	 * @return  Returns the idCassa.
	 * @uml.property  name="idCassa"
	 */
	public Long getIdCassa() {
		return idCassa;
	}

	/**
	 * @return  Returns the idSportello.
	 * @uml.property  name="idSportello"
	 */
	public Long getIdSportello() {
		return idSportello;
	}



	public boolean equals(Object arg0) {
		boolean result=false;
		if (arg0 instanceof Cassa) {
			Cassa altraCassa=(Cassa) arg0;
			result=EqualsUtil.objectEquals(altraCassa.idCassa, this.idCassa);
		}
		return result;
	}
	public int hashCode() {
		if (idCassa==null) {
			return 0;
		} else {
			return idCassa.hashCode();
		}
	}

	public String getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
	}


	public void setIdCassa(Long idCassa) {
		this.idCassa = idCassa;
	}


	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}


	public void setCodice(String codice) {
		this.codice = codice;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public void setIdSportello(Long idSportello) {
		this.idSportello = idSportello;
	}
}

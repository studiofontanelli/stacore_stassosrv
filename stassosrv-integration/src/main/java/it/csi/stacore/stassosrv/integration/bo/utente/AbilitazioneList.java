/*
 * Created on 26-lug-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package it.csi.stacore.stassosrv.integration.bo.utente;

import java.io.Serializable;

public class AbilitazioneList  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3052167515368265020L;

	/**
	 * @uml.property  name="idPostazione"
	 */
	Long idPostazione =null;

	/**
	 * @uml.property  name="idEnte"
	 */
	Long idEnte;

	/**
	 * @uml.property  name="idSportello"
	 */
	Long idSportello;

	/**
	 * @uml.property  name="idCassa"
	 */
	Long idCassa;

	/**
	 * @return  Returns the idCassa.
	 * @uml.property  name="idCassa"
	 */
	public Long getIdCassa() {
		return idCassa;
	}
	/**
	 * @return  Returns the idEnte.
	 * @uml.property  name="idEnte"
	 */
	public Long getIdEnte() {
		return idEnte;
	}
	/**
	 * @return  Returns the idPostazione.
	 * @uml.property  name="idPostazione"
	 */
	public Long getIdPostazione() {
		return idPostazione;
	}
	/**
	 * @return  Returns the idSportello.
	 * @uml.property  name="idSportello"
	 */
	public Long getIdSportello() {
		return idSportello;
	}
	/**
	 * @param idPostazione
	 * @param idEnte
	 * @param idSportello
	 * @param idCassa
	 */
	public AbilitazioneList(Long idPostazione, Long idEnte, Long idSportello,
			Long idCassa) {
		super();
		this.idPostazione = idPostazione;
		this.idEnte = idEnte;
		this.idSportello = idSportello;
		this.idCassa = idCassa;
	}
}

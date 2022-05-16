package it.csi.stacore.stassosrv.integration.bo.utente;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import it.csi.stacore.stassosrv.integration.bo.Decodifica;
import it.csi.stacore.stassosrv.integration.bo.utente.id.IdDecodifica;

public class Ente extends Decodifica implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = -3550635240884211683L;
	/**
	 * @uml.property  name="email"
	 */
	private String email;
	/**
	 * @uml.property  name="indirizzo"
	 */
	private String indirizzo;
	/**
	 * @uml.property  name="civico"
	 */
	private String civico;
	/**
	 * @uml.property  name="cap"
	 */
	private Integer cap;
	/**
	 * @uml.property  name="comune"
	 */
	private String comune;
	/**
	 * @uml.property  name="codiceFiscale"
	 */
	private String codiceFiscale;
	/**
	 * @uml.property  name="provincia"
	 */
	private String provincia;
	/**
	 * @uml.property  name="siglaTop"
	 */
	private String siglaTop;
	/**
	 * @uml.property  name="dataInizioAttivita"
	 */
	private Date dataInizioAttivita;

	/**
	 * @associates    <{it.csi.stacore.staon.business.bo.utente.Sportello}>
	 * @directed    directed
	 * @supplierCardinality    0..*
	 * @uml.property  name="sportello"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="it.csi.stacore.staon.business.bo.utente.Sportello"
	 */
	private List sportello;

	private Boolean abilitazioneRiscossione;


	/**
	 * @param idEnte
	 */
	public Ente(IdDecodifica idEnte) {
		super(idEnte, "", "");
	}

	public Ente(Long idEnte) {
	    //IdDecodifica id = new IdDecodifica(idEnte.longValue());
		super(new IdDecodifica(idEnte.longValue()), "", "");
	}


	/**
	 * @param idEnte
	 * @param email
	 * @param indirizzo
	 * @param civico
	 * @param cap
	 * @param comune
	 * @param codiceFiscale
	 * @param provincia
	 * @param siglaTop
	 * @param codice
	 * @param descrizione
	 * @param dataInizioAttivita
	 * @param abilitazioneRiscossione
	 */
	public Ente(Long idEnte,
	            String email,
	            String indirizzo,
	            String civico,
			    Integer cap,
			    String comune,
			    String codiceFiscale,
			    String provincia,
			    String siglaTop,
			    String codice,
			    String descrizione,
			    Date dataInizioAttivita,
			    Boolean abilitazioneRiscossione) {

		super(new IdDecodifica(idEnte.longValue()), codice, descrizione);
		this.email = email;
		this.indirizzo = indirizzo;
		this.civico = civico;
		this.cap = cap;
		this.comune = comune;
		this.codiceFiscale = codiceFiscale;
		this.provincia = provincia;
		this.siglaTop = siglaTop;
		this.dataInizioAttivita = dataInizioAttivita;
		this.abilitazioneRiscossione = abilitazioneRiscossione;
	}

	/**
	 * @param sportello  The sportello to set.
	 * @uml.property  name="sportello"
	 */
	public void setSportello(List sportello) {
		this.sportello = sportello;
	}
	/**
	 * @return  Returns the cap.
	 * @uml.property  name="cap"
	 */
	public Integer getCap() {
		return cap;
	}
	/**
	 * @return  Returns the civico.
	 * @uml.property  name="civico"
	 */
	public String getCivico() {
		return civico;
	}
	/**
	 * @return  Returns the codiceFiscale.
	 * @uml.property  name="codiceFiscale"
	 */
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	/**
	 * @return  Returns the comune.
	 * @uml.property  name="comune"
	 */
	public String getComune() {
		return comune;
	}
	/**
	 * @return  Returns the dataInizioAttivita.
	 * @uml.property  name="dataInizioAttivita"
	 */
	public Date getDataInizioAttivita() {
		return dataInizioAttivita;
	}
	/**
	 * @return  Returns the email.
	 * @uml.property  name="email"
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @return  Returns the indirizzo.
	 * @uml.property  name="indirizzo"
	 */
	public String getIndirizzo() {
		return indirizzo;
	}
	/**
	 * @return  Returns the provincia.
	 * @uml.property  name="provincia"
	 */
	public String getProvincia() {
		return provincia;
	}
	/**
	 * @return  Returns the siglaTop.
	 * @uml.property  name="siglaTop"
	 */
	public String getSiglaTop() {
		return siglaTop;
	}
	/**
	 * @return  Returns the sportello.
	 * @uml.property  name="sportello"
	 */
	public List getSportello() {
		return sportello;
	}
	/**
	 * @return  Returns the abilitazioneRiscossione.
	 * @uml.property  name="abilitazioneRiscossione"
	 */
	public Boolean getAbilitazioneRiscossione() {
		return abilitazioneRiscossione;
	}


	public Sportello getSportelloByCassa(Cassa cassa) {
	  Sportello result=null;

	  List sportelloList=getSportello();
	  for (Iterator iter = sportelloList.iterator(); iter.hasNext();) {
	    Sportello sportello = (Sportello) iter.next();

	    if (sportello.getId().getId() == cassa.getIdSportello().longValue()) {
	      result=sportello;
	    }
	  }

	  return result;
	}


	public boolean equals(Object obj) {

	    boolean result = false;

	    if (obj instanceof Ente) {
	        Ente objEnte = (Ente)obj;
	        if (this.getId().equals(objEnte.getId())) result = true;
	    }

	    return result;
	}


}

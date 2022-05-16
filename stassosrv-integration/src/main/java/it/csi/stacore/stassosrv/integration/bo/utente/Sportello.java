package it.csi.stacore.stassosrv.integration.bo.utente;

import java.io.Serializable;
import java.util.List;

import it.csi.stacore.stassosrv.integration.bo.Decodifica;
import it.csi.stacore.stassosrv.integration.bo.utente.id.IdDecodifica;

/**
 * @author fguglielmelli
 */
public class Sportello extends Decodifica implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = -9124747226072316944L;
	/**
	 * @uml.property  name="idEnte"
	 */
	private Long idEnte;
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
	 * @uml.property  name="provincia"
	 */
	private String provincia;

	private String codmctc;

	/**
	 * @associates    <{it.csi.stacore.staon.business.bo.utente.Cassa}>
	 * @directed    directed
	 * @supplierCardinality    0..*
	 * @uml.property  name="cassaList"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="it.csi.stacore.staon.business.bo.utente.Cassa"
	 */
	List cassaList = null;


	public Sportello(Long sportello) {
		super(new IdDecodifica(sportello.longValue()), "", "");
	}

	/**
	 * @param idSportello
	 * @param email
	 * @param indirizzo
	 * @param civico
	 * @param cap
	 * @param comune
	 * @param provincia
	 * @param codice
	 * @param descrizione
	 * @param cassa
	 */
	public Sportello(Long sportello,
	                 String email,
	                 String indirizzo,
			         String civico,
			         Integer cap,
			         String comune,
			         String provincia,
			         String codice,
			         String descrizione,
			         List cassaList) {

		super(new IdDecodifica(sportello.longValue()), codice, descrizione);

		//this.idSportello = idSportello;
		//this.codice = codice;
		//this.descrizione = descrizione;

		this.email = email;
		this.indirizzo = indirizzo;
		this.civico = civico;
		this.cap = cap;
		this.comune = comune;
		this.provincia = provincia;
		this.cassaList = cassaList;
	}

	/**
	 * Questo metodo restituisce la Struttura COMPLETA di un ente
	 * @param enteid
	 * @return Ente
	 * @throws IntegrationException
	 * @throws ApplicationException
	 * @throws java.rmi.RemoteException
	 */
	public Sportello(Long sportello,
			         Long idEnte,
			         String email,
			         String indirizzo,
					 String civico,
					 Integer cap,
					 String comune,
					 String provincia,
					 String codice,
					 String descrizione) {

		super(new IdDecodifica(sportello.longValue()), codice, descrizione);

		this.idEnte = idEnte;
		this.email = email;
		this.indirizzo = indirizzo;
		this.civico = civico;
		this.cap = cap;
		this.comune = comune;
		this.provincia = provincia;
	}


	/**
	 * @return  Returns the cap.
	 * @uml.property  name="cap"
	 */
	public Integer getCap() {
		return cap;
	}
	/**
	 * @return  Returns the cassaList.
	 * @uml.property  name="cassaList"
	 */
	public List getCassaList() {
		return cassaList;
	}
	/**
	 * @return  Returns the civico.
	 * @uml.property  name="civico"
	 */
	public String getCivico() {
		return civico;
	}

	/**
	 * @return  Returns the comune.
	 * @uml.property  name="comune"
	 */
	public String getComune() {
		return comune;
	}

	/**
	 * @return  Returns the email.
	 * @uml.property  name="email"
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return  Returns the idEnte.
	 * @uml.property  name="idEnte"
	 */
	public Long getIdEnte() {
		return idEnte;
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
	 * @param cassaList  The cassaList to set.
	 * @uml.property  name="cassaList"
	 */
	public void setCassaList(List cassaList) {
	    this.cassaList=cassaList;
	}

	public boolean equals(Object obj) {

	    boolean result = false;

	    if (getId()!=null) {
		    if (obj instanceof Sportello) {
		        Sportello sportello = (Sportello)obj;
		        if (getId().equals(sportello.getId())) result = true;
		    }
		}

	    return result;
	}



	  public int hashCode() {
	    if (getId()==null) {
	      return 0;
	    } else {
	      return getId().hashCode();
	    }
	  }

	public String getCodmctc() {
		return codmctc;
	}

	public void setCodmctc(String codmctc) {
		this.codmctc = codmctc;
	}
}

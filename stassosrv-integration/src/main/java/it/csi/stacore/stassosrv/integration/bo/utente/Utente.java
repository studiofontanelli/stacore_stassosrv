/*
 * Created on 3-gen-2005
 *
 */
package it.csi.stacore.stassosrv.integration.bo.utente;

import java.io.Serializable;


import it.csi.stacore.stassosrv.integration.util.EqualsUtil;

/**
 * DOCUMENT ME!
 *
 * @author curtoni
 */
public class Utente  implements Serializable {
	//~ Static fields/initializers ===============================================

	/**
	 * DOCUMENT ME!
	 */
	static final long serialVersionUID = -9221380548617840824L;

	//~ Instance fields ==========================================================
	/**
	 * @uml.property  name="idUtente"
	 */
	private final String idUtente;

	/**
	 * @uml.property  name="ente"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Ente ente;

	/**
	 * @associates    <{it.csi.stacore.staon.business.bo.utente.TipoUtente}>
	 * @directed    directed
	 * @supplierCardinality    0..*
	 * @uml.property  name="tipoUtente"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */

	private final TipoUtente tipoUtente;

	/**
	 * @associates    <{it.csi.stacore.staon.business.bo.utente.Abilitazione}>
	 * @directed    directed
	 * @supplierCardinality    0..*
	 * @uml.property  name="abilitazione"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Abilitazione abilitazione;

	/**
	 * @uml.property  name="profilo"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Profilo profilo;

	/**
	 * @uml.property  name="descrizione"
	 */
	private final String descrizione;

	/**
	 * @uml.property  name="identitaIrideString"
	 */
	private final String identitaIrideString;

	/**
	 * @uml.property  name="cognome"
	 */
	private final String cognome;

	/**
	 * @uml.property  name="nome"
	 */
	private final String nome;

	private boolean abilitazionePagamentoManuale = false;

	private final static String OPERATORE_SPORTELLO_REGIONALE = "00";
	
	private final static String ASSISTENZA_CSI = "07";

	//~ Constructors =============================================================

	/**
	 * DOCUMENT ME!
	 * @param cognome TODO
	 * @param nome TODO
	 * @param ente
	 * @param profilo DOCUMENT ME!
	 * @param nome
	 * @param cognome
	 * @param codiceFiscale
	 */
	public Utente(String idUtente, String cognome, String nome, TipoUtente tipoUtente, Ente ente, String descrizione, Abilitazione abilitazione,
			Profilo profilo, String identitaIrideString, String pagamentoManuale) {
		super();
		this.idUtente = idUtente;
		this.tipoUtente = tipoUtente;
		this.ente = ente;
		this.abilitazione = abilitazione;
		this.profilo = profilo;
		this.descrizione = descrizione;
		this.cognome = cognome;
		this.nome = nome;
		this.identitaIrideString = identitaIrideString;
		if ("S".equals(pagamentoManuale)) {
			abilitazionePagamentoManuale = true;
		}
	}

	/**
	 * DOCUMENT ME!
	 * @return  Returns the idUtente.
	 * @uml.property  name="idUtente"
	 */
	public String getIdUtente() {
		return idUtente;
	}

	/**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="profilo"
	 */
	public Profilo getProfilo() {
		return profilo;
	}

	/**
	 * @return  Returns the tipoUtente.
	 * @uml.property  name="tipoUtente"
	 */
	public TipoUtente getTipoUtente() {
		return tipoUtente;
	}

	/**
	 * @return  Returns the abilitazione.
	 * @uml.property  name="abilitazione"
	 */
	public Abilitazione getAbilitazione() {
		return abilitazione;
	}

	/**
	 * @param abilitazione  The abilitazione to set.
	 * @uml.property  name="abilitazione"
	 */
	public void setAbilitazione(Abilitazione abilitazione) {
		this.abilitazione = abilitazione;
	}

	/**
	 * @param ente  The ente to set.
	 * @uml.property  name="ente"
	 */
	public void setEnte(Ente ente) {
		this.ente = ente;
	}

	/**
	 * @param profilo  The profilo to set.
	 * @uml.property  name="profilo"
	 */
	public void setProfilo(Profilo profilo) {
		this.profilo = profilo;
	}

	/**
	 * @return  Returns the descrizione.
	 * @uml.property  name="descrizione"
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * @return  Returns the nome.
	 * @uml.property  name="nome"
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return  Returns the cognome.
	 * @uml.property  name="cognome"
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * @return  Returns the identitaIride.
	 * @uml.property  name="identitaIrideString"
	 */
	public String getIdentitaIrideString() {
		return identitaIrideString;
	}

	/**
	 * @return  Returns the ente.
	 * @uml.property  name="ente"
	 */
	public Ente getEnte() {
		return ente;
	}

	public boolean hasAbilitazionePagamentoManuale() {
		return abilitazionePagamentoManuale;
	}
	
	public boolean isAmministratore(){
		String codiceEnte = ente.getCodice();
		return OPERATORE_SPORTELLO_REGIONALE.equals(codiceEnte) || ASSISTENZA_CSI.equals(codiceEnte);
	}

	public boolean isUtenteBatch(){
		return TipoUtente.TIPO_UTENTE_BATCH.equals(tipoUtente);
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param object DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean equals(Object object) {
		boolean equals = false;

		if ((object != null) && object instanceof Utente) {
			Utente altro = (Utente) object;
			equals = EqualsUtil.objectEquals(getIdUtente(), altro.getIdUtente());
		}

		return equals;
	}

}

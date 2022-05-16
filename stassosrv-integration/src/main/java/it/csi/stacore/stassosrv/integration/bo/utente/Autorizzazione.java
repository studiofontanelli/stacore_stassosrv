/*
 * Created on 24-mag-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package it.csi.stacore.stassosrv.integration.bo.utente;

import java.io.Serializable;


/**
 * DOCUMENT ME!
 *
 * @author curtoni TODO To change the template for this generated type comment
 *         go to Window - Preferences - Java - Code Style - Code Templates
 */
public class Autorizzazione implements Serializable {
  //~ Instance fields ==========================================================

  /**
	 * 
	 */
	private static final long serialVersionUID = -8683827019515393597L;
/**
	 * @uml.property  name="codice"
	 */
  private final String codice;
  /**
	 * @uml.property  name="descrizione"
	 */
  private final String descrizione;

  //~ Constructors =============================================================

  /**
   * Creates a new Abilitazione object.
   *
   * @param codice DOCUMENT ME!
   */
  public Autorizzazione(String codice) {
    this.codice        = codice;
    this.descrizione   = null;
  }

  /**
   * Creates a new Abilitazione object.
   *
   * @param codice DOCUMENT ME!
   * @param descrizione DOCUMENT ME!
   */
  public Autorizzazione(String codice, String descrizione) {
    this.codice        = codice;
    this.descrizione   = descrizione;
  }

  //~ Methods ==================================================================

  /**
	 * DOCUMENT ME!
	 * @return  Returns the codice.
	 * @uml.property  name="codice"
	 */
  public String getCodice() {
    return codice;
  }

  /**
	 * DOCUMENT ME!
	 * @return  Returns the descrizione.
	 * @uml.property  name="descrizione"
	 */
  public String getDescrizione() {
    return descrizione;
  }
}

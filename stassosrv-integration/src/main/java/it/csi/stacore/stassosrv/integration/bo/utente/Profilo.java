/*
 * Created on 9-feb-2005
 *
 */
package it.csi.stacore.stassosrv.integration.bo.utente;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * DOCUMENT ME!
 *
 * @author curtoni
 */
public class Profilo  implements Serializable {
  //~ Instance fields ==========================================================

  /**
	 *
	 */
	private static final long serialVersionUID = -7021828978801936674L;

/**
	 * DOCUMENT ME!
	 * @uml.property  name="mapAbilitazioni"
	 * @uml.associationEnd  qualifier="codiceAbilitazione:java.lang.String it.csi.stacore.staon.business.bo.utente.Autorizzazione"
	 */
  final Map mapAbilitazioni;

  /**
	 * @uml.property  name="abilitazioni"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
  private Autorizzazione[] abilitazioni = null;

  //~ Constructors =============================================================

  /**
   * Creates a new Profilo object.
   */
  public Profilo() {
    mapAbilitazioni = new HashMap();
  }

  /**
   * Creates a new Profilo object.
   *
   * @param abilitazioni DOCUMENT ME!
   */
  public Profilo(Autorizzazione[] arrayAbilitazioni) {

    this.abilitazioni=arrayAbilitazioni;
    mapAbilitazioni = new HashMap();

    for(int i = 0; i < abilitazioni.length; i++) {
      Autorizzazione abilitazione = abilitazioni[i];
      mapAbilitazioni.put(abilitazione.getCodice(), abilitazione);
    }
  }

  //~ Methods ==================================================================

  /**
   * DOCUMENT ME!
   *
   * @param codiceAbilitazione DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isAbilitatoPer(String codiceAbilitazione) {
    boolean result = false;

    if(mapAbilitazioni.containsKey(codiceAbilitazione)) {
      result = true;
    }

    return result;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public List getAbilitazioniList() {
    return new ArrayList(mapAbilitazioni.values());
  }

  public Autorizzazione[] getAbilitazioniOrderedList() {
      return abilitazioni;
  }

}

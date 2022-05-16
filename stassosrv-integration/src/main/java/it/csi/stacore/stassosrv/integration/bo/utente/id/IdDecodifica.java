package it.csi.stacore.stassosrv.integration.bo.utente.id;

/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class IdDecodifica extends LongId implements java.io.Serializable {
  //~ Constructors =============================================================

  /**
	 * 
	 */
	private static final long serialVersionUID = -89240917603442835L;

/**
   * Creates a new IdDecodifica object.
   *
   * @param id DOCUMENT ME!
   */
  public IdDecodifica(long id) {
    super(id);
  }

  //~ Methods ==================================================================

  /**
   * DOCUMENT ME!
   *
   * @param object DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean equals(Object object) {
    boolean equals = false;

    if((object != null) && object instanceof IdDecodifica) {
      IdDecodifica altro = (IdDecodifica) object;
      equals = (this.getId() == altro.getId());
    }

    return equals;
  }
}

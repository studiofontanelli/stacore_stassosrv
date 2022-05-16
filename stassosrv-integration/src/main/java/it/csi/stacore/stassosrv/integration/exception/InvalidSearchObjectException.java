package it.csi.stacore.stassosrv.integration.exception;

/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class InvalidSearchObjectException extends ResourceAccessException {
  //~ Constructors =============================================================

  /**
	 *
	 */
	private static final long serialVersionUID = -8252137390714833788L;

/**
   * Creates a new InvalidSearchObjectException object.
   *
   * @param string DOCUMENT ME!
   * @param cause DOCUMENT ME!
   */
  protected InvalidSearchObjectException(String string, Throwable cause) {
    super(string, cause);
  }

  /**
   * Creates a new InvalidSearchObjectException object.
   *
   * @param string DOCUMENT ME!
   */
  public InvalidSearchObjectException(String string) {
    super(string, null);
  }
}

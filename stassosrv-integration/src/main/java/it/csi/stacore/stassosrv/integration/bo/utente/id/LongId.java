package it.csi.stacore.stassosrv.integration.bo.utente.id;

import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public abstract class LongId implements java.io.Serializable {
	//~ Instance fields ==========================================================

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="id"
	 */
	private final long id;

	//~ Constructors =============================================================

	/**
	 * Creates a new LongId object.
	 *
	 * @param id DOCUMENT ME!
	 */
	public LongId(final long id) {
		this.id = id;
	}

	//~ Methods ==================================================================

	/**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="id"
	 */
	public long getId() {
		return id;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param object DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public abstract boolean equals(Object object);

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(id).toHashCode();
	}

	public String toString() {
		return "" + getId();
	}
}

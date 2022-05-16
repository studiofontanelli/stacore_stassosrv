package it.csi.stacore.stassosrv.integration.bo;


import java.lang.reflect.Field;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import it.csi.stacore.stassosrv.integration.bo.utente.id.IdDecodifica;


/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public abstract class Decodifica implements java.io.Serializable, Comparable {
	//~ Instance fields ==========================================================

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @uml.property  name="idDecodifica"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private IdDecodifica idDecodifica;
	/**
	 * @uml.property  name="descrizione"
	 */
	private String       descrizione;
	/**
	 * @uml.property  name="codice"
	 */
	private String       codice;

	//~ Constructors =============================================================

	/**
	 * Creates a new Decodifica object.
	 *
	 * @param id DOCUMENT ME!
	 * @param descrizione DOCUMENT ME!
	 */
	public Decodifica(IdDecodifica id, String descrizione) {
		if(id == null) {
			throw new IllegalArgumentException("id non pu� essere nullo");
		}

		if(descrizione == null) {
			throw new IllegalArgumentException("descrizione non pu� essere nullo");
		}

		this.idDecodifica   = id;
		this.descrizione    = descrizione;
	}

	/**
	 * Creates a new Decodifica object.
	 *
	 * @param id DOCUMENT ME!
	 * @param codice DOCUMENT ME!
	 * @param descrizione DOCUMENT ME!
	 */
	public Decodifica(IdDecodifica id, String codice, String descrizione) {
		if(id == null) {
			throw new IllegalArgumentException("id non pu� essere nullo");
		}

		if(codice == null) {
			throw new IllegalArgumentException("codice non pu� essere nullo");
		}

		if(descrizione == null) {
			throw new IllegalArgumentException("descrizione non pu� essere nullo");
		}

		this.idDecodifica   = id;
		this.codice         = codice;
		this.descrizione    = descrizione;
	}

	//~ Methods ==================================================================

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public IdDecodifica getId() {
		return idDecodifica;
	}

	/**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="descrizione"
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="codice"
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * Ogni discendente dell'oggetto Decodifica deve ridefinire il metodo equals
	 *
	 * @param object 
	 *
	 * @return 
	 */
	public abstract boolean equals(Object object);

	/**
	 * 
	 *
	 * @return 
	 */
	public int hashCode(){
		return HashCodeBuilder.reflectionHashCode(this);
	}


	/**
	 * DOCUMENT ME!
	 *
	 * @param obj DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public int compareTo(Object obj) {
		Decodifica altraDecodifica = (Decodifica) obj;

		return (int) (this.getId().getId() - altraDecodifica.getId().getId());
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static boolean isCodiceValido(Decodifica tipo) throws IllegalArgumentException, IllegalAccessException {
		boolean result = false;
		Field[] fields = tipo.getClass().getDeclaredFields();

		for(int i=0; i<fields.length;i++){
			Field f = fields[i];
			if(f.getName().startsWith("CODICE_")){
				f.setAccessible(true);

				if(f.get(tipo).equals(tipo.getCodice())){
					result = true;
					break;
				}
			}
		}
		return result;
	}


	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public String toString() {
		return ReflectionToStringBuilder.toString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
}

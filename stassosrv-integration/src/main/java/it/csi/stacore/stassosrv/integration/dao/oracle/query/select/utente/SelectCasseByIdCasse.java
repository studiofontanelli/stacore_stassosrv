/*
 * Created on 15-giu-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package it.csi.stacore.stassosrv.integration.dao.oracle.query.select.utente;


import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import it.csi.stacore.stassosrv.integration.bo.utente.Abilitazione;
import it.csi.stacore.stassosrv.integration.bo.utente.Cassa;
import it.csi.stacore.stassosrv.integration.dao.oracle.query.select.AbstractSelect;
import it.csi.stacore.stassosrv.integration.dao.oracle.query.select.TAURDEResultSet;
import it.csi.stacore.stassosrv.integration.dao.oracle.query.select.TauPreparedStatement;
import it.csi.stacore.stassosrv.integration.exception.InvalidSearchObjectException;

/**
 * @author fguglielmelli
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SelectCasseByIdCasse extends AbstractSelect {
	/**
	 * @uml.property  name="casseList"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="it.csi.stacore.staon.business.bo.utente.Cassa"
	 */
	private List casseList ;
	/**
	 * @uml.property  name="abilitazione"
	 * @uml.associationEnd  readOnly="true"
	 */
	private Abilitazione abilitazione ;
	/**
	 * @uml.property  name="idCassa"
	 */
	private Long idCassa ;
	/**
	 * @uml.property  name="denominazione"
	 */
	private String denominazione ;
	/**
	 * @uml.property  name="codice"
	 */
	private String codice ;
	/**
	 * @uml.property  name="descrizione"
	 */
	private String descrizione ;
	
	public SelectCasseByIdCasse(List casseList) {
		this.casseList = casseList;
		}
	public Object createBO(TAURDEResultSet rs) throws SQLException {
		
		return new Cassa(
		    rs.getLong("ID_CASSA"), 
			rs.getString("DENOMINAZIONE"), 
			rs.getString("CODICE"),
			rs.getString("DESCRIZIONE"),
			rs.getLong("ID_SPORTELLO")
		);
				
	}

	public String getSQLStatement() throws InvalidSearchObjectException {
		
		/*
		 * Questa Select deve prelevare le casse su cui l'utente � Abilitato
		 */
		String query  =   "SELECT ID_CASSA, DENOMINAZIONE, CODICE, DESCRIZIONE, ID_SPORTELLO " +
	    			 	  "FROM TAU_T_CASSA ";
		String orderBy =  "ORDER BY ID_CASSA";
	     
	     String inClause="";
	     
	     for (Iterator iter = casseList.iterator(); iter.hasNext();) {
			Cassa cassa= (Cassa) iter.next();
			
			Long idCassa= cassa.getIdCassa();
			
			if (inClause.length()==0)
				inClause+=idCassa;
			else
				inClause+=", "+idCassa;
		}
		if (inClause.length()!=0)
			query+="WHERE ID_CASSA IN ("+inClause+")";
		
		query+=orderBy;
		return query;

	}
	

	public void setPreparedStatement(TauPreparedStatement stmt)
			throws SQLException {

	}
}

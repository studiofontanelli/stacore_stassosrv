/*
 * Created on 25-lug-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package it.csi.stacore.stassosrv.integration.dao.oracle.query.select.utente;


import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import it.csi.stacore.stassosrv.integration.bo.utente.Abilitazione;
import it.csi.stacore.stassosrv.integration.bo.utente.Sportello;
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
public class SelectSportellobyAbilitazione extends AbstractSelect {
	/**
	 * @uml.property  name="abilitazione"
	 * @uml.associationEnd  readOnly="true"
	 */
	private Abilitazione abilitazione;
	/**
	 * @uml.property  name="sportelliList"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="it.csi.stacore.staon.business.bo.utente.Sportello"
	 */
	private List sportelliList;


	public SelectSportellobyAbilitazione(List sportelliList) {
		this.sportelliList = sportelliList;
	}
	public Object createBO(TAURDEResultSet rs) throws SQLException {

		
		return new Sportello(rs.getLong("ID_SPORTELLO"), 
				rs.getLong("ID_ENTE"),
				rs.getString("EMAIL"),
				rs.getString("INDIRIZZO"), 
				rs.getString("CIVICO"), 
				rs.getInteger("CAP"), 
				rs.getString("COMUNE"), 
				rs.getString("PROVINCIA"),
				rs.getString("CODICE"), 
				rs.getString("DESCRIZIONE"));
	}

	public String getSQLStatement() throws InvalidSearchObjectException {
		/*
		 * Questa Select deve prelevare le case su cui l'utente � Abilitato
		 */

		String query="SELECT ID_SPORTELLO, ID_ENTE, EMAIL ,INDIRIZZO, CIVICO, CAP, COMUNE,PROVINCIA, CODICE, DESCRIZIONE " +
	     "FROM TAU_T_SPORTELLO";
	     
	     String orderBy=" ORDER BY ID_SPORTELLO";
	     
	     String inClause="";
	     
	     for (Iterator iter = sportelliList.iterator(); iter.hasNext();) {
			Sportello sportello= (Sportello) iter.next();
			
			long idSportello= sportello.getId().getId();
			
			if (inClause.length()==0)
				inClause+=idSportello;
			else
				inClause+=", "+idSportello;
		}
		if (inClause.length()!=0)
			query+=" WHERE ID_SPORTELLO IN ("+inClause+")";
		
		query+=orderBy;
		return query;

	}


	public void setPreparedStatement(TauPreparedStatement stmt)
			throws SQLException {

	}
}

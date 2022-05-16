/*
 * Created on 22-lug-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package it.csi.stacore.stassosrv.integration.dao.oracle.query.select.utente;



import java.sql.SQLException;
import java.util.List;

import it.csi.stacore.stassosrv.integration.bo.utente.Ente;
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
public class SelectSportellobyEnte extends AbstractSelect {
	/**
	 * @uml.property  name="sportelloList" multiplicity="(0 -1)"
	 */
	private List sportelloList;

	/**
	 * @uml.property  name="ente"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Ente ente;

	public SelectSportellobyEnte(Ente ente) {
		this.ente = ente;
	}



	public Object createBO(TAURDEResultSet rs) throws SQLException {
		
		Sportello res = new Sportello(rs.getLong("ID_SPORTELLO"), 
				rs.getLong("ID_ENTE"),
				rs.getString("EMAIL"),
				rs.getString("INDIRIZZO"), 
				rs.getString("CIVICO"), 
				rs.getInteger("CAP"), 
				rs.getString("COMUNE"), 
				rs.getString("PROVINCIA"),
				rs.getString("CODICE"), 
				rs.getString("DESCRIZIONE"));
		res.setCodmctc(rs.getString("codmctc"));

		return res;
		
	}

	public String getSQLStatement() throws InvalidSearchObjectException {
	
		String query="SELECT sp.ID_SPORTELLO, sp.ID_ENTE, sp.EMAIL, sp.INDIRIZZO, sp.CIVICO, "
				+ "sp.CAP, sp.COMUNE, sp.PROVINCIA, sp.CODICE, sp.DESCRIZIONE, a.codmctc " +
	     " FROM TAU_T_SPORTELLO sp, gin_t_agenzia a";
		String queryWhere =" WHERE ID_ENTE = "+ente.getId().getId() + " and sp.ID_SPORTELLO = a.ID_SPORTELLO (+) ";
		query+= queryWhere;
		return query;
	}

	public void setPreparedStatement(TauPreparedStatement stmt)
			throws SQLException {

	}
}

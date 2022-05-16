/*
 * Created on 26-lug-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package it.csi.stacore.stassosrv.integration.dao.oracle.query.select.utente;


import java.sql.SQLException;

import it.csi.stacore.stassosrv.integration.bo.utente.AbilitazioneList;
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
public class SelectAbilitazioneList extends AbstractSelect {

	/**
	 * @uml.property  name="idUtente"
	 */
	private String idUtente;

	public SelectAbilitazioneList(String idUtente) {
		this.idUtente = idUtente;
	}

	public Object createBO(TAURDEResultSet rs) throws SQLException {

		return new AbilitazioneList(rs.getLong("ID_POSTAZIONE"),
									rs.getLong("ID_ENTE"), 
									rs.getLong("ID_SPORTELLO"), 
									rs.getLong("ID_CASSA"));

	}

	public String getSQLStatement() throws InvalidSearchObjectException {
		String query = 
		" SELECT "+
		"  abi.ID_POSTAZIONE as ID_POSTAZIONE, pos.ID_CASSA as ID_CASSA, pos.ID_SPORTELLO as ID_SPORTELLO, pos.ID_ENTE as ID_ENTE "+
		" FROM "+
		"  TAU_R_ABILITAZIONE abi, TAU_T_POSTAZIONE pos "+
		" WHERE "+
		"  pos.ID_POSTAZIONE = abi.ID_POSTAZIONE AND abi.IDENTIFICATIVO_UTENTE = ?";
		return query;
	}

	public void setPreparedStatement(TauPreparedStatement stmt)
			throws SQLException {
	  int iPos = 1;
      stmt.setUpperCaseString(iPos++, idUtente);
	}
}

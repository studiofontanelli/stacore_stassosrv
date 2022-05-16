package it.csi.stacore.stassosrv.integration.dao.oracle.query.select;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.csi.stacore.stassosrv.integration.dao.oracle.util.OracleQuery;
import it.csi.stacore.stassosrv.integration.dao.oracle.util.OracleQueryList;
import it.csi.stacore.stassosrv.integration.exception.InvalidSearchObjectException;
import it.csi.stacore.stassosrv.util.Constants;


/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */

public abstract class AbstractQuery {

protected static final String LOGGER_PREFIX = Constants.APPLICATION_CODE;
	protected final static Logger LOG = LoggerFactory.getLogger(LOGGER_PREFIX);

	//~ Methods ==================================================================

	public Logger getLogger() {
		return LOG;
	}

	//~ Constructors =============================================================

	/**
	 * Creates a new AbstractQuery object.
	 */
	protected AbstractQuery() {
	}

	//~ Methods ==================================================================

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 *
	 * @throws InvalidSearchObjectException DOCUMENT ME!
	 */
	public String getSQLStatement() throws InvalidSearchObjectException {
		OracleQuery q = getOracleQueryList().getQuery(getClass().getName());
		return q.getQuery();
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	protected OracleQueryList getOracleQueryList() {
		return OracleQueryList.getInstance();
	}

	/**
	 * Nell'implementazione di questo metodo deve essere impostato correttamente
	 * il PreparedStatement
	 *
	 * @param stmt
	 *
	 * @throws SQLException
	 */
	protected abstract void setPreparedStatement(TauPreparedStatement stmt)
			throws SQLException;


}

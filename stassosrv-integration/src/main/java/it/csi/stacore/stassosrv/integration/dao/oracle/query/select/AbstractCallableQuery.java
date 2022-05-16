package it.csi.stacore.stassosrv.integration.dao.oracle.query.select;

import java.sql.Connection;
import java.sql.SQLException;

import it.csi.stacore.stassosrv.integration.exception.InvalidSearchObjectException;
import it.csi.stacore.stassosrv.util.Tracer;
import it.csi.util.performance.StopWatch;


/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @author andreafontanelli
 * @version $Revision$
 */
public abstract class AbstractCallableQuery extends AbstractQuery {


	

	//~ Instance fields ==========================================================

	/**
	 * @uml.property  name="stmt"
	 * @uml.associationEnd
	 */
	private TAURDECallableStatement stmt;

	//~ Constructors =============================================================

	/**
	 * Creates a new AbstractCallableQuery object.
	 */
	public AbstractCallableQuery() {
		super();
	}

	//~ Methods ==================================================================

	/**
	 * ridefinisce il metodo execute
	 *
	 * @param connection
	 *
	 * @throws SQLException
	 * @throws InvalidSearchObjectException
	 */
	public void execute(Connection connection) throws SQLException, InvalidSearchObjectException {
		final String method = "execute";
		StopWatch stopWatch = new StopWatch(LOGGER_PREFIX);
		stopWatch.start();
		String query = getSQLStatement();
		Tracer.debug(LOG, getClass().getName(), method, "query= " + query);
		setCallableStmt(new TAURDECallableStatement(connection, query));

		try {
			setPreparedStatement(getCallableStmt());
			getCallableStmt().execute();
		} finally {
			stopWatch.stop();
			stopWatch.dumpElapsed(getClass().getName(), method, "query time execution", "-");
		}
	}

	/**
	 * DOCUMENT ME!
	 */
	public void close() {
		if(getCallableStmt() != null) {
			getCallableStmt().close();
		}
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param stmt The stmt to set.
	 */
	protected void setCallableStmt(TAURDECallableStatement stmt) {
		this.stmt = stmt;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return Returns the stmt.
	 */
	protected TAURDECallableStatement getCallableStmt() {
		return stmt;
	}
}

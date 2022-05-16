package it.csi.stacore.stassosrv.integration.dao.oracle.query.select;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import it.csi.stacore.stassosrv.integration.exception.InvalidSearchObjectException;
import it.csi.stacore.stassosrv.util.Tracer;
import it.csi.util.performance.StopWatch;

/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public abstract class AbstractSelect extends AbstractQuery {
	//~ Constructors =============================================================

	/**
	 * Creates a new AbstractSelect object.
	 */
	protected AbstractSelect() {
		super();
	}

	//~ Methods ==================================================================

	/**
	 * crea l'oggetto di business logic
	 *
	 * @param rs
	 *
	 * @return
	 *
	 * @throws SQLException
	 */
	public abstract Object createBO(TAURDEResultSet rs) throws SQLException;

	/**
	 * esegue la query
	 *
	 * @param conn
	 *
	 * @return
	 *
	 * @throws SQLException
	 * @throws InvalidSearchObjectException
	 */
	public Object execute(Connection conn) throws SQLException, InvalidSearchObjectException {
		final String method = "execute";
		StopWatch stopWatch = new StopWatch(LOGGER_PREFIX);
		stopWatch.start();
		TauPreparedStatement stmt = new TauPreparedStatement(conn, getSQLStatement());
		try {
			Tracer.debug(LOG, getClass().getName(), method, "query= " + getSQLStatement());
			setPreparedStatement(stmt);
			TAURDEResultSet rs = stmt.executeQuery();
			try {
				Object result = null;
				if (rs.next()) {
					result = createBO(rs);
				}
				return result;
			} finally {
				rs.close();
			}
		} finally {
			stmt.close();
			stopWatch.stop();
			stopWatch.dumpElapsed(getClass().getName(), method, "query time execution", stmt.getSqlToString(getSQLStatement()));
			
		}
	}

	/**
	 * Ritorna una Collection di oggetti costruiti nel metodo createBO(ResultSet
	 * rs) Da usare nel caso in cui la query debba eseguire ricerche multiple.
	 *
	 * @param conn
	 *
	 * @return
	 *
	 * @throws SQLException
	 * @throws InvalidSearchObjectException
	 */
	public List executeMultipla(Connection conn) throws SQLException, InvalidSearchObjectException {
		final String method = "executeMultipla";
		StopWatch stopWatch = new StopWatch(LOGGER_PREFIX);
		stopWatch.start();
		Tracer.debug(LOG, getClass().getName(), method, "query= " + getSQLStatement());
		TauPreparedStatement stmt = new TauPreparedStatement(conn, getSQLStatement());
		try {
			setPreparedStatement(stmt);
			TAURDEResultSet rs = stmt.executeQuery();
			try {
				List result = new ArrayList();
				while (rs.next()) {
					Object queryResult = createBO(rs);
					if (queryResult != null) {
						result.add(queryResult);
					}
				}
				if (getLogger().isDebugEnabled()) {
					Tracer.debug(LOG, getClass().getName(), method, "query class: " + getClass().getName() + ", record estratti: " + result.size());
				}
				return result;
			} finally {
				rs.close();
			}
		} finally {
			stmt.close();
			stopWatch.stop();
			stopWatch.dumpElapsed(getClass().getName(), method, "esecuzione query", "query = " + getClass().getName() + " "
					+ stmt.getSqlToString(getSQLStatement()));
		}
	}
	
	protected static String createCondition(List lista, String column) {
		final String parameter = "?";
		final String comma     = ",";
		StringBuffer condition = new StringBuffer();
		if (lista != null && !lista.isEmpty()){
			condition.append("(" + column);
			if (lista.size() == 1){
				condition.append(" = ?)");
			} else {
				condition.append(" IN (?");
				for (int y = 1;y < lista.size();y++) {
					if (y%1000 == 0){
						condition.append(") OR " + column + " IN (?");
					} else {
						condition.append(comma).append(parameter);
					}
				}
				condition.append("))");
			}
		}
		
		return condition.toString();
	}
	
	

}

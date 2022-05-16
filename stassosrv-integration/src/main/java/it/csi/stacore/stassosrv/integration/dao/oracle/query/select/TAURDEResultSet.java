package it.csi.stacore.stassosrv.integration.dao.oracle.query.select;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class TAURDEResultSet {

	protected final static Logger LOG = LoggerFactory.getLogger(it.csi.stacore.stassosrv.util.Constants.APPLICATION_CODE);

	private Logger getLogger() {
		return LOG;
	}


	//~ Instance fields ==========================================================

	/**
	 * @uml.property  name="itsRs"
	 */
	private ResultSet itsRs;

	//~ Constructors =============================================================

	/**
	 * Creates a new TAURDEResultSet object.
	 *
	 * @param rs DOCUMENT ME!
	 */
	public TAURDEResultSet(ResultSet rs) {
		setResultSet(rs);
	}

	//~ Methods ==================================================================

	private void setResultSet(ResultSet rs) {
		itsRs = rs;
	}

	private ResultSet getResultSet() {
		return itsRs;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 *
	 * @throws SQLException DOCUMENT ME!
	 */
	public boolean next() throws SQLException {
		return getResultSet().next();
	}

	/**
	 * DOCUMENT ME!
	 */
	public void close() {
		try {
			getResultSet().close();
		} catch(SQLException ex) {
			getLogger().error("SQLException close: " + ex.getMessage(), ex);
			
		}
	}

	
	public Long getLong(String nameField) throws SQLException {
		Long   result = null;

		Object obj = getResultSet().getObject(nameField);

		if(obj == null) {
			result = null;
		} else if(obj instanceof BigDecimal) {
			BigDecimal bigDecimal = (BigDecimal) obj;
			result = new Long(bigDecimal.longValue());
		} else if(obj instanceof String) {
			String str = (String) obj;

			try {
				long l = Long.parseLong(str);
				result = new Long(l);
			} catch(NumberFormatException ex) {
				getLogger().warn("Conversione da " + obj.getClass() +
						" a Long non supportata. Caratteri non validi"
						);
			}
		} else {
			getLogger().warn("Conversione da " + obj.getClass() +
					" a Long non supportata."
					);
		}

		return result;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param nameField DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 *
	 * @throws SQLException DOCUMENT ME!
	 */
	public BigDecimal getBigDecimal(String nameField) throws SQLException {
		BigDecimal result = null;

		Object     obj = getResultSet().getObject(nameField);

		if(obj == null) {
			result = null;
		} else if(obj instanceof BigDecimal) {
			result = (BigDecimal) obj;
		} else if(obj instanceof String) {
			String str = (String) obj;

			try {
				long l = Long.parseLong(str);
				result = new BigDecimal(l);
			} catch(NumberFormatException ex) {
				getLogger().warn("Conversione da " + obj.getClass() +
						" a BigDecimal non supportata. Caratteri non validi"
						);
			}
		} else {
			getLogger().warn("Conversione da " + obj.getClass() +
					" a BigDecimal non supportata."
					);
		}

		return result;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param nameField DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 *
	 * @throws SQLException DOCUMENT ME!
	 */
	public Integer getInteger(String nameField) throws SQLException {
		Integer result = null;

		Object  obj = getResultSet().getObject(nameField);

		if(obj == null) {
			result = null;
		} else if(obj instanceof BigDecimal) {
			BigDecimal bigDecimal = (BigDecimal) obj;
			result = new Integer(bigDecimal.intValue());
		} else if(obj instanceof String) {
			String str = (String) obj;

			try {
				int iRet = Integer.parseInt(str);
				result = new Integer(iRet);
			} catch(NumberFormatException ex) {
				getLogger().warn("Conversione da " + obj.getClass() +
						" a Integer non supportata. Caratteri non validi"
						);
			}
		} else {
			getLogger().warn("Conversione da " + obj.getClass() +
					" a Integer non supportata."
					);
		}

		return result;
	}

	/**
	 * restituisce un Boolean da un flag 'S'/'N' presente sul database
	 *
	 * @param nameField
	 *
	 * @return
	 *
	 * @throws SQLException
	 */
	public Boolean getBooleanFromFlag(String nameField) throws SQLException {
		Boolean result = null;

		Object  obj = getResultSet().getObject(nameField);

		if(obj == null) {
			result = null;
		} else if(obj instanceof String) {
			String bool = (String) obj;
			result =
					new Boolean(bool.equalsIgnoreCase("S") || bool.equalsIgnoreCase("1"));
		} else {
			getLogger().warn("Conversione da " + obj.getClass() +
					" a Boolean from flag non supportata."
					);
		}

		return result;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param columnName DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 *
	 * @throws SQLException DOCUMENT ME!
	 */
	public String getString(String columnName) throws SQLException {
		return getResultSet().getString(columnName);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param columnName DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 *
	 * @throws SQLException DOCUMENT ME!
	 */
	public Date getDate(String columnName) throws SQLException {
		return getResultSet().getDate(columnName);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param columnName DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 *
	 * @throws SQLException DOCUMENT ME!
	 */
	public Timestamp getTimestamp(String columnName) throws SQLException {
		return getResultSet().getTimestamp(columnName);
	}





}

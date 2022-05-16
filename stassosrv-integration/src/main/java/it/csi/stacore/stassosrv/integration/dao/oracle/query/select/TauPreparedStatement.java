package it.csi.stacore.stassosrv.integration.dao.oracle.query.select;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.csi.stacore.stassosrv.util.Constants;
import it.csi.stacore.stassosrv.util.Tracer;



/**
 * DOCUMENT ME!
 *
 * @author dventura 23-nov-2004 Decoratore di un PreparedStatement che ne
 *         ridefinisce alcuni metodi per aggiungere funzionalit� di controllo
 *         sui parametri da settare nel PreparedStatement e nei logger.
 */
public class TauPreparedStatement {

	protected final static Logger LOG = LoggerFactory.getLogger(Constants.APPLICATION_CODE);

	protected Logger getLogger() {
		return LOG;
	}

	//~ Instance fields ==========================================================

	/**
	 * @uml.property  name="itsStmt"
	 */
	private PreparedStatement itsStmt;

	private Map params = new HashMap();

	//~ Constructors =============================================================

	/**
	 * Creates a new TAURDEPreparedStatement object.
	 */
	protected TauPreparedStatement() {
	}

	/**
	 * Creates a new TAURDEPreparedStatement object.
	 *
	 * @param connection DOCUMENT ME!
	 * @param query DOCUMENT ME!
	 *
	 * @throws SQLException DOCUMENT ME!
	 */
	public TauPreparedStatement(Connection connection, String query) throws SQLException {
		this();
		setStmt(connection.prepareStatement(query));
	}

	//~ Methods ==================================================================

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 *
	 * @throws SQLException DOCUMENT ME!
	 */
	public TAURDEResultSet executeQuery() throws SQLException {
		return new TAURDEResultSet(getStmt().executeQuery());
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 *
	 * @throws SQLException
	 */
	public int executeUpdate() throws SQLException {
		return getStmt().executeUpdate();
	}

	/**
	 * DOCUMENT ME!
	 */
	public void close() {
		try {
			getStmt().close();
		} catch (SQLException ex) {
			getLogger().error("SQLException close: " + ex.getMessage(), ex);
		}
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param position DOCUMENT ME!
	 * @param aValue DOCUMENT ME!
	 *
	 * @throws SQLException DOCUMENT ME!
	 */
	public void setInt(int position, int aValue) throws SQLException {
		final String method = "setInt";
		getStmt().setInt(position, aValue);
		setParam(position, "" + aValue);
		Tracer.debug(LOG, getClass().getName(), method, "pos: " + position + " Valore impostato: '" + aValue + "'");
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param position DOCUMENT ME!
	 * @param aValue DOCUMENT ME!
	 *
	 * @throws SQLException DOCUMENT ME!
	 */
	public void setInt(int position, Integer aValue) throws SQLException {
		final String method = "setInt";
		String strMsgValue = null;
		if (aValue != null) {
			getStmt().setInt(position, aValue.intValue());
			strMsgValue = "" + aValue.intValue();
		} else {
			getStmt().setNull(position, Types.INTEGER);
		}

		String param = null;
		if (aValue != null) param = aValue.toString();
		setParam(position, param);
		Tracer.debug(LOG, getClass().getName(), method, "pos: " + position + " Valore impostato: '" + strMsgValue + "'");
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param position DOCUMENT ME!
	 * @param aValue DOCUMENT ME!
	 *
	 * @throws SQLException DOCUMENT ME!
	 */
	public void setUpperCaseString(int position, String aValue) throws SQLException {
		if (aValue != null) {
			aValue = aValue.toUpperCase();
			getStmt().setString(position, aValue);
		} else {
			getStmt().setNull(position, Types.VARCHAR);
		}
		String param = null;
		if (aValue != null) param = aValue.toString();
		setParam(position, param);
		getLogger().debug("[setUpperCaseString()] - pos: " + position + " Valore impostato: '" + aValue + "'");
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param position DOCUMENT ME!
	 * @param aValue DOCUMENT ME!
	 *
	 * @throws SQLException DOCUMENT ME!
	 */
	public void setString(int position, String aValue) throws SQLException {
		if (aValue != null) {
			getStmt().setString(position, aValue);
		} else {
			getStmt().setNull(position, Types.VARCHAR);
		}
		String param = null;
		if (aValue != null) param = aValue.toString();
		setParam(position, param);
		getLogger().debug("[setString()] - pos: " + position + " Valore impostato: '" + aValue + "'");
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param position DOCUMENT ME!
	 * @param aValue DOCUMENT ME!
	 *
	 * @throws SQLException DOCUMENT ME!
	 */
	public void setDate(int position, Date aValue) throws SQLException {
		if (aValue != null) {
			getStmt().setDate(position, new java.sql.Date(aValue.getTime()));
		} else {
			getStmt().setNull(position, Types.DATE);
		}
		String param = null;
		if (aValue != null) param = aValue.toString();
		setParam(position, param);
		getLogger().debug("[setDate()] - pos: " + position + " Valore impostato: '" + aValue + "'");
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param position DOCUMENT ME!
	 * @param aValue DOCUMENT ME!
	 *
	 * @throws SQLException DOCUMENT ME!
	 */
	public void setTimestamp(int position, Date aValue) throws SQLException {
		if (aValue != null) {
			getStmt().setTimestamp(position, new Timestamp(aValue.getTime()));
		} else {
			getStmt().setNull(position, Types.TIMESTAMP);
		}
		String param = null;
		if (aValue != null) param = aValue.toString();
		setParam(position, param);
		getLogger().debug("[setTimestamp()] - pos: " + position + " Valore impostato: '" + aValue + "'");
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param position DOCUMENT ME!
	 * @param aValue DOCUMENT ME!
	 *
	 * @throws SQLException DOCUMENT ME!
	 */
	public void setLong(int position, Long aValue) throws SQLException {
		String strMsgValue = null;

		if (aValue != null) {
			getStmt().setLong(position, aValue.longValue());
			strMsgValue = "" + aValue.longValue();
		} else {
			getStmt().setNull(position, Types.NUMERIC);
		}
		String param = null;
		if (aValue != null) param = aValue.toString();
		setParam(position, param);
		getLogger().debug("[setLong()] - pos: " + position + " Valore impostato: '" + strMsgValue + "'");
	}

	/*
	public void setDecodifica(int position, Decodifica aValue) throws SQLException {
		LongId id = null;

		if (aValue != null) {
			id = aValue.getId();
		}
		setLongId(position, id);
	}
	*/
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param position DOCUMENT ME!
	 * @param aValue DOCUMENT ME!
	 *
	 * @throws SQLException DOCUMENT ME!
	 */
	/*
	public void setLongId(int position, LongId aValue) throws SQLException {
		String strMsgValue = null;

		if (aValue != null) {
			getStmt().setLong(position, aValue.getId());
			strMsgValue = "" + aValue.getId();
		} else {
			getStmt().setNull(position, Types.NUMERIC);
		}

		String param = null;
		if (aValue != null) param = aValue.toString();
		setParam(position, param);
		getLogger().debug("[setLongId()] - pos: " + position + " Valore impostato: '" + strMsgValue + "'");
	}
	*/

	/**
	 * DOCUMENT ME!
	 *
	 * @param position DOCUMENT ME!
	 * @param aValue DOCUMENT ME!
	 *
	 * @throws SQLException DOCUMENT ME!
	 */
	public void setFlagFromBoolean(int position, Boolean aValue) throws SQLException {
		String strMsgValue = null;

		if (aValue != null) {
			strMsgValue = (aValue.booleanValue()) ? "1" : "0";
			getStmt().setString(position, strMsgValue);
		} else {
			getStmt().setNull(position, Types.CHAR);
		}

		String param = null;
		if (aValue != null) param = aValue.toString();
		setParam(position, param);
		getLogger().debug("[setBoolean()] - pos: " + position + " Valore impostato: '" + strMsgValue + "'");
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param position DOCUMENT ME!
	 * @param aValue DOCUMENT ME!
	 *
	 * @throws SQLException DOCUMENT ME!
	 */
	public void setLong(int position, long aValue) throws SQLException {
		getStmt().setLong(position, aValue);

		setParam(position, "" + aValue);
		getLogger().debug("[setLong()] - pos: " + position + " Valore impostato: '" + aValue + "'");
	}

	public void setBytes(int position, byte[] aValue) throws SQLException {
		getStmt().setBytes(position, aValue);

		setParam(position, "" + aValue);
		getLogger().debug("[setBytes()] - pos: " + position + " Valore impostato: '" + aValue + "'");
	}

	/*
	public void setImportoValuta(int position, Valuta aValue) throws SQLException {
		String strMsgValue = null;

		if ((aValue != null) && (aValue.getDivisa() != null)) {
			BigDecimal bd = null;

			if (aValue.getDivisa().equals(Divisa.EURO)) {
				bd = aValue.getImporto().multiply(new BigDecimal(100));
			} else {
				getLogger().warn("Divisa " + aValue.getDivisa().getCodice() + " non gestita!");
			}

			getStmt().setBigDecimal(position, bd);
			strMsgValue = "" + bd;
		} else {
			getStmt().setNull(position, Types.NUMERIC);
		}

		String param = null;
		if (aValue != null) param = aValue.toString();
		setParam(position, param);
		getLogger().debug("[setImportoValuta()] - pos: " + position + " Valore impostato: '" + strMsgValue + "'");
	}
	*/

	/**
	 * DOCUMENT ME!
	 *
	 * @param position DOCUMENT ME!
	 * @param aValue DOCUMENT ME!
	 *
	 * @throws SQLException DOCUMENT ME!
	 */
	public void setBigDecimal(int position, BigDecimal aValue) throws SQLException {
		String strMsgValue = null;

		if (aValue != null) {
			getStmt().setBigDecimal(position, aValue);
			strMsgValue = "" + aValue.toString();
		} else {
			getStmt().setNull(position, Types.NUMERIC);
		}
		String param = null;
		if (aValue != null) param = aValue.toString();
		setParam(position, param);
		getLogger().debug("[setBigDecimal()] - pos: " + position + " Valore impostato: '" + strMsgValue + "'");
	}

	/*
	public void setCO2(int position, String aValue) throws SQLException {
		String strMsgValue = null;

		if (aValue != null && aValue.length() != 0) {
			BigDecimal bd = null;

			bd = NumberUtil.decodeBigDecimalFromTextInput(aValue).multiply(
					new BigDecimal(10));
			bd = bd.setScale(0);

			getStmt().setString(position, allineaDx("" + bd, 4, '0'));
			strMsgValue = allineaDx("" + bd, 4, '0');
		} else {
			getStmt().setNull(position, Types.VARCHAR);
		}

		String param = null;
		if (aValue != null)
			param = allineaDx(aValue.toString(), 4, '0');
		setParam(position, param);

		getLogger().debug(
				"[setCO2()] - pos: " + position + " Valore impostato: '" + strMsgValue + "'");
	}
	*/
	/**
	 * DOCUMENT ME!
	 *
	 * @param stmt DOCUMENT ME!
	 */
	protected void setStmt(PreparedStatement stmt) {
		itsStmt = stmt;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	protected PreparedStatement getStmt() {
		return itsStmt;
	}

	public String getSqlToString(String str) {
		String result = null;

		result = parseSql(str);
    return result.replace(',', ' ').replace((char) 10, ' ').replace((char) 9, ' ').replace((char) 13, ' ');



		//		if (getLogger().isDebugEnabled()) {
		//			if (result != null) result.replace(',', ' ');
		//		}
		//		return "";
	}

	private String parseSql(String sql) {
		if (sql == null) return sql;

		int key = 0;
		String val = "?";
		int pos = sql.indexOf("?");
		while (pos >= 0) {
			key++;
			val = "?";
			if (params.containsKey(new Integer(key))) val = "<" + params.get(new Integer(key)).toString() + ">";

			sql = sql.substring(0, pos) + val + sql.substring(pos + 1);
			pos = sql.indexOf("?", pos + 1);
		}
		return sql;
	}

	private void setParam(int position, String value) {
		if (value == null) value = "null";
		params.put(new Integer(position), value);
	}

	private static String allineaDx(String value, int length, char riempimento) {
		String result = (value == null) ? "" : value;
		if (result.length() > length)
			result = result.substring(0, length);

		String textDx = "";
		for (int i = 0; i < (length - result.length()); i++)
			textDx += riempimento;
		result = textDx + result;

		return result;
	}

	



	public void setQueryTimeout(int seconds) throws SQLException {
		itsStmt.setQueryTimeout(seconds);
	}

}

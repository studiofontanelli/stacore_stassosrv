package it.csi.stacore.stassosrv.integration.dao.oracle.query.select;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class TAURDECallableStatement extends TauPreparedStatement {
  //~ Constructors =============================================================

  /**
   * Creates a new TAURDECallableStatement object.
   *
   * @param connection
   * @param query
   *
   * @throws SQLException
   */
  public TAURDECallableStatement(Connection connection, String query)
                          throws SQLException {
    super();
    setStmt(connection.prepareCall(query));
  }

  //~ Methods ==================================================================

  /**
   * Executes any kind of SQL statement. Some prepared statements return
   * multiple results; the execute  method handles these complex statements as
   * well as the simpler form of statements handled by the methods
   * executeQuery  and executeUpdate
   *
   * @return
   *
   * @throws SQLException
   */
  public boolean execute() throws SQLException {
    return getStmt().execute();
  }

  /**
   * Registers the OUT parameter in ordinal position parameterIndex to the JDBC
   * type sqlType. All OUT parameters must be registered before a stored
   * procedure is executed
   *
   * @param parameterIndex
   * @param sqlType
   *
   * @throws SQLException
   */
  public void registerOutParameter(int parameterIndex, int sqlType)
                            throws SQLException {
    getCallableStmt().registerOutParameter(parameterIndex, sqlType);
  }

  /**
   * Gets the value of a JDBC NUMERIC parameter as a java.math.BigDecimal
   * object with as many digits to the right of the decimal point as the value
   * contains
   *
   * @param parameterIndex
   *
   * @return
   *
   * @throws SQLException
   */
  public BigDecimal getBigDecimal(int parameterIndex) throws SQLException {
    return getCallableStmt().getBigDecimal(parameterIndex);
  }

  /**
   * Gets the value of a JDBC INTEGER parameter as an int  in the Java
   * programming language
   *
   * @param parameterIndex
   *
   * @return
   *
   * @throws SQLException
   */
  public int getInt(int parameterIndex) throws SQLException {
    return getCallableStmt().getInt(parameterIndex);
  }

  /**
   * restituisce un Boolean da un flag '1'(true) '0' (false) presente sul
   * database
   *
   * @param parameterIndex
   *
   * @return
   *
   * @throws SQLException
   */
  public Boolean getBooleanFromFlag(int parameterIndex)
                             throws SQLException {
    Boolean result = null;

    Object  obj = getCallableStmt().getObject(parameterIndex);

    if(obj == null) {
      result = null;
    } else if(obj instanceof String) {
      String bool = (String) obj;
      result = new Boolean(bool.equalsIgnoreCase("1"));
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
   * @param parameterIndex DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   *
   * @throws SQLException DOCUMENT ME!
   */
  public Date getDate(int parameterIndex) throws SQLException {
    return getCallableStmt().getDate(parameterIndex);
  }

  public boolean getBoolean(int parameterIndex) throws SQLException {
	  return getCallableStmt().getBoolean(parameterIndex);
  }

  /**
   * DOCUMENT ME!
   *
   * @param parameterIndex DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   *
   * @throws SQLException DOCUMENT ME!
   */
  public Integer getInteger(int parameterIndex) throws SQLException {
    Integer result = null;

    Object  obj = getCallableStmt().getObject(parameterIndex);

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
   * DOCUMENT ME!
   *
   * @param parameterIndex DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   *
   * @throws SQLException DOCUMENT ME!
   */
  public Long getLong(int parameterIndex) throws SQLException {
    Long   result = null;

    Object obj = getCallableStmt().getObject(parameterIndex);

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
   * @param parameterIndex DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   *
   * @throws SQLException DOCUMENT ME!
   */
  public String getString(int parameterIndex) throws SQLException {
    return getCallableStmt().getString(parameterIndex);
  }

  


  /**
   * DOCUMENT ME!
   *
   * @param parameterIndex DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   *
   * @throws SQLException DOCUMENT ME!
   */
  public java.sql.ResultSet getResutlSet(int parameterIndex)
                   throws SQLException {

	    java.sql.ResultSet result = null;

	    Object  obj = getCallableStmt().getObject(parameterIndex);

	    if(obj == null) {
	      result = null;
	    } else if(obj instanceof ResultSet) {
	    	result = (ResultSet) obj;
	    } else {
	      getLogger().warn("Conversione da " + obj.getClass() +
	                       " a Integer non supportata."
	                      );
	    }
	    return result;
  }


  private CallableStatement getCallableStmt() {
    return (CallableStatement) getStmt();
  }

  public void setQueryTimeout(int seconds) throws SQLException {
	  getStmt().setQueryTimeout(seconds);
  }
}

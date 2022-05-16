package it.csi.stacore.stassosrv.integration.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import it.csi.stacore.stassosrv.integration.exception.ResourceAccessException;
import it.csi.stacore.stassosrv.util.Constants;
import it.csi.stacore.stassosrv.util.Tracer;



/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @author andreafontanelli: refactoring
 * @version $Revision$
 */

@Repository
public class AbstractDAO {

	protected final static Logger LOG = LoggerFactory.getLogger(Constants.APPLICATION_CODE);
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	public Connection getConnection() throws ResourceAccessException{
		final String method = "getConnection";
		try {
			return jdbcTemplate.getDataSource().getConnection();
		}
		catch(SQLException e) {
			Tracer.error(LOG, getClass().getName(), method, "SQLException " + e);
			throw new ResourceAccessException("Cannot get connection", e);
		}
	}

	public void releaseConnection(Connection conn){
		final String method = "releaseConnection";
		try {
			if(conn != null) {
				conn.close();
			}
		}
		catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
		}
	}

}

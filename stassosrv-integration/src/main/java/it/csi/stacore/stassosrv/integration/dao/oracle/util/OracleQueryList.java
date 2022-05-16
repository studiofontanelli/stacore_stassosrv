package it.csi.stacore.stassosrv.integration.dao.oracle.util;

import java.io.InputStream;
import java.util.HashMap;

import org.apache.commons.digester3.Digester;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.csi.stacore.stassosrv.util.Constants;
import it.csi.stacore.stassosrv.util.Tracer;




/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class OracleQueryList {

	protected final static Logger LOG = LoggerFactory.getLogger(Constants.APPLICATION_CODE);

	//~ Methods ==================================================================

	public Logger getLogger() {
		return LOG;
	}

	//~ Static fields/initializers ===============================================

	private static final String    ORACLEQUERYLIST_XML = "OracleQueryList.xml";
	private static OracleQueryList orclQuery = new OracleQueryList();

	//~ Instance fields ==========================================================

	/**
	 * @uml.property  name="queries"
	 * @uml.associationEnd  qualifier="name:java.lang.String it.csi.stacore.staon.integration.oracle.util.OracleQuery"
	 */
	private HashMap<String, OracleQuery> queries  = new HashMap<String, OracleQuery>();
	/**
	 * @uml.property  name="filename"
	 */
	private final String filename;

	//~ Constructors =============================================================

	private OracleQueryList() {
		this(ORACLEQUERYLIST_XML);
	}

	private OracleQueryList(String filename) {
		String method = "COSTRUTTORE";
		this.filename = filename;
		Tracer.info(LOG, getClass().getName(), method, "Istanziazione OracleQueryList dal file: "+this.filename);
		setup();
	}

	//~ Methods ==================================================================

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static OracleQueryList getInstance() {
		if(orclQuery == null) {
			orclQuery = new OracleQueryList();
		}

		return orclQuery;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param filename DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static OracleQueryList newInstance(String filename) {
		return new OracleQueryList(filename);
	}

	/**
	 * aggiunge una query
	 *
	 * @param query
	 */
	public void addQuery(OracleQuery query) {
		final String method = "addQuery";
		Tracer.info(LOG, getClass().getName(), method, "adding query : "+ query.getName());
		queries.put(query.getName(), query);
	}

	/**
	 * restituisce una query
	 *
	 * @param name
	 *
	 * @return
	 */
	public OracleQuery getQuery(String name) {
		final String method = "getQuery";
		Tracer.debug(LOG, getClass().getName(), method, "getting query: "+ name);
		return (OracleQuery) queries.get(name);
	}

	/**
	 * recupera la lista delle query dal file di configurazione
	 */
	private void setup() {
		final String method = "setup";
		
		// Create a Digester instance
		Digester d = new Digester();
		d.setClassLoader(getClass().getClassLoader());

		// Prime the digester stack with an object for rules to
		// operate on. Note that it is quite common for "this"
		// to be the object pushed.
		d.push(this);

		// Add rules to the digester that will be triggered while
		// parsing occurs.
		d.addObjectCreate("list-query/query", OracleQuery.class);
		d.addSetProperties("list-query/query");

		d.addSetNext("list-query/query", "addQuery");
		d.addCallMethod("list-query/query", "setQuery", 0);

		d.addCallMethod("list-query/query/body", "setBody", 0);
		d.addCallMethod("list-query/query/body/field", "setFieldBody", 2);
		d.addCallParam("list-query/query/body/field", 0, "id");
		d.addCallParam("list-query/query/body/field", 1);

		d.addCallMethod("list-query/query/from", "setFrom", 0);
		d.addCallMethod("list-query/query/from/paramFrom", "setParamFrom", 2);
		d.addCallParam("list-query/query/from/paramFrom", 0, "id");
		d.addCallParam("list-query/query/from/paramFrom", 1);

		d.addCallMethod("list-query/query/where", "setWhere", 0);
		d.addCallMethod("list-query/query/where/paramWhere", "setParamWhere", 2);
		d.addCallParam("list-query/query/where/paramWhere", 0, "id");
		d.addCallParam("list-query/query/where/paramWhere", 1);

		d.addCallMethod("list-query/query/orderBy", "setOrderBy", 0);
		d.addCallMethod("list-query/query/orderBy/paramOrderBy", "setParamOrderBy", 2);
		d.addCallParam("list-query/query/orderBy/paramOrderBy", 0, "id");
		d.addCallParam("list-query/query/orderBy/paramOrderBy", 1);

		// Process the input file.
		try {
			InputStream input = this.getClass().getClassLoader().getResourceAsStream(filename);
			d.parse(input);
			getLogger().info("Caricamento file " + filename + " completato con successo.");
			Tracer.info(LOG, getClass().getName(), method, "file " + filename + " loaded correctly");
		} catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Error in reading file " + filename + " " + e.getMessage());
			throw new RuntimeException("Impossibile leggere il file delle query " + filename);
		} 
	}


}

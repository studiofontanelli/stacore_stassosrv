package it.csi.stacore.stassosrv.integration.dao.oracle.util;

import java.util.HashMap;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class OracleQuery {
  //~ Instance fields ==========================================================

  /**
	 * @uml.property  name="name"
	 */
  private String  name;
  /**
	 * @uml.property  name="query"
	 */
  private String  query;
  /**
	 * @uml.property  name="body"
	 */
  private String  body;
  /**
	 * @uml.property  name="from"
	 */
  private String  from;
  /**
	 * @uml.property  name="where"
	 */
  private String  where;
  /**
	 * @uml.property  name="orderBy"
	 */
  private String  orderBy;
  /**
	 * @uml.property  name="paramFrom"
	 */
  private HashMap paramFrom  = new HashMap();
  /**
	 * @uml.property  name="paramWhere"
	 */
  private HashMap paramWhere = new HashMap();
  /**
	 * @uml.property  name="paramOrderBy"
	 */
  private HashMap paramOrderBy = new HashMap();
  /**
	 * @uml.property  name="fieldBody"
	 */
  private HashMap fieldBody  = new HashMap();

  //~ Methods ==================================================================

  /**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="name"
	 */
  public String getName() {
    return name;
  }

  /**
	 * DOCUMENT ME!
	 * @param name  DOCUMENT ME!
	 * @uml.property  name="name"
	 */
  public void setName(String name) {
    this.name = name;
  }

  /**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="query"
	 */
  public String getQuery() {
    return query;
  }

  /**
	 * DOCUMENT ME!
	 * @param query  DOCUMENT ME!
	 * @uml.property  name="query"
	 */
  public void setQuery(String query) {
    this.query = query;
  }

  /**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="body"
	 */
  public String getBody() {
    return body;
  }

  /**
	 * DOCUMENT ME!
	 * @param body  DOCUMENT ME!
	 * @uml.property  name="body"
	 */
  public void setBody(String body) {
    this.body = addEnter(body);
  }

  /**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="from"
	 */
  public String getFrom() {
    return from;
  }

  /**
	 * DOCUMENT ME!
	 * @param from  DOCUMENT ME!
	 * @uml.property  name="from"
	 */
  public void setFrom(String from) {
    this.from = addEnter(from);
  }

  /**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="where"
	 */
  public String getWhere() {
    return where;
  }

  /**
	 * DOCUMENT ME!
	 * @param where  DOCUMENT ME!
	 * @uml.property  name="where"
	 */
  public void setWhere(String where) {
    this.where = addEnter(where);
  }

  /**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="orderBy"
	 */
  public String getOrderBy() {
    return orderBy;
  }

  /**
	 * DOCUMENT ME!
	 * @param orderBy  DOCUMENT ME!
	 * @uml.property  name="orderBy"
	 */
  public void setOrderBy(String orderBy) {
    this.orderBy = addEnter(orderBy);
  }

  /**
   * DOCUMENT ME!
   *
   * @param id DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getParamFrom(String id) {
    return getParam(paramFrom, id);
  }

  /**
   * DOCUMENT ME!
   *
   * @param id DOCUMENT ME!
   * @param value DOCUMENT ME!
   */
  public void setParamFrom(String id, String value) {
    this.setParam(paramFrom, id, value);
  }

  /**
   * DOCUMENT ME!
   *
   * @param id DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getParamWhere(String id) {
    return getParam(paramWhere, id);
  }

  /**
   * DOCUMENT ME!
   *
   * @param id DOCUMENT ME!
   * @param value DOCUMENT ME!
   */
  public void setParamWhere(String id, String value) {
    this.setParam(paramWhere, id, value);
  }

  /**
   * DOCUMENT ME!
   *
   * @param id DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getParamOrderBy(String id) {
	  return getParam(paramOrderBy, id);
  }

  /**
   * DOCUMENT ME!
   *
   * @param id DOCUMENT ME!
   * @param value DOCUMENT ME!
   */
  public void setParamOrderBy(String id, String value) {
	  this.setParam(paramOrderBy, id, value);
  }

  /**
   * DOCUMENT ME!
   *
   * @param id DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getFieldBody(String id) {
    return getParam(fieldBody, id);
  }

  /**
   * DOCUMENT ME!
   *
   * @param id DOCUMENT ME!
   * @param value DOCUMENT ME!
   */
  public void setFieldBody(String id, String value) {
    this.setParam(fieldBody, id, value);
  }

  private String getParam(HashMap map, String id) {
    return (String) map.get(id);
  }

  private void setParam(HashMap map, String id, String value) {
    map.put(id, addEnter(value));
  }

  /**
   * aggiunge se non presente un \n al termine della riga
   *
   * @param str
   *
   * @return
   */
  private String addEnter(String str) {
    if(str != null) {
      if(!str.endsWith("\n")) {
        str += "\n";
      }
    }

    return str;
  }

  public String toString() {
    return ReflectionToStringBuilder.toString(this);
}
}

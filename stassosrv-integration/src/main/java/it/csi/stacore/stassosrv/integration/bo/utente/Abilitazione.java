/*
 * Created on 18-lug-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package it.csi.stacore.stassosrv.integration.bo.utente;

import java.io.Serializable;
import java.util.List;


/**
 * @author fguglielmelli
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Abilitazione implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8610850501601424599L;

	/**
	 * @associates    <{it.csi.stacore.staon.business.bo.utente.Ente}>
	 * @directed    directed
	 * @supplierCardinality    1
	 * @uml.property  name="ente"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	Ente ente = null;

	/**
	 * @associates    <{it.csi.stacore.staon.business.bo.utente.Sportello}>
	 * @directed    directed
	 * @supplierCardinality    0..*
	 * @uml.property  name="sportelloList"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="it.csi.stacore.staon.business.bo.utente.Sportello"
	 */
	List sportelloList =null;

	/**
	 * @associates    <{it.csi.stacore.staon.business.bo.utente.Cassa}>
	 * @directed    directed
	 * @supplierCardinality    0..*
	 * @uml.property  name="cassaList"
	 */
	List cassaList =null;

	/**
	 * @param cassaList  The cassaList to set.
	 * @uml.property  name="cassaList"
	 */
	public void setCassaList(List cassaList) {
		this.cassaList = cassaList;
	}
	/**
	 * @param ente  The ente to set.
	 * @uml.property  name="ente"
	 */
	public void setEnte(Ente ente) {
		this.ente = ente;
	}
	/**
	 * @param sportelloList  The sportelloList to set.
	 * @uml.property  name="sportelloList"
	 */
	public void setSportelloList(List sportelloList) {
		this.sportelloList = sportelloList;
	}
	/**
	 * @return  Returns the cassa.
	 * @uml.property  name="cassaList"
	 */
	public List getCassaList() {
		return cassaList;
	}
	/**
	 * @return  Returns the ente.
	 * @uml.property  name="ente"
	 */
	public Ente getEnte() {
		return ente;
	}
	/**
	 * @return  Returns the sportelloList.
	 * @uml.property  name="sportelloList"
	 */
	public List getSportelloList() {
		return sportelloList;
	}
	public Abilitazione(List sportelloList, List cassaList, Ente ente) {
		this.ente = ente;
		this.sportelloList = sportelloList;
		this.cassaList = cassaList;
	}
	public Abilitazione(List idSportelloList, List idCassaList, Long idEnte) {
		this.ente = new Ente(idEnte);
		this.sportelloList = idSportelloList;
		this.cassaList = idCassaList;
		
	}

}

/*
 * Created on 21-lug-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package it.csi.stacore.stassosrv.integration.dao;


import it.csi.stacore.stassosrv.integration.bo.utente.Abilitazione;
import it.csi.stacore.stassosrv.integration.bo.utente.Utente;
import it.csi.stacore.stassosrv.integration.exception.ResourceAccessException;


/**
 * @author fguglielmelli
 * @author andreafontanelli refactoring
 * 
 *
 * 
 */
public interface UtenteDao {

	
	
	public Abilitazione getAbilitazione (String idUtente) throws ResourceAccessException;
	
	public Abilitazione findAbilitazioniPerUtente( String idUtente) throws ResourceAccessException;

	public Utente findUtente(Utente utente) throws ResourceAccessException;

	public Utente loadUtenteById(String idUtente) throws ResourceAccessException;

	
	
}

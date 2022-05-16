/*
 * Created on 21-lug-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package it.csi.stacore.stassosrv.integration.dao.oracle;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import it.csi.stacore.stassosrv.integration.bo.utente.Abilitazione;
import it.csi.stacore.stassosrv.integration.bo.utente.AbilitazioneList;
import it.csi.stacore.stassosrv.integration.bo.utente.Cassa;
import it.csi.stacore.stassosrv.integration.bo.utente.Ente;
import it.csi.stacore.stassosrv.integration.bo.utente.Sportello;
import it.csi.stacore.stassosrv.integration.bo.utente.Utente;
import it.csi.stacore.stassosrv.integration.bo.utente.id.IdDecodifica;
import it.csi.stacore.stassosrv.integration.dao.AbstractDAO;
import it.csi.stacore.stassosrv.integration.dao.UtenteDao;
import it.csi.stacore.stassosrv.integration.dao.oracle.query.select.utente.SelectAbilitazioneList;
import it.csi.stacore.stassosrv.integration.dao.oracle.query.select.utente.SelectCassabySportello;
import it.csi.stacore.stassosrv.integration.dao.oracle.query.select.utente.SelectEnte;
import it.csi.stacore.stassosrv.integration.dao.oracle.query.select.utente.SelectSportellobyEnte;
import it.csi.stacore.stassosrv.integration.dao.oracle.query.select.utente.SelectUtenteById;
import it.csi.stacore.stassosrv.integration.exception.ResourceAccessException;
import it.csi.stacore.stassosrv.util.Tracer;
import it.csi.stacore.stassosrv.util.XmlSerializer;

/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */

@Repository
public class OracleUtenteDAO extends AbstractDAO implements UtenteDao {

	@Override
	public Abilitazione findAbilitazioniPerUtente(String idUtente) throws ResourceAccessException {
		String method = "findAbilitazioniPerUtente";
		Tracer.debug(LOG, getClass().getName(), method, "BEGIN");
		Abilitazione abilitazione = null;
		Connection connection = null;
		try{
			connection = getConnection();

			if(1==2) {
				throw new SQLException("ROMPO TUTTO");
			}

			abilitazione = getAbilitazione(idUtente);





		}
		catch (SQLException e) {
			Tracer.error(LOG, getClass().getName(), method, "SQLException " + e);
			throw new ResourceAccessException(method, e);
		}
		finally{
			Tracer.debug(LOG, getClass().getName(), method, "END");
			releaseConnection(connection);
		}
		return abilitazione;
	}

	@Override
	public Utente findUtente(Utente utente) throws ResourceAccessException {
		// TODO Auto-generated method stub
		return null;
	}


	private void riempiSportelliConCasse(final List sportelloList) throws ResourceAccessException{
		String method = "riempiSportelliConCasse";
		Tracer.debug(LOG, getClass().getName(), method, "BEGIN");
		Connection connection = null;
		try{
			connection = getConnection();
			SelectCassabySportello selectCassabySportello = new SelectCassabySportello(sportelloList);
			List casseList = selectCassabySportello.executeMultipla(connection);

			//// Collego ogni cassa allo sportello relativo
			// Step 1 - Metto in una map idSportello->sportello
			Map sportelliMap = new HashMap(sportelloList.size());
			for (Iterator iter = sportelloList.iterator(); iter.hasNext();) {
				Sportello sportello = (Sportello) iter.next();
				IdDecodifica idDecodifica=sportello.getId();
				if (idDecodifica!=null)
					sportelliMap.put(new Long(idDecodifica.getId()), sportello);
				else 
					Tracer.warn(LOG, getClass().getName(), method, "Caricato uno sportello con id nullo!");
			}
			// Step 2 - Associo ogni cassa allo sportello corretto 
			for (Iterator iter = casseList.iterator(); iter.hasNext();) {
				Cassa cassa = (Cassa) iter.next();

				Long idSportello=cassa.getIdSportello();
				Sportello sportello = (Sportello) sportelliMap.get(idSportello);

				if (sportello.getCassaList()==null) 
					sportello.setCassaList(new ArrayList());
				sportello.getCassaList().add(cassa);
			}
		}
		catch (Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
			throw new ResourceAccessException(method, e);
		}
		finally{
			Tracer.debug(LOG, getClass().getName(), method, "END");
			releaseConnection(connection);
		}
	}

	@Override
	public Utente loadUtenteById(String idUtente) throws ResourceAccessException {
		String method = "loadUtenteById";
		Tracer.debug(LOG, getClass().getName(), method, "BEGIN");
		Utente utente = null;
		Connection connection = null;
		try{
			connection = getConnection();
			SelectUtenteById selectUtenteById = new SelectUtenteById(idUtente);
			utente = (Utente) selectUtenteById.execute(connection);

			if(LOG.isDebugEnabled()) {
				Tracer.debug(LOG, getClass().getName(), method, "utente\n " + XmlSerializer.objectToXml(utente));
			}

			SelectEnte selectEnte = new SelectEnte(utente.getEnte().getId());
			Ente ente=(Ente)selectEnte.execute(connection);

			SelectSportellobyEnte selectSportellobyEnte=new SelectSportellobyEnte(ente);
			List<Sportello> sportelloList = selectSportellobyEnte.executeMultipla(connection);

			if(LOG.isDebugEnabled()) {
				Tracer.debug(LOG, getClass().getName(), method, "ente\n " + XmlSerializer.objectToXml(ente));
			}

			SelectCassabySportello selectCassabySportello = new SelectCassabySportello(sportelloList);
			List<Cassa> casseList = selectCassabySportello.executeMultipla(connection);


			//// Collego ogni cassa allo sportello relativo
			// Step 1 - Metto in una map idSportello->sportello
			Map sportelliMap = new HashMap(sportelloList.size());
			for (Iterator iter = sportelloList.iterator(); iter.hasNext();) {
				Sportello sportello = (Sportello) iter.next();
				IdDecodifica idDecodifica=sportello.getId();
				if (idDecodifica!=null)
					sportelliMap.put(new Long(idDecodifica.getId()), sportello);
				else 
					Tracer.warn(LOG, getClass().getName(), method, "Caricato uno sportello con id nullo!");
			}
			// Step 2 - Associo ogni cassa allo sportello corretto 
			for (Iterator iter = casseList.iterator(); iter.hasNext();) {
				Cassa cassa = (Cassa) iter.next();

				Long idSportello=cassa.getIdSportello();
				Sportello sportello = (Sportello) sportelliMap.get(idSportello);

				if (sportello.getCassaList()==null) 
					sportello.setCassaList(new ArrayList());
				sportello.getCassaList().add(cassa);
			}


			ente.setSportello(sportelloList);

			Tracer.debug(LOG, getClass().getName(), method, "Caricato l'ente: " + ente);


			Abilitazione abilitazione = findAbilitazioniPerUtente(idUtente);

			utente.setAbilitazione(abilitazione);
			utente.setEnte(ente);

			Tracer.debug(LOG, getClass().getName(), method, "Caricato l'utente: " + utente);



		}
		catch (SQLException e) {
			Tracer.error(LOG, getClass().getName(), method, "SQLException " + e);
			throw new ResourceAccessException(method, e);
		}
		finally{
			Tracer.debug(LOG, getClass().getName(), method, "END");
			releaseConnection(connection);
		}
		return utente;
	}

	@Override
	public Abilitazione getAbilitazione(String idUtente) throws ResourceAccessException {
		String method = "getAbilitazione";
		Tracer.debug(LOG, getClass().getName(), method, "BEGIN");
		Abilitazione abilitazione = null;
		Connection connection = null;
		try{
			connection = getConnection();
			SelectAbilitazioneList select = new SelectAbilitazioneList(idUtente);
			List abilitazioneList = select.executeMultipla(connection);

			List cassaList = new ArrayList();
			List sportelloList = new ArrayList();
			Ente ente = null;
			for (Iterator iter = abilitazioneList.iterator(); iter.hasNext();) {
				AbilitazioneList abList = (AbilitazioneList) iter.next();

				if (abList.getIdCassa() != null) {
					Cassa cassa = new Cassa(abList.getIdCassa(), null, null, null);
					cassaList.add(cassa);

				} else if (abList.getIdSportello() != null) {
					Sportello sportello = new Sportello(abList.getIdSportello(), null, null, null, null, (Integer)null, null, null, "", "");
					sportelloList.add(sportello);
				} else if (abList.getIdEnte() != null) {
					ente = new Ente(abList.getIdEnte(), null, null, null, null, null, null, null, null, "", "", null, null);
				}
			}
			abilitazione=new Abilitazione(sportelloList,cassaList,ente);
		}
		catch (Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "SQLException " + e);
			throw new ResourceAccessException(method, e);
		}
		finally{
			Tracer.debug(LOG, getClass().getName(), method, "END");
			releaseConnection(connection);
		}
		return abilitazione;
	}



}

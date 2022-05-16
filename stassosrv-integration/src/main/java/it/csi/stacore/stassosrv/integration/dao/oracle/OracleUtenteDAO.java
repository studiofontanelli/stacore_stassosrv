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
import it.csi.stacore.stassosrv.integration.dao.oracle.query.select.utente.SelectCasseByIdCasse;
import it.csi.stacore.stassosrv.integration.dao.oracle.query.select.utente.SelectEnte;
import it.csi.stacore.stassosrv.integration.dao.oracle.query.select.utente.SelectSportellobyAbilitazione;
import it.csi.stacore.stassosrv.integration.dao.oracle.query.select.utente.SelectSportellobyEnte;
import it.csi.stacore.stassosrv.integration.dao.oracle.query.select.utente.SelectUtenteById;
import it.csi.stacore.stassosrv.integration.exception.InvalidSearchObjectException;
import it.csi.stacore.stassosrv.integration.exception.ResourceAccessException;
import it.csi.stacore.stassosrv.util.Tracer;


@Repository("oracleUtenteDAO")
public class OracleUtenteDAO extends AbstractDAO implements UtenteDao {


	@Override
	public Abilitazione getAbilitazione(String idUtente) throws ResourceAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Abilitazione findAbilitazioniPerUtente(String idUtente) throws ResourceAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente findUtente(Utente utente) throws ResourceAccessException {
		// TODO Auto-generated method stub
		return null;
	}


	private void riempiSportelliConCasse(final Connection connection, final List sportelloList) throws SQLException, InvalidSearchObjectException {
		// Recupero le casse relative ad ogni sportello
		final String method = "riempiSportelliConCasse";
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
			else {
				Tracer.warn(LOG, getClass().getName(), method, "caricato uno sportello con id nullo!");
			}
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
	
	private Abilitazione getAbilitazione(Connection connection, String idUtente) throws ResourceAccessException {
	    final String method = "getAbilitazione";
		SelectAbilitazioneList select = new SelectAbilitazioneList(idUtente);
	    try {
	      List abilitazioneList = select.executeMultipla(connection);

	      Abilitazione abilitazione = null;

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

	      return abilitazione;
	    } catch (SQLException e) {
	    	Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
			throw new ResourceAccessException(e.getMessage(), e);
			
	    }
	  }

	
	public Abilitazione findAbilitazioniPerUtente(Connection connection, String idUtente) throws ResourceAccessException {
	    final String method = "findAbilitazioniPerUtente";
	    
		Abilitazione abilitazione = getAbilitazione(connection, idUtente);
	    try {

	      if (abilitazione.getCassaList() != null && !abilitazione.getCassaList().isEmpty()) {
	        // Recupero le casse direttamente collegate
	        SelectCasseByIdCasse selectCassa = new SelectCasseByIdCasse(abilitazione.getCassaList());
	        abilitazione.setCassaList(selectCassa.executeMultipla(connection));
	      } 
	      
	      if (abilitazione.getSportelloList() != null && !abilitazione.getSportelloList().isEmpty()) {
	        // Recupero gli sportelli direttamente collegati
	        SelectSportellobyAbilitazione selectSportello = new SelectSportellobyAbilitazione(abilitazione.getSportelloList());
	        abilitazione.setSportelloList(selectSportello.executeMultipla(connection));

	        List sportelloList = abilitazione.getSportelloList();
	        riempiSportelliConCasse(connection, sportelloList);
	      }
	      
	      if (abilitazione.getEnte() != null) {
	        Ente ente = abilitazione.getEnte(); 
	        // Recupero l'ente collegato
	        SelectEnte selectEnte = new SelectEnte(abilitazione.getEnte().getId());
	        abilitazione.setEnte((Ente) selectEnte.execute(connection));

	        SelectSportellobyEnte selectSportello = new SelectSportellobyEnte(ente);
	        List sportelliCollegatiAEnte = selectSportello.executeMultipla(connection);
	        riempiSportelliConCasse(connection, sportelliCollegatiAEnte);
	        ente.setSportello(sportelliCollegatiAEnte);
	      }
	      return abilitazione;
	    } catch (SQLException e) {
	    	Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
			throw new ResourceAccessException(e.getMessage(), e);
	    }
	}
	@Override
	public Utente loadUtenteById(String idUtente) throws ResourceAccessException {
		final String method = "loadUtenteById";
		Tracer.debug(LOG, getClass().getName(), method, "BEGIN");
		Connection connection = null;
		Utente result= null;
		try{
			connection = getConnection();


			SelectUtenteById selectUtenteById = new SelectUtenteById(idUtente);
			result = (Utente) selectUtenteById.execute(connection);

			SelectEnte selectEnte = new SelectEnte(result.getEnte().getId());
			Ente ente=(Ente)selectEnte.execute(connection);

			SelectSportellobyEnte selectSportellobyEnte=new SelectSportellobyEnte(ente);
			List sportelliList=selectSportellobyEnte.executeMultipla(connection);

			riempiSportelliConCasse(connection,sportelliList);
			ente.setSportello(sportelliList);


			Tracer.debug(LOG, getClass().getName(), method, "Caricato l'ente: " + ente);   
			

			Abilitazione abilitazione = findAbilitazioniPerUtente(connection,idUtente);
			result.setAbilitazione(abilitazione);
			result.setEnte(ente);
			


		}catch (Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
			throw new ResourceAccessException(e.getMessage(), e);
		}
		finally{
			releaseConnection(connection);
			Tracer.debug(LOG, getClass().getName(), method, "END");
		}
		return result;

	}
}

/*
 *  SelectUtenteById selectUtenteById = new SelectUtenteById(idUtente);
      result = (Utente) selectUtenteById.execute(connection);

      SelectEnte selectEnte = new SelectEnte(result.getEnte().getId());
      Ente ente=(Ente)selectEnte.execute(connection);

      SelectSportellobyEnte selectSportellobyEnte=new SelectSportellobyEnte(ente);
      List sportelliList=selectSportellobyEnte.executeMultipla(connection);

      riempiSportelliConCasse(connection,sportelliList);
      ente.setSportello(sportelliList);

      getLogger().debug("Caricato l'ente: " + ente);

      Abilitazione abilitazione = findAbilitazioniPerUtente(connection,idUtente);
      result.setAbilitazione(abilitazione);
      result.setEnte(ente);

      getLogger().debug("Caricato l'utente: " + result);

    } catch (SQLException e) {
      if (getLogger().isErrorEnabled()) {
        getLogger().error("SQLException find: " + e.getMessage(), e);
      }

      throw new ResourceAccessException("OracleUtenteDAO.loadUtenteById", e);
    }

 */




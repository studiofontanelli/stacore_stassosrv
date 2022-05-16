package it.csi.stacore.stassosrv.integration.dao.oracle.query.select.utente;



import java.sql.SQLException;
import java.util.Date;

import it.csi.stacore.stassosrv.integration.bo.utente.Ente;
import it.csi.stacore.stassosrv.integration.bo.utente.Utente;
import it.csi.stacore.stassosrv.integration.bo.utente.id.IdDecodifica;
import it.csi.stacore.stassosrv.integration.dao.oracle.query.select.AbstractSelect;
import it.csi.stacore.stassosrv.integration.dao.oracle.query.select.TAURDEResultSet;
import it.csi.stacore.stassosrv.integration.dao.oracle.query.select.TauPreparedStatement;
import it.csi.stacore.stassosrv.integration.dao.oracle.util.OracleQuery;
import it.csi.stacore.stassosrv.integration.dao.oracle.util.OracleQueryList;
import it.csi.stacore.stassosrv.integration.exception.InvalidSearchObjectException;

public class SelectEnte extends AbstractSelect {
    
	/**
	 * @uml.property  name="idEnte"
	 * @uml.associationEnd  
	 */
	private IdDecodifica idEnte = null;
	
	private Long idSportello = null;
	
	private Boolean abilitazioneRiscossione = null;
	
    public SelectEnte() {}
	
	public SelectEnte(IdDecodifica idEnte) {
		this.idEnte = idEnte;
	}
	
	public SelectEnte(Long idSportello) {
		this.idSportello = idSportello;
	}
    
	public SelectEnte(Utente utente) {
		this.idEnte = utente.getEnte().getId();
	}
    
	public SelectEnte(Boolean abilitazioneRiscossione) {
		this.abilitazioneRiscossione = abilitazioneRiscossione;
	}
	
	public Object createBO(TAURDEResultSet rs) throws SQLException {
	    
	    Long idEnte=rs.getLong("ENTE_ID_ENTE");
	    String email=rs.getString("ENTE_EMAIL");
	    String indirizzo=rs.getString("ENTE_INDIRIZZO");
	    String civico=rs.getString("ENTE_CIVICO");
	    Integer cap=rs.getInteger("ENTE_CAP");
	    String comune=rs.getString("ENTE_COMUNE");
	    String codiceFiscale=rs.getString("ENTE_CODICE_FISCALE");
	    String provincia=rs.getString("ENTE_PROVINCIA");
	    String siglaTop=rs.getString("ENTE_SIGLATOP");
	    String codice=rs.getString("ENTE_CODICE");
	    String descrizione=rs.getString("ENTE_DESCRIZIONE");
	    Date dataInizioAttivita=rs.getDate("ENTE_DATA_INIZIO_ATTIVITA");
	    Boolean isRiscossione = rs.getBooleanFromFlag("ABILITAZIONE_RISCOSSIONE");

	    Ente ente = new Ente(idEnte, email, indirizzo, civico, cap, comune, codiceFiscale,
				provincia, siglaTop, codice, descrizione, dataInizioAttivita, isRiscossione);

		return ente;
	}

	public void setPreparedStatement(TauPreparedStatement stmt)
		throws SQLException {
	    
	    if(idEnte != null) {
		    int iPos = 1;
		    stmt.setLong(iPos++, idEnte.getId());
	    }

	    if(abilitazioneRiscossione != null) {
	    	int iPos = 1;
	    	stmt.setFlagFromBoolean(iPos++, abilitazioneRiscossione);
	    }
	    
	    if(idSportello != null) {
	    	int iPos = 1;
	    	stmt.setLong(iPos++, idSportello);
	    }
	    
	} 
	
	public String getSQLStatement() throws InvalidSearchObjectException {
	    
	    OracleQuery q = OracleQueryList.getInstance().getQuery(getClass().getName());
	    String query = q.getBody();
	    
	    if(idEnte != null) {
		    query += q.getWhere();
            query += q.getParamWhere("idEnte");
	    }
	    
	    if(abilitazioneRiscossione != null) {
	    	query += q.getWhere();
	    	query += q.getParamWhere("abilitazioneRiscossione");
	    }
	    
	    if(idSportello != null) {
	    	query += q.getWhere();
	    	query += q.getParamWhere("idSportello");
	    }
	    
	    return query;
	}
	
	
}
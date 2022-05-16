package it.csi.stacore.stassosrv.integration.dao.oracle.query.select.utente;

import java.sql.SQLException;

import it.csi.stacore.stassosrv.integration.bo.utente.Ente;
import it.csi.stacore.stassosrv.integration.bo.utente.TipoUtente;
import it.csi.stacore.stassosrv.integration.bo.utente.Utente;
import it.csi.stacore.stassosrv.integration.bo.utente.id.IdDecodifica;
import it.csi.stacore.stassosrv.integration.dao.oracle.query.select.AbstractSelect;
import it.csi.stacore.stassosrv.integration.dao.oracle.query.select.TAURDEResultSet;
import it.csi.stacore.stassosrv.integration.dao.oracle.query.select.TauPreparedStatement;

/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class SelectUtenteById extends AbstractSelect {
	//~ Instance fields ==========================================================

	/**
	 * @uml.property  name="idUtente"
	 */
	private String idUtente;

	//~ Constructors =============================================================

	/**
	 * Creates a new SelectContributoById object.
	 *
	 * @param idContributo DOCUMENT ME!
	 */
	public SelectUtenteById(String idUtente) {
		super();
		this.idUtente = idUtente;
	}

	//~ Methods ==================================================================

	/**
	 * DOCUMENT ME!
	 *
	 * @param stmt DOCUMENT ME!
	 *
	 * @throws SQLException DOCUMENT ME!
	 */
	protected void setPreparedStatement(TauPreparedStatement stmt) throws SQLException {
		int iPos = 1;
		stmt.setUpperCaseString(iPos++, idUtente);
	}

	/**
	 * crea il BO Contributo
	 *
	 * @param rs 
	 *
	 * @return Contributo
	 *
	 * @throws SQLException 
	 */
	public Object createBO(TAURDEResultSet rs) throws SQLException {
		String idUtente = rs.getString("IDENTIFICATIVO_UTENTE");
		String cognome = rs.getString("COGNOME");
		String nome = rs.getString("NOME");
		Long idEnte = rs.getLong("ID_ENTE");
		Long idTipoUtente = rs.getLong("ID_TIPOUTENTE");
		String tipoUtenteCodice = rs.getString("TIPO_UTENTE_CODICE");
		String tipoUtenteDescrizione = rs.getString("TIPO_UTENTE_DESCRIZIONE");
		String abilitazionePagamentoManuale = rs.getString("ABILITAZIONE_PAGAMENTO_MANUALE");

		TipoUtente tipoUtente = new TipoUtente(new IdDecodifica(idTipoUtente.longValue()), tipoUtenteCodice, tipoUtenteDescrizione);

		Ente ente = new Ente(idEnte, null, null, null, (Integer) null, null, null, null, null, "", "", null, null);
		Utente result = new Utente(idUtente, null, null, tipoUtente, ente, cognome, null, null, null, abilitazionePagamentoManuale);

		return result;
	}

}

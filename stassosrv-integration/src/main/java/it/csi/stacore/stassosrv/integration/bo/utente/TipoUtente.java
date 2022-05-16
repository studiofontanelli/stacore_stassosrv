package it.csi.stacore.stassosrv.integration.bo.utente;

import it.csi.stacore.stassosrv.integration.bo.Decodifica;
import it.csi.stacore.stassosrv.integration.bo.utente.id.IdDecodifica;
import it.csi.stacore.stassosrv.integration.util.EqualsUtil;

/**
 * @author fguglielmelli
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class TipoUtente extends Decodifica implements java.io.Serializable {

	private static final long serialVersionUID = -8647678399752831028L;

	public final static TipoUtente TIPO_UTENTE_OPERATORE = new TipoUtente(
			new IdDecodifica(1L), "OP", "Operatore");

	public final static TipoUtente TIPO_UTENTE_APPLICATIVO = new TipoUtente(
			new IdDecodifica(2L), "AP", "Applicativo");

	public final static TipoUtente TIPO_UTENTE_BATCH = new TipoUtente(
			new IdDecodifica(3L), "BA", "Batch");

	// TODO [Ivano Canella] Da mappare sul DB
	public final static TipoUtente TIPO_UTENTE_INTERREGIONALE = new TipoUtente(
			new IdDecodifica(1L), "OP", "Interregionale");

	public TipoUtente(IdDecodifica idDecodifica, String codice,
			String descrizione) {
		super(idDecodifica, codice, descrizione);
	}

	public boolean equals(Object object) {
		boolean equals = false;
		if (object != null && object instanceof TipoUtente) {
			TipoUtente altro = (TipoUtente) object;
			equals = EqualsUtil.objectEquals(getId(), altro.getId())
					&& EqualsUtil.objectEquals(getCodice(), altro.getCodice())
					&& EqualsUtil.objectEquals(getDescrizione(), altro
							.getDescrizione());
		}
		return equals;
	}

}
package it.csi.stacore.stassosrv.business.helper;

import it.csi.stacore.stassosrv.api.dto.Utente;
import it.csi.stacore.stassosrv.business.exception.HelperException;

public interface IrideHelper {

	public boolean testResources() throws HelperException;
	
	public Utente getUtente(String token) throws HelperException;
	
}

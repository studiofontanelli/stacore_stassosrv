package it.csi.stacore.stassosrv.integration.service;

import java.util.List;

import it.csi.iride2.policy.base.nmsf.stub.base.entity.Identita;
import it.csi.iride2.policy.base.nmsf.stub.base.entity.UseCase;
import it.csi.stacore.stassosrv.integration.exception.IntegrationException;

public interface IrideService {
	
	
	public static final String CODICE_APPLICATION_IRIDE = "STA";
	
	
	
	
	/**
	 * 
	 * @param identita
	 * @param application
	 * @return
	 * @throws IntegrationException
	 */
	public List<UseCase> findUseCasesForPersonaInApplication(Identita identita) throws IntegrationException;
	
	
	
	
	
}

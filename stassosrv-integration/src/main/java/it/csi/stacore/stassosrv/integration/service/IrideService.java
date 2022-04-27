package it.csi.stacore.stassosrv.integration.service;

import it.csi.stacore.stassosrv.integration.exception.IntegrationException;

public interface IrideService {
	
	
	/**
	 * 
	 * @return
	 * @throws IntegrationException
	 */
	public boolean testResources() throws IntegrationException;
	
}

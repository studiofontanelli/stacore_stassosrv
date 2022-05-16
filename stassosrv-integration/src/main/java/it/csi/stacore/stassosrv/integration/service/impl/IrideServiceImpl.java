package it.csi.stacore.stassosrv.integration.service.impl;



import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.iride2.policy.base.nmsf.stub.base.entity.Application;
import it.csi.iride2.policy.base.nmsf.stub.base.entity.Identita;
import it.csi.iride2.policy.base.nmsf.stub.base.entity.UseCase;
import it.csi.iride2.policy.base.nmsf.stub.interf.PolicyEnforcerBase;
import it.csi.iride2.policy.base.nmsf.stub.interf.PolicyEnforcerBaseServiceLocator;
import it.csi.stacore.stassosrv.integration.exception.IntegrationException;
import it.csi.stacore.stassosrv.integration.service.IrideService;
import it.csi.stacore.stassosrv.util.Constants;
import it.csi.stacore.stassosrv.util.Environment;
import it.csi.stacore.stassosrv.util.Tracer;

@Service("irideService")
public class IrideServiceImpl implements IrideService {

	private static final String LOGGER_PREFIX = Constants.APPLICATION_CODE + ".integration";
	protected final static Logger LOG = LoggerFactory.getLogger(LOGGER_PREFIX);
	
	
	private Application application = null;
	
	private PolicyEnforcerBase policyEnforcerBase = null;
	
	@Autowired Environment env;

	@PostConstruct
	public void init() {
		final String method = "init";
		try {
			
			application = new Application(IrideService.CODICE_APPLICATION_IRIDE);
			
			PolicyEnforcerBaseServiceLocator serviceLocator = new PolicyEnforcerBaseServiceLocator();
			
			String url = env.getIrideEndpoint();
			
			Tracer.debug(LOG, getClass().getName(), method, "endpoint iride= " + url);
			
			serviceLocator.setPolicyEnforcerBaseEndpointAddress(url);
			
			policyEnforcerBase =  serviceLocator.getPolicyEnforcerBase();
			
			
			Tracer.info(LOG, getClass().getName(), method, "policyEnforcerBase loaded");
			
			
			
		}
		catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception "  +e);
			throw new RuntimeException(e.getMessage());
		}
		finally {
			
		}
		
	}
	
	


	@Override
	public List<UseCase> findUseCasesForPersonaInApplication(Identita identita) throws IntegrationException {
		final String method = "findUseCasesForPersonaInApplication";
		List<UseCase> result = null;
		try {
			
			UseCase[] userCase = policyEnforcerBase.findUseCasesForPersonaInApplication(identita, application);
			if(userCase != null && userCase.length > 0) {
				result = Arrays.asList(userCase);	
			}
			
			
		}
		catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception "  +e);
			throw new IntegrationException("Problemi con al comunicazione com Iride: " + e.getMessage());
		}
		finally {
			
		}
		return result;
	}
	
	

}

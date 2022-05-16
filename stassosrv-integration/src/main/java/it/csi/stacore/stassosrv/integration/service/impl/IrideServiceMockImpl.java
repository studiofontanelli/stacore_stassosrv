package it.csi.stacore.stassosrv.integration.service.impl;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import it.csi.iride2.policy.base.nmsf.stub.base.entity.Application;
import it.csi.iride2.policy.base.nmsf.stub.base.entity.Identita;
import it.csi.iride2.policy.base.nmsf.stub.base.entity.UseCase;
import it.csi.stacore.stassosrv.integration.exception.IntegrationException;
import it.csi.stacore.stassosrv.integration.service.IrideService;
import it.csi.stacore.stassosrv.util.Tracer;

@Service("irideServiceMock")
public class IrideServiceMockImpl extends IrideServiceImpl  {

	
	@PostConstruct
	public void init() {
		final String method = "init";
		try {
			
			Tracer.info(LOG, getClass().getName(), method, "THIS IS A MOCK: IF YOU SEE THAT IN PROD ENV SWITCH IN PANIC MODE..... IMMEDITIALLY!!!!");
			
			
			
			
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
		List<UseCase> result = new ArrayList<UseCase>();
		try {
			
			Application ap = new Application(IrideService.CODICE_APPLICATION_IRIDE);
			UseCase uc = new UseCase(ap, "MOCK.USECASE");
			result.add(uc);
			
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

package it.csi.stacore.stassosrv.business.helper.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.stacore.stassosrv.business.exception.HelperException;
import it.csi.stacore.stassosrv.business.helper.IrideHelper;
import it.csi.stacore.stassosrv.business.helper.TestResourceHelper;
import it.csi.stacore.stassosrv.integration.exception.IntegrationException;
import it.csi.stacore.stassosrv.integration.service.IrideService;
import it.csi.stacore.stassosrv.util.Tracer;

@Service("testResourceHelper")
public class TestResourceHelperImpl extends CommonHelperImpl implements TestResourceHelper {
	
	
	
	
	@Autowired private IrideService irideService;
	
	@Autowired private IrideHelper irideHelper;
	
	@PostConstruct
	public void init() {
		final String method = "init";
		try {
			Tracer.debug(LOG, getClass().getName(), method, "called");
			
			
			
		}
		catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception "  +e);
		}
		finally {
			
		}
		
	}

	@Override
	public boolean testResources() throws HelperException {
		final String method = "testResources";
		try {
			Tracer.debug(LOG, getClass().getName(), method, "called");
			return irideHelper.testResources();
		} catch (Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
			throw new HelperException(e.getMessage());
		}
		finally {
			
		}
		
	}

	

}

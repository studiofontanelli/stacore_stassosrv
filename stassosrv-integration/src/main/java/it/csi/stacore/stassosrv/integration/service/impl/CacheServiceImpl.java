package it.csi.stacore.stassosrv.integration.service.impl;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import it.csi.stacore.stassosrv.integration.service.CacheService;
import it.csi.stacore.stassosrv.util.Constants;
import it.csi.stacore.stassosrv.util.Tracer;

@Service("cacheService")
public class CacheServiceImpl implements CacheService {

	private static final String LOGGER_PREFIX = Constants.APPLICATION_CODE + ".integration";
	protected final static Logger LOG = LoggerFactory.getLogger(LOGGER_PREFIX);

	
	
	
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
	
	

}

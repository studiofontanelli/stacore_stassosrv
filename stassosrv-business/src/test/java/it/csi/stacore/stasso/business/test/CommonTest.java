package it.csi.stacore.stasso.business.test;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

import it.csi.stacore.stassosrv.util.ApplicationContextManager;
import it.csi.stacore.stassosrv.util.Constants;
import it.csi.stacore.stassosrv.util.Tracer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/spring-main-junit.xml")
public class CommonTest {

	protected final Logger LOG = LoggerFactory.getLogger(Constants.APPLICATION_CODE);

	@Autowired
	private ApplicationContext applicationContext;

	private ApplicationContextManager applicationContextManager;

	@Before
	public void setUp() throws Exception {
		String method = "setUp";
		try {
			System.out.println("****** SETUP********");
			Log4jConfigurer.initLogging("classpath:log4j.properties");
			Tracer.debug(LOG, getClass().getName(), method, "setting application context");
			applicationContextManager = (ApplicationContextManager) applicationContext.getBean("applicationContextManager");
			applicationContextManager.setApplicationContext(applicationContext);
			if (applicationContext != null) {
				Tracer.info(LOG, getClass().getSimpleName(), method, "application context loaded correctly!!!!");
			}
		}
		
		catch(FileNotFoundException e) { 
			throw new Exception(e.getLocalizedMessage()); 
		}
		finally {

		}

	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

}

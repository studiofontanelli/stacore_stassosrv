package it.csi.stacore.stasso.business.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import it.csi.stacore.stassosrv.business.helper.TestResourceHelper;
import it.csi.stacore.stassosrv.util.Constants;
import it.csi.stacore.stassosrv.util.Tracer;

public class TestResourceHelperTest extends CommonTest{
	
	
	protected final Logger LOG = LoggerFactory.getLogger(Constants.APPLICATION_CODE);


	@Autowired
	TestResourceHelper helper;


	@Test
	public final void testResources() {
		final String method = "testResource";
		Tracer.debug(LOG, getClass().getName(), method, "BEGIN");
		try {
			boolean result = helper.testResources();



			assertTrue(result);
		} catch (Exception e) {
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception: " + e);
			fail();
		}
		finally {
			Tracer.debug(LOG, getClass().getName(), method, "END");
		}

	}

}

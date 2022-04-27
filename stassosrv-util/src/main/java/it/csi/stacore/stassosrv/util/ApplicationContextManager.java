package it.csi.stacore.stassosrv.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextManager implements ApplicationContextAware {

	private final static Logger LOG = LoggerFactory.getLogger(Constants.APPLICATION_CODE);

	private static ApplicationContext appContext;

	// Private constructor prevents instantiation from other classes
	private ApplicationContextManager() {
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		final String method = "setApplicationContext";
		Tracer.info(LOG, getClass().getName(), method, "setting application context " + applicationContext);
		appContext = applicationContext;
	}

	public static Object getBean(String beanName) throws RuntimeException {
		final String method = "getBean";
		try {
			if(appContext == null)
				throw new Exception("appContext is null");
			return appContext.getBean(beanName);
		}
		catch(Exception e) {
			Tracer.error(LOG, ApplicationContextManager.class.getName(), method, "Error in getting bean " + beanName);
			throw new RuntimeException(e.getMessage());
		}
	}

	public static <T> T getBean(Class<T> clazz) {
		return appContext.getBean(clazz);
	}

}

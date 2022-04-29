package it.csi.stacore.stassosrv.api.application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.jaxrs.config.BeanConfig;
import it.csi.stacore.stassosrv.api.interceptor.LoggingInterceptor;
import it.csi.stacore.stassosrv.api.provider.ExceptionHandler;
import it.csi.stacore.stassosrv.util.ApplicationContextManager;
import it.csi.stacore.stassosrv.util.Constants;
import it.csi.stacore.stassosrv.util.Tracer;



@ApplicationPath("/api")
public class StassosrvApplication extends Application {

	protected final static Logger LOG = LoggerFactory.getLogger(Constants.APPLICATION_CODE);

	private Set<Object> singletons = new HashSet<>();
	private Set<Class<?>> classes = new HashSet<>();


	private List<String> getServiceList(){
		List<String> l = new ArrayList<String>();
		l.add("testApi");
		l.add("ssoApi");
		return l;

	}

	private List<Class> getProviderList(){
		List<Class> l = new ArrayList<Class>();
		l.add(ExceptionHandler.class);
		l.add(LoggingInterceptor.class);
		return l;

	}
	
	
	private List<Class> getSwaggerList(){
		List<Class> l = new ArrayList<Class>();
		l.add(io.swagger.jaxrs.listing.ApiListingResource.class);
		l.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
		return l;

	}
	
	/*
	 * 
	 * public RestConfiguration() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("v1");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost(System.getProperty("togus.swagger.host", "localhost:8080"));
        beanConfig.setBasePath(System.getProperty("togus.swagger.basepath", "togus/rest"));
        beanConfig.setResourcePackage("br.com.diegogusava.togus.endpoint");
        beanConfig.setScan(true);
    }
	 * 
	 * 
	 */
	

	public StassosrvApplication() {
		final String method = "CONSTRUCTOR";
		try {

			// Resources
			for(String api : getServiceList()) {
				Tracer.info(LOG, getClass().getName(), method, "adding api " + api);
				this.singletons.add(ApplicationContextManager.getBean(api));
				Tracer.info(LOG, getClass().getName(), method, "api " + api + " added correctly");
			}
			// Providers
			for(Class provider : getProviderList()) {
				Tracer.info(LOG, getClass().getName(), method, "adding provider " + provider);
				classes.add(provider);
			}
			
			// SWAGGER 
		
			for(Class clazz : getSwaggerList()) {
				Tracer.info(LOG, getClass().getName(), method, "adding swagger " + clazz);
				classes.add(clazz);
			}
			
			
			BeanConfig beanConfig = new BeanConfig();
	        beanConfig.setVersion("v1");
	        beanConfig.setSchemes(new String[]{"http"});
	        beanConfig.setHost("localhost:8080");
	        beanConfig.setBasePath("/stassosrv");
	        beanConfig.setResourcePackage("it.csi.stacore.staaudit.api.service");
	        beanConfig.setScan(true);
			
			
			Tracer.info(LOG, getClass().getName(), method, "Startup rest services done correctly!");



		}
		catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception: " + e);
			throw new RuntimeException("Errore infase di startup configurazione servizi rest", e);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.ws.rs.core.Application#getClasses()
	 */
	@Override
	public Set<Class<?>> getClasses() {
		return this.classes;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.ws.rs.core.Application#getSingletons()
	 */
	@Override
	public Set<Object> getSingletons() {
		return this.singletons;
	}
}

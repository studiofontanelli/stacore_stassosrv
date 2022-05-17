package it.csi.stacore.stassosrv.business.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.csi.stacore.stassosrv.util.Constants;
import it.csi.stacore.stassosrv.util.Tracer;
import it.csi.stacore.stassosrv.util.XmlSerializer;
import it.csi.util.performance.StopWatch;


public class CommonAspect {

	protected static final String LOGGER_PREFIX = Constants.APPLICATION_CODE;
	protected final static Logger LOG = LoggerFactory.getLogger(LOGGER_PREFIX);
	protected StopWatch stopWatch = null;

	public Object stopWatchAspect(ProceedingJoinPoint joinPoint, boolean showResult) throws Throwable {
		String className = joinPoint.getTarget().getClass().getName();
		String method = joinPoint.getSignature().getName();
		Tracer.debug(LOG, className, method, "BEGIN");
		stopWatch = new StopWatch(LOGGER_PREFIX);
		try {
			stopWatch.start();
			Object result = joinPoint.proceed();
			if(showResult) {
				if(LOG.isDebugEnabled()) {
					Tracer.debug(LOG, className, method, "out:\n " + XmlSerializer.objectToXml(result));
				}
			}
			return result;
		}
		finally {
			Tracer.debug(LOG, className, method, "END");
			stopWatch.stop();
			stopWatch.dumpElapsed(className, method, "tempo esecuzione di [" +LOGGER_PREFIX+"]::["  + method + "]", "(ASPECT)");
		}
	}
	
	public Object logAspect(ProceedingJoinPoint joinPoint) throws Throwable {
		String className = joinPoint.getTarget().getClass().getName();
		String method = joinPoint.getSignature().getName();
		Tracer.debug(LOG, className, method, "BEGIN");
		stopWatch = new StopWatch(LOGGER_PREFIX);
		try {
			return joinPoint.proceed();
		}
		finally {
			Tracer.debug(LOG, className, method, "END");
		}
	}

	public Object stopWatchAspect(ProceedingJoinPoint joinPoint) throws Throwable {
		return stopWatchAspect(joinPoint, false);
	}

	public void beforeAspect(JoinPoint joinPoint) throws Throwable {

		String className = joinPoint.getTarget().getClass().getSimpleName();
		String method = joinPoint.getSignature().getName();
		if(LOG.isDebugEnabled()) {
			Tracer.debug(LOG, className, method, "in:");
			for(int i = 0; i<joinPoint.getArgs().length; i++ ) {
				Tracer.debug(LOG, className, method, "arg[" + i + "]:\n " + XmlSerializer.objectToXml(joinPoint.getArgs()[i]));
			}
		}
	}


	public void afterAspect(JoinPoint joinPoint) throws Throwable {
		String className = joinPoint.getTarget().getClass().getSimpleName();
		String method = joinPoint.getSignature().getName();


		Tracer.debug(LOG, className, method, "afterAspect....");


	}

	public void afterThrowingAspect(JoinPoint joinPoint, Exception ex) throws Throwable {

		String className = joinPoint.getTarget().getClass().getSimpleName();
		String method = joinPoint.getSignature().getName();

		Tracer.error(LOG, className, method, "ASPECT TRACER");
		Tracer.error(LOG, className, method, "Si e' verificato un errore: " + ex);
		Tracer.info(LOG, className, method, "trace params:");
		for(int i = 0; i<joinPoint.getArgs().length; i++ ) {
			Tracer.info(LOG, className, method, "arg[" + i + "]: " + XmlSerializer.objectToXml(joinPoint.getArgs()[i]));
		}
		//throw new HelperException(ex.getMessage(), ex);
		throw ex;

	}


}
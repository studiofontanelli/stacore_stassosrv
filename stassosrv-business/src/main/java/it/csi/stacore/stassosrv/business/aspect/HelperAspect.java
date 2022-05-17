package it.csi.stacore.stassosrv.business.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import it.csi.stacore.stassosrv.business.exception.HelperException;
import it.csi.stacore.stassosrv.util.Constants;
import it.csi.stacore.stassosrv.util.Tracer;
import it.csi.stacore.stassosrv.util.XmlSerializer;


@Component("helperAspect")
@Aspect
public class HelperAspect extends CommonAspect{

	public static final String LOGGER_PREFIX = Constants.APPLICATION_CODE + ".aspect";

	@Around(value = "execution(* it.csi.stacore.stassosrv.business.helper.impl..*.*(..))", argNames = "joinPoint")
	public Object stopWatchMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		if(1==12)
			throw new Exception("STOP EVERYTHING");
		
		return super.stopWatchAspect(joinPoint);
	}
	
	@Before(value="execution(* it.csi.stacore.stassosrv.business.helper.impl..*.*(..))")
	public void beforeAspect(JoinPoint joinPoint) throws Throwable {
		super.beforeAspect(joinPoint);
	}

	@AfterThrowing (pointcut="execution(* it.csi.stacore.stassosrv.business.helper.impl..*.*(..))", throwing="ex" )
	public void afterThrowingAspect(JoinPoint joinPoint, Exception ex) throws Throwable {
		String className = joinPoint.getTarget().getClass().getSimpleName();
		String method = joinPoint.getSignature().getName();

		Tracer.error(LOG, className, method, "HELPER TRACER");
		Tracer.error(LOG, className, method, "Si e' verificato un errore: " + ex);
		Tracer.info(LOG, className, method, "trace params:");
		for(int i = 0; i<joinPoint.getArgs().length; i++ ) {
			Tracer.info(LOG, className, method, "arg[" + i + "]: " + XmlSerializer.objectToXml(joinPoint.getArgs()[i]));
		}
		if(ex instanceof HelperException ) {
			Tracer.error(LOG, className, method, "ErrorDetail\n " + XmlSerializer.objectToXml(((HelperException)ex).getErrorDetails()));

		}
		throw ex;
	}


}
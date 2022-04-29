package it.csi.stacore.stassosrv.business.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import it.csi.stacore.stassosrv.integration.exception.IntegrationException;
import it.csi.stacore.stassosrv.util.Tracer;
import it.csi.stacore.stassosrv.util.XmlSerializer;


@Component("integrationAspect")
@Aspect
public class IntegrationAspect extends CommonAspect {

	@Around(value = "execution(* it.csi.stacore.stassosrv.integration.**.impl..*.*(..))", argNames = "joinPoint")
	public Object stopWatchMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		return super.stopWatchAspect(joinPoint);
	}

	//@Before(value="execution(* it.csi.fpcommon.fpdoc.integration.**.impl..*.*(..))")
	public void beforeAspect(JoinPoint joinPoint) throws Throwable {
		super.beforeAspect(joinPoint);
	}

	@AfterThrowing (pointcut="execution(* it.csi.stacore.stassosrv.integration.**.impl..*.*(..))", throwing="ex" )
	public void afterThrowingAspect(JoinPoint joinPoint, Exception ex) throws Throwable {

		String className = joinPoint.getTarget().getClass().getSimpleName();
		String method = joinPoint.getSignature().getName();

		Tracer.error(LOG, className, method, "Si e' verificato un errore: " + ex);
		Tracer.info(LOG, className, method, "trace params:");
		for(int i = 0; i<joinPoint.getArgs().length; i++ ) {
			Tracer.info(LOG, className, method, "arg[" + i + "]: " + XmlSerializer.objectToXml(joinPoint.getArgs()[i]));
		}
		throw new IntegrationException(ex.getMessage(), ex);

	}

}
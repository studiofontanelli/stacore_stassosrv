package it.csi.stacore.stassosrv.business.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import it.csi.stacore.stassosrv.util.Constants;
import it.csi.stacore.stassosrv.util.Tracer;


@Component("adapterAspect")
@Aspect
public class AdapterAspect extends CommonAspect{

	public static final String LOGGER_PREFIX = Constants.APPLICATION_CODE + ".aspect";


	@Before(value="execution(*  it.csi.stacore.stassosrv.business.aspect..*.*(..))")
	public void beforeAspect(JoinPoint joinPoint) throws Throwable {
		super.beforeAspect(joinPoint);
	}

	@Before(value="execution(*  it.csi.stacore.stassosrv.business.aspect..*.*(..))")
	public void afterAspect(JoinPoint joinPoint) throws Throwable {
		String className = joinPoint.getTarget().getClass().getSimpleName();
		String method = joinPoint.getSignature().getName();


		Tracer.debug(LOG, className, method, "afterAspect....");


	}



}
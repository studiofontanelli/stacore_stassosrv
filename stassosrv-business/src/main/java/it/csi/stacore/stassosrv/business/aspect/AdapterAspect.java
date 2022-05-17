package it.csi.stacore.stassosrv.business.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import it.csi.stacore.stassosrv.util.Constants;


@Component("adapterAspect")
@Aspect
public class AdapterAspect extends CommonAspect{

	public static final String LOGGER_PREFIX = Constants.APPLICATION_CODE + ".aspect";

	
	
	@Around(value = "execution(* it.csi.stacore.stassosrv.business.adapter.impl..*.*(..))", argNames = "joinPoint")
	public Object logAspect(ProceedingJoinPoint joinPoint) throws Throwable {
		return super.logAspect(joinPoint);
	}

	//@Before(value="execution(*  it.csi.stacore.stassosrv.business.adapter..*.*(..))")
	public void beforeAspect(JoinPoint joinPoint) throws Throwable {
		super.beforeAspect(joinPoint);
	}

	//@Before(value="execution(*  it.csi.stacore.stassosrv.business.adapter..*.*(..))")
	public void afterAspect(JoinPoint joinPoint) throws Throwable {
		String className = joinPoint.getTarget().getClass().getSimpleName();
		String method = joinPoint.getSignature().getName();
		
	}
}
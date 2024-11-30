package mm.vivarta.av.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLoggingAspect {
  // order of advice aspects matter

  public static final Logger log = LoggerFactory.getLogger(ServiceLoggingAspect.class.getName());

  @Pointcut("execution(* mm.vivarta.av.service.impl.*.*(..))")
  private void inServiceLayer() {}

  @Around(value = "inServiceLayer()")
  public Object timeMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = System.currentTimeMillis();
    Object result = null;
    try {
      result = joinPoint.proceed(); // Proceed with the intercepted method
    } finally {
      long duration = System.currentTimeMillis() - start;
      log.debug("Method {} executed in {} ms", joinPoint.getSignature().getName(), duration);
    }
    return result;
  }

}

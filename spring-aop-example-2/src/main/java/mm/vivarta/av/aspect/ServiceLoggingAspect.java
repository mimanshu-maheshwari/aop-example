package mm.vivarta.av.aspect;

import mm.vivarta.av.dto.UserDto;
import mm.vivarta.av.exception.UserException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class ServiceLoggingAspect {
  // order of advice aspects matter

  public static final Logger log = LoggerFactory.getLogger(ServiceLoggingAspect.class.getName());

  @Pointcut("execution(* mm.vivarta.av.service.impl.*.*(..))")
  private void inServiceLayer() {}

  @Before("inServiceLayer()")
  public void beforeService(JoinPoint joinPoint) {
    log.debug("Calling method: {}", joinPoint.getSignature().getName());
  }

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

  @AfterReturning(pointcut = "inServiceLayer()", returning = "userDto")
  public void returningUserDto(JoinPoint joinPoint, UserDto userDto) {
    log.debug(
      "Calling method: {} returned user: {}",
      joinPoint.getSignature().getName(),
      userDto.userName()
    );
  }

  @AfterReturning(pointcut = "inServiceLayer()", returning = "userDtos")
  public void returningUserDtos(JoinPoint joinPoint, List<UserDto> userDtos) {
    log.debug(
      "Calling method: {} returned users: {}",
      joinPoint.getSignature().getName(),
      userDtos.stream().map(UserDto::userName).toList()
    );
  }

  @AfterThrowing(pointcut = "inServiceLayer()", throwing = "userException")
  public void throwingUserException(JoinPoint joinPoint, UserException userException) {
    log.debug(
      "Calling method: {} throwing error {}",
      joinPoint.getSignature().getName(),
      userException.getMessage()
    );
  }
}

package mm.vivarta.av.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclarePrecedence;
import org.springframework.stereotype.Component;

@Aspect
@Component
@DeclarePrecedence("ServiceLoggingAspect")
public class AspectPrecedence { }

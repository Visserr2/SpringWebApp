package nl.thuis.tutorial.springwebapp.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Before("nl.thuis.tutorial.springwebapp.aspect.PointcutExpression.selectRepsitoryAndServiceAndControllerPackage()")
	public void before(JoinPoint joinPoint) {
		
		logger.info("LOGGING ==> @Before Advice: " + joinPoint.toShortString());
		
		Object[] args = joinPoint.getArgs();
		for(Object arg: args) {
			logger.info("LOGGING ==> Method arg: " + arg);
		}
	}
	
	@AfterReturning(pointcut="nl.thuis.tutorial.springwebapp.aspect.PointcutExpression.selectRepsitoryAndServiceAndControllerPackage()", returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		
		logger.info("LOGGING ==> @AfterThrowing Advice: " + joinPoint.toShortString());

		logger.info("LOGGING ==> @AfterThrowing Advice Result: " + result);
	}
}

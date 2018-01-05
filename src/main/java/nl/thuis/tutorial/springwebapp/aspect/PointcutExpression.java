package nl.thuis.tutorial.springwebapp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutExpression {

	// Declaring public pointcuts

	@Pointcut("execution(* nl.thuis.tutorial.springwebapp.controller.*.*(..))")
	public void selectControllerPackage() {}
	
	@Pointcut("execution(* nl.thuis.tutorial.springwebapp.service.*.*(..))")
	public void selectServicePackage() {}
	
	@Pointcut("execution(* nl.thuis.tutorial.springwebapp.repository.*.*(..))")
	public void selectRepositoryPackage() {}
	
	@Pointcut("selectControllerPackage() || selectServicePackage() || selectRepositoryPackage()")
	public void selectRepsitoryAndServiceAndControllerPackage() {}
}

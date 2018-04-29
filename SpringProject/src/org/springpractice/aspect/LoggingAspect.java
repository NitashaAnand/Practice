package org.springpractice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springpractice.model.Circle;

//@Aspect
public class LoggingAspect {
	
	//@Before("execution(public String getName())")
	//@Before("execution(public String org.springpractice.model.Circle.getName())")
	//@Before("execution(public * get*(..))")
	//@Before("allGetters()")
	//@Before("allCircleMethods()")
	//@Before("allGetters() && allCircleMethods()")
/*	public void LoggingAdvice()
	{
		System.out.println("Advice run. Get method called..");
	}*/
	
	/*	@Before("allCircleMethods()")
		public void LoggingAdvice(JoinPoint joinpoint)
		{
			//System.out.println(joinpoint.toString());
			Circle circle=(Circle)joinpoint.getTarget();
			
		}*/
	
	/*@Before("allGetters()")
	//@Before("allCircleMethods()")
	public void secondAdvice()
	{
		System.out.println("Second Advice executed..");
	}*/
	
	/*@Before("args(String)")
	public void StringArgumentMethod()
	{
		System.out.println("A method that takes String argument has been called");
	}*/
	
	/*//@Before("args(name)")
	//@After("args(name)")
	@AfterReturning("args(name)")
	public void StringArgumentMethod(String name)
	{
		System.out.println("A method that takes String argument has been called. The value is:"+name);
	}*/
	

	//@Before("args(name)")
	//@After("args(name)")
	/*@AfterReturning(pointcut="args(name)",returning="returnString")
	public void StringArgumentMethod(String name,String returnString)
	{
		System.out.println("A method that takes String argument has been called. The value is:"+name+"The output is:"+returnString);
	}*/
	
	/*@AfterThrowing("args(name)")
	public void exceptionAdvice(String name)
	{
		System.out.println("An exception has been thrown.");
	}*/
	
	//@AfterThrowing("args(name)")
	/*@AfterThrowing(pointcut="args(name)",throwing="ex")
	public void exceptionAdvice(String name,Exception ex)
	{
		System.out.println("An exception has been thrown."+ ex);
	}*/
	
	//@Around("allGetters()")
	//@Around("@annotation(org.springpractice.aspect.Loggable)")
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint)
	{
		Object returnValue=null;
		try {
			System.out.println("Before Advice");
			returnValue=proceedingJoinPoint.proceed();
			System.out.println("After Returning");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println("After Throwing");
		}
		
		System.out.println("After Finally");
		return returnValue;
	}

	
	/*@Pointcut("execution(public * get*(..))")
	public void allGetters(){}*/
	
	/*//@Pointcut("execution(* org.springpractice.model.Circle.*(..))")
	@Pointcut("within(org.springpractice.model.Circle)")
	public void allCircleMethods(){}*/
	
	
	public void loggingAdvice(){
		System.out.println("Logging from the Advice");
	}
}

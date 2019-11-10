package com.javatraining0.application.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TrackTimeAspect {

	Logger logger = LoggerFactory.getLogger(TrackTimeAspect.class);

	@Around("@annotation(com.javatraining0.application.aop.TrackTime)")
	public Object logData(ProceedingJoinPoint pje) throws Throwable {

		long startTime = System.currentTimeMillis();

		Object obj = pje.proceed();
		long endTime = System.currentTimeMillis();

		System.out.println("Time taken to executethe method is : "
				+ (endTime - startTime));
		return obj;

	}

	@Before("@annotation(com.javatraining0.application.aop.TrackBeforeExecution)")
	public void logBeforeExec()  {

		

		System.out.println("Eecution Started");
		

	}

	@After("@annotation(com.javatraining0.application.aop.TrackAfterExecution)")
	public void logAfterExec() {

		System.out.println("Execution Ended: ");
		
	

	}

}

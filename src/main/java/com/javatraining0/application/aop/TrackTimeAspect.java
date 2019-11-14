package com.javatraining0.application.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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

		logger.info("Time taken to executethe method is : "
				+ (endTime - startTime));
		return obj;

	}
	
	/*@Pointcut(value = "execution(* com.javatraining0.application.*.*.*(..))")
	public void pointCut1() {

	}*/


	@Before("@annotation(com.javatraining0.application.aop.TrackBeforeExecution)")
	public void logBeforeExec() {

		logger.info("Eecution method  Started");

	}

	@After("@annotation(com.javatraining0.application.aop.TrackAfterExecution)")
	public void logAfterExec() {

		logger.info("Execution Ended: ");

	}

}

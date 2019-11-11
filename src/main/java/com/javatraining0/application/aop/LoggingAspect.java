package com.javatraining0.application.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAspect {

	Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@Pointcut(value = "execution(* com.javatraining0.application.*.*.*(..))")
	public void pointCut1() {

	}

	@Around("pointCut1()")
	public Object logData(ProceedingJoinPoint pje) throws Throwable {

		ObjectMapper objectMapper = new ObjectMapper();
		String className = pje.getTarget().getClass().getName();
		String methodName = pje.getSignature().getName();
		Object[] arguments = pje.getArgs();

		logger.info("Execution in class:" + className + " and method is :"
				+ methodName + " and arguments are :" + arguments);

		Object obj = pje.proceed();

		logger.info("Execution in class:" + className + " and method is :"
				+ methodName + " and arguments are :" + arguments
				+ "and the response is :"
				+ objectMapper.writeValueAsString(arguments));
		return obj;

	}
}

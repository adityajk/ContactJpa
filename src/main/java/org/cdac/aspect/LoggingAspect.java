package org.cdac.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.cdac.domain.Event;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {

	@Before("execution(public String home(..))")
	public void loggingAdvice() {
		System.out.println("Advice run");
	}
	
	/*@Before("execution(public String showEvent(..))")
	public void showEventAdvice() {
		System.out.println("Event clicked");
	}*/
}

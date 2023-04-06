package com.ravi.springdemoOne;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load the spring configuration
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScopeApplicationContext.xml");
		
		// retrieve the beans from the container
		
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		CricketCoach alphaCoach =  context.getBean("myCricketCoach", CricketCoach.class);
		
		
		// methods
		boolean result = (theCoach == alphaCoach);
		System.out.println(theCoach);
		System.out.println(alphaCoach);
		System.out.println(result);
		
		// close the context
		context.close();
	}

}

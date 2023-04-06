package com.ravi.springdemoOne;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifCycleDemoApp {

	public static void main(String[] args) {
		// load the spring configuration
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycleApplicationContext.xml");
		
		
		// retrieve the bean from the container
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		// methods
		
		System.out.println(theCoach.dailyWorkOut());
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();
	}

}

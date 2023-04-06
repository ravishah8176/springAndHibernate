package com.ravi.springdemoOne;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		CricketCoach cricketCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		// call methods on beans
		System.out.println(cricketCoach.getEmailAddress());
		System.out.println(cricketCoach.getTeamName());
		
		
		
		
		// close the context
		context.close();
	}

}

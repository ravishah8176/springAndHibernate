package com.ravi.springdemoOne;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
//		Coach theCoach = context.getBean("myCoach", Coach.class);
//		HockeyCoach hockeyCoach = context.getBean("hockeyCoach", HockeyCoach.class);
//		
//		// call methods on the bean
//		System.out.println(theCoach.dailyWorkOut());
//	    System.out.println(hockeyCoach.dailyWorkOut());
//	    hockeyCoach.print();
		
//		Coach baseball = context.getBean("baseballCoach", Coach.class);
//		System.out.println(baseball.dailyWorkOut());
//		System.out.println(baseball.getDailyFortune());
		
//		Coach cricketCoach = context.getBean("myCricketCoach", Coach.class);
//		cricketCoach
		
		// close the context
	    context.close();
	}

}

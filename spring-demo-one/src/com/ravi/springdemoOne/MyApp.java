package com.ravi.springdemoOne;

public class MyApp {

	public static void main(String[] args) {
		// create objects of the class
		Coach theCoach = new BasketballCoach();
		Coach trackCoach = new TrackCoach();
		
		// use the objects
		System.out.println(theCoach.dailyWorkOut());
		System.out.println(trackCoach.dailyWorkOut());
		
	}

}

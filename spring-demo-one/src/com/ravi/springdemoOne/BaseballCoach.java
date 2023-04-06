package com.ravi.springdemoOne;

public class BaseballCoach implements Coach{
	// define private field for dependency
	private FortuneService fortuneService;
	
	// define constructor for dependency injection
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	@Override
	public String dailyWorkOut() {
		return "practice 30 min baseball in court";
	}
	@Override
	public String getDailyFortune() {
		// use my fortuneService to get a fortune
		return fortuneService.getFortune();
	}
}

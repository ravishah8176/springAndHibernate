package com.ravi.springdemoOne;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	private String emailAddress;
	private String teamName;
	
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor");
	}

	public CricketCoach(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside one arg constructor");
		this.fortuneService = fortuneService;
	}



	@Override
	public String dailyWorkOut() {
		return "practice fast bowling for 30 min in net";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method --> setFortuneSErvice");
		this.fortuneService = fortuneService;
	}
	
	public void setEmailAddress(String emailAdderss) {
		System.out.println("CricketCoach: inside setter method --> setEmailAddress");
		this.emailAddress = emailAdderss;				
	}
	
	public void setTeamName(String teamName) {
		System.out.println("CricketCoach: inside setter method --> setTeamName");
		this.teamName = teamName;
	}
	
	public String getEmailAddress() {
		return this.emailAddress;
	}
	
	public String getTeamName() {
		return this.teamName;
	}
	
	// add an in-it method
	public void doMyStartUpStuff() {
		System.out.println("CricketCoach: inside method doMyStartUpStuff");
	}
	
	
	// add a destroy method
	public void doMyCleanUpStuff() {
		System.out.println("CricketCoach: inside method doMyCleanUpStuff");
	}

}

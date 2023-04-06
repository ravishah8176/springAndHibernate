package com.ravi.springdemoOne;

public class HockeyCoach implements Coach{

	@Override
	public String dailyWorkOut() {
		return "Practice Hockey for 20 min in ground";
	}
	public void print() {
		System.out.println("Hi, I am practing hockey for 20 min in ground");
	}
	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}

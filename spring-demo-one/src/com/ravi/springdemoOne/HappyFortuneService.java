package com.ravi.springdemoOne;

public class HappyFortuneService implements FortuneService{
	@Override
	public String getFortune() {
		// return the string
		return "Today is your lucky day";
	}
}

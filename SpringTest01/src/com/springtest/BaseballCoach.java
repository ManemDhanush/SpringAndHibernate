package com.springtest;

public class BaseballCoach implements Coach {
    FortuneService fortuneService;

    public BaseballCoach () {
    }

    public BaseballCoach (FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getWorkout () {
        return "Spend 10 mins in batting nets";
    }

    @Override
    public String getDailyFortune () {
        return fortuneService.getFortune();
    }
}

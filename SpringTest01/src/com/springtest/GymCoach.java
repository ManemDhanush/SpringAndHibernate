package com.springtest;

public class GymCoach implements Coach {
    FortuneService fortuneService;
    @Override
    public String getWorkout () {
        return "Spend 10 mins in for treadmill and 100 push-ups";
    }

    @Override
    public String getDailyFortune () {
        return fortuneService.getFortune();
    }
}

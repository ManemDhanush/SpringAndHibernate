package com.springtest;

public class CricketCoach implements  Coach{
    FortuneService fortuneService;

    private String emailAddress;
    private String team;

    public void setEmailAddress (String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setTeam (String team) {
        this.team = team;
    }

    public String getEmailAddress () {
        return emailAddress;
    }

    public String getTeam () {
        return team;
    }

    public CricketCoach () {
        System.out.println("Inside Cricket Coach no-args Constructor");
    }

    public void setFortuneService (FortuneService fortuneService) {
        System.out.println("Cricket Coach - setFortuneService");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getWorkout () {
        return "Practice Bowling for 20 mins";
    }

    @Override
    public String getDailyFortune () {
        return fortuneService.getFortune();
    }

}

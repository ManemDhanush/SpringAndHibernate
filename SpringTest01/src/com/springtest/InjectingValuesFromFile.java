package com.springtest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InjectingValuesFromFile {
    public static void main (String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);

        System.out.println(theCoach.getWorkout());
        System.out.println(theCoach.getDailyFortune());
        System.out.println(theCoach.getTeam());
        System.out.println(theCoach.getEmailAddress());

        context.close();
    }
}

package com.springtest;
import org.springframework.context.support.*;

public class InversionControlAndDependencyInjection {
    public static void main (String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach theCoach = context.getBean("myCoach", Coach.class);

        System.out.println(theCoach.getDailyFortune());

        context.close();
    }
}

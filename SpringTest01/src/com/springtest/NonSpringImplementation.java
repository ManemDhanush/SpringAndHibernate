package com.springtest;

public class NonSpringImplementation {
    public static void main (String[] args) {
        Coach theCoach = new BaseballCoach();
        System.out.println(theCoach.getWorkout());
    }
}

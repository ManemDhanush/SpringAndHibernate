package com.SpringMVCDemo;

import java.util.LinkedHashMap;

public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private String language;
    private String[] operatingSystem;

    public String getLanguage () {
        return language;
    }

    public void setLanguage (String language) {
        this.language = language;
    }

    public String[] getOperatingSystem () {
        return operatingSystem;
    }

    public void setOperatingSystem (String[] operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    private LinkedHashMap<String, String> countryOptions;

    public Student () {
        countryOptions = new LinkedHashMap<>();

        countryOptions.put("BR", "Brazil");
        countryOptions.put("FR", "France");
        countryOptions.put("DE", "Germany");
        countryOptions.put("IN", "India");
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public String getCountry () {
        return country;
    }

    public void setCountry (String country) {
        this.country = country;
    }
    public LinkedHashMap<String, String> getCountryOptions () {
        return countryOptions;
    }
}

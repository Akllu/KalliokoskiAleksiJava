package com.akllu.finalproject;

public class Student {
    private static long idCounter = 0;
    private long id;
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName) {
        this.id = idCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getStudentId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return this.lastName + " " + this.firstName;
    }
}
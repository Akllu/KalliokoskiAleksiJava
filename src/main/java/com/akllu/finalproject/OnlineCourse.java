package com.akllu.finalproject;

import java.util.List;

public class OnlineCourse extends Course{
    private String courseAddress;

    public OnlineCourse(String courseName, String teacherName, List<Student> studentList, String courseAddress) {
        super(courseName, teacherName, studentList);
        this.courseAddress = courseAddress;
    }

    public String getCourseAddress() {
        return this.courseAddress;
    }

    public void setCourseAddress(String courseAddress) {
        this.courseAddress = courseAddress;
    }

    @Override
    public String toString() {
        return super.getCourseName() + " – " + super.getTeacherName() + " – " + this.getCourseAddress();
    }
}
package com.akllu.finalproject;

import java.util.List;

public class LocalCourse extends Course {
    private String classRoom;

    public LocalCourse(String courseName, String teacherName, List<Student> studentList, String classRoom) {
        super(courseName, teacherName, studentList);
        this.classRoom = classRoom;
    }

    public String getClassRoom() {
        return this.classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    @Override
    public boolean addStudentToCourse(Student student) {
        if(this.getStudentList().size() < 25) {
            return super.addStudentToCourse(student);
        }
        else {
            System.out.println("This course is full!");
            return false;
        }
    }

    @Override
    public String toString() {
        return super.getCourseName() + " – " + super.getTeacherName() + " – " + this.getClassRoom();
    }
}
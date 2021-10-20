package com.akllu.finalproject;

import java.util.ArrayList;
import java.util.List;

public abstract class Course {
    private static long idCounter = 0;
    private long id;
    private String courseName;
    private String teacherName;
    private List<Student> studentList;

    public Course(String courseName, String teacherName, List<Student> studentList) {
        this.id = idCounter++;
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.studentList = studentList;
    }

    public long getCourseId() {
        return this.id;        
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return this.teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public boolean addStudentToCourse(Student student) {
        if(this.studentList.contains(student)) {
            System.out.println("This student has already been added to the course!");
            return false;
        }
        else {
            this.studentList.add(student);
            return true;
        }
    }

    public void removeStudentFromCourse(Student student) {
        if(this.studentList.contains(student)) {
            this.studentList.remove(student);
        }
        System.out.println("Oppilasta ei löytynyt!");
    }

    public List<Student> getStudentList() {
        return new ArrayList<>(this.studentList);
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
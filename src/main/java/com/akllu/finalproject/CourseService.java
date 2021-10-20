package com.akllu.finalproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CourseService implements ICourseService {
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    CourseFileService fileService = new CourseFileService();

    public CourseService() {
        try {
            this.students = fileService.readStudentsFromFile("students.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            this.courses = fileService.readCoursesFromFile("courses.txt");
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    @Override
    public List<Student> getStudents() {
        return new ArrayList<>(this.students);
    }

    @Override
    public List<Course> getCourses() {
        return new ArrayList<>(this.courses);
    }

    @Override
    public Student getStudentById(long studentId) {
        for (Student s : this.students) {
            if(s.getStudentId() == studentId) {
                return s;
            }
        }
        return null;
    }

    @Override
    public Course getCourseById(long courseId) {
        for (Course c : this.courses) {
            if(c.getCourseId() == courseId) {
                return c;
            }            
        }
        return null;
    }

    @Override
    public List<Course> getCoursesOfStudent(long studentId) {
        Student student = getStudentById(studentId);
        List<Course> coursesOfStudent = new ArrayList<>();

        for (Course c : this.courses) {
            if(c.getStudentList().contains(student)) {
                coursesOfStudent.add(c);
            }            
        }
        return coursesOfStudent;
    }

    @Override
    public boolean addStudentToCourse(long studentId, long courseId) {
        Student student = getStudentById(studentId);
        Course course = getCourseById(courseId);

        if(student != null && course != null) {
            boolean didAdd = course.addStudentToCourse(student);
            if(didAdd) {
                return true;
            }
            return false;
        }
        else {
            System.out.println("Something is missing!");
            return false;
        }
    }
}
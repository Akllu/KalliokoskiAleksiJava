package com.akllu.finalproject;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    CourseService courseService;

    @GetMapping("students")
    public List<Student> getStudents() {
        return courseService.getStudents();
    }

    @GetMapping("courses")
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @GetMapping("onlinecourses")
    public String getOnlineCourses() {
        List<Course> courses = courseService.getCourses();
        String courseNames = "";
        for (Course course : courses) {
            if(course instanceof OnlineCourse) {
                courseNames += "<div>" + course.getCourseName() + "</div>";
            }                        
        }
        return courseNames;
    }

    @GetMapping("students/{id}")
    public String getStudentById(@PathVariable long id) {
        Student student = courseService.getStudentById(id);
        String studentName = "<h3>" + student.toString() + "</h3>";
        String studentCourses = "";
        List<Course> courses = courseService.getCoursesOfStudent(id);
        for (Course course : courses) {
            studentCourses += "<div>" + course.getCourseName() + "</div>";                        
        }
        return studentName + studentCourses;
    }

    @GetMapping("courses/{id}")
    public String getCourseById(@PathVariable long id) {
        Course course = courseService.getCourseById(id);
        String courseName = "<h3>" + course.getCourseName() + "</h3>";
        String courseStudents = "";
        List<Student> students = course.getStudentList();
        for (Student student : students) {
            courseStudents += "<div>" + student.toString() + "</div>";
        }
        return courseName + courseStudents;
    }

    @PostMapping("add")
    public String addToCourse(@RequestBody Map<String, Object> jsonMapping) {
        String resSid = jsonMapping.get("sid").toString();
        String resCid = jsonMapping.get("cid").toString();
        long sid = Long.parseLong(resSid);
        long cid = Long.parseLong(resCid);
        boolean didAdd = courseService.addStudentToCourse(sid, cid);
        if(didAdd) {
            Student student = courseService.getStudentById(sid);
            return student.toString() + " added to " + courseService.getCourseById(cid).getCourseName() + " course!";
        }
        return "Failed to add student to course!";  
    }
}
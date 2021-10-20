package com.akllu.finalproject;

import java.io.FileNotFoundException;
import java.util.List;

public interface ICourseFileService {
    /* Reads list of students from txt-file */
    List<Student> readStudentsFromFile(String filePath) throws FileNotFoundException;

    /* Reads list of courses from txt-file */
    List<Course> readCoursesFromFile(String filePath) throws FileNotFoundException;
}
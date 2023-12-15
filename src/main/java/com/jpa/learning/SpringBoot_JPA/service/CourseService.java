package com.jpa.learning.SpringBoot_JPA.service;

import com.jpa.learning.SpringBoot_JPA.entity.Course;
import com.jpa.learning.SpringBoot_JPA.exception.inside.CourseNotFoundEXception;

import java.util.List;

public interface CourseService {
    String addCourse(Course course);
    Course getCourseById(Integer CID) throws CourseNotFoundEXception;
    List<Course> getAllCourses();
    String deleteById(Integer CID);
}

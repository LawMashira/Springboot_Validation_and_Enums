package com.jpa.learning.SpringBoot_JPA.service;

import com.jpa.learning.SpringBoot_JPA.entity.Course;
import com.jpa.learning.SpringBoot_JPA.exception.inside.CourseNotFoundEXception;
import com.jpa.learning.SpringBoot_JPA.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl  implements  CourseService{

    @Autowired
    private CourseRepository courseRepository;
    @Override
    public  String addCourse(Course course){
        courseRepository.save(course);
        return  "success";
    }

    @Override
    public Course getCourseById(Integer CID) throws CourseNotFoundEXception {
    Optional<Course>findById = courseRepository.findById(CID);

    if(findById.isPresent())   {
        return findById.get();
    }else{
        throw  new CourseNotFoundEXception("No course with  ID "+CID);
    }


    }

    @Override
    public List<Course> getAllCourses() {


        return courseRepository.findAll();
    }

    @Override
    public String deleteById(Integer CID) {
        if(courseRepository.existsById(CID)){
            courseRepository.deleteById(CID);
            return  "Deleted";
        }else {
            return  "No record";
        }
    }
}

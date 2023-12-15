package com.jpa.learning.SpringBoot_JPA.restconroller;

import com.jpa.learning.SpringBoot_JPA.entity.Course;
import com.jpa.learning.SpringBoot_JPA.exception.inside.CourseNotFoundEXception;
import com.jpa.learning.SpringBoot_JPA.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @PostMapping("course")
    public ResponseEntity<String> createCourse(@RequestBody @Valid Course course){
      String status = courseService.addCourse(course);
        return  new ResponseEntity<> (status, HttpStatus.CREATED);

    }
    @GetMapping("course/{cid}")

    public  ResponseEntity<Course> getCourseById(@PathVariable Integer cid) throws CourseNotFoundEXception {
        Course course =courseService.getCourseById(cid);
        return  new ResponseEntity<>(course, HttpStatus.OK);
    }


    @GetMapping("courses")
    public ResponseEntity<List<Course>> getAllCourses(){
        List <Course> courses =courseService.getAllCourses();
        return  new ResponseEntity<>(courses,HttpStatus.OK);
    }
    @DeleteMapping("course/{cid}")

    public  ResponseEntity<String> deleteCourseById(@PathVariable Integer cid){
    String  status= courseService.deleteById(cid);
        return  new ResponseEntity<>(status, HttpStatus.OK);
    }


}

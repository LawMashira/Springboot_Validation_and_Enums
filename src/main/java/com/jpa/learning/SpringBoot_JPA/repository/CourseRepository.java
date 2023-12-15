package com.jpa.learning.SpringBoot_JPA.repository;

import com.jpa.learning.SpringBoot_JPA.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;

import java.io.Serializable;

public interface CourseRepository  extends JpaRepository<Course, Integer> {
}

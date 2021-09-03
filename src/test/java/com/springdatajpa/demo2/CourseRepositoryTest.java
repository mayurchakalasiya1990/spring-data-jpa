package com.springdatajpa.demo2;

import com.springdatajpa.demo2.entity.Course;
import com.springdatajpa.demo2.repository.CourseRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courseList=courseRepository.findAll();
        System.out.println("courses:"+courseList);
    }

}
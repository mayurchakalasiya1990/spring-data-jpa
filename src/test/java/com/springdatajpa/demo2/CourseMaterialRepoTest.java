package com.springdatajpa.demo2;

import com.springdatajpa.demo2.entity.Course;
import com.springdatajpa.demo2.entity.CourseMaterial;
import com.springdatajpa.demo2.repository.CourseMaterialRepository;
import com.springdatajpa.demo2.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CourseMaterialRepoTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void  saveCourseMaterial(){


        Course course=Course.builder()
                .credit(6)
                .title("Programming")
                .build();
        //courseRepository.save(course);
        CourseMaterial courseMaterial=CourseMaterial.builder()
                .credit(10)
                .title("Java programming")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterial(){
        List<CourseMaterial> courseMaterials= courseMaterialRepository.findAll();
        System.out.println(courseMaterials);
    }

    @Test
    public void printAllCourse(){
        List<Course> courses= courseRepository.findAll();
        System.out.println(courses);
    }

}

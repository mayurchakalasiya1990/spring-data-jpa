package com.springdatajpa.demo2;

import com.springdatajpa.demo2.entity.Course;
import com.springdatajpa.demo2.entity.Teacher;
import com.springdatajpa.demo2.repository.CourseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courseList=courseRepository.findAll();
        System.out.println("courses:"+courseList);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher= Teacher.builder()
                .firstName("priya")
                .lastName("singh")
                .build();
        Course course=Course.builder()
                .credit(10)
                .title("Python")
                .teacher(teacher)
                .build();
        courseRepository.save(course);

    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords= PageRequest.of(0,3);
        Pageable secondPageWithThreeRecords= PageRequest.of(1,2);
        List<Course> courses=courseRepository.findAll(firstPageWithThreeRecords).getContent();
        long totalElements=courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        long totalPages=courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();
        System.out.println("totalElements:"+totalElements);
        System.out.println("totalPages:"+totalPages);
        System.out.println("Course:"+courses);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle= PageRequest.of(
                0,
                3,
                Sort.by("title")
        );

        Pageable sortByTitleDesc = PageRequest.of(
                0,
                3,
                Sort.by("title").descending()
        );

        Pageable sortByTitleAndCreditDescending = PageRequest.of(
                0,
                2,
                Sort.by("title")
                        .descending()
                        .and(Sort.by("Credit"))
        );
        List<Course> courses=courseRepository.findAll(sortByTitle).getContent();
        System.out.println("sortByTitle:"+courses);

    }
}
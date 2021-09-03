package com.springdatajpa.demo.Repository;

import com.springdatajpa.demo.entity.Course;
import com.springdatajpa.demo.entity.Passport;
import com.springdatajpa.demo.entity.Student;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest // load Spring-boot Context
public class StudenteRepositoryTest {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional
    public void retrieveStudentAndPassport(){
        Student student=entityManager.find(Student.class,2L);
        logger.info("Student:"+student);
        Passport passport=student.getPassport();
        logger.info("Passport:"+passport);
        Assertions.assertNotNull(student);
        Assertions.assertNotNull(passport);
    }

    @Test
    @Transactional
    public void retrievePassportAndStudent(){
        Passport passport=entityManager.find(Passport.class,1L);
        logger.info("Passport:"+passport);
        Student student=passport.getStudent();
        logger.info("Student:"+student);
        Assertions.assertNotNull(passport);
        Assertions.assertNotNull(student);
    }

    @Test
    @Transactional
    public void testCrudeOperation(){
        studentRepository.crudOperationStudent();
    }

    @Test
    @Transactional
    public void retrieveStudentAndCourse(){
        Student student=entityManager.find(Student.class,10002L);
        logger.info("Student:"+student);
        logger.info("Course:"+student.getCourses());

    }

}

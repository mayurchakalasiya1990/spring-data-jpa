package com.springdatajpa.demo.Repository;

import com.springdatajpa.demo.entity.Course;
import com.springdatajpa.demo.entity.Review;
import com.springdatajpa.demo.entity.Student;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest // load Spring-boot Context
public class CourseRepositoryTest {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    EntityManager entityManager;
    @Test
    public void contextLoads(){
        Course course=courseRepository.findById(10002L);
        Assertions.assertEquals("Spring MVC course",course.getName());
    }

    @Test
    //@DirtiesContext
    public void deleteById(){
        courseRepository.deleteById(10002L);
        Course course=courseRepository.findById(10002L);
        Assertions.assertNull(course);
    }

    @Test
    public void insertById(){
        Course course=courseRepository.save(Course.builder().name("Microservice course").build());
        Assertions.assertEquals(course.getName(),"Microservice course");
    }

    @Test
    @Transactional
    public void retrieveReviewsForCourse(){
       Course course=courseRepository.findById(10002L);
       logger.info("Reviews:"+course.getReviews().size());
    }

    @Test
    @Transactional
    public void retrieveCourseForReview(){
        Review review=entityManager.find(Review.class,10002L);
        logger.info("Reviews:"+review.getCourse());
    }
}

package com.springdatajpa.demo;


import com.springdatajpa.demo.entity.Course;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest // load Spring-boot Context
public class JPQLTest {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    @Test
    public void selectUsingJPQL(){
        List list =entityManager.createQuery("Select c from Course c").getResultList();
        logger.info("Result list:"+list);
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void findById_typed(){
        List<Course> list =entityManager.createQuery("Select c from Course c where name like '%API%'",Course.class).getResultList();
        logger.info("Result list<Course>:"+list);
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void findCourseUsingNamedQuery(){
        List list =entityManager.createNamedQuery("get_all_courses").getResultList();
        Assertions.assertFalse(list.isEmpty());
    }

}

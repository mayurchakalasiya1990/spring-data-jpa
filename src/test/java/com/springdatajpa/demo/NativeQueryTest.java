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
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest // load Spring-boot Context
public class NativeQueryTest {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    @Test
    public void selectUsingNativeQuery(){
        List list =entityManager.createNativeQuery("select * from course", Course.class).getResultList();
        logger.info("Result list:"+list);
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void selectUsingNativeQuery_where(){
        Query query =entityManager.createNativeQuery("select * from course where id=?", Course.class);
        query.setParameter(1,11);
        List list=query.getResultList();
        logger.info("Result list:"+list);
        Assertions.assertEquals(((Course)list.get(0)).getId(),11);
    }

    @Test
    @Transactional
    public void updateTimeStampForAllRecord(){
        Query query =entityManager.createNativeQuery("update course set created_date=sysdate(), last_updated_date=sysdate()", Course.class);
        int count=query.executeUpdate();
        logger.info("Row update Count:"+count);
        Assertions.assertTrue(count>0);
    }
}

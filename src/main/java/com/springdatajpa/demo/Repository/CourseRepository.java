package com.springdatajpa.demo.Repository;

import com.springdatajpa.demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager entityManager;

    public Course findById(Long id){
            return entityManager.find(Course.class,id);
    }

    public Course save(Course course){
        if(course.getId()==null){
            entityManager.persist(course);
        }else{
            entityManager.merge(course);
        }
        return course;
    }

    public void deleteById(Long id){
        Course course=findById(id);
        entityManager.remove(course);
    }

    public void playWithEntityManager(){
        Course course= Course.builder().name("Rest WebService").build();
        entityManager.persist(course);
        entityManager.flush(); // changes are flushed to DB

        course.setName("Rest WebService - Updated");
        entityManager.flush();// changes are flushed to DB

        //entityManager.clear(); // clear whole entity manager so after this no changes will be tracked under the transaction

        Course course2=Course.builder().name("SOAP WebService").build();
        entityManager.persist(course2);
        entityManager.flush();// changes are flushed to DB

        entityManager.detach(course2); // course2 will be not tracked under the transaction.
        //entityManager.flush();// changes are flushed to DB
        course.setName("SOAP WebService - before refresh");
        entityManager.refresh(course); // update the course details from DB and lost other changes which are not saved in DB.
        System.out.println(course);
        course2.setName("SOAP WebService - After refresh");

    }

}

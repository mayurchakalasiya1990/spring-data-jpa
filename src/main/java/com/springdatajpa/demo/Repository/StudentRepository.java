package com.springdatajpa.demo.Repository;

import com.springdatajpa.demo.entity.Course;
import com.springdatajpa.demo.entity.Passport;
import com.springdatajpa.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class StudentRepository {
    @Autowired
    EntityManager entityManager;

    public Student findById(Long id){
        return entityManager.find(Student.class,id);
    }

    public Student save(Student student){
        if(student.getId()==null){
            entityManager.persist(student);
        }else{
            entityManager.merge(student);
        }
        return student;
    }

    public void deleteById(Long id){
        Student student=findById(id);
        entityManager.remove(student);
    }

    public void playWithEntityManager(){
        Passport passport= Passport.builder().passportNo("Z123345").build();
        entityManager.persist(passport);

        Student student= Student.builder().name("Mike").age(20).email("mike@email.com").passport(passport).build();
        entityManager.persist(student);
    }

    //JPA will create transaction when this method calls
    //After transaction, JPA will create
    public void crudOperationStudent(){
        //Retrieve Student
        Student student=entityManager.find(Student.class,2L);
        // persistence Context have Student
        //Retrieve Passport
        Passport passport=student.getPassport();
        // persistence Context have Student,passport
        //Update passport number for student
        passport.setPassportNo("ZX132322");
        // persistence Context have Student, updated-passport
        //update Student details
        student.setAge(25);
        // persistence Context have updated-Student, updated-passport
        entityManager.persist(student);

    }

}

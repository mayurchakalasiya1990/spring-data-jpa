package com.springdatajpa.demo2.repository;

import com.springdatajpa.demo2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
         List<Student> findByFirstName(String firstName);
         List<Student> findByFirstNameContaining(String firstName);
         List<Student> findByLastNameNotNull();
         List<Student> findByGuardianName(String guardianName);

         //JPQL Query
         @Query("select s from Student s where s.emailId = ?1")
         Student getStudentByEmailId(String emailId);

        //JPQL Query
        @Query("select s.firstName from Student s where s.emailId= ?1")
        String getFirstNameByEmailId(String emailId);

        //Native Query
        @Query(
                value = "SELECT * FROM tbl_student S WHERE S.EMAIL_ADDRESS = ?1",
                nativeQuery = true
        )
        String getStudentByEmailIdNative(String emailId);

        //Native Named Query
        @Query(
                value = "SELECT * FROM tbl_student S WHERE S.EMAIL_ADDRESS = :emailId",
                nativeQuery = true
        )
        String getStudentByEmailIdNativeNamedParam(@Param("emailId") String emailId);

    //Native Named Query
    @Modifying
    @Transactional // it should be added on service layer instead of DOA or repository
    @Query(
            value = "update tbl_student S set S.first_name= :firstName WHERE S.EMAIL_ADDRESS = :emailId",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(@Param("firstName") String firstName,@Param("emailId") String emailId);


}


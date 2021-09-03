package com.springdatajpa.demo2;

import com.springdatajpa.demo2.entity.Guardian;
import com.springdatajpa.demo2.entity.Student;
import com.springdatajpa.demo2.repository.StudentRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentRepoTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    @Disabled
    public void saveStudentTest(){
        Student student= Student.builder()
                .firstName("Mayur")
                .lastName("Chakalasiya")
                .emailId("mayurchaklasiya@gmail.com")
                //.guardianName("xyz")
                //.guardianMobile("727620XXX")
                .build();
        studentRepository.save(student);
    }

    @Test
    @Disabled
    public void saveStudentWithGuardianDetailsTest(){
        Student student= Student.builder()
                .firstName("Mayur")
                .lastName("Chakalasiya")
                .emailId("mayurchaklasiya111@gmail.com")
                .guardian(
                        Guardian.builder()
                            .name("xxx")
                            .email("xyz@gmail.com")
                            .mobile("XXXYYYXXX")
                            .build()
                )
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> allStudents=studentRepository.findAll();
        System.out.println(allStudents);
    }


    @ParameterizedTest(name = "name")
    @ValueSource(strings = {"mayur","mayur1"})
    public void findByFirstName(String name){
        List<Student> studentsByFirstName=studentRepository.findByFirstName(name);
        System.out.println(studentsByFirstName);
    }

    @ParameterizedTest(name = "name")
    @ValueSource(strings = {"may","mayur1"})
    public void findByFirstNameContaining(String name){
        List<Student> studentsByFirstName=studentRepository.findByFirstNameContaining(name);
        System.out.println(studentsByFirstName);
    }

    @Test
    public void findByLastnameNotNull(){
        List<Student> studentsByLastnameNotNull=studentRepository.findByLastNameNotNull();
        System.out.println(studentsByLastnameNotNull);
    }

    @Test
    public void findByStudentByEmailId_JPQLQuery(){
        Student student=studentRepository.getStudentByEmailId("mayurchaklasiya111@gmail.com");
        System.out.println(student);
    }

    @Test
    public void findByFirstnameByEmailId_JPQLQuery(){
        String studentFirstname=studentRepository.getFirstNameByEmailId("mayurchaklasiya111@gmail.com");
        System.out.println(studentFirstname);
    }


    @Test
    public void findByStudentByEmailId_NativeQuery(){
        String student=studentRepository.getStudentByEmailIdNative("mayurchaklasiya111@gmail.com");
        System.out.println(student);
    }

    @Test
    public void findByStudentByEmailId_NativeNamedParamQuery(){
        String student=studentRepository.getStudentByEmailIdNativeNamedParam("mayurchaklasiya111@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        int student=studentRepository.updateStudentNameByEmailId("mayurxxx","mayurchaklasiya111@gmail.com");
        System.out.println(student);
    }



}

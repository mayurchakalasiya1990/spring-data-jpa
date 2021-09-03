package com.springdatajpa.demo2;

import com.springdatajpa.demo2.entity.Course;
import com.springdatajpa.demo2.entity.Teacher;
import com.springdatajpa.demo2.repository.StudentRepository;
import com.springdatajpa.demo2.repository.TeacherRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TeacherRepoTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveTeacher(){

        Course course1= Course.builder()
                .title("meditation")
                .credit(100)
                .build();
        Course course2= Course.builder()
                .title("karma Yoga")
                .credit(200)
                .build();

        Teacher teacher=Teacher.builder()
                .firstName("Swami Vivekanda")
                .lastName("Guruji")
                //.courses(List.of(course1,course2))
                .build();
        System.out.println(studentRepository);
        System.out.println(teacherRepository);
        teacherRepository.save(teacher);
    }
}

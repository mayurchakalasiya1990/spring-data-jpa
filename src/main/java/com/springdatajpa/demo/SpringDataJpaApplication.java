package com.springdatajpa.demo;

import com.springdatajpa.demo.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	@Autowired
	private com.springdatajpa.demo.Repository.CourseRepository courseRepository;

	private Logger logger= LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Course course=courseRepository.findById(10003L);
		//logger.info("Course 10001 details :"+course.getName());
		//courseRepository.deleteById(10001L);
		//courseRepository.save(Course.builder().name("AngularJS course").build());
		//courseRepository.playWithEntityManager();
	}
}

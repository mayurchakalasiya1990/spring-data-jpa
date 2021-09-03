package com.springdatajpa.demo;

import com.springdatajpa.demo.Repository.CourseRepository;
import com.springdatajpa.demo.Repository.StudentRepository;
import com.springdatajpa.demo.entity.Course;
import com.springdatajpa.demo.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

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
		//studentRepository.playWithEntityManager();
		Long courseId=10002L;
		Review review1=Review.builder().rating(5).description("Hand-on stuff.").build();
		Review review2=Review.builder().rating(4).description("Wonderful documents.").build();
		List<Review> list= List.of(review1,review2);

		//courseRepository.addCourseReview(courseId,list);
	}
}

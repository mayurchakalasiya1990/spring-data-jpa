package com.springdatajpa.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor // it is required by JPA to create Entity class
@AllArgsConstructor
@Data
@Builder
//@Table(name = "CourseDetails") // JPA will create table with table name "course_details" in database
//@NamedQuery(name = "get_all_courses", query = "Select c from Course c")
@NamedQueries(
        value = {
                @NamedQuery(name = "get_all_courses", query = "Select c from Course c"),
                @NamedQuery(name = "get_all_API_courses", query = "Select c from Course c where name like '%API%'")
        }
)
public class Course {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;
    @CreationTimestamp
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "course",fetch = FetchType.LAZY)
    List<Review> reviews=new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    List<Student> students=new ArrayList<>();
}

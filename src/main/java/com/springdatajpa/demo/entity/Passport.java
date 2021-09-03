package com.springdatajpa.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Passport {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String passportNo;

    /*
        mappedBy = "passport"  indicates:
        In one_To_one relation of Student-Passport
        Student - parent table (Student table have passport_id as column in table)
        Passport - child table (Passport table don't have student_id as column in table)
     */
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "passport")
    private Student student;

}

package com.jpa.learning.SpringBoot_JPA.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name="COURSE_TABLE")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CID;
    @NotBlank(message="Name not blank")
    private  String name;
    @NotNull
    private  Double price;

    //Enums demo
@Enumerated(EnumType.STRING)
    private CourseEnums courseEnum;
}

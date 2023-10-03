package com.example.iacdemy.entities.courses.dto;

import com.example.iacdemy.entities.courses.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class AddCourseDto {


    private String title;
    private String description;
    private BigDecimal price;
}

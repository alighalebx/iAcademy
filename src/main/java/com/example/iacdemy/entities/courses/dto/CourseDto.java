package com.example.iacdemy.entities.courses.dto;

import com.example.iacdemy.entities.courses.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class CourseDto {
    private final Course course;

    public CourseDto(Course course){
        this.course = course;
    }

    public String getTitle(){
       return this.course.getTitle();
    }

    public String getDescription(){
        return this.course.getDescription();
    }

    public BigDecimal getPrice(){
        BigDecimal price = this.course.getPrice();
        return price.setScale(2, RoundingMode.HALF_UP);
    }


}

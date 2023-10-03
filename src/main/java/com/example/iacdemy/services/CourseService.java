package com.example.iacdemy.services;

import com.example.iacdemy.entities.courses.Course;
import com.example.iacdemy.entities.courses.dto.AddCourseDto;
import com.example.iacdemy.entities.courses.dto.CourseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourseService {

    ResponseEntity<List<CourseDto>>findAll();
    ResponseEntity<CourseDto> findById(Long id);
    ResponseEntity<CourseDto> create(AddCourseDto addCourseDto);
    ResponseEntity<CourseDto> update(Long id, AddCourseDto addCourseDto);

    ResponseEntity<String> remove(Long id);


}

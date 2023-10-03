package com.example.iacdemy.mappers;

import com.example.iacdemy.entities.courses.Course;
import com.example.iacdemy.entities.courses.dto.AddCourseDto;
import com.example.iacdemy.entities.courses.dto.CourseDto;

public interface CourseMapper {

    Course addCourseDtoToCourse(AddCourseDto addCourseDto);

    CourseDto courseToCourseDto(Course course);
}

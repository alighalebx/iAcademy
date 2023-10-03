package com.example.iacdemy.mappers;

import com.example.iacdemy.entities.courses.Course;
import com.example.iacdemy.entities.courses.dto.AddCourseDto;
import com.example.iacdemy.entities.courses.dto.CourseDto;

public class CourseMapperImpl implements CourseMapper {
    @Override
    public Course addCourseDtoToCourse(AddCourseDto addCourseDto) {
        Course course = new Course();
        course.setTitle(addCourseDto.getTitle());
        course.setDescription(addCourseDto.getDescription());
        course.setPrice(addCourseDto.getPrice());

        return course;
    }

    @Override
    public CourseDto courseToCourseDto(Course course) {
        return new CourseDto(course);
    }
}

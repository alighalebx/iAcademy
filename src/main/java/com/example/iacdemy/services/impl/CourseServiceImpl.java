package com.example.iacdemy.services.impl;

import com.example.iacdemy.entities.courses.Course;
import com.example.iacdemy.entities.courses.dto.AddCourseDto;
import com.example.iacdemy.entities.courses.dto.CourseDto;
import com.example.iacdemy.errors.CourseNotFoundException;
import com.example.iacdemy.mappers.CourseMapper;
import com.example.iacdemy.mappers.CourseMapperImpl;
import com.example.iacdemy.repositories.courses.CourseRepository;
import com.example.iacdemy.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private static final CourseMapper mapper = new CourseMapperImpl();


    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public ResponseEntity<List<CourseDto>> findAll() {
        List<Course> courses = this.courseRepository.findAll();
        List<CourseDto> courseDtoList = courses.stream().map(mapper::courseToCourseDto).collect(Collectors.toList());
        return new ResponseEntity<>(courseDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CourseDto> findById(Long id) {
        Optional<Course> course = this.courseRepository.findById(id);
        if(course.isEmpty()){
            throw new CourseNotFoundException("Not Found :)");
        }
        CourseDto courseDto = mapper.courseToCourseDto(course.get());
        return new ResponseEntity<>(courseDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CourseDto> create(AddCourseDto addCourseDto) {
        final  Course course = mapper.addCourseDtoToCourse(addCourseDto);
        final Course createdCourse = this.courseRepository.save(course);

        CourseDto courseDto = mapper.courseToCourseDto(createdCourse);

        return new ResponseEntity<>(courseDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CourseDto> update(Long id, AddCourseDto newCourse) {
        Optional<Course> course = this.courseRepository.findById(id);
        if(course.isEmpty()){
            throw new CourseNotFoundException(id+"Not Found");
        }
        Course existingCourse = course.get();
        existingCourse.setTitle(newCourse.getTitle());
        existingCourse.setDescription(newCourse.getDescription());
        existingCourse.setPrice(newCourse.getPrice());
        Course updatedCourse = this.courseRepository.save(existingCourse);
        CourseDto courseDto = mapper.courseToCourseDto(updatedCourse);
        return new ResponseEntity<>(courseDto, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<String> remove(Long id) {
        boolean exists = this.courseRepository.existsById(id);

        if(!exists){
            throw new CourseNotFoundException(id+"Not Found");
        }
        this.courseRepository.deleteById(id);
        return new ResponseEntity<>("Removed :)",HttpStatus.NO_CONTENT);
    }
}

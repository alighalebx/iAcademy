package com.example.iacdemy.config;

import com.example.iacdemy.entities.courses.Course;
import com.example.iacdemy.entities.courses.dto.AddCourseDto;
import com.example.iacdemy.mappers.CourseMapper;
import com.example.iacdemy.mappers.CourseMapperImpl;
import com.example.iacdemy.repositories.courses.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.math.BigDecimal;
import java.util.stream.IntStream;

@Configuration
@EnableAspectJAutoProxy
public class CourseCommandLineRunner {
    @Bean
    CommandLineRunner initDatabase(CourseRepository courseRepository){
        return args -> {
            CourseMapper courseMapper = new CourseMapperImpl();
            IntStream.rangeClosed(1, 10).forEach(i -> {
                AddCourseDto addCourseDto =
                        new AddCourseDto("Course #" + i,
                                "Learn COurse #" + i + "in the best way.",
                                new BigDecimal(String.valueOf(i * 100)));
                Course course = courseMapper.addCourseDtoToCourse(addCourseDto);
                courseRepository.save(course);
            });
        };
    }
}
// AOP
// sring security


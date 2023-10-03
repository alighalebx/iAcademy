package com.example.iacdemy.repositories.courses;

import com.example.iacdemy.entities.courses.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {


}

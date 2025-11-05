package org.example.introspringboot.service;

import org.example.introspringboot.api.v1.dto.CourseDTO;
import org.example.introspringboot.api.v1.dto.CourseWithStudentsDTO;
import org.example.introspringboot.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<CourseWithStudentsDTO> findAll();
    List<CourseDTO> findByStudentId(Integer studentId);
    Optional<Course> findById(Integer id);
    Course save(Course course);
    void deleteById(Integer id);
}

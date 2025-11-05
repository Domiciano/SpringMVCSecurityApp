package org.example.introspringboot.service.impl;

import org.example.introspringboot.api.v1.dto.CourseDTO;
import org.example.introspringboot.api.v1.dto.CourseWithStudentsDTO;
import org.example.introspringboot.api.v1.dto.StudentDTO;
import org.example.introspringboot.api.v1.mappers.CourseMapper;
import org.example.introspringboot.api.v1.mappers.StudentMapper;
import org.example.introspringboot.entity.Course;
import org.example.introspringboot.repository.CourseRepository;
import org.example.introspringboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CourseWithStudentsDTO> findAll() {
        return courseRepository.findAll().stream().map(
                entity -> {
                    CourseWithStudentsDTO dto = courseMapper.toCourseWithStudentsDto(entity);
                    List<StudentDTO> studentList = entity
                            .getStudentCourses()
                            .stream()
                            .map(
                                    studentCourse ->
                                            studentMapper.toSimpleDto(
                                                    studentCourse.getStudent()
                                            )
                            ).toList();
                    dto.setStudents(studentList);
                    return dto;
                }
        ).toList();
    }

    @Override
    public List<CourseDTO> findByStudentId(Integer studentId) {
        return courseRepository.findByStudentCourses_Student_Id(studentId).stream().map(
                course -> courseMapper.toSimpleDto(course)
        ).toList();
    }

    @Override
    public Optional<Course> findById(Integer id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteById(Integer id) {
        courseRepository.deleteById(id);
    }
}

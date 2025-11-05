package org.example.introspringboot.api.v1.mappers;

import org.example.introspringboot.api.v1.dto.CourseDTO;
import org.example.introspringboot.api.v1.dto.CourseWithStudentsDTO;
import org.example.introspringboot.api.v1.dto.StudentDTO;
import org.example.introspringboot.entity.Course;
import org.example.introspringboot.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDTO toSimpleDto(Student student);
    Student toEntity(StudentDTO StudentDTO);
}

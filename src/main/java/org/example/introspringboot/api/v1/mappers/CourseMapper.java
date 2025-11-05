package org.example.introspringboot.api.v1.mappers;

import org.example.introspringboot.api.v1.dto.CourseDTO;
import org.example.introspringboot.api.v1.dto.CourseWithStudentsDTO;
import org.example.introspringboot.api.v1.dto.ProfessorDTO;
import org.example.introspringboot.entity.Course;
import org.example.introspringboot.entity.Professor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDTO toSimpleDto(Course course);
    CourseWithStudentsDTO toCourseWithStudentsDto(Course course);
}

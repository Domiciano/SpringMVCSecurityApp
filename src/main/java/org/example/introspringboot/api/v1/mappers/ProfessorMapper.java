package org.example.introspringboot.api.v1.mappers;

import org.example.introspringboot.api.v1.dto.ProfessorDTO;
import org.example.introspringboot.entity.Professor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {
    ProfessorDTO toDto(Professor professor);
    Professor toEntity(ProfessorDTO professorDTO);
}

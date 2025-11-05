package org.example.introspringboot.api.v1.mappers;

import org.example.introspringboot.api.v1.dto.AuthorDTO;
import org.example.introspringboot.entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorDTO toDto(Author author);
    Author toEntity(AuthorDTO authorDTO);
}

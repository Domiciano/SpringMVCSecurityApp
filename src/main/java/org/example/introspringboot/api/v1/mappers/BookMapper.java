package org.example.introspringboot.api.v1.mappers;

import org.example.introspringboot.api.v1.dto.BookDTO;
import org.example.introspringboot.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(source = "author.id", target = "authorId")
    BookDTO toDto(Book book);

    @Mapping(source = "authorId", target = "author.id")
    Book toEntity(BookDTO bookDTO);
}

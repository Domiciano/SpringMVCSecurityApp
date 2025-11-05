package org.example.introspringboot.service;

import org.example.introspringboot.api.v1.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> findAll();
    BookDTO findById(Integer id);
    BookDTO save(BookDTO book);
    BookDTO update(Integer id, BookDTO book);
    void deleteById(Integer id);
}

package org.example.introspringboot.service.impl;

import org.example.introspringboot.api.v1.dto.BookDTO;
import org.example.introspringboot.api.v1.mappers.BookMapper;
import org.example.introspringboot.entity.Book;
import org.example.introspringboot.repository.BookRepository;
import org.example.introspringboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<BookDTO> findAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDTO findById(Integer id) {
        return bookRepository.findById(id)
                .map(bookMapper::toDto)
                .orElse(null);
    }

    @Override
    public BookDTO save(BookDTO bookDTO) {
        Book book = bookMapper.toEntity(bookDTO);
        book = bookRepository.save(book);
        return bookMapper.toDto(book);
    }

    @Override
    public BookDTO update(Integer id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.setTitle(bookDTO.getTitle());
            book.setPublicationYear(bookDTO.getPublicationYear());
            book.setGenre(bookDTO.getGenre());
            // Assuming author is managed elsewhere and ID is sufficient
            book = bookRepository.save(book);
            return bookMapper.toDto(book);
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }
}

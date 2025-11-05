package org.example.introspringboot.repository;

import org.example.introspringboot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}

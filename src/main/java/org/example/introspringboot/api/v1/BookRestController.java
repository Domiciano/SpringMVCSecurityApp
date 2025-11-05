package org.example.introspringboot.api.v1;

import org.example.introspringboot.api.v1.dto.BookDTO;
import org.example.introspringboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookRestController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Integer id) {
        BookDTO book = bookService.findById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.save(bookDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Integer id, @RequestBody BookDTO bookDTO) {
        BookDTO updatedBook = bookService.update(id, bookDTO);
        if (updatedBook != null) {
            return ResponseEntity.ok(updatedBook);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

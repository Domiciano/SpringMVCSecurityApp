package org.example.introspringboot.api.v1;

import org.example.introspringboot.api.v1.dto.AuthorDTO;
import org.example.introspringboot.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorRestController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
        return ResponseEntity.ok(authorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable Integer id) {
        AuthorDTO author = authorService.findById(id);
        if (author != null) {
            return ResponseEntity.ok(author);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO authorDTO) {
        return ResponseEntity.ok(authorService.save(authorDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable Integer id, @RequestBody AuthorDTO authorDTO) {
        AuthorDTO updatedAuthor = authorService.update(id, authorDTO);
        if (updatedAuthor != null) {
            return ResponseEntity.ok(updatedAuthor);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Integer id) {
        authorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

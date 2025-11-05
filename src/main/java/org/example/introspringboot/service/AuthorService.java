package org.example.introspringboot.service;

import org.example.introspringboot.api.v1.dto.AuthorDTO;

import java.util.List;

public interface AuthorService {
    List<AuthorDTO> findAll();
    AuthorDTO findById(Integer id);
    AuthorDTO save(AuthorDTO author);
    AuthorDTO update(Integer id, AuthorDTO author);
    void deleteById(Integer id);
}

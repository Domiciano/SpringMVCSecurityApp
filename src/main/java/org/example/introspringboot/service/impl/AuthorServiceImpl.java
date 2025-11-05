package org.example.introspringboot.service.impl;

import org.example.introspringboot.api.v1.dto.AuthorDTO;
import org.example.introspringboot.api.v1.mappers.AuthorMapper;
import org.example.introspringboot.entity.Author;
import org.example.introspringboot.repository.AuthorRepository;
import org.example.introspringboot.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public List<AuthorDTO> findAll() {
        return authorRepository.findAll().stream()
                .map(authorMapper::toDto)
                .toList();
    }

    @Override
    public AuthorDTO findById(Integer id) {
        return authorRepository.findById(id)
                .map(authorMapper::toDto)
                .orElse(null);
    }

    @Override
    public AuthorDTO save(AuthorDTO authorDTO) {
        Author author = authorMapper.toEntity(authorDTO);
        author = authorRepository.save(author);
        return authorMapper.toDto(author);
    }

    @Override
    public AuthorDTO update(Integer id, AuthorDTO authorDTO) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author != null) {
            author.setName(authorDTO.getName());
            author.setNationality(authorDTO.getNationality());
            author = authorRepository.save(author);
            return authorMapper.toDto(author);
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        authorRepository.deleteById(id);
    }
}

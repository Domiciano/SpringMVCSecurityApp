package org.example.introspringboot.service.impl;

import org.example.introspringboot.api.v1.dto.ProfessorDTO;
import org.example.introspringboot.api.v1.mappers.ProfessorMapper;
import org.example.introspringboot.entity.Professor;
import org.example.introspringboot.repository.ProfessorRepository;
import org.example.introspringboot.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private ProfessorMapper professorMapper;

    @Override
    public List<ProfessorDTO> findAll() {
        return professorRepository.findAll().stream().map(
                professor -> professorMapper.toDto(professor)
        ).toList();
    }

    @Override
    public ProfessorDTO findById(Integer id) {
        return professorRepository.findById(id)
                .map(professor -> professorMapper.toDto(professor)).orElse(null);
    }

    @Override
    public ProfessorDTO save(ProfessorDTO professorDTO) {
        var entity = professorMapper.toEntity(professorDTO);
        professorRepository.save(entity);
        professorDTO.setId(entity.getId());
        return professorDTO;
    }

    @Override
    public void deleteById(Integer id) {
        professorRepository.deleteById(id);
    }
}

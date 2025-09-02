package org.example.introspringboot.service.impl;

import org.example.introspringboot.entity.Student;
import org.example.introspringboot.repository.StudentRepository;
import org.example.introspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public long getCount() {
        return studentRepository.count();
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }


}

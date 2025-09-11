package org.example.introspringboot.unit.service;


import org.example.introspringboot.entity.Student;
import org.example.introspringboot.repository.StudentRepository;
import org.example.introspringboot.service.StudentService;
import org.example.introspringboot.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    void findStudentByCode_WhenStudentExist_ShouldReturnOptionalStudent(){

        Student mockStudent = new Student();

        when(studentRepository.findByCode("12345")).thenReturn(Optional.of(mockStudent));

        Optional<Student> student = studentService.findStudentByCode("12345");
        assertTrue(student.isPresent());
    }

}

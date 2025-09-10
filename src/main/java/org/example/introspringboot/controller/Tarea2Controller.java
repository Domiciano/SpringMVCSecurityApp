package org.example.introspringboot.controller;

import org.example.introspringboot.entity.Course;
import org.example.introspringboot.entity.Student;
import org.example.introspringboot.repository.CourseRepository;
import org.example.introspringboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class Tarea2Controller {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("ej1")
    public ResponseEntity<?> ej1(){
        Optional<Student> output = studentRepository.findByCode("2021102001");
        return ResponseEntity.status(200).body(output);
    }

    @GetMapping("ej2")
    public ResponseEntity<?> ej2(){
        var output = courseRepository.findFirstByOrderByNameAsc();
        return ResponseEntity.status(200).body(output);
    }

    @GetMapping("ej3")
    public ResponseEntity<?> ej3(){
        var output = courseRepository.findTop2ByOrderByCreditsDesc();
        return ResponseEntity.status(200).body(output);
    }

    @GetMapping("ej4")
    public ResponseEntity<?> ej4(){
        var output = courseRepository.findFirst100ByProfessor_Name("Juan Perez");
        return ResponseEntity.status(200).body(output);
    }

    @GetMapping("ej5")
    public ResponseEntity<?> ej5(){
        var output = courseRepository.findByProfessor_NameOrderByNameDesc("Juan Perez");
        return ResponseEntity.status(200).body(output);
    }


    @GetMapping("ej6")
    public ResponseEntity<?> ej6(){
        var output = courseRepository.findByCreditsGreaterThanEqual(
                1,
                PageRequest.of(1, 4)
        );
        return ResponseEntity.status(200).body(output);
    }



}

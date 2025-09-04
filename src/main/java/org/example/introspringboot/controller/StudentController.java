package org.example.introspringboot.controller;

import org.example.introspringboot.entity.Student;
import org.example.introspringboot.repository.AccountRepository;
import org.example.introspringboot.repository.StudentRepository;
import org.example.introspringboot.service.AccountService;
import org.example.introspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    @Qualifier("studentServiceImpl")
    private StudentService studentService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("transfer")
    public String transfer(){
        accountService.transferMoney(1L,2L, 300.0);
        return "transfer";
    }

    @GetMapping("count")
    public String getStudentCount() {
        long count = studentService.getCount();
        return "Estudiantes: " + count;
    }



    @GetMapping("students")
    public String getStudents() {
        StringBuilder output = new StringBuilder();
        for (Student student : studentService.getStudents()) {
            output.append(student.getName());
        }
        return output.toString();
    }

}

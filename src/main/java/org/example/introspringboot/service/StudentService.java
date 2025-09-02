package org.example.introspringboot.service;

import org.example.introspringboot.entity.Student;

import java.util.List;

public interface StudentService {

    long getCount();

    List<Student> getStudents();

}

package org.example.introspringboot.repository;

import org.example.introspringboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByProgramAndCodeStartingWith(String program, String prefix);
}

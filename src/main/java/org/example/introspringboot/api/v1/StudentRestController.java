package org.example.introspringboot.api.v1;

import org.example.introspringboot.api.v1.dto.MessageResponse;
import org.example.introspringboot.api.v1.dto.ProfessorDTO;
import org.example.introspringboot.service.CourseService;
import org.example.introspringboot.service.ProfessorService;
import org.example.introspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/students")
public class StudentRestController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_PROFESSOR')")
    public ResponseEntity<?> getProfessors() {
        var students = studentService.getStudents();
        return ResponseEntity.status(200).body(students);
    }

    @GetMapping("/{id}/courses")
    @PreAuthorize("hasAuthority('ROLE_PROFESSOR')")
    public ResponseEntity<?> getCoursesByStudent(@PathVariable Integer id) {
        var courses = courseService.findByStudentId(id);
        return ResponseEntity.status(200).body(courses);
    }

}

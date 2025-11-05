package org.example.introspringboot.api.v1;

import org.example.introspringboot.api.v1.dto.MessageResponse;
import org.example.introspringboot.api.v1.dto.ProfessorDTO;
import org.example.introspringboot.service.CourseService;
import org.example.introspringboot.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseRestController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<?> getAllCourses() {
        var courses = courseService.findAll();
        return ResponseEntity.status(200).body(courses);
    }


}

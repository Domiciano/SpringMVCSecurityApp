package org.example.introspringboot.integration.service;


import org.example.introspringboot.entity.*;
import org.example.introspringboot.repository.CourseRepository;
import org.example.introspringboot.repository.ProfessorRepository;
import org.example.introspringboot.repository.StudentCourseRepository;
import org.example.introspringboot.repository.StudentRepository;
import org.example.introspringboot.service.StudentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentServiceIntegrationTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ProfessorRepository professorRepository;

    private Student student1;
    private Student student2;
    private Professor professor;
    private Course course;
    private StudentCourse studentCourse1;
    private StudentCourse studentCourse2;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentCourseRepository studentCourseRepository;

    public void scenario1(){
        professor = new Professor();
        professor.setName("James Rodriguez");
        professorRepository.save(professor);

        course = new Course();
        course.setName("Compu2");
        course.setCredits(3);
        course.setProfessor(professor);
        courseRepository.save(course);

        student1 = new Student();
        student1.setName("Santiago Grajales");
        student1.setProgram("SIS");
        student1.setCode("111");
        studentRepository.save(student1);

        student2 = new Student();
        student2.setName("Dario Marquinez");
        student2.setProgram("SIS");
        student2.setCode("222");
        studentRepository.save(student2);

        StudentCourseId studentCourseId1 = new StudentCourseId();
        studentCourseId1.setStudentId(student1.getId());
        studentCourseId1.setCourseId(course.getId());
        studentCourse1 = new StudentCourse();
        studentCourse1.setStudentCourseId(studentCourseId1);
        studentCourse1.setCourse(course);
        studentCourse1.setStudent(student1);
        studentCourseRepository.save(studentCourse1);

        StudentCourseId studentCourseId2 = new StudentCourseId();
        studentCourseId2.setStudentId(student2.getId());
        studentCourseId2.setCourseId(course.getId());
        studentCourse2 = new StudentCourse();
        studentCourse2.setStudentCourseId(studentCourseId2);
        studentCourse2.setCourse(course);
        studentCourse2.setStudent(student2);
        studentCourseRepository.save(studentCourse2);


    }

    @BeforeEach
    public void setup() {}

    //AQUI VAN LAS PRUEBAS
    @Test
    void findStudentByCode_WhenStudentExist_ShouldReturnOptionalStudent(){
        //Arrange
        Student student1 = new Student();
        student1.setName("John");
        student1.setCode("12345");
        student1.setProgram("SIS");
        studentRepository.save(student1);
        //Act
        Optional<Student> returnedStudent = studentService.findStudentByCode("12345");

        //Assert
        assertTrue(returnedStudent.isPresent());

        Optional<Student> studentInDB = studentRepository.findById(returnedStudent.get().getId());
        assertTrue(studentInDB.isPresent());

    }

    @Test
    void findStudentByCode_WhenStudentDoesNotExist_ShouldThrowRuntimeException(){
        String code = "12345";
        assertThrows(RuntimeException.class, ()->{
            studentService.findStudentByCode(code);
        });
    }

    @Test
    void getStudentsByCourseName_WhenCalled_ShouldReturnStudentList(){
        scenario1();
        List<Student> studentList = studentService.getStudentsByCourseName(course.getName());
        assertEquals(2, studentList.size());
    }


    @AfterEach
    public void cleanup() {
        studentRepository.deleteAll();
    }

}

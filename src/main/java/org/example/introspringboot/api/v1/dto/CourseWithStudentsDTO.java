package org.example.introspringboot.api.v1.dto;

import java.util.List;

public class CourseWithStudentsDTO {
    private String name;
    private int credits;
    private List<StudentDTO> students;

    public CourseWithStudentsDTO() {
    }

    public CourseWithStudentsDTO(String name, int credits, List<StudentDTO> students) {
        this.name = name;
        this.credits = credits;
        this.students = students;
    }

    public List<StudentDTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDTO> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}

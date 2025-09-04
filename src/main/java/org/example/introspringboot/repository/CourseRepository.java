package org.example.introspringboot.repository;

import org.example.introspringboot.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

interface CourseRepository extends JpaRepository<Course, Integer> {
}

package com.example.managementsystem.repositories;

import com.example.managementsystem.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Integer> {
}

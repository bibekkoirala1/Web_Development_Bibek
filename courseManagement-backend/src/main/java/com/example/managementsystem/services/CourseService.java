package com.example.managementsystem.services;

import com.example.managementsystem.entities.Course;
import com.example.managementsystem.payloads.CourseDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {
    List<CourseDto> getAllCourses();
    CourseDto getCourse(Integer courseId);
    CourseDto createCourse(CourseDto courseDto);
    CourseDto updateCourse(CourseDto courseDto, Integer courseId);
    void deleteCourse(Integer courseId);
}

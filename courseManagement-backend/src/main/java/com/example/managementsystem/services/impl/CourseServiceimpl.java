package com.example.managementsystem.services.impl;

import com.example.managementsystem.entities.Course;
import com.example.managementsystem.exceptions.ResourceNotFoundException;
import com.example.managementsystem.payloads.CourseDto;
import com.example.managementsystem.repositories.CourseRepo;
import com.example.managementsystem.services.CourseService;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CourseServiceimpl implements CourseService {

    private ModelMapper modelMapper;
    private CourseRepo courseRepo;
    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> courses = this.courseRepo.findAll();
        List<CourseDto> courseDtos = new ArrayList<>();
        for (Course course : courses) {
            CourseDto courseDto = this.modelMapper.map(course, CourseDto.class);
            courseDtos.add(courseDto);
        }
        return courseDtos;
    }

    @Override
    public CourseDto getCourse(Integer courseId) {
        Course course = this.courseRepo.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "course id", courseId));
        return this.modelMapper.map(course, CourseDto.class);
    }

    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        Course course = this.modelMapper.map(courseDto, Course.class);
        Course course1 = this.courseRepo.save(course);
        return this.modelMapper.map(course1, CourseDto.class);
    }

    @Override
    public CourseDto updateCourse(CourseDto courseDto, Integer courseId) {
        Course course = this.courseRepo.findById(courseId).
                orElseThrow(() -> new ResourceNotFoundException("Course", "course id", courseId));
        course.setTitle(courseDto.getTitle());
        course.setDescription(courseDto.getDescription());
        Course course1 = this.courseRepo.save(course);
        return this.modelMapper.map(course, CourseDto.class);
    }

    @Override
    public void deleteCourse(Integer courseId) {
        Course course = this.courseRepo.findById(courseId).
                orElseThrow(() -> new ResourceNotFoundException("Course", "course id", courseId));
        this.courseRepo.delete(course);
    }
}

package com.example.managementsystem.controllers;

import com.example.managementsystem.constant.ApiConstant;
import com.example.managementsystem.entities.Course;
import com.example.managementsystem.payloads.CourseDto;
import com.example.managementsystem.services.CourseService;
//import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
//@CrossOrigin
@RestController
@AllArgsConstructor
//@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,
//RequestMethod.PUT, RequestMethod.DELETE}
@CrossOrigin
public class CourseController {

    private CourseService courseService;

    @GetMapping(ApiConstant.COURSE)
    public ResponseEntity<List<CourseDto>> getAllCourse() {
        List<CourseDto> courseDtoList = this.courseService.getAllCourses();
        return new ResponseEntity<List<CourseDto>>(courseDtoList, HttpStatus.OK);
    }
    @GetMapping(ApiConstant.COURSE + ApiConstant.COURSEID)
    public ResponseEntity<CourseDto> getCourse(@PathVariable("courseId") Integer courseId) {
        CourseDto courseDto = this.courseService.getCourse(courseId);
        return new ResponseEntity<CourseDto>(courseDto, HttpStatus.OK);
    }
    @PostMapping(ApiConstant.COURSE)
    public ResponseEntity<CourseDto> createCourse(@Valid @RequestBody CourseDto courseDto) {
        CourseDto courseDto1 = this.courseService.createCourse(courseDto);
        return new ResponseEntity<CourseDto>(courseDto1, HttpStatus.CREATED);
    }

    @PutMapping(ApiConstant.COURSE + ApiConstant.COURSEID)
    public ResponseEntity<CourseDto> updateCourse(@Valid @RequestBody CourseDto courseDto,
                                                  @PathVariable("courseId") Integer courseId){
        CourseDto courseDto1 = this.courseService.updateCourse(courseDto, courseId);
        return new ResponseEntity<CourseDto>(courseDto1, HttpStatus.OK);
    }

    @DeleteMapping(ApiConstant.COURSE + ApiConstant.COURSEID)
    public void deleteCourse(@PathVariable ("courseId") Integer courseId) {
        this.courseService.deleteCourse(courseId);
    }

}

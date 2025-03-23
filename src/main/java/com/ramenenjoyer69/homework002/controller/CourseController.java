package com.ramenenjoyer69.homework002.controller;


import com.ramenenjoyer69.homework002.exception.NotFoundException;
import com.ramenenjoyer69.homework002.model.entity.Course;
import com.ramenenjoyer69.homework002.model.error.ErrorResponse;
import com.ramenenjoyer69.homework002.model.request.CourseRequest;
import com.ramenenjoyer69.homework002.model.response.Response;
import com.ramenenjoyer69.homework002.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<Response<List<Course>>> list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return courseService.getAllCourses(page,size);
    }

    @GetMapping("/{course_id}")
    public ResponseEntity<?> getCourseById(@PathVariable("course_id") Long courseId) {

        Course course = courseService.getCourseById(courseId);

        try {
            if (course == null) {
                throw new NotFoundException("Course not found");
            }
        }
        catch (NotFoundException e) {
            ErrorResponse errorResponse = new ErrorResponse(
                    e.getMessage(),
                    HttpStatus.NOT_FOUND
            );

            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @DeleteMapping("/{course_id}")
    public ResponseEntity<Response<Course>> deleteCourseById(@PathVariable("course_id") Long courseId) {
        return courseService.deleteCourseById(courseId);
    }

    @PostMapping
    public ResponseEntity<Response<Course>> saveCourse(@RequestBody CourseRequest request) {
        return courseService.saveCourse(request);
    }

    @PutMapping("/{course_id}")
    public ResponseEntity<Response<Course>> updateCourseById(@PathVariable("course_id") Long courseId, @RequestBody CourseRequest request) {
        return courseService.updateCourseById(courseId, request);
    }
}

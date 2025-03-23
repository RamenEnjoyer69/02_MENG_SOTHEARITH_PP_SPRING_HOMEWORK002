package com.ramenenjoyer69.homework002.controller;


import com.ramenenjoyer69.homework002.model.entity.Course;
import com.ramenenjoyer69.homework002.model.request.CourseRequest;
import com.ramenenjoyer69.homework002.model.response.Response;
import com.ramenenjoyer69.homework002.service.CourseService;
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
    public Course getCourseById(@PathVariable("course_id") Long courseId) {
        return courseService.getCourseById(courseId);
    }

    @DeleteMapping("/{course_id}")
    public Course deleteCourseById(@PathVariable("course_id") Long courseId) {
        return courseService.deleteCourseById(courseId);
    }

    @PostMapping
    public Course saveCourse(@RequestBody CourseRequest request) {
        return courseService.saveCourse(request);
    }

    @PutMapping("/{course_id}")
    public Course updateCourseById(@PathVariable("course_id") Long courseId, @RequestBody CourseRequest request) {
        return courseService.updateCourseById(courseId, request);
    }
}
